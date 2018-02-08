package com.yidu.stockControl.service.impl;
/**
 /**
 * 证券应收应付业务逻辑处理层实现类
 * @author 肖向恩
 * @date 2017年11月20日
 * @time 上午10:30:54
 */
 
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.stockControl.dao.SecurityArapStockDao;
import com.yidu.stockControl.domain.SecurityArapStock;
import com.yidu.stockControl.service.SecurityArapStockService;
import com.yidu.util.AllUtil;
@Service
public class SecurityArapStockServiceImpl implements SecurityArapStockService {
	//证券应收应付库存Dao
	@Autowired
	SecurityArapStockDao securityArapStockDao;
	/**
	 * 查询的方法
	 */
	@Override
	public HashMap<String, Object> selectSecurityArapStock(SecurityArapStock securityArapStock) {
	/*证券应收应付条件查询businessStatus*/
	StringBuffer strWhere = new StringBuffer("");
	String strStart=securityArapStock.getStrStart();
			strWhere.append(" and fund_code  = '"+securityArapStock.getFundCode()+"'");
	try {
		if(strStart!=null&&!strStart.equals("")){
			strWhere.append(" and  business_date=to_date('"+strStart+"','yyyy-mm-dd')");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("tableName","security_arap_stock");
		map.put("qualification",strWhere.toString());
		map.put("page",securityArapStock.getPage());
		map.put("rows",securityArapStock.getRows());
		map.put("orderColumn","security_arap_stock_code");
		map.put("orderStyle","asc");
		securityArapStockDao.selectSecurityArapStock(map);
		System.err.println(map);
		return map;
	}
	/**
	 * 删除的方法
	 */
	@Override
	public int deleteSecurityArapStockId(String securityArapStockCode) {
		String[] split=securityArapStockCode.split(",");
		int size=0;
		for(int i=0;i<split.length;i++){
			size=securityArapStockDao.deleteSecurityArapStockId(split[i]);
			++size;
		}
		return size;
	}
	/**
	 * 添加的方法
	 */
	@Override
	public int insertSecurityArapStock(SecurityArapStock securityArapStock) {
		int size=securityArapStockDao.insertSecurityArapStock(securityArapStock);
		return size;
	}
	/**
	 * 修改的方法
	 */
	@Override
	public int updateSecurityArapStock(SecurityArapStock securityArapStock) {
		int updateSecurityArapStock = securityArapStockDao.updateSecurityArapStock(securityArapStock);
		return updateSecurityArapStock;
	}
	/**
	 * 查询ID的方法
	 */
	@Override
	public SecurityArapStock selectSecurityArapStockIds(String securityArapStockCode) {
		SecurityArapStock securityArapStock=securityArapStockDao.selectSecurityArapStockIds(securityArapStockCode);
		return securityArapStock;
	}

}
