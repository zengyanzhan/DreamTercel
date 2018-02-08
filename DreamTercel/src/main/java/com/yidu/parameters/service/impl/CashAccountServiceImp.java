package com.yidu.parameters.service.impl;
/**
 * serviced的继承类
 * @author 肖向恩
 *	
 */
import java.io.UnsupportedEncodingException;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.parameters.dao.CashAccountDao;
import com.yidu.parameters.domain.Bond;
import com.yidu.parameters.domain.CashAccount;
import com.yidu.parameters.service.CashAccountService;
import com.yidu.stockControl.dao.CashArapStockDao;
@Service
@Transactional
public class CashAccountServiceImp implements CashAccountService{
	//现金账号的Dao类
	@Autowired
	CashAccountDao cashAccountDao;
	/**
	 * 现金账号查询的方法
	 */
	@Override
	public HashMap<String, Object> selectCashAccount(CashAccount cashAccount) {
	//创建一个strWhere SBF
		StringBuffer strWhere = new StringBuffer("");
		if(cashAccount.getCashAccountBankName()!=null&&!cashAccount.getCashAccountBankName().equals("")){
			try {
				strWhere.append("  and cash_account_bank_name  like '%"+(new String (cashAccount.getCashAccountBankName().getBytes("ISO8859-1"),"UTF-8"))+"%'  ");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("tableName","cash_account");
				map.put("qualification",strWhere.toString());
				map.put("page",cashAccount.getPage());
				map.put("rows",cashAccount.getRows());
				map.put("orderColumn","CASH_ACCOUNT_CODE");
				map.put("orderStyle","asc");
				cashAccountDao.selectCashAccount(map);
				System.err.println(map);
				return map;
	}
	
	/**
	 * 删除的方法
	 */
	@Override
	public int deleteCashAccountId(String cashAccountCode) {
		String[] split=cashAccountCode.split(",");
		int size=0;
		for(int i=0;i<split.length;i++){
			size=cashAccountDao.deleteCashAccountId(split[i]);
			++size;
		}
		return size;
	}

	/**
	 * 添加的方法
	 */
	@Override
	public int insertCashAccount(CashAccount cashAccount) {
		// TODO Auto-generated method stub
				int size=cashAccountDao.insertCashaccount(cashAccount);
				return size;
	}
	/**
	 * 修改的方法
	 */

	@Override
	public int updateCashAccount(CashAccount cashAccount) {
		// TODO Auto-generated method stub
		int updateCashAccount=cashAccountDao.updateCashAccount(cashAccount);
		return updateCashAccount;
	}

	/**
	 * 查询id的方法
	 */
	@Override
	public CashAccount selectCashAccountIds(String cashAccountCodes) {
		CashAccount cashAccount=cashAccountDao.selectCashAccountIds(cashAccountCodes);
		return cashAccount;
	}
	
}
