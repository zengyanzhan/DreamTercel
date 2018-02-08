package com.yidu.system.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.yidu.system.domain.User;

/**
 * 
 * @author HeXiXian
 * @date   2017年11月16日
 * @time   下午2:20:09
 *
 */
public interface UserService {
	/**
	 * 查询
	 * @param user 用户实体类
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */
	public Map<String,Object> selectUser(User user) throws UnsupportedEncodingException;
	/**
	 * 增加
	 * @param user 用户实体类
	 * @return
	 */
	public Integer insertUser(User user);
	/**
	 * 修改
	 * @param user 用户实体类
	 * @return
	 */
	public Integer updateUser(User user);
	/**
	 * 删除
	 * @param user 用户实体类
	 * @return
	 */
	public Integer deleteUser(User user);
	/**
	 * 通过编号查询数据
	 * @param user
	 * @return
	 */
	public User selectOneByCode(User user);
	/**
	 * 登录验证
	 * @param user 用户的实体类
	 * @return 登录成功的标志
	 */
	public User checkLogin(User user);
}
