package com.yidu.dayEnd.dao;

import java.util.List;
import java.util.Map;

import com.yidu.dayEnd.domain.NetValue;
/**
 * 净值统计链接数据库的操作类接口
 * @author 向燕春
 * @date 2017年11月18日
 * @time 下午10:07:17
 *
 */
public interface NetValueDao {
	/**
	 * 多条件查询，查询净值统计表的数据
	 * @param map 集合
	 */
	public void selectNetValues(Map<String, Object> map);
	/**
	 * 删除净值统计表的数据
	 * @param netValue 净值统计表的实体对象
	 * @return 删除的条数
	 */
	public int deleteNetValue(NetValue netValue);
	/**
	 * 增加净值统计表的数据
	 * @param netValue	净值统计表的实体对象
	 * @return	增加的条数
	 */
	public int insertNetValue(NetValue netValue);
	/**
	 * 查询证券下面股票、债券各自的详细信息
	 * @param netValue 净值统计表的实体对象
	 * @return list集合
	 */
	public List<NetValue> selectSecurityDetail(NetValue netValue);
	/**
	 * 查询证券下面股票、债券的头部信息
	 * @param netValue 净值统计表的实体对象
	 * @return list集合
	 */
	public NetValue selectSecurity(NetValue netValue);
	/**
	 * 查询证券的总头部（包含股票+债券）
	 * @param netValue 净值统计表的实体对象
	 * @return list集合
	 */
	public NetValue selectSecurityAll(NetValue netValue);
	/**
	 * 查询账户现金的总和（账户头部）
	 * @param netValue 净值统计表的实体对象
	 * @return list集合
	 */
	public List<NetValue> selectCashAccount(NetValue netValue);
	/**
	 * 查询现金账户的应收应付详情
	 * @param netValue 净值统计表的实体对象
	 * @return 净值统计表实体类
	 */
	public NetValue selectCashAccountDetail(NetValue netValue);
	/**
	 * 查询证券应收应付的详情
	 * @param netValue 净值统计表的实体对象
	 * @return 净值统计表实体类
	 */
	public NetValue selectSecurityArapDetail(NetValue netValue);
	/**
	 * 查询债券利息 
	 * @param netValue 净值统计表的实体对象
	 * @return 净值统计表实体类
	 */
	public NetValue selectBondLiXi(NetValue netValue);
	/**
	 * 查询TA交易数量
	 * @param netValue 净值统计表的实体对象
	 * @return 交易的数量
	 */
	public Integer selectTaQuantity(NetValue netValue);
}
