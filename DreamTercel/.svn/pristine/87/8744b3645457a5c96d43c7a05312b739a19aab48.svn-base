package com.yidu.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.system.dao.HoildayXiaoDao;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.system.service.HoildayXiaoSerice;
@Transactional
@Service
public class HoildayXiaoSericeImpl implements HoildayXiaoSerice{
	
	@Autowired
	HoildayXiaoDao hoildayXiaoDao;
	
	@Override
	public List<HoildayXiao> selectHoildayXiao(Integer date) {
		// TODO Auto-generated method stub
		
		return hoildayXiaoDao.selectHoildayXiao(date);
	}

	@Override
	public int insertHoildayXiao(HoildayXiao hoildayXiao) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("t_holidayDate", hoildayXiao.gethDate());
		map.put("t_holidayYear", hoildayXiao.gethYear());
		map.put("t_holidayMonth", hoildayXiao.gethMonth());
		map.put("t_holidayDay", hoildayXiao.gethDay());
		map.put("t_hoildDesc", hoildayXiao.gethDesc());
		hoildayXiaoDao.insertHoildayXiao(map);
		int i=(int) map.get("t_flag");
		return i;
	}

	@Override
	public int deleteHoildayXiao(String date) {
		// TODO Auto-generated method stub
		int i=hoildayXiaoDao.deleteHoildayXiao(date);
		return i;
	}

	@Override
	public List<HoildayXiao> selectHoildayBydate(String date) {
		// TODO Auto-generated method stub
		return 	 hoildayXiaoDao.selectHoildayBydate(date);
	}

}
