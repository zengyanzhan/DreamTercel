package com.yidu.transactionProcessing.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 交易数据实体
 * @author Wang
 * @date 2017年11月18日
 * @time 上午8:43:33
 */
public class DealData implements Serializable{  
	private String dealDataCode;//交易的单子号(主键)(JYSJ20171107001)		主键 通过这个Code来查的数据
	private String fundCode	;//  ,--基金代码（外键）	null	引用基金表的基金代码  说明你交易的是哪个基金 外键（基金设置表）
	private String securityCode;//证券表的Code（外键）	null	外键（证券表的Code） 你引入证券表的Code
	private Date dealDate;//成交日期	not null	 交易成交的日期
	private Date setAccountDate;//结算日期	not null	交易结算的日期
	private String strDealDate;//成交日期	not null	 交易成交的日期(转日期的临时变量)
	private String strSetAccountDate;//结算日期	not null	交易结算的日期(转日期的临时变量)
	private String userCode;//投资经理	null	 引用投资y用户表的编号Code userCode
	private String brokerCode;//-券商Code	null	引用券商表的券商Code
	private String tradeSeatCode;//交易席位Code	null	引用交易席位表的该券商已有的交易席位Code
	private Integer dealType;//交易方式	not null	1买入、2卖出，3分红，4送股
	private Integer dealFlag;//交易标识	not null	1流入，-1流出
	private String cashAccountCode;//账户Code号	null	  引用现金账户表 t_cashAccount 的Code
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
	private Integer dealStatus;//交易状态	default 0	已经结算为1，未结算为2
	private String dealDataDesc;//备注	null	
	private Integer page;//分页页数
	private Integer rows;//分页行数
	private String sortName;//排序的列
	private String sortOrder;//排序方式
	private Integer exchangeName;//交易所
	private Integer securityType;//交易类型
	public DealData() {
		super();
	}
	

	public DealData(String dealDataCode, String fundCode, String securityCode, Date dealDate, Date setAccountDate,
			String strDealDate, String strSetAccountDate, String userCode, String brokerCode, String tradeSeatCode,
			Integer dealType, Integer dealFlag, String cashAccountCode, Double dealPrice, Double dealQuantity,
			Double dealTotalPrice, Double stampDuty, Double managementFee, Double transferFee, Double commissionFee,
			Double brokerageFee, Double realCollectFee, Double securityFnterest, Integer dealStatus,
			String dealDataDesc) {
		super();
		this.dealDataCode = dealDataCode;
		this.fundCode = fundCode;
		this.securityCode = securityCode;
		this.dealDate = dealDate;
		this.setAccountDate = setAccountDate;
		this.strDealDate = strDealDate;
		this.strSetAccountDate = strSetAccountDate;
		this.userCode = userCode;
		this.brokerCode = brokerCode;
		this.tradeSeatCode = tradeSeatCode;
		this.dealType = dealType;
		this.dealFlag = dealFlag;
		this.cashAccountCode = cashAccountCode;
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
		this.dealStatus = dealStatus;
		this.dealDataDesc = dealDataDesc;
	}


	public String getDealDataCode() {
		return dealDataCode;
	}
	public void setDealDataCode(String dealDataCode) {
		this.dealDataCode = dealDataCode;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public Date getSetAccountDate() {
		return setAccountDate;
	}
	public void setSetAccountDate(Date setAccountDate) {
		this.setAccountDate = setAccountDate;
	}
	public String getStrDealDate() {
		return strDealDate;
	}
	public void setStrDealDate(String strDealDate) {
		this.strDealDate = strDealDate;
	}
	public String getStrSetAccountDate() {
		return strSetAccountDate;
	}
	public void setStrSetAccountDate(String strSetAccountDate) {
		this.strSetAccountDate = strSetAccountDate;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getBrokerCode() {
		return brokerCode;
	}
	public void setBrokerCode(String brokerCode) {
		this.brokerCode = brokerCode;
	}
	public String getTradeSeatCode() {
		return tradeSeatCode;
	}
	public void setTradeSeatCode(String tradeSeatCode) {
		this.tradeSeatCode = tradeSeatCode;
	}
	public Integer getDealType() {
		return dealType;
	}
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}
	public Integer getDealFlag() {
		return dealFlag;
	}
	public void setDealFlag(Integer dealFlag) {
		this.dealFlag = dealFlag;
	}
	public String getCashAccountCode() {
		return cashAccountCode;
	}
	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
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
	
	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getDealDataDesc() {
		return dealDataDesc;
	}
	public void setDealDataDesc(String dealDataDesc) {
		this.dealDataDesc = dealDataDesc;
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
	
	public Integer getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(Integer exchangeName) {
		this.exchangeName = exchangeName;
	}
	public Integer getSecurityType() {
		return securityType;
	}
	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}
	@Override
	public String toString() {
		return "DealData [dealDataCode=" + dealDataCode + ", fundCode=" + fundCode + ", securityCode=" + securityCode
				+ ", dealDate=" + dealDate + ", setAccountDate=" + setAccountDate + ", strDealDate=" + strDealDate
				+ ", strSetAccountDate=" + strSetAccountDate + ", userCode=" + userCode + ", brokerCode=" + brokerCode
				+ ", tradeSeatCode=" + tradeSeatCode + ", dealType=" + dealType + ", dealFlag=" + dealFlag
				+ ", cashAccountCode=" + cashAccountCode + ", dealPrice=" + dealPrice + ", dealQuantity=" + dealQuantity
				+ ", dealTotalPrice=" + dealTotalPrice + ", stampDuty=" + stampDuty + ", managementFee=" + managementFee
				+ ", transferFee=" + transferFee + ", commissionFee=" + commissionFee + ", brokerageFee=" + brokerageFee
				+ ", realCollectFee=" + realCollectFee + ", securityFnterest=" + securityFnterest + ", dealStatus="
				+ dealStatus + ", dealDataDesc=" + dealDataDesc + ", page=" + page + ", rows=" + rows + ", sortName="
				+ sortName + ", sortOrder=" + sortOrder + "]";
	}
	
	
}
