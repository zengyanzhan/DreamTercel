package com.yidu.system.service;

import java.util.List;

import com.yidu.system.domain.Holiday;

/**
 * 节假日Service
 * @author Lee
 * @date 2017年11月14日
 * @time 下午3:15:00
 */
public interface HolidayService {
	
	public   List<Holiday> selectHolidayByDate (String date);
}
