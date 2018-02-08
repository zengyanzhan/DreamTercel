package com.yidu.parameters.service;

import java.util.HashMap;
import java.util.List;

import com.yidu.parameters.domain.Bond;

/**
 * 债劵信息数据库业务逻辑操作抽象类
 * @author 杨丽
 * @date 2017年11月14日	
 * @time 下午3:27:19
 *
 */
public interface BondService {
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
	public HashMap<String,Object> selectBonds(
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
	public String bufferWhere(Bond bond);
	/**
	 * 按条件删除
	 * @param bondCode	主键列  债劵id
	 * @return	受影响的行数
	 */
	public int deleteBondByBondIds(String bondCode);
	/**
	 * 增加债劵信息
	 * @param bond	债劵信息对象
	 * @return	返回1 增加成功	返回0 增加失败
	 */
	public int insertBond(Bond bond);
	/**
	 * 修改债劵信息
	 * @param bond	债劵信息对象
	 */
	public void updateBond(Bond bond);
	
	/**
	 * 通过id查询债劵信息
	 * @param bondCode	债劵id
	 * @return	债劵信息对象
	 */
	public Bond selectBondByIds(String bondCode);
	/**
	 * 通过类型（2债劵）查询出债劵与证券不相同的编号
	 * @param securityType	证券类型
	 * @return	list集合
	 */
	public List<Bond> selectSecurityTypes(Integer securityType);
}


