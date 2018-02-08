package com.yidu.businessData.serivce.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.Date;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.linuxense.javadbf.DBFReader;
import com.yidu.businessData.dao.EquityDataDao;
import com.yidu.businessData.domain.EquityData;
import com.yidu.businessData.service.EquityDataService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 
 * @author XiaoYuJie
 * @date 2017年11月14日
 * @time 上午11:45:45
 */
@Transactional
@Service
public class EquityDataServiceImpl implements EquityDataService{
	@Autowired
	EquityDataDao equityDataDao;
	@Autowired
	AutoBianService autoBianHao;
	
	@Override
	public int insertEquityData(EquityData equityData) {
		// TODO Auto-generated method stub
		int i=equityDataDao.insertEquityData(equityData);
		return i;
	}

	@Override
	public int deleteEquityData(EquityData equityData) {
		// TODO Auto-generated method stub
		int i=equityDataDao.deleteEquityData(equityData);
		return i;
	}

	@Override
	public int updateEquityData(EquityData equityData) {
		int i=equityDataDao.updateEquityData(equityData);
		return i;
	}
	
	@Override
	public Map selectEquityData(EquityData equityData) {
		System.out.println(equityData);
		System.out.println("equityData.getEqShareOutBonusScale()"+equityData.getEqShareOutBonusScale());
		StringBuffer buffwhere=new StringBuffer("");
		//判断权益类型是否为空
		if(equityData.getEqShareOutBonusScale()!=null&&!"".equals(equityData.getEqShareOutBonusScale())){
			buffwhere.append(" and share_qut_bonus_scale="+equityData.getEqShareOutBonusScale());
		}
		//判断除权日是否为空
		if(equityData.getStreqExDayDate()!=null &&!equityData.getStreqExDayDate().equals("") ){
			System.err.println("进来了按日期查");
			try {
				//将string日期装换为date型
				equityData.setEqExDay(AllUtil.getDate(equityData.getStreqExDayDate()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("equityData.getEqExDay()"+equityData.getEqExDay());
			buffwhere.append(" and ex_day=to_date('"+equityData.getEqExDay()+"','yyyy-MM-dd')");
		}
		buffwhere.append(" and fund_code="+"'"+equityData.getFundCode()+"'");
		System.err.println(" buffwhere.toString()"+ buffwhere.toString());
		String tableName="(select distinct ed.*,ss.fund_code from security_stock ss join equity_data ed on ss.security_code=ed.security_code)";
		Map map=new HashMap();
		map.put("tabName", tableName);
		map.put("qualification", buffwhere.toString());
		map.put("page", equityData.getPage());
		map.put("rows", equityData.getRows());
		map.put("orderColumn", "equity_data_code");
		map.put("orderStyle", equityData.getOrderStyle());
		System.out.println(map);
		equityDataDao.selectEquityData(map);
		//得到查出来的集合
		List<EquityData>equityDataList= (List<EquityData>) map.get("cursor");
		//for循环遍历集合
		for(EquityData equityDatas:equityDataList){
			try {
				//将date型日期装换为string型
				equityDatas.setStrDate(AllUtil.getStringDate(equityDatas.getEqRegisterDay()));
				equityDatas.setStreqExDayDate(AllUtil.getStringDate(equityDatas.getEqExDay()));
				equityDatas.setStreqToAccountDate(AllUtil.getStringDate(equityDatas.getEqToAccountDate()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println("equityDataList"+equityDataList);
		int size=(int) map.get("rowsTotal");
		System.out.println(size);
		Map listMap=new HashMap();
		listMap.put("total", size);
		listMap.put("rows", equityDataList);
		System.out.println("listMap"+listMap);
		return listMap;
	}

	@Override
	public List<EquityData> selectEquityDataCode(String eqDataCode) {
		List<EquityData> equityDataList=equityDataDao.selectEquityDataCode(eqDataCode);
		//for循环得到的集合
		for(EquityData equityData:equityDataList){
			try {
				//将date型日期装换为string型
				equityData.setStrDate(AllUtil.getStringDate(equityData.getEqRegisterDay()));
				equityData.setStreqExDayDate(AllUtil.getStringDate(equityData.getEqExDay()));
				equityData.setStreqToAccountDate(AllUtil.getStringDate(equityData.getEqToAccountDate()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return equityDataList;
	}

	@Override
	public int input(String path) {
		int i=0;
		 InputStream fis = null;  
	        try {  
	            // 读取文件的输入流  
	            fis = new FileInputStream(path);  
	            // 根据输入流初始化一个DBFReader实例，用来读取DBF文件信息  
	            DBFReader reader = new DBFReader(fis);             
	            Object[] rowValues;  
	            // 一条条取出path文件中记录  
	            while ((rowValues = reader.nextRecord()) != null) {
	            	//现金账户
	                String cashAccountCode=(rowValues[0]+"").trim();
	                //证券id
	                String securityCode=(rowValues[1]+"").trim();
	                //比例
	                Double eqSendStockScale=Double.parseDouble((rowValues[5]+"").trim());
	                //权益登记日
	                String  strDate=(rowValues[10]+"").trim();
	                StringBuffer strDateff=new StringBuffer(strDate);
	                strDateff.insert(4, "-");
	                strDateff.insert(7, "-");
	                Date eqRegisterDay= AllUtil.getDate(strDateff.toString());
	                //处理标志
	                Integer eqShareOutBonusScale= Integer.parseInt((rowValues[11]+"").trim());
	                String eqDesc="未处理";
	                String streqExDayDate="2017-12-30";
	                Date eqExDay=AllUtil.getDate(streqExDayDate);
	                String streqToAccountDate="2017-12-31";
	                Date eqToAccountDate=AllUtil.getDate(streqToAccountDate);
	                String eqDataCode=autoBianHao.getAutoBianhao("equity_data", "QYSJ", "equity_data_code", "register_day", new Date(System.currentTimeMillis()));
	                EquityData equityData=new EquityData();
	                equityData.setEqDataCode(eqDataCode);
	                equityData.setCashAccountCode(cashAccountCode);
	                equityData.setSecurityCode(securityCode);
	                equityData.setEqRegisterDay(eqRegisterDay);
	                equityData.setEqExDay(eqExDay);
	                equityData.setEqShareOutBonusScale(eqShareOutBonusScale);
	                equityData.setEqSendStockScale(eqSendStockScale);
	                equityData.setEqToAccountDate(eqToAccountDate);
	                equityData.setEqDesc(eqDesc);
	                int j=equityDataDao.insertEquityData(equityData);
	                if(j>0){
	                	System.err.println("增加成功");
	                	 i=1;
	                }else{
	                	System.err.println("增加失败");
	                }
	               
	            }  
	        } catch (Exception e) { 
	        	i=0;
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                fis.close();  
	            } catch (Exception e) {  
	            }  
	        }  	
		return i;
	}

}
