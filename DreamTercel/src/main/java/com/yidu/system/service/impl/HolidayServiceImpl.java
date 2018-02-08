package com.yidu.system.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yidu.system.dao.HolidayDao;
import com.yidu.system.domain.Holiday;
import com.yidu.system.service.HolidayService;

/**
 * 节假日ServiceImpl
 * @author Lee
 * @date 2017年11月14日
 * @time 下午3:15:14
 */

public class HolidayServiceImpl implements HolidayService{
	@Autowired
	HolidayDao holidayDao;
	@Override
	public List<Holiday> selectHolidayByDate(String date) {
		
		return holidayDao.selectHolidayByDate(date);
	
	}
	

}
