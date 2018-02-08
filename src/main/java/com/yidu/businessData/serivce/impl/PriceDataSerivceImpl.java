package com.yidu.businessData.serivce.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.yidu.businessData.dao.PriceDateDao;
import com.yidu.businessData.domain.PriceData;
import com.yidu.businessData.service.PriceDateService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;


/**
* @author YiWenQi 
* @version 创建时间：2017年11月17日 上午11:38:52
* 类说明
*/
@Transactional
@Service
public class PriceDataSerivceImpl implements PriceDateService{
	@Autowired
	PriceDateDao priceDateDaos;
	@Autowired
	AutoBianService autoBianService;
	@Override
	public Map<String, Object> selectPriceData(PriceData priceDatas) {
		//打印是否进了这里
			System.err.println("进来了"+priceDatas);
			//创建一个StringBuffer类
			StringBuffer swrWhere=new StringBuffer("");
			//判断证券代码ID 不为null 不为 空字符
			if (priceDatas.getSecurityCode()!=null && !priceDatas.getSecurityCode().equals("")) 
			{
				swrWhere.append(" and pd_securityCode = '"+priceDatas.getSecurityCode()+"'");
			}
			if (priceDatas.getStrEnteringDate()!=null && !priceDatas.getStrEnteringDate().equals(""))
			{
				swrWhere.append(" and pd_enteringDate = to_date('"+priceDatas.getStrEnteringDate()+"','yyyy-mm-dd')");
			}
			System.err.println(swrWhere);
			//创建一个hashMap的集合
			Map<String, Object> map=new HashMap<String, Object>();
			//put的表名
			map.put("tableName", "priceData");
			//条件
			map.put("qualification", swrWhere.toString());
			//列
			map.put("page", priceDatas.getPage());
			System.out.println(priceDatas.getPage());
			//行
			map.put("rows", priceDatas.getRows());
			System.out.println(priceDatas.getRows());
			//行情数据ID
			map.put("orderColumn", "pd_priceDataCode");
			//排序方式
			map.put("orderStyle", priceDatas.getSortOrder());
			//行情数据的Dao的到查询的方法
			priceDateDaos.selectPriceData(map);
			return map;

		}
	/**
	 * 这是新增的服务类接口
	 */
	@Override
	public Integer insertPrice(PriceData priceDatas) {
		// TODO Auto-generated method stub
		return priceDateDaos.insertPrice(priceDatas);
	}
	/**
	 * 这是修改
	 */
	@Override
	public Integer updatePrice(PriceData priceDatas) {
		// TODO Auto-generated method stub
		return priceDateDaos.updatePrice(priceDatas);
	}
	/**
	 * 这是删除
	 */
	@Override
	public Integer deletePrrice(PriceData priceDatas) {
		// TODO Auto-generated method stub
		return priceDateDaos.deletePrrice(priceDatas);
	}
	/**
	 * 这是通过查询Code
	 */
	@Override
	public PriceData selectPriceDataByCode(PriceData priceDatas) {
		// TODO Auto-generated method stub
		return priceDateDaos.selectPriceDataByCode(priceDatas);
	}
	@Override
	public int imputShangHai(String path) {
		InputStream fis=null;
		String flag="导入成功";
		String auoto=null;
		String values=new String();
		try {
			// 读取文件的输入流 
			fis=new FileInputStream(path);
			try {
				// 根据输入流初始化一个DBFReader实例，用来读取DBF文件信息 
				DBFReader reader=new DBFReader(fis);
				// 调用DBFReader对实例方法得到path文件中字段的个数
				reader.setCharactersetName("GBK"); 
				Object[] rowValues;
				//创建一个Array的集合
				List<PriceData> priceDataList=new ArrayList<>();  
			
				//String  j = "HXSJ"+new Date(System.currentTimeMillis())+"001";
				int rows  = 0;
				Date priceDate = null;
				while ( (rowValues = reader.nextRecord())!= null) {
					//证券代码
					rows++;
					
					
					if(rows==1){
						String strDate = (rowValues[5]+"").trim();
						System.err.println("strDate=========="+AllUtil.scientificCountintMethedToNumber(new Double(strDate),0));
						//工具类得到转格式的方法
						strDate=AllUtil.scientificCountintMethedToNumber(new Double(strDate),0);
						//创建一个字符串的包装类
						StringBuffer stringBuffer = new StringBuffer(strDate);
						strDate =stringBuffer.insert(4, "-").insert(7, "-").toString();
						System.err.println(strDate);
						//公共的类得到时间
						priceDate=AllUtil.getDate(strDate);
						System.err.println("当前时间为："+priceDate);
						continue;
						
					}
					//证券代码0
					String securityCode=(rowValues[0]+"").trim();
					
					//证券名称1
					String securityName=(rowValues[1]+"").trim();
				
					//开盘价格3
					String openingPrice=(rowValues[3]+"").trim();
					Double doubleOpeningPrice=Double.parseDouble(openingPrice);
					//前收盘价格2
					String  closingPrice =(rowValues[2]+"").trim();
					//转成Double的收盘价格
					Double douleClosingPrice=Double.parseDouble(closingPrice);
					String priceData[]=values.split(",");
					if(auoto==null){
						//服务类得到自动生成编号
						auoto= autoBianService.getAutoBianhao("priceData", "HXSJ", "PD_PRICEDATACODE", "pd_enteringDate", priceDate);
					}else{
						//工具类得到L
						auoto = AllUtil.getLocalhostAutoBianHao(auoto);
						System.err.println(auoto+"我猜你要死了");

					}
					//创建一个实体类
					PriceData priceData2=new PriceData(auoto,securityCode,priceDate,new Double(openingPrice),new Double(closingPrice),"导入数据");
					priceDataList.add(priceData2);
					
				}
				
				System.err.println(priceDataList);
				//dao层得到删除行情数据的方法
				priceDateDaos.deletePriceByDate(priceDate);
				for (int i = 0; i < priceDataList.size(); i++) {
					//得到I
					PriceData priceDatas = priceDataList.get(i);
					//进入查询的方法 ，dao得到查询的（编号）方法
					PriceData selectPriceDate=priceDateDaos.selectPriceDataByCode(priceDatas);
				//判断查询的条件为NUll 进入dao得到增加的方法
					if(selectPriceDate==null){
						priceDateDaos.insertPrice(priceDatas);
					}else{
					 flag = "当日已导入过这些行情数据";
					}
				}
			} catch (DBFException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			flag="导入失败";
		}
		return 0 ;
	}
	/**
	 *先删除的行情数据的方法
	 */
	@Override
	public int deletePriceByDate(PriceData priceDatas) {
		// TODO Auto-generated method stub
		return priceDateDaos.deletePriceByDate(priceDatas.getEnteringDate());
	}
}
