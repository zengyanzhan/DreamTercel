package com.yidu.dayEnd.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.businessData.dao.SecurityArapDao;
import com.yidu.businessData.domain.SecurityArap;
import com.yidu.cashManagement.dao.MoneyAllotDao;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.dao.BondPayDao;
import com.yidu.dayEnd.domain.BondPay;
import com.yidu.dayEnd.service.BondPayService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 债券支付的服务实现类
 * @author 肖光宇
 * @date 2017年11月21日
 * @time 上午10:22:22
 *
 */
@Service
@Transactional
public class BondPayServiceImpl implements BondPayService{
	@Autowired
	BondPayDao bondPayDao;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	MoneyAllotDao moneyAllotDao;
	@Autowired
	SecurityArapDao securityArapDao;
	@Override
	public List<BondPay> selectBondPay(BondPay bondPay) {
		//得到字符串的业务日期
		String strBusiness=bondPay.getStrBusiness();
		HashMap<String, Object> map=new HashMap<String, Object>();
		Date businessDate;
		try {
			if(strBusiness.equals("flag")){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//格式化日期
				businessDate = AllUtil.getDate( sdf.format(new java.util.Date()), -1);//查询昨天的日期
			}else{
				businessDate = AllUtil.getDate(strBusiness, -1);//查询昨天的日期
			}
			map.put("businessDate", businessDate);
			map.put("fundCode", bondPay.getFundCode());//从登陆的基金代码中取
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bondPayDao.selectBondPay(map);
	}
	@Override
	public Integer selectBondPayCount(BondPay bondPay) {
		String strBusiness=bondPay.getStrBusiness();//得到业务日期的字符串
		Date businessDate;
		try {
			if(strBusiness.equals("flag")){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				businessDate = AllUtil.getDate( sdf.format(new java.util.Date()), -1);//查询昨天的日期
			}else{
				businessDate = AllUtil.getDate(strBusiness, -1);//查询昨天的日期
			}
			bondPay.setBusinessDate(businessDate);
			bondPay.setFundCode(bondPay.getFundCode());//从登陆的基金代码中取
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bondPayDao.selectBondPayCount(bondPay);
	}
	@Override
	public boolean tongJiZhaiQuan(BondPay bondPay) {
		boolean flag=false;
		Integer result1=0;
		Integer result2=0;
		Date date=new Date(System.currentTimeMillis());	//得到当前时间
		bondPay.setBusinessDate(date);//赋值给业务日期
		String securityarapCode=securityarapCode(bondPay);//查询证券应收应付编号
		try {
			String securityArapCode=autoBianService.getAutoBianhao("security_arap", "ZJYSYF", "security_arap_code", "business_date", date);//自动生成证券应收应付编号
			String moneyAllotCode=autoBianService.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date", date);//自动生成资金调拨编号
			MoneyAllot moneyAllot=new MoneyAllot();//创建资金调拨
			SecurityArap securityArap=new  SecurityArap();//创建证券应收应付
			if(securityarapCode==null){
				//证券应收应付实体类
				 securityArap=new  SecurityArap(securityArapCode,bondPay.getAccountCode(),bondPay.getFundCode(),bondPay.getBondCode(),3,-1,bondPay.getAllMoney(),date,"");
				//资金调拨实体类
				 moneyAllot=new MoneyAllot(moneyAllotCode,bondPay.getFundCode(),securityArap.getMoney(),securityArap.getCashAccountCode(),1,date,date,securityArapCode,5,"");
				result1=moneyAllotDao.insertMoneyAllot(moneyAllot);//增加资金调拨
				result2=securityArapDao.insertSecurityArap(securityArap);//增加证券应收应付
			}else{
				moneyAllot.setBusinessCode(securityarapCode);//赋值资金调拨业务编号
				securityArap.setSecurityCode(securityarapCode);//赋值证券应收应付编号
				Integer flag1=bondPayDao.deleteSecurityaraps(securityArap);//删除证券应收应付
				Integer flag2=bondPayDao.deleteMoneys(moneyAllot);//删除资金调拨
				
				if(flag1>0&&flag2>0){
					//证券应收应付实体类
					 securityArap=new  SecurityArap(securityArapCode,bondPay.getAccountCode(),bondPay.getFundCode(),bondPay.getBondCode(),3,-1,bondPay.getAllMoney(),bondPay.getBusinessDate(),"");
					//资金调拨实体类
					 moneyAllot=new MoneyAllot(moneyAllotCode,bondPay.getFundCode(),securityArap.getMoney(),securityArap.getCashAccountCode(),1,date,bondPay.getBusinessDate(),securityArapCode,5,"");
					result1=moneyAllotDao.insertMoneyAllot(moneyAllot);//增加资金调拨
					result2=securityArapDao.insertSecurityArap(securityArap);//增加证券应收应付
				}
			}
			if(result1>0&result2>0){
				flag=true;
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//根据工具类自动生成编号

		return flag;
	}
	@Override
	public String securityarapCode(BondPay bondPay) {
		return bondPayDao.selectSecurityarapCode(bondPay);
	}
	@Override
	public Integer deleteSecurityaraps(SecurityArap securityArap) {
		// TODO Auto-generated method stub
		return bondPayDao.deleteSecurityaraps(securityArap);
	}
	@Override
	public Integer deleteMoneys(MoneyAllot moneyAllot) {
		// TODO Auto-generated method stub
		return bondPayDao.deleteMoneys(moneyAllot);
	}

}
