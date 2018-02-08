package com.yidu.dayEnd.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.yidu.dayEnd.domain.BondAccrual;
/**
 * 债券计息接口
 * @author 邓涛
 * @date 2017年11月26日
 * @time 下午6:25:36 
 */
@Repository
public interface BondAccrualDao {
	/**
	 * 查询债券利息
	 * @param map 集合
	 */
	public List selectBondAccrual(Map<Object, Object> map);
	/**
	 * 通过账户id 统计日期 查询债券计息的方法
	 * @param businessDateWhere 日期
	 * @param bondCode 债券代码 
	 * @return List集合
	 */
	public List<BondAccrual> selectByIdBondAccrual(String bondCode);
	/**
	 * 查询总条数的方法
	 * @return
	 */
	public int selectSize();
}
