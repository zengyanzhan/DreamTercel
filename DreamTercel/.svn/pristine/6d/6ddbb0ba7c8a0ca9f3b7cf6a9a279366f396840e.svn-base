package com.yidu.parameters.service;

import java.util.List;
import java.util.Map;

import com.yidu.parameters.domain.Broket;

/**
 * 券商信息业务逻辑处理类
 * @author Wang
 * @date 2017年11月16日
 * @time 上午11:01:42
 */
public interface BroketService {
	/**
	 * 查询券商信息
	 * @param broket  券商实体对象
	 * @return 分页条数和券商数据集合
	 */
	public Map<String, Object> selectBorket(Broket broket);
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
