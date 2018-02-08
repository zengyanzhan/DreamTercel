package com.yidu.parameters.dao;
/**
 * 现金账号表 Dao
 * @author 肖向恩
 *	
 */
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.CashAccount;
@Repository
public interface CashAccountDao {
	
	/**
	 * 查询现金账户
	 * @return	Map集合
	 */
	public void selectCashAccount(Map<String, Object> map);
	
	/**
	 * 按条件删除现金账户
	 * @param bondCode	主键列 债劵id
	 */
	public int deleteCashAccountId(String cashAccountCodes);
	/**
	 * 添加现金账户
	 * @return	现金集合
	 */
	public Integer insertCashaccount(CashAccount cashAccount);
	/**
	 *	修改现金账户
	 * @return	现金集合
	 */
	public int updateCashAccount(CashAccount cashAccount);
	/**
	 *	查询现金账户ID
	 *@return	现金账户ID
	 */
	public CashAccount selectCashAccountIds(String cashAccountCodes);
}
