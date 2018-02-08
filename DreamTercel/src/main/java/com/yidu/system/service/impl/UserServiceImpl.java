package com.yidu.system.service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.system.dao.UserDao;
import com.yidu.system.domain.User;
import com.yidu.system.service.UserService;
import com.yidu.util.AllUtil;

/**
 * 
 * @author HeXiXian
 * @date   2017年11月16日
 * @time   下午2:17:21
 *
 */
@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userdao;
	@Override
	public Map<String, Object> selectUser(User user) throws UnsupportedEncodingException {
	
		Map<String,Object>map=new HashMap<String,Object>();
		StringBuffer strWhere=new StringBuffer();
		String name=new String(user.getUserName().getBytes("iso8859-1"),"UTF-8");
		//条件查询
		if(name!=null&&!name.equals("")){
			strWhere.append("and user_name like '%"+name+"%'");
		}if(user.getCreateDate()!=null&&!user.getCreateDate().equals("")){
			strWhere.append("and user_create_date=to_date('"+user.getCreateDate()+"','yyyy-mm-dd')");
		}
		map.put("tableName", "users");//表名
		map.put("qualification", strWhere.toString());//条件
		map.put("page", user.getPage());//当前的页
		map.put("rows", user.getRows());//当前的行
		map.put("orderColumn", "user_code");//排序的列
		map.put("orderStyle", user.getSortOrder());//排序的方式
		userdao.selectUser(map);
		// TODO Auto-generated method stub
		return map;
	}
	@Override
	public Integer insertUser(User user) {
		// TODO Auto-generated method stub
		return userdao.insertUser(user);
	}
	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
	}
	@Override
	public Integer deleteUser(User user) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(user);
	}
	@Override
	public User selectOneByCode(User user) {
		// TODO Auto-generated method stub
		return userdao.selectOneByCode(user);
	}

	@Override
	public User checkLogin(User user) {
		// TODO Auto-generated method stub
		return userdao.checkLogin(user);
	}


	
}
