package com.yidu.util.dao;

import org.springframework.stereotype.Repository;

import com.yidu.util.domain.UtilDomian;
@Repository
public interface UtilDao {
	public String selectCodeByMaXCode(UtilDomian utilDomian);
	public String selectCodeByDateAndMaxCode(UtilDomian utilDomian);
	
	/**
	 * 净值统计自动生成编号
	 * @param utilDomian 
	 * @return
	 */
	public String getNetValueCode(UtilDomian utilDomian);
}
