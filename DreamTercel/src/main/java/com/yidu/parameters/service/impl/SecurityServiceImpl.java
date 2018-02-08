package com.yidu.parameters.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.parameters.dao.SecurityDao;
import com.yidu.parameters.domain.Security;
import com.yidu.parameters.service.SecurityService;

/**
 * 证劵信息数据库业务逻辑操作抽象接口实现类
 * @author 杨丽
 * @date 2017年11月20日	
 * @time 下午3:02:38
 */
@Transactional
@Service
public class SecurityServiceImpl implements SecurityService{
	@Autowired
	SecurityDao securityDao;
	
	@Override
	public HashMap<String, Object> selectSecuritys(String tableName, String qualification, Integer page, Integer rows,
			Integer rowsTotal, String orderColumn, String orderStyle) {
		// TODO Auto-generated method stub
		//new一个map
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("tableName",tableName);	//表名
		map.put("qualification",qualification);
		map.put("page",page);	//页
		map.put("rows",rows);	//行
		map.put("rowsTotal",rowsTotal);
		map.put("orderColumn","security_code");	//证券编号
		map.put("orderStyle",orderStyle);
		//调用查询证券的方法
		securityDao.selectSecuritys(map);
		map.get("securityList");
		
		return map; 
	}

	@Override
	public String bufferWhere(Security security) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer("");
		//判断证劵编号是否为空
		if(security.getSecurityCode()!=null && !security.getSecurityCode().equals("")){
			buffer=buffer.append(" and security_code = "+security.getSecurityCode());
		}
		//判断证券信息发行日期是否为空
		if(security.getPublishDates()!=null && !security.getPublishDates().equals("")){
			buffer=buffer.append(" and publish_date = to_date('"+security.getPublishDates()+"','yyyy-mm-dd')");
		}
		String flag=buffer.toString();
		return flag;
	}

	@Override
	public int insertSecurity(Security security) {
		// TODO Auto-generated method stub
		//调用增加证券的方法
		int size=securityDao.insertSecurity(security);
		return size;
	}

	@Override
	public int deleteSecurityByIds(String securityCode) {
		// TODO Auto-generated method stub
		//调用删除证券的方法
		int size=securityDao.deleteSecurityByIds(securityCode);
		return size;
	}

	@Override
	public void updateSecurity(Security security) {
		// TODO Auto-generated method stub
		//调用修改证券的方法
		securityDao.updateSecurity(security);
	}

	@Override
	public Security selectSecurityByIds(String securityCode) {
		// TODO Auto-generated method stub
		//调用通过id查询证券的方法
		Security security=securityDao.selectSecurityByIds(securityCode);
		return security;
	}
	
}
