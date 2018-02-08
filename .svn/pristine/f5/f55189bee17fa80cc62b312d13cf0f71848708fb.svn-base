package com.yidu.transactionProcessing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.businessData.domain.EquityData;
import com.yidu.transactionProcessing.dao.InterestsDao;
import com.yidu.transactionProcessing.domain.Interests;
import com.yidu.transactionProcessing.service.InterestsService;
import com.yidu.util.AllUtil;
/**
 * 
 * @author XiaoYuJie
 * @date 2017年11月17日
 * @time 上午9:57:49
 */
@Transactional
@Service
public class InterestsServiceImpl implements InterestsService{
	@Autowired
	InterestsDao interestsDao;

	@Override
	public Map<String, Object> selectInterests(String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle) {
		
		System.err.println(qualification+page+"rows"+rows);
		Map map=new HashMap();
		tableName="(select nvl(sum(st.security_total_money),0)as totalmoney ,nvl(sum(st.security_quantity),0) as securityquantity , sc.security_name as securityName ,sc.security_code as securityCode,"
		+"ed.equity_data_code as eqDataCode , ed.cash_account_code as accountCode , ed.equity_data as tip ,ed.ex_day as exRights ,"
		+"ed.share_qut_bonus_scale as equityType,ed.send_stock_scale as stockDistribution ,st.fund_code as fundCode "
		+" from equity_data ed left  join security sc on ed.security_code=sc.security_code join  security_stock st on sc.security_code=st.security_code where  ed.equity_data='未处理'"
		+" group by sc.security_name,sc.security_code,st.fund_code,ed.equity_data_code,ed.cash_account_code,ed.equity_data,ed.ex_day ,ed.share_qut_bonus_scale,ed.send_stock_scale )";
		map.put("tableName", tableName);
		map.put("qualification", qualification);
		map.put("page", page);
		map.put("rows", rows);
		map.put("orderColumn", "eqDataCode");
		map.put("orderStyle", "");
		
		//通过实体类查询数据
		interestsDao.selectInterests(map);
		map.get("cursor");
		return map;
	}

	@Override
	public int updateInterests(String eqDataCode, String tip) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("eqDataCode", eqDataCode);
		map.put("tip", tip);
		int i=interestsDao.updateInterests(map);
		return i;
	}

	@Override
	public Map<String, Object> selectInterestsYi(String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle) {
		
		Map map=new HashMap();
		tableName="(select nvl(sum(st.security_total_money),0)as totalmoney ,nvl(sum(st.security_quantity),0) as securityquantity , sc.security_name as securityName ,sc.security_code as securityCode,"
		+"ed.equity_data_code as eqDataCode , ed.cash_account_code as accountCode , ed.equity_data as tip ,ed.ex_day as exRights ,"
		+"ed.share_qut_bonus_scale as equityType,ed.send_stock_scale as stockDistribution, st.fund_code as fundCode "
		+" from equity_data ed left  join security sc on ed.security_code=sc.security_code join  security_stock st on sc.security_code=st.security_code where  ed.equity_data='处理'"
		+" group by sc.security_name,sc.security_code,ed.equity_data_code,ed.cash_account_code,ed.equity_data,ed.ex_day ,ed.share_qut_bonus_scale,ed.send_stock_scale,st.fund_code )";
		map.put("tableName", tableName);
		map.put("qualification", qualification);
		map.put("page", page);
		map.put("rows", rows);
		map.put("orderColumn", "eqDataCode");
		map.put("orderStyle", "");
		
		//通过实体类查询数据
		interestsDao.selectInterests(map);
		
		return map;
	}

	@Override
	public int updateInterestsYi(String eqDataCode, String tip) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("eqDataCode", eqDataCode);
		map.put("tip", tip);
		int i=interestsDao.updateInterestsYi(map);
		return i;
		
	}
	/**
	 * 查询出将要处理的数据
	 */
	@Override
	public List<Interests> selectInterestsEqDataCode(String eqDataCode) {
		List<Interests>interestsDataList= interestsDao.selectInterestsEqDataCode(eqDataCode);
		for(Interests interestss:interestsDataList){
			try {
				interestss.setStrDate(AllUtil.getStringDate(interestss.getExRights()));
				Double num;
				if(interestss.getEquityType()==1){
					num=interestss.getTotalmoney()*interestss.getStockDistribution();
				}else{
					num=interestss.getStockDistribution()*interestss.getSecurityquantity();
				}
				interestss.setSendstockQuantity(num);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return interestsDataList;
	}

	@Override
	public String buffwhere(Interests interests) {
		
		StringBuffer buffwhere=new StringBuffer("");
		if(interests.getEquityType()!=null && !interests.getEquityType().equals("")){
			buffwhere.append(" and equityType="+interests.getEquityType());
		}
		if(interests.getStrDate()!=null && !interests.getStrDate().equals("")){
			try {
				interests.setExRights(AllUtil.getDate(interests.getStrDate()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffwhere.append(" and exRights=to_date('"+interests.getExRights()+"','yyyy-MM-dd')");
		}
		buffwhere.append(" and fundCode="+"'"+interests.getFundCode()+"'");
		return buffwhere.toString();
	}
	
	

}
