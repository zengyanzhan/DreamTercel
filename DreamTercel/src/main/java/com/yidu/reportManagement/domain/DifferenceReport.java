package com.yidu.reportManagement.domain;

import java.io.Serializable;

/**
 * 轧差表的实体类
 * @author Wang
 * @date 2017年12月11日
 * @time 下午7:27:16
 */
public class DifferenceReport implements Serializable{
	private Integer securityType;
	private String strSecurityType;
	private Integer exchangeName;
	
	private Double stampDuty;
	private Double transferFee;
	private Double managementFee;
	private Double brokerageFee;
	private Double commissionFee;
	private Double securityInterest;
	private Double settleMoney;
	private Double lcTotalPrice;
	private Double lrTotalPrice;
	
	private Double shiJiMoney;
	
	private String strDealDate;
	private Integer page;//分页页数
	private Integer rows;//分页行数
	private String sortName;//排序的列
	private String sortOrder;//排序方式
	public DifferenceReport() {
		super();
	}
	public DifferenceReport(Integer securityType, String strSecurityType, Integer exchangeName, Double stampDuty,
			Double transferFee, Double managementFee, Double brokerageFee, Double commissionFee,
			Double securityInterest, Double settleMoney, Double lcTotalPrice, Double lrTotalPrice, Double shiJiMoney) {
		super();
		this.securityType = securityType;
		this.strSecurityType = strSecurityType;
		this.exchangeName = exchangeName;
		this.stampDuty = stampDuty;
		this.transferFee = transferFee;
		this.managementFee = managementFee;
		this.brokerageFee = brokerageFee;
		this.commissionFee = commissionFee;
		this.securityInterest = securityInterest;
		this.settleMoney = settleMoney;
		this.lcTotalPrice = lcTotalPrice;
		this.lrTotalPrice = lrTotalPrice;
		this.shiJiMoney = shiJiMoney;
	}
	public Integer getSecurityType() {
		return securityType;
	}
	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}
	public String getStrSecurityType() {
		return strSecurityType;
	}
	public void setStrSecurityType(String strSecurityType) {
		this.strSecurityType = strSecurityType;
	}
	public Integer getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(Integer exchangeName) {
		this.exchangeName = exchangeName;
	}
	public Double getStampDuty() {
		return stampDuty;
	}
	public void setStampDuty(Double stampDuty) {
		this.stampDuty = stampDuty;
	}
	public Double getTransferFee() {
		return transferFee;
	}
	public void setTransferFee(Double transferFee) {
		this.transferFee = transferFee;
	}
	public Double getManagementFee() {
		return managementFee;
	}
	public void setManagementFee(Double managementFee) {
		this.managementFee = managementFee;
	}
	public Double getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(Double brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	public Double getCommissionFee() {
		return commissionFee;
	}
	public void setCommissionFee(Double commissionFee) {
		this.commissionFee = commissionFee;
	}
	public Double getSecurityInterest() {
		return securityInterest;
	}
	public void setSecurityInterest(Double securityInterest) {
		this.securityInterest = securityInterest;
	}
	public Double getSettleMoney() {
		return settleMoney;
	}
	public void setSettleMoney(Double settleMoney) {
		this.settleMoney = settleMoney;
	}
	public Double getLcTotalPrice() {
		return lcTotalPrice;
	}
	public void setLcTotalPrice(Double lcTotalPrice) {
		this.lcTotalPrice = lcTotalPrice;
	}
	public Double getLrTotalPrice() {
		return lrTotalPrice;
	}
	public void setLrTotalPrice(Double lrTotalPrice) {
		this.lrTotalPrice = lrTotalPrice;
	}
	public Double getShiJiMoney() {
		return shiJiMoney;
	}
	public void setShiJiMoney(Double shiJiMoney) {
		this.shiJiMoney = shiJiMoney;
	}
	public String getStrDealDate() {
		return strDealDate;
	}
	public void setStrDealDate(String strDealDate) {
		this.strDealDate = strDealDate;
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
		return "DifferenceReport [securityType=" + securityType + ", strSecurityType=" + strSecurityType
				+ ", exchangeName=" + exchangeName + ", stampDuty=" + stampDuty + ", transferFee=" + transferFee
				+ ", managementFee=" + managementFee + ", brokerageFee=" + brokerageFee + ", commissionFee="
				+ commissionFee + ", securityInterest=" + securityInterest + ", settleMoney=" + settleMoney
				+ ", lcTotalPrice=" + lcTotalPrice + ", lrTotalPrice=" + lrTotalPrice + ", shiJiMoney=" + shiJiMoney
				+ ", strDealDate=" + strDealDate + ", page=" + page + ", rows=" + rows + ", sortName=" + sortName
				+ ", sortOrder=" + sortOrder + "]";
	}
	
}
