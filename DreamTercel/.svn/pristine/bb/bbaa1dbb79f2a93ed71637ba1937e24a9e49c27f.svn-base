package com.yidu.parameters.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.Broket;

/**
 * 券商信息数据库操作类
 * @author Wang
 * @date 2017年11月16日
 * @time 上午11:14:54
 */
@Repository
public interface BroketDao {
	/**
	 * 查询所有信息
	 * @param map 条件查询的map
	 */
	public void selectBroket(Map<String, Object> map);
	/**
	 * 增加券商信息
	 * @param broket 券商信息实体对象
	 * @return 受影响行数
	 */
	public int insertBroket(Broket broket);
	/**
	 * 修改券商信息
	 * @param broket 券商信息实体对象
	 * @return 受影响行数
	 */
	public int updateBroket(Broket broket);
	/**
	 * 删除券商信息
	 * @param broket 券商信息实体对象
	 * @return 受影响行数
	 */
	public int deleteBroket(Broket broket);
	/**
	 * 通过券商编号查询券商信息
	 * @param broketCode 券商编号
	 * @return 券商信息集合
	 */
	public List<Broket> selectBroketById(String broketCode);
}
