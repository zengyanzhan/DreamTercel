package com.yidu.dayEnd.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.businessData.dao.CashArapDao;
import com.yidu.businessData.domain.CashArap;
import com.yidu.cashManagement.dao.MoneyAllotDao;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.dayEnd.dao.CashPayDao;
import com.yidu.dayEnd.domain.CashPay;
import com.yidu.dayEnd.service.CashPayService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 现金账户和两费service
 * @author 肖光宇
 * @date 2017年11月22日
 * @time 下午2:32:53
 *
 */
@Service
@Transactional
public class CashPayServiceImpl implements CashPayService{
	@Autowired
	CashPayDao cashPayDao;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	MoneyAllotDao moneyAllotDao;
	@Autowired
	CashArapDao cashArapDao;
	@Override
	public List<CashPay> selectCashPay(CashPay cashPay) {
		String strBusiness=cashPay.getStrBusiness();//得到业务日期的字符串
		HashMap<String, Object> map=new HashMap<String, Object>();
		Date businessDate;
		try {
			if(strBusiness.equals("flag")){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//格式化日期
				businessDate = AllUtil.getDate( sdf.format(new java.util.Date()), -1);//得到昨天的日期
			}
			else{
				businessDate = AllUtil.getDate(strBusiness, -1);//查询昨天的日期
			}
			map.put("businessDate", businessDate);
			map.put("fundCode", cashPay.getFundCode());//从登陆的基金代码中取
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//查询昨天的日期

		return cashPayDao.selectCashPay(map);
	}
	@Override
	public Integer selectnCashPayCount(CashPay cashPay) {
		String strBusiness=cashPay.getStrBusiness();
		Date businessDate;
		try {
			if(strBusiness.equals("flag")){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				businessDate = AllUtil.getDate( sdf.format(new java.util.Date()), -1);//查询昨天的日期
			}else{
				businessDate = AllUtil.getDate(strBusiness, -1);//查询昨天的日期
			}
			cashPay.setBusinessDate(businessDate);
			cashPay.setFundCode(cashPay.getFundCode());//从登陆的基金代码中取
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cashPayDao.selectnCashPayCount(cashPay);
	}
	@Override
	public Integer deleteMoneys(MoneyAllot moneyAllot) {
		// TODO Auto-generated method stub
		return cashPayDao.deleteMoneys(moneyAllot);
	}
	@Override
	public Integer deleteCashAraps(CashArap cashArap) {
		return cashPayDao.deleteCashAraps(cashArap);
	}
	@Override
	public boolean tongJiXianJin(CashPay cashPay) {
		boolean flag=false;
		Integer result1=0;
		Integer result2=0;
		Date date=new Date(System.currentTimeMillis());	//得到当前时间
		cashPay.setBusinessDate(date);//赋值业务日期
		String cashArapCode=selectCashArapCode(cashPay);//查询现金应收应付编号

		try {
			String code=autoBianService.getAutoBianhao("cash_arap", "XJYSYF", "cash_arap_code", "business_date", date);//自动生成现金应收应付编号
			String moneyAllotCode=autoBianService.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date", date);//资金调拨编号
			CashArap cashArap=new CashArap();//创建一个现金应收应付
			MoneyAllot moneyAllot=new MoneyAllot();//创建一个资金调拨
			if(cashArapCode==null){
				cashArap=new CashArap(code,cashPay.getCashAccountCode(),cashPay.getFundCode(),3,-1,cashPay.getMoney(),date,"");//现金应收应付实体类
				//资金调拨实体类
				moneyAllot=new MoneyAllot(moneyAllotCode, cashPay.getFundCode(), cashPay.getMoney(), cashPay.getCashAccountCode(), 1, date, date, code, 1, "");
				result1=cashArapDao.insertCashArap(cashArap);//增加现金应收应付
				result2=moneyAllotDao.insertMoneyAllot(moneyAllot);//增加资金调拨
			}else{
				cashArap.setCashArapCode(cashArapCode);//赋值给现金应收应付编号
				moneyAllot.setBusinessCode(cashArapCode);//赋值给资金调拨业务日期
				Integer flag1=cashPayDao.deleteCashAraps(cashArap);//删除现金应收应付
				Integer flag2=cashPayDao.deleteMoneys(moneyAllot);//删除资金调拨
				if(flag1>0&&flag2>0){
					cashArap=new CashArap(code,cashPay.getCashAccountCode(),cashPay.getFundCode(),3,-1,cashPay.getMoney(),date,"");//现金应收应付实体类
					//资金调拨实体类
					moneyAllot=new MoneyAllot(moneyAllotCode, cashPay.getFundCode(), cashPay.getMoney(), cashPay.getCashAccountCode(), 1, date, date, code, 1, "");
					result1=cashArapDao.insertCashArap(cashArap);//增加现金应收应付
					result2=moneyAllotDao.insertMoneyAllot(moneyAllot);//增加资金调拨
				}

			}
			if(result1>0&result2>0){
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return flag;
	}
	@Override
	public String selectCashArapCode(CashPay cashPay) {
		// TODO Auto-generated method stub
		return cashPayDao.selectCashArapCode(cashPay);
	}
	@Override
	public List<CashPay> selectTwoMoney(CashPay cashPay) {
		String strBusiness=cashPay.getStrBusiness();
		HashMap<String, Object> map=new HashMap<String, Object>();
		Date businessDate;
		try {
			if(strBusiness.equals("flag")){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//格式化
				businessDate = AllUtil.getDate( sdf.format(new java.util.Date()), -1);//得到昨天的日期
			}
			else{
				businessDate = AllUtil.getDate(strBusiness, -1);//查询昨天的日期
			}
			map.put("businessDate", businessDate);
			map.put("fundCode", cashPay.getFundCode());//从登陆的基金代码中取
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//查询昨天的日期
		// TODO Auto-generated method stub
		return cashPayDao.selectTwoMoney(map);
	}
	@Override
	public Integer selectTwoMoneyCount(CashPay cashPay) {
		String strBusiness=cashPay.getStrBusiness();
		Date businessDate;
		try {
			if(strBusiness.equals("flag")){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//格式化
				businessDate = AllUtil.getDate( sdf.format(new java.util.Date()), -1);//查询昨天的日期
			}else{
				businessDate = AllUtil.getDate(strBusiness, -1);//查询昨天的日期
			}
			cashPay.setBusinessDate(businessDate);//赋值业务日期
			cashPay.setFundCode(cashPay.getFundCode());//从登陆的基金代码中取
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cashPayDao.selectTwoMoneyCount(cashPay);
	}
	@Override
	public boolean tongJiTwoMoney(CashPay cashPay) {
		boolean flag=false;
		Integer result1=0;
		Integer result2=0;
		Date date=new Date(System.currentTimeMillis());	//得到当前时间
		cashPay.setBusinessDate(date);
        
		String cashArapCode=selectTwoMoneyCode(cashPay);//查询现两费编号
	
		try {
			String code=autoBianService.getAutoBianhao("cash_arap", "XJYSYF", "cash_arap_code", "business_date", date);//自动生成现金应收应付编号
			String moneyAllotCode=autoBianService.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date", date);//资金调拨编号
			CashArap cashArap=new CashArap();//创建一个现金应收应付
			MoneyAllot moneyAllot=new MoneyAllot();//创建一个资金调拨
			if(cashArapCode==null){
				cashArap=new CashArap(code,cashPay.getCashAccountCode(),cashPay.getFundCode(),cashPay.getBusinessType(),1,cashPay.getMoney(),date,"");//现金应收应付实体类
				moneyAllot=new MoneyAllot(moneyAllotCode, cashPay.getFundCode(), cashPay.getMoney(), cashPay.getCashAccountCode(), -1, date, date, code, 4, "");//资金调拨实体类
				result1=cashArapDao.insertCashArap(cashArap);//增加现金应收应付
				result2=moneyAllotDao.insertMoneyAllot(moneyAllot);//增加资金调拨
			}else{
				cashArap.setCashArapCode(cashArapCode);//赋值现金应收应付编号
				moneyAllot.setBusinessCode(cashArapCode);//赋值资金调拨业务编号
				Integer flag1=cashPayDao.deleteCashAraps(cashArap);//删除现金应收应付
				Integer flag2=cashPayDao.deleteMoneys(moneyAllot);//删除资金调拨
				if(flag1>0&&flag2>0){
					cashArap=new CashArap(code,cashPay.getCashAccountCode(),cashPay.getFundCode(),cashPay.getBusinessType(),1,cashPay.getMoney(),date,"");//现金应收应付实体类
					moneyAllot=new MoneyAllot(moneyAllotCode, cashPay.getFundCode(), cashPay.getMoney(), cashPay.getCashAccountCode(), -1, date, date, code, 4, "");//资金调拨实体类
					result1=cashArapDao.insertCashArap(cashArap);//增加现金应收应付
					result2=moneyAllotDao.insertMoneyAllot(moneyAllot);//增加资金调拨
				}

			}
			if(result1>0&result2>0){
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return flag;
	}
	@Override
	public String selectTwoMoneyCode(CashPay cashPay) {
		// TODO Auto-generated method stub
		return cashPayDao.selectTwoMoneyCode(cashPay);
	}


}
