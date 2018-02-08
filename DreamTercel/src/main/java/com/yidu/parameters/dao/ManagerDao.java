package com.yidu.parameters.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.Manager;





/**
* @author YiWenQi 
* @version 创建时间：2017年11月20日 上午10:48:49
* 管理人的DAO类
*/
@Repository
public interface ManagerDao {
	/**
	 * 分页查询
	 * @param map
	 */
	public void selectManagerRow(Map<String, Object> map);
		/**
		 * 新增
		 * @param manager实体类
		 * @return
		 */
	public int insertManager(Manager manager); 
	/**
	 * 修改管理人数据的方法
	 * @param manager 实体类
	 * @return int 修改返回的影响行数
	 */
	public int updateManager(Manager manager);
	/**
	 * 删除管理人数据的方法
	 * @param manager
	 * @return int 删除返回影响的行数
	 */
	public int deleteManager(Manager manager);
	/**
	 * 通过管理人编号查询数据
	 * @param manager 
	 * @return
	 */
	public Manager selectManagerByCode(Manager manager);
}
