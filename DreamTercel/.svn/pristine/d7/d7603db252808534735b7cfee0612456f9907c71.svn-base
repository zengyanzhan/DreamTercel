package com.yidu.reportManagement.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.reportManagement.dao.StockeQuityDao;
import com.yidu.reportManagement.domain.StockeQuity;
import com.yidu.reportManagement.service.StockeQuityService;
import com.yidu.util.AllUtil;
/**
 * 股票权益service实现类
 * @author XiaoYuJie
 * @date 2017年12月6日
 * @time 下午7:49:16
 */
@Transactional
@Service
public class StockeQuityServiceImpl implements StockeQuityService{
	
	@Autowired
	StockeQuityDao   stockeQuityDao; 
	@Override
	public Map<String, Object> selectStockeQuity(String tableName, String qualification, Integer page, Integer rows,
			Integer rowsTotal, String orderColumn, String orderStyle) {
		System.err.println("qualification"+qualification+"page"+page+"rows"+rows);
		Map map=new HashMap();
		tableName="( select nvl(sum(st.security_total_money),0)as totalmoney ,nvl(sum(st.security_quantity),0) as securityquantity,"
				+" st.security_name as securityName ,st.security_code as securityCode,ed.ex_day as exRights,"
				+" ed.share_qut_bonus_scale as equityType"
				+" from equity_data ed left   join  security_stock st on ed.security_code=st.security_code "  
				+" group by st.security_name,st.security_code,ed.ex_day,ed.share_qut_bonus_scale )";
		map.put("tableName", tableName);
		map.put("qualification", qualification);
		map.put("page", page);
		map.put("rows", rows);
		map.put("orderColumn", "securityCode");
		map.put("orderStyle", "");	
		//通过实体类查询数据
		stockeQuityDao.selectStockeQuity(map);
		map.get("cursor");
		return map;
	}

	@Override
	public String buffwhere(StockeQuity stockeQuity) {
		
		StringBuffer buffwhere=new StringBuffer("");
		if(stockeQuity.getEquityType()!=null && !stockeQuity.getEquityType().equals("")){
			buffwhere.append(" and equityType="+stockeQuity.getEquityType());
		}
		if(stockeQuity.getStrDate()!=null && !stockeQuity.getStrDate().equals("")){
			try {
				stockeQuity.setExRights(AllUtil.getDate(stockeQuity.getStrDate()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffwhere.append(" and exRights=to_date('"+stockeQuity.getExRights()+"','yyyy-MM-dd')");
		}
		return buffwhere.toString();
	}

}
