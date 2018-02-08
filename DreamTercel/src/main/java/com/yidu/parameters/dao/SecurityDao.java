package com.yidu.parameters.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.Security;
import com.yidu.parameters.domain.StockPlate;

/**
 * 证劵信息数据库操作抽象类
 * @author 杨丽
 * @date 2017年11月20日	
 * @time 下午2:52:38
 *
 */
@Repository
public interface SecurityDao {
	/**
	 * 查询证劵信息
	 * @return	证劵信息集合
	 */
	public void selectSecuritys(Map<String, Object> map);
	/**
	 * 条件拼接
	 * @param security	证券信息对象
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
