package com.yidu.parameters.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.parameters.dao.FundDao;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.service.FundService;
@Transactional
@Service
public class FundServiceImpl implements FundService{
	@Autowired
	FundDao fundDao;
	@Override
	public Map<String, Object> selectFundRow(Fund fund) {
		System.out.println("进来了"+fund);
		//创建一个字符的Buffer类
		StringBuffer strWhere = new StringBuffer("");
		//判断基金类型不空 不等于0
		if(fund.getFundType()!=null && fund.getFundType()!=0){
			strWhere.append(" and fund_type='"+fund.getFundType()+"'");
		}
		//判断基金ID不空 不空字符
		if(fund.getFundCode()!=null && !fund.getFundCode().equals("")){
			strWhere.append(" and fund_code='"+fund.getFundCode()+"'");
		}
		System.err.println(strWhere);
		//创建hash集合
		Map<String,Object> map=new HashMap<String,Object>();

		map.put("tableName", "(select * from fund f "
		+"join trustee t on t.trustee_code=f.trustee_code "
				+"join manager m on f.manager_code=m.manager_code)");
		//条件""
		map.put("qualification", strWhere.toString());
		//每页
		map.put("page",fund.getPage());
		System.out.println(fund.getPage());
		//每行
		map.put("rows",fund.getRows());
		System.out.println(fund.getRows());
		//排序的列 o
		map.put("orderColumn", "fund_code");
		//排序的方法 按照SortOrder查询
		map.put("orderStyle", fund.getSortOrder());
		//Dao查询基金的方法
		fundDao.selectFundRow(map);
		return map;

	}
	
	/**
	 * 增加的方法
	 */	
	@Override
	public Integer insertFundRow(Fund fund) {
		// TODO Auto-generated method stub
		return fundDao.insertFundRow(fund);
	}
	/**
	 * 修改的方法
	 */
	@Override
	public Integer updateFund(Fund fund) {
		// TODO Auto-generated method stub
		return fundDao.updateFund(fund);
	}
	/**
	 * 删除的方法
	 */
	@Override
	public Integer deleteFund(Fund fund) {
		// TODO Auto-generated method stub
		return fundDao.deleteFund(fund);
	}
	/**
	 * 查询的code的方法
	 */
	@Override
	public Fund selectFundByCode(Fund fund) {
		// TODO Auto-generated method stub
		return fundDao.selectFundByCode(fund);
	}
	

}
