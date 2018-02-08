package com.yidu.dayEnd.service;

import java.util.HashMap;
import java.util.List;

import com.yidu.dayEnd.domain.NetValue;
/**
 * 净值统计业务逻辑层接口
 * @author 向燕春
 * @date 2017年11月18日
 * @time 下午10:07:17
 *
 */
public interface NetValueService {
	/**
	 * 查询所有的现金应收应付库存的数据
	 * @param tableName 表名
	 * @param qualification 条件
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectNetValues(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle
			);
	/**
	 * 条件拼接
	 * @param netValue 净值统计的实体类
	 * @return 拼接的条件
	 */
	public String strWhere(NetValue netValue);
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
