package com.yidu.reportManagement.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.parameters.dao.SecurityDao;
import com.yidu.reportManagement.dao.OffsetBalanceDao;
import com.yidu.reportManagement.domain.OffsetBalance;
import com.yidu.reportManagement.service.OffsetBalanceService;
import com.yidu.transactionProcessing.domain.DealData;
@Service("offsetBalanceService")
public class OffsetBalanceServiceImp implements OffsetBalanceService {

	@Autowired
	private OffsetBalanceDao offsetBalanceDao;		//成交清算轧差数据连接数据库操作接口类
	
	@Autowired
	private SecurityDao securityDao;				//证券信息连接数据库操作类
	

	@Override
	public List<OffsetBalance> selectOffsetBalance(DealData dealData) {
		//如果没有选中日期就默认当天
				if(dealData.getDealDate()==null || dealData.getDealDate().equals("")){
					//格式化当天日期
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String strDate = sdf.format(date);
					//给参数实体类设置日期
					//dealData.setDealData(strDate);
				}
		return null;
	}

}
