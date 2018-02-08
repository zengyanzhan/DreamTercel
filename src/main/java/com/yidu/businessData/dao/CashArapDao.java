package com.yidu.businessData.dao;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.yidu.businessData.domain.CashArap;
/**
 * 现金应收应付持久层接口类
 * @author 邓涛
 * @date 2017年11月14日
 * @time 下午3:55:40
 */
@Repository
public interface CashArapDao {
	/**
	 * 增加的方法
	 * @param cashArap 现金应收应付实体类
	 * @return boolean为true则增加
	 */
	public int insertCashArap(CashArap cashArap);
	/**
	 * 删除的方法
	 * @param cashArapCode 现金应付应收编号
	 * @return 整型
	 */
	public int deleteCashArap(CashArap cashArap);
	/**
	 * 修改的方法
	 * @param cashArapCode 现金应付应收编号
	 * @return 整型
	 */
	public int updateCashArap(CashArap cashArap);
	/**
	 * 查询的方法
	 * @param map 现金应收应付实体类
	 * @return HashMap集合
	 */
	public Map<String, Object>selectCashArap(HashMap<String, Object> map);
	/**
	 * 通过编号查询
	 * @param cashArapCode 现金应收应付编号
	 * @return CashArap现金应收应付实体类
	 */
	public CashArap selectCashArapById(String cashArapCode);
	/**
	 * 通过账户编号 统计时间删除的方法
	 * @param cashAccountCode 账户编号
	 * @param businessDate 统计时间
	 * @return
	 */
	public int deleteSqlWhereCashArap(@Param("cashAccountCode")String cashAccountCode, @Param("businessDate")Date businessDate,@Param("fundCode")String fundCode,@Param("cashArapType")Integer cashArapType);
}
