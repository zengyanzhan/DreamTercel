package com.yidu.parameters.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.Bond;

/**
 * 债劵信息数据库操作抽象类
 * @author 杨丽
 * @date 2017年11月14日	
 * @time 下午3:23:14
 *
 */
@Repository
public interface BondDao {
	/**
	 * 查询债劵信息
	 * @return	债劵信息集合
	 */
	public void selectBonds(Map<String, Object> map);
	/**
	 * 条件拼接
	 * @param bond	债券信息对象
	 * @return	拼接好的条件
	 */
	public String bufferWhere(Bond bond);
	/**
	 * 按条件删除
	 * @param bondCode	主键列 债劵id
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
