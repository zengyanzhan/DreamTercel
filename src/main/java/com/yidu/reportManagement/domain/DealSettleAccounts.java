package com.yidu.reportManagement.domain;

import java.io.Serializable;

/**
 * 查询交易成交日报表实体类
 * @author Wang
 * @date 2017年12月7日
 * @time 下午4:29:57
 */
public class DealSettleAccounts implements Serializable{
	private String securityCode;//证券表的Code（外键）
	private String securityName;//证券表的名称
	private Integer dealType;//交易方式
	private Double dealPrice;//交易价格(单价)	default 0	交易一份的钱
	private Double dealQuantity;//交易数量	default 0	此次交易的数量
	private Double dealTotalPrice;//交易金额（总的）	default 0	交易金额（总的）
	private Double stampDuty;//印花税	null	上交国家的税
	private Double managementFee;//征管费	null	上交国家的税
	private Double transferFee;//过户费（交易所）	default 0	交易所收的钱
	private Double commissionFee;//-佣金费用（券商）	default 0	卷商收的钱
	private Double brokerageFee;//-经手费（交易所）	default 0	交易所收的钱
	private Double realCollectFee;//实收金额 	default 0	总交易金额+总费用
	private Double securityFnterest;//证券利息	default 0
	private Integer securityType;
	private String dealLeixing;
	private String strDealDate;
	private Integer page;//分页页数
	private Integer rows;//分页行数
	private String sortName;//排序的列
	private String sortOrder;//排序方式
	public DealSettleAccounts() {
		super();
	}
	public DealSettleAccounts(String securityCode, String securityName, Integer dealType, Double dealPrice,
			Double dealQuantity, Double dealTotalPrice, Double stampDuty, Double managementFee, Double transferFee,
			Double commissionFee, Double brokerageFee, Double realCollectFee, Double securityFnterest) {
		super();
		this.securityCode = securityCode;
		this.securityName = securityName;
		this.dealType = dealType;
		this.dealPrice = dealPrice;
		this.dealQuantity = dealQuantity;
		this.dealTotalPrice = dealTotalPrice;
		this.stampDuty = stampDuty;
		this.managementFee = managementFee;
		this.transferFee = transferFee;
		this.commissionFee = commissionFee;
		this.brokerageFee = brokerageFee;
		this.realCollectFee = realCollectFee;
		this.securityFnterest = securityFnterest;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public Integer getDealType() {
		return dealType;
	}
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}
	public Double getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(Double dealPrice) {
		this.dealPrice = dealPrice;
	}
	public Double getDealQuantity() {
		return dealQuantity;
	}
	public void setDealQuantity(Double dealQuantity) {
		this.dealQuantity = dealQuantity;
	}
	public Double getDealTotalPrice() {
		return dealTotalPrice;
	}
	public void setDealTotalPrice(Double dealTotalPrice) {
		this.dealTotalPrice = dealTotalPrice;
	}
	public Double getStampDuty() {
		return stampDuty;
	}
	public void setStampDuty(Double stampDuty) {
		this.stampDuty = stampDuty;
	}
	public Double getManagementFee() {
		return managementFee;
	}
	public void setManagementFee(Double managementFee) {
		this.managementFee = managementFee;
	}
	public Double getTransferFee() {
		return transferFee;
	}
	public void setTransferFee(Double transferFee) {
		this.transferFee = transferFee;
	}
	public Double getCommissionFee() {
		return commissionFee;
	}
	public void setCommissionFee(Double commissionFee) {
		this.commissionFee = commissionFee;
	}
	public Double getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(Double brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	public Double getRealCollectFee() {
		return realCollectFee;
	}
	public void setRealCollectFee(Double realCollectFee) {
		this.realCollectFee = realCollectFee;
	}
	public Double getSecurityFnterest() {
		return securityFnterest;
	}
	public void setSecurityFnterest(Double securityFnterest) {
		this.securityFnterest = securityFnterest;
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
	public String getStrDealDate() {
		return strDealDate;
	}
	public void setStrDealDate(String strDealDate) {
		this.strDealDate = strDealDate;
	}
	public String getDealLeixing() {
		return dealLeixing;
	}
	public void setDealLeixing(String dealLeixing) {
		this.dealLeixing = dealLeixing;
	}
	public Integer getSecurityType() {
		return securityType;
	}
	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}
	@Override
	public String toString() {
		return "DealSettleAccounts [securityCode=" + securityCode + ", securityName=" + securityName + ", dealType="
				+ dealType + ", dealPrice=" + dealPrice + ", dealQuantity=" + dealQuantity + ", dealTotalPrice="
				+ dealTotalPrice + ", stampDuty=" + stampDuty + ", managementFee=" + managementFee + ", transferFee="
				+ transferFee + ", commissionFee=" + commissionFee + ", brokerageFee=" + brokerageFee
				+ ", realCollectFee=" + realCollectFee + ", securityFnterest=" + securityFnterest + "]";
	}
	
}
