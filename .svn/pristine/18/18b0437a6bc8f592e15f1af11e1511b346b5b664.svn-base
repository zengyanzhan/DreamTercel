package com.yidu.parameters.service;
/**
 * 现金账号表业务处理Service
 * @author 肖向恩
 *	
 */
import java.util.HashMap;

import com.yidu.parameters.domain.Bond;
import com.yidu.parameters.domain.CashAccount;

public interface CashAccountService {

	/**
	 * 查询债劵信息数据
	 * @param tableName 表名
	 * @param qualification 条件
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectCashAccount(CashAccount cashAccount);
	/**
	 * 按条件删除
	 * @param cashAccountCode	主键列  债劵id
	 * @return	受影响的行数
	 */
	public int deleteCashAccountId(String cashAccountCode);
	/**
	 * 添加现金账户
	 * @return	现金集合
	 */
	public int insertCashAccount(CashAccount cashAccount);
	/**
	 * 修改现金账户
	 * @param bond	债劵信息对象
	 */
	public int updateCashAccount(CashAccount cashAccount);
	/**
	 *	修改现金账户ID查询
	 */
	public CashAccount selectCashAccountIds(String cashAccountCodes);
	
}
