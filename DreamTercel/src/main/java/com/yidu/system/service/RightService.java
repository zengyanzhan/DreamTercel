package com.yidu.system.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.yidu.system.domain.Right;
/**
 * 功能表的业务处理层
 * @author ZouJianwen
 * @data  2017年11月15日
 * @time  下午2:53:23
 *
 */
public interface RightService {
	
	/**
	 * 通过用户名查询父功能模块
	 * @param userName 用户名
	 * @return 包含功能模块的集合
	 */
	public List<Right> selectSysRightByDocument(String userName);
	/**
	 * 通过用户名和父功能编号查询子功能
	 * @param userName 用户名
	 * @param parentCode 父功能编号
	 * @return 包含功能模块的集合
	 */
	public List<Right> selectSysRightByFloder(String  userName,String parentCode);
	
	/**
	 * 通过角色编号查询父功能
	 * @param roleCode 角色编号
	 * @return 包含功能模块的集合
	 */
	public List<Right> selectRightByRoleAndDocument(String  roleCode);
	/**
	 * 通过角色编号和父功能编号查询子功能
	 * @param roleCode 角色编号
	 * @param parentCode父功能编号
	 * @return 包含功能模块的集合
	 */
	public List<Right> selectRightRoleAndFloder(String  roleCode,String parentCode);
	
	/**
	 * 查询所有的功能权限
	 * @param right 参数
	 * @return Map 返回功能集合
	 * @throws UnsupportedEncodingException 
	 */
	public Map<String,Object> selectRight(Right right) throws UnsupportedEncodingException;
	
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
	public int deleteRight(String rightCodes);
	
	/**
	 * 增加功能的方法
	 * @param right 参数
	 * @return int 增加是否成功
 	 */
	public int insertRight(Right right);
	
	/**
	 * 查询功能编号 或者
	 * @param rightType 功能类型
	 * @return 字符串 存贮功能编号
	 */
	public String selectRightCodeByType(Right right);
	
	/**
	 * 查询所有父功能id
	 * @param flag 标志
	 * @return 功能集合
	 */
	public  List<Right> selectRightParentCodeByType(String flag);
}
