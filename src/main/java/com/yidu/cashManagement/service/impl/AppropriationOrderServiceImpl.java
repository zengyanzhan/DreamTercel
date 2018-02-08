package com.yidu.cashManagement.service.impl;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.cashManagement.dao.AppropriationOrderDao;
import com.yidu.cashManagement.domain.AppropriationOrder;
import com.yidu.cashManagement.service.AppropriationOrderService;
@Transactional
@Service
/**
 * 划款指令控制器实现类
 * @author 肖光宇
 * @date 2017年12月14日
 * @time 上午10:20:11
 *
 */
public class AppropriationOrderServiceImpl implements AppropriationOrderService{
	@Autowired
	AppropriationOrderDao appropriationOrderDao;
	@Override
	public HashMap<String, Object> selectAppripriationOrder(AppropriationOrder appropriationOrder) {
		StringBuffer strWhere=new StringBuffer("");//拼接条件
		String strOderDate=appropriationOrder.getStrOrderDate();//得到指令日期
		String strToDate=appropriationOrder.getStrToDate();//得到调拨日期
		String cashName=null;
		try {
			cashName = new String(appropriationOrder.getCashName().getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(strOderDate!=null&&!strOderDate.equals("")){
			strWhere.append("   and orderDate=to_date('"+strOderDate+"','yyyy-MM-dd')");
		}else if(strToDate!=null&&!strToDate.equals("")){
			strWhere.append("   and toAccountDate=to_date('"+strToDate+"','yyyy-MM-dd')");
		}else if(cashName!=null&&!cashName.equals("")){
			strWhere.append("  and collectAccountName like  '%"+cashName+"%' ");
		}
		HashMap<String, Object>  map=new  HashMap<String, Object>();
		map.put("tabName", "appropriationOrder");
		map.put("qualification",strWhere.toString());
		map.put("page", appropriationOrder.getPage());
		map.put("rows", appropriationOrder.getRows());
		map.put("orderColumn", "appropriationOrderCode");
		map.put("orderStyle",appropriationOrder.getSortOrder());
		appropriationOrderDao.selectAppripriationOrder(map);//给输出参数赋值
		return map;
	}
	@Override
	public Integer insertApproOrder(AppropriationOrder appropriationOrder) {
		// TODO Auto-generated method stub
		return appropriationOrderDao.insertApproOrder(appropriationOrder);
	}
	@Override
	public Integer updateApproOrder(AppropriationOrder appropriationOrder) {
		// TODO Auto-generated method stub
		return appropriationOrderDao.updateApproOrder(appropriationOrder);
	}
	@Override
	public Integer deleteApproOrder(AppropriationOrder appropriationOrder) {
		// TODO Auto-generated method stub
		return appropriationOrderDao.deleteApproOrder(appropriationOrder);
	}
	@Override
	public AppropriationOrder selectApproCode(String code) {
		// TODO Auto-generated method stub
		return appropriationOrderDao.selectApproCode(code);
	}
	

}
