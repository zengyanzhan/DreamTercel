package com.yidu.dayEnd.domain;

import java.sql.Date;

/**
 * 查询传输参数的提示类
 * @author ZengYanZhan
 * @date 2017年11月18日
 * @time 上午10:07:35
 */
public class DateParams {
	private Integer periodFlag;//期初标志
	private Integer securityType;//证券类型
	private String securityCode;//证券id
	private Integer dealType;//交易类型
	private String fundCode;//基金代码
	private Date yesterdayDate;//昨日日期
	private Date todayStatisticsDate;//统计日期
	
	public DateParams(){}

	public DateParams(Integer periodFlag, Integer securityType, String securityCode, Integer dealType, String fundCode,
			Date yesterdayDate, Date todayStatisticsDate) {
		super();
		this.periodFlag = periodFlag;
		this.securityType = securityType;
		this.securityCode = securityCode;
		this.dealType = dealType;
		this.fundCode = fundCode;
		this.yesterdayDate = yesterdayDate;
		this.todayStatisticsDate = todayStatisticsDate;
	}

	public Integer getDealType() {
		return dealType;
	}

	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}

	public Integer getPeriodFlag() {
		return periodFlag;
	}

	public void setPeriodFlag(Integer periodFlag) {
		this.periodFlag = periodFlag;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public Date getYesterdayDate() {
		return yesterdayDate;
	}

	public void setYesterdayDate(Date yesterdayDate) {
		this.yesterdayDate = yesterdayDate;
	}

	public Date getTodayStatisticsDate() {
		return todayStatisticsDate;
	}

	public void setTodayStatisticsDate(Date todayStatisticsDate) {
		this.todayStatisticsDate = todayStatisticsDate;
	}

	public Integer getSecurityCode() {
		return securityType;
	}

	public void setSecurityCode(Integer securityType) {
		this.securityType = securityType;
	}

	public Integer getSecurityType() {
		return securityType;
	}

	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String toString() {
		return "DateParams [periodFlag=" + periodFlag + ", securityType=" + securityType + ", securityCode="
				+ securityCode + ", dealType=" + dealType + ", fundCode=" + fundCode + ", yesterdayDate="
				+ yesterdayDate + ", todayStatisticsDate=" + todayStatisticsDate + "]";
	}

}
