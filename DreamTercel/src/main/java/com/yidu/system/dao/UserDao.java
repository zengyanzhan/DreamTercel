package com.yidu.system.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.system.domain.User;

/**
 * 用户的数据库操作的接口
 * @author HeXiXian
 * @data  2017年11月14日
 * @time  上午9:55:30
 *
 */
@Repository
public interface UserDao {

	/**
	 * 登录验证 
	 * @param user 包含用户信息的实体类
	 * @return 登录是否成功的标志
	 */
	public User checkLogin(User user);
	/**
	 * 查询
	 * @param map
	 */
	public  void selectUser(Map<String,Object>map);
	/**
	 * 增加
	 * @param user 用户实体类
	 * @return 增加影响的行数
	 */
	public int insertUser(User user);
	/**
	 * 修改
	 * @param user 用户实体类
	 * @return 修改影响的行数
	 */
	public int updateUser(User user);
	/**
	 * 删除
	 * @param user 用户实体类
	 * @return 删除影响的行数
	 */
	public int deleteUser(User user); 
	/**
	 * 通过编号查询数据
	 * @param user 包含编号的实体类
	 * @return
	 */
	public User selectOneByCode(User user);
} 
