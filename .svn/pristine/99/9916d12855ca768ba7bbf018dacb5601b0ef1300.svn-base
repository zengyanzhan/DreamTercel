package com.yidu.cashManagement.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.cashManagement.dao.MoneyAllotDao;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.cashManagement.service.MoneyAllotService;
@Service
@Transactional
public class MoneyAllotServiceImpl implements MoneyAllotService{
	@Autowired
	MoneyAllotDao moneyAllotDao; 
	@Override
	public HashMap<String, Object> selectMoneyAllot(MoneyAllot moneyAllot) {
		StringBuffer strWhere=new StringBuffer("");
		String strDate=moneyAllot.getStrDate();//调拨日期
		String strBusinessDate=moneyAllot.getStrBusinessDate();
		if(strDate!=null && !strDate.equals("")){
			strWhere.append("   and  fund_allot_Date=to_date('"+strDate+"',('yyyy-MM-dd'))");
		}else if(strBusinessDate!=null && !strBusinessDate.equals("")){
			strWhere.append("   and    business_date=to_date('"+strBusinessDate+"',('yyyy-MM-dd'))");
		}else if(moneyAllot.getType()!=0){
			strWhere.append("  and   fund_allot_type="+moneyAllot.getType());
		}
		HashMap<String, Object> map=new HashMap<String, Object>();//创建一个map
		map.put("tabName", "fund_allot");
		map.put("qualification", strWhere.toString());
		map.put("page", moneyAllot.getPage());
		map.put("rows", moneyAllot.getRows());
		map.put("orderColumn", "fund_allot_code");
		map.put("orderStyle",moneyAllot.getSortOrder());
		moneyAllotDao.selectMoneyAllot(map);  //给输出参数赋值

		return map;
	}
	@Override
	public int insertMoneyAllot(MoneyAllot moneyAllot) {
		// TODO Auto-generated method stub
		return moneyAllotDao.insertMoneyAllot(moneyAllot);
	}
	@Override
	public int updateMoneyAllot(MoneyAllot moneyAllot) {
		// TODO Auto-generated method stub
		return moneyAllotDao.updateMoneyAllot(moneyAllot);
	}
	@Override
	public int deleteMoneyAllot(MoneyAllot moneyAllot) {
		// TODO Auto-generated method stub
		return moneyAllotDao.deleteMoneyAllot(moneyAllot);
	}
	@Override
	public MoneyAllot selectMoneyAllotByCode(String code) {
		// TODO Auto-generated method stub
		return moneyAllotDao.selectMoneyAllotByCode(code);
	}
	

}
