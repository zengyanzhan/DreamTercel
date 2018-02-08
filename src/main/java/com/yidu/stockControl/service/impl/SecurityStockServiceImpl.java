package com.yidu.stockControl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.parameters.domain.Security;
import com.yidu.stockControl.dao.SecurityStockDao;
import com.yidu.stockControl.domain.SecurityStock;
import com.yidu.stockControl.service.SecurityStockService;
import com.yidu.util.AllUtil;

/**
 * 证券库存业务逻辑处理层实现类
 * @author ZengYanZhan
 * @date 2017年11月13日
 * @time 上午10:30:54
 */
@Service
public class SecurityStockServiceImpl  implements SecurityStockService{

	@Autowired
	private SecurityStockDao securityStockDao;//自动装配

	@Override
	public Map<String,Object> selectSecurityStock(SecurityStock securityStock) throws Exception {
		// TODO Auto-generated method stub
		String dateTime=securityStock.getDatetime();//统计日期
		String fundCode=securityStock.getFundCode();//基金代码
		String securityCode=new String(securityStock.getSecurityCode().getBytes("ISO-8859-1"),"UTF-8"); //证券名称
		StringBuffer str=new StringBuffer("  and fund_code='"+fundCode+"'");//这里需要s对条件进行拼接 使用缓冲字符串
		/**
		 * 进行字符串判断 用来拼接条件
		 */
		if(dateTime != null && !dateTime.equals("")){
			str.append(" and security_statistics_date=to_date('"+dateTime+"','yyyy-mm-dd')");//按照日期条件查询证券库存数据
		}
		if(securityCode != null && !securityCode.equals("")){
			str.append(" and security_code  like '%"+securityCode+"%'");//证券名称模糊查询
		}
		if(securityStock.getSecurityType()!=null && !securityStock.getSecurityType().equals("")){
			str.append(" and security_type='"+securityStock.getSecurityType()+"'");//按照证券类型查询证券库存数据
		}
		HashMap<String,Object> map=new HashMap<String,Object>(); //创建一个Map，用来装参数
		map.put("tableName","security_stock"); //表名
		map.put("qualification", str.toString()); //条件
		map.put("rows", securityStock.getRows()); //每页总行数
		map.put("page", securityStock.getPage()); //第几页
		map.put("orderColumn", "security_stock_code"); //排序的列字段
		map.put("orderStyle", securityStock.getSortOrder()); //排序的方式
		securityStockDao.selectSecurityStock(map);//得到输出参数 数据
		return map;
	}

	@Override
	public int deleteSecurityStock(String code) {
		// TODO Auto-generated method stub
		String[] str=code.split(","); //切割字符串
		List<String> list=new ArrayList<String>(); //创建list集合
		for(int i=0;i<str.length;i++){
			list.add(str[i]);//将字符串添加到集合中去
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", list);
		return securityStockDao.deleteSecurityStock(map);
	}

	@Override
	public int insertSecurityStock(SecurityStock securityStock) {
		// TODO Auto-generated method stub
		return securityStockDao.insertSecurityStock(securityStock);
	}

	@Override
	public int updateSecurityStock(SecurityStock securityStock) {
		// TODO Auto-generated method stub
		return securityStockDao.updateSecurityStock(securityStock);
	}

	@Override
	public SecurityStock selectSecurityStockByCode(String code) {
		// TODO Auto-generated method stub
		return securityStockDao.selectSecurityStockByCode(code);
	}

}
