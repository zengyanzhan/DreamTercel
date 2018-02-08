package com.yidu.parameters.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.Fund;


/**
 * 
 * @author YiWenQi
 * 
 * @date 2017年11月22日
 * @time 下午1:50:30
 */
@Repository
public interface FundDao {
	/**
	 * 分页查询
	 * @param map
	 */
	public void selectFundRow(Map<String, Object> map);
		/**
		 * 新增
		 * @param fund
		 * @return
		 */
	public int insertFundRow(Fund fund); 
	/**
	 * 修改角色数据的方法
	 * @param role 角色实体类
	 * @return int 修改返回的影响行数
	 */
	public int updateFund(Fund fund);
	/**
	 * 删除角色数据的方法
	 * @param map
	 * @return int 删除返回影响的行数
	 */
	public int deleteFund(Fund fund);
	/**
	 * 通过编号查询数据
	 * @param fund 
	 * @return
	 */
	public Fund selectFundByCode(Fund fund);
	/**
	 * 通过基金代码查询基金名称
	 * @param fundCode
	 * @return
	 */
	public String selectFundName(String fundCode);

}
