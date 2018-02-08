package com.yidu.parameters.domain;

import java.io.Serializable;

/**
 * 交易席位信息实体类
 * @author Wang
 * @date 2017年11月16日
 * @time 下午4:31:41
 */
public class Seat implements Serializable{
	private String seatCode;//交易席位的唯一ID
	private String  brokerCode;//引用券商表broker的broker_code  
	private String  seatName;//席位名称
	private String  seatAddress;//席位地点 上海/深圳
	private Integer  seatType;//1=普通，2=贵宾
	private Double  commissionRate;//佣金利率
	private String  seatDesc;//交易席位信息表的备用字段
	private Integer page;//分页页数
	private Integer rows;//分页行数
	private String sortName;//排序的列
	private String sortOrder;//排序方式
	public Seat() {
		super();
	}
	public Seat(String seatCode, String brokerCode, String seatName, String seatAddress, Integer seatType,
			Double commissionRate, String seatDesc) {
		super();
		this.seatCode = seatCode;
		this.brokerCode = brokerCode;
		this.seatName = seatName;
		this.seatAddress = seatAddress;
		this.seatType = seatType;
		this.commissionRate = commissionRate;
		this.seatDesc = seatDesc;
	}
	public String getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}
	public String getBrokerCode() {
		return brokerCode;
	}
	public void setBrokerCode(String brokerCode) {
		this.brokerCode = brokerCode;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public String getSeatAddress() {
		return seatAddress;
	}
	public void setSeatAddress(String seatAddress) {
		this.seatAddress = seatAddress;
	}
	public Integer getSeatType() {
		return seatType;
	}
	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}
	public Double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(Double commissionRate) {
		this.commissionRate = commissionRate;
	}
	public String getSeatDesc() {
		return seatDesc;
	}
	public void setSeatDesc(String seatDesc) {
		this.seatDesc = seatDesc;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	@Override
	public String toString() {
		return "Seat [seatCode=" + seatCode + ", brokerCode=" + brokerCode + ", seatName=" + seatName + ", seatAddress="
				+ seatAddress + ", seatType=" + seatType + ", commissionRate=" + commissionRate + ", seatDesc="
				+ seatDesc + ", page=" + page + ", rows=" + rows + ", sortName=" + sortName + ", sortOrder=" + sortOrder
				+ "]";
	}
	
	
}
