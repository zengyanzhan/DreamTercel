package com.yidu.cashManagement.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.yidu.cashManagement.domain.AppropriationOrder;

/**
 * 
 * @author 肖光宇
 * @date 2017年11月28日
 * @time 上午11:29:09
 *
 */
@Repository
public interface AppropriationOrderDao {
	/**
	 * 查询划款指令
	 * @param map
	 * @return 划款指令map
	 */
	public HashMap<String,Object> selectAppripriationOrder(HashMap<String,Object> map);
	/**
	 * 增加划款指令
	 * @param appropriationOrder 划款指令实体类
	 * @return 划款指令实体类
	 */
	public Integer insertApproOrder(AppropriationOrder appropriationOrder);
	/**
	 * 修改划款指令
	 * @param appropriationOrder 划款指令实体类
	 * @return 划款指令实体类
	 */
	public Integer updateApproOrder(AppropriationOrder appropriationOrder);
	/**
	 * 删除划款指令
	 * @param appropriationOrder 划款指令实体类
	 * @return 划款指令实体类
	 */
	public Integer deleteApproOrder(AppropriationOrder appropriationOrder);
	/**
	 * 通过编号查询划款指令
	 * @param code  编号
	 * @return 划款指令实体类
	 */
	public AppropriationOrder selectApproCode(String code);
	
}
