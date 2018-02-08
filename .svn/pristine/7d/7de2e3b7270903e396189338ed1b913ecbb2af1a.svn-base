package com.yidu.system.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.system.domain.Right;
/**
 * 功能表的数据库操作类
 * @author ZouJianwen
 * @data  2017年11月15日
 * @time  下午2:28:41
 *
 */
@Repository
public interface RightDao {

	/**
	 * 通过用户名查询所有的大功能
	 * @param map 包含条件的map集合
	 * @return 包含功能模块的集合
	 */
	public List<Right> selectSysRightByDocument(HashMap<String, Object> map);
	/**
	 * 通过用户名查询子功能
	 * @param map 包含条件的map集合
	 * @return 包含功能模块的集合
	 */
	public List<Right> selectSysRightByFloder(HashMap<String, Object> map);
	/**
	 * 通过角色编号 查询父模块
	 * @param map
	 * @return
	 */
	public List<Right> selectRightByRoleAndDocument(HashMap<String, Object> map);
	/**
	 * 通过角色编号 查询子模块
	 * @param map
	 * @return
	 */
	public List<Right> selectRightRoleAndFloder(HashMap<String, Object> map);
	
	/**
	 * 查询所有的功能权限
	 * @param right 参数
	 * @return Map 返回功能集合
	 */
	public Map<String,Object> selectRight(Map<String, Object> map);
	
	/**
	 * 修改功能的方法
	 * @param right 参数
	 * @return int 是否修改成功
	 */
	public int updateRight(Right right);
	
	/**
	 * 删除功能方法 
	 * @param rightCode 功能id
	 * @return int 是否删除成功
	 */
	public int deleteRight(Map<String,Object> map);
	
	/**
	 * 增加功能的方法
	 * @param right 参数
	 * @return int 增加是否成功
 	 */
	public int insertRight(Right right);
	
	/**
	 * 查询功能编号 
	 * @param rightType 功能类型
	 * @return 字符串 存贮功能编号
	 */
	public String selectRightCodeByType(Right right);
	
	/**
	 * 查询所有父功能id
	 * @return
	 */
	public  List<Right> selectRightParentCodeByType(Map<String,Object> map);
}
