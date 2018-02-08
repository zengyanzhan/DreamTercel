package com.yidu.parameters.service;

import java.util.HashMap;

import com.yidu.parameters.domain.Security;

/**
 * 证劵信息数据库业务逻辑操作抽象类
 * @author 杨丽
 * @date 2017年11月20日	
 * @time 下午3:00:23
 *
 */
public interface SecurityService {
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
	public HashMap<String,Object> selectSecuritys(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle
		);
	
	/**
	 *拼接条件 
	 * @param bond	债劵信息对象
	 * @return	拼接好的条件
	 */
	public String bufferWhere(Security security);
	/**
	 * 增加证劵信息的方法
	 * @param security	证券信息对象
	 * @return	返回0 增加失败 返回1	增加成功
	 */
	public int insertSecurity(Security security);
	/**
	 * 通过id删除证券信息的方法
	 * @param securityCode	证券id
	 * @return	返回0 删除失败	返回1	删除成功
	 */
	public int deleteSecurityByIds(String securityCode);
	/**
	 * 修改的方法
	 * @param security	证券信息对象
	 */
	public void updateSecurity(Security security);
	/**
	 * 通过id查询证券信息
	 * @param securityCode	证券id
	 * @return	证券信息对象
	 */
	public Security selectSecurityByIds(String securityCode);
}
