package com.yidu.system.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.system.dao.RightDao;
import com.yidu.system.domain.Right;
import com.yidu.system.service.RightService;
/**
 * 模块管理的业务处理层实现类
 * @author ZouJianwen
 * @data  2017年12月20日
 * @time  上午8:45:13
 *
 */
@Transactional
@Service
public class RightServiceImpl implements RightService {

	@Autowired
	RightDao rightDao;

	@Override
	public List<Right> selectSysRightByDocument(String userName) {
		//创建集合
		HashMap<String,Object> map = new HashMap<String,Object>();
		//添加数据
		map.put("userName", userName);
		return rightDao.selectSysRightByDocument(map);
	}

	@Override
	public List<Right> selectSysRightByFloder(String userName, String parentCode) {
		//创建集合
		HashMap<String,Object> map = new HashMap<>();
		//添加数据
		map.put("userName", userName);
		map.put("parentCode", parentCode);
		return rightDao.selectSysRightByFloder(map);

	}

	@Override
	public List<Right> selectRightByRoleAndDocument(String roleCode) {
		//创建集合
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("roleCode", roleCode);
		return rightDao.selectRightByRoleAndDocument(map);
	}

	@Override
	public List<Right> selectRightRoleAndFloder(String roleCode, String parentCode) {
		//创建集合
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("roleCode", roleCode);
		map.put("parentCode", parentCode);
		return rightDao.selectRightRoleAndFloder(map);
	}

	@Override
	public Map<String, Object> selectRight(Right right) throws UnsupportedEncodingException {
		
		String rightText=null;
		//缓冲字符串 用于拼接条件
		StringBuffer strWhere  = new StringBuffer(" ");
		//功能名字不为空判断
		if(right.getRightText()!=null && !right.getRightText().equals("")){
			//转码
			rightText=new String(right.getRightText().getBytes("ISO-8859-1"),"UTF-8");
		}
		//功能编号不为空判断
		if(right.getRightCode()!= null && !right.getRightCode().equals("")){
			strWhere.append(" and right_code='"+right.getRightCode()+"'");//拼接功能id
		}
		//功能类型不为空判断
		if(right.getRightType()!= null && !right.getRightType().equals("") && rightText==null){
			strWhere.append(" and right_type='"+right.getRightType()+"'");//拼接功能类型
		}
		//功能父功能编号不为空判断
		if(right.getRightParentCode()!= null && !right.getRightParentCode().equals("")){
			strWhere.append(" and right_parent_code='"+right.getRightParentCode()+"'");//拼接父功能id
		}
		//转码后的功能名称不为空判断
		if(rightText!=null && !rightText.equals("")){//拼接功能名称模糊查询
			strWhere.append(" and right_text like '%"+rightText+"%'");
		}
		//创建集合
		HashMap<String,Object> map=new HashMap<String,Object>();//创建hashMap存储参数
		
		map.put("tableName", "right"); //表名
		map.put("qualification", strWhere.toString());//条件
		map.put("page", right.getPage()); //第几页
		map.put("rows", right.getRows()); //每页显示行数
		map.put("orderColumn", "right_code");//排序的列字段
		map.put("orderStyle", "asc"); //排序方式
		rightDao.selectRight(map); //加载参数
		return map; 
	}

	@Override
	public int updateRight(Right right) {
		// TODO Auto-generated method stub
		return rightDao.updateRight(right);
	}

	@Override
	public int deleteRight(String rightCodes) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("rightCodes", rightCodes);
		return rightDao.deleteRight(map);
	}

	@Override
	public int insertRight(Right right) {
		// TODO Auto-generated method stub
		return rightDao.insertRight(right);
	}

	@Override
	public String selectRightCodeByType(Right right) {
		// TODO Auto-generated method stub
		return rightDao.selectRightCodeByType(right);
	}

	@Override
	public List<Right> selectRightParentCodeByType(String flag) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("flag", flag);
		return rightDao.selectRightParentCodeByType(map);
	}



}
