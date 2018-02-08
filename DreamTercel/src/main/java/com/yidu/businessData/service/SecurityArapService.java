package com.yidu.businessData.service;
import java.sql.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yidu.businessData.domain.SecurityArap;
/**
 * 证券应收应付业务逻辑类
 * @author 邓涛
 * @date 2017年11月17日
 * @time 下午2:15:42
 */
public interface SecurityArapService {
	/**
	 * 增加的方法
	 * @param securityArap 证券应收应付实体类
	 * @return 整型
	 */
	public int insertSecurityArap(SecurityArap securityArap);
	/**
	 * 删除的方法
	 * @param cashArapCode 证券应付应收编号
	 * @return 整型
	 */
	public int deleteSecurityArap(SecurityArap securityArap);
	/**
	 * 修改的方法
	 * @param cashArapCode 证券应付应收编号
	 * @return 整型
	 */
	public int updateSecurityArap(SecurityArap securityArap);
	/**
	 * 查询的方法
	 * @param map 证券应收应付实体类
	 * @return HashMap集合
	 */
	public Map<String, Object>selectSecurityArap(SecurityArap securityArap);
	/**
	 * 通过编号查询
	 * @param cashArapCode 证券应收应付编号
	 * @return CashArap证券应收应付实体类
	 */
	public SecurityArap selectSecurityArapById(String securityArapCode);
	
	/**
	 * 通过账户id 类型 日期 资金流动方向删除的方法
	 * @param cashAccountCode 账户id
	 * @param businessDate 日期
	 * @return
	 */
	public int deleteSqlWhereSecurityArap(String cashAccountCode, Date businessDate, String fundCode,Integer securityArapType);
}
