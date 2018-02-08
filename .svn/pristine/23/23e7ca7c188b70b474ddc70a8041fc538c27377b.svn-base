package com.yidu.parameters.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.parameters.dao.TrusteeDao;
import com.yidu.parameters.domain.Trustee;
import com.yidu.parameters.service.TrusteeService;

/**
* @author YiWenQi 
* @version 创建时间：2017年11月22日 下午2:06:38
* 托管人的实现类
*/
@Transactional
@Service
public class TrusteeServiceImpl implements TrusteeService{
	@Autowired
	TrusteeDao trusteeDao;//盗类
	@Override
	public Map<String, Object> selectTrusteeRow(Trustee trustee) {
		System.out.println("进来了"+trustee);//打印
		String trusteName=trustee.getTrusteeName();
		StringBuffer strWhere = new StringBuffer("");//用StringBuff类 判断code 和Name不为null和空字符
		if(trustee.getTrusteeCode()!=null && !trustee.getTrusteeCode().equals("")){
			strWhere.append(" and trustee_code like '%"+trustee.getTrusteeCode()+"%'");
		}
		if(trustee.getTrusteeName()!=null && !trustee.getTrusteeName().equals("")){
			try {
				trusteName=new String(trusteName.getBytes("iso8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strWhere.append(" and trustee_name like '%"+trusteName+"%'");
		}
		System.err.println(strWhere);
		//new 一个hash集合
		Map<String,Object> map=new HashMap<String,Object>();
		//它的表名
		map.put("tableName", "trustee");
		//他的条件
		map.put("qualification", strWhere.toString());
		//p每页
		map.put("page",trustee.getPage());
		System.out.println(trustee.getPage());
		//每行 
		map.put("rows",trustee.getRows());
		System.out.println(trustee.getRows());
		//排序的列 o
		map.put("orderColumn", "trustee_code");
		//排序的方法 按照SortOrder查询
		map.put("orderStyle", trustee.getSortOrder());
		trusteeDao.selectTrusteeRow(map);
		return map;

	}

	@Override
	public Integer insertTrustee(Trustee trustee) {
		// TODO Auto-generated method stub
		return trusteeDao.insertTrustee(trustee);
	}

	@Override
	public Integer updateTrustee(Trustee trustee) {
		// TODO Auto-generated method stub
		return trusteeDao.updateTrustee(trustee);
	}

	@Override
	public Integer deleteTrustee(Trustee trustee) {
		// TODO Auto-generated method stub
		return trusteeDao.deleteTrustee(trustee);
	}

	@Override
	public Trustee selectTrusteeByCode(Trustee trustee) {
		// TODO Auto-generated method stub
		return trusteeDao.selectTrusteeByCode(trustee);
	}

}
