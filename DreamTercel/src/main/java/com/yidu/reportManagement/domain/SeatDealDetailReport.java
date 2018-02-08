package com.yidu.reportManagement.domain;
/**
 * 席位成交明细实体类
 * @author ZengYanZhan
 * @date 2017年12月1日
 * @time 下午7:57:33
 */
public class SeatDealDetailReport {
	private String seatName;//席位名称
	private String securityCode;//证券上市唯一代码  手动
	private String securityName;//证券名称
	private double dealQuantity;//交易数量  此次交易的数量
	private double dealTotalPrice;//交易金额（总的）  交易的总价钱=单价*num
	private double brokerage;//佣金费用（券商）   基金公司交付给券商
	private double stamps;//印花税（国家）
	private double handleFee;//经手费（交易所）
	private double transferFee;//过户费（交易所）
	private double manageFee;//征管费（国家）
	private Integer exchangeCode;//交易所 1是上交所 2是深交所
	private Integer secrityType;//证券类型 1是股票 2是债券
	
	private SeatDealDetailReport(){}

	public SeatDealDetailReport(String seatName, String securityCode, String securityName, double dealQuantity,
			double dealTotalPrice, double brokerage, double stamps, double handleFee, double transferFee,
			double manageFee, Integer exchangeCode, Integer secrityType) {
		super();
		this.seatName = seatName;
		this.securityCode = securityCode;
		this.securityName = securityName;
		this.dealQuantity = dealQuantity;
		this.dealTotalPrice = dealTotalPrice;
		this.brokerage = brokerage;
		this.stamps = stamps;
		this.handleFee = handleFee;
		this.transferFee = transferFee;
		this.manageFee = manageFee;
		this.exchangeCode = exchangeCode;
		this.secrityType = secrityType;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
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

	public double getDealQuantity() {
		return dealQuantity;
	}

	public void setDealQuantity(double dealQuantity) {
		this.dealQuantity = dealQuantity;
	}

	public double getDealTotalPrice() {
		return dealTotalPrice;
	}

	public void setDealTotalPrice(double dealTotalPrice) {
		this.dealTotalPrice = dealTotalPrice;
	}

	public double getBrokerage() {
		return brokerage;
	}

	public void setBrokerage(double brokerage) {
		this.brokerage = brokerage;
	}

	public double getStamps() {
		return stamps;
	}

	public void setStamps(double stamps) {
		this.stamps = stamps;
	}

	public double getHandleFee() {
		return handleFee;
	}

	public void setHandleFee(double handleFee) {
		this.handleFee = handleFee;
	}

	public double getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(double transferFee) {
		this.transferFee = transferFee;
	}

	public double getManageFee() {
		return manageFee;
	}

	public void setManageFee(double manageFee) {
		this.manageFee = manageFee;
	}

	public Integer getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(Integer exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public Integer getSecrityType() {
		return secrityType;
	}

	public void setSecrityType(Integer secrityType) {
		this.secrityType = secrityType;
	}

	@Override
	public String toString() {
		return "SeatDealDetailReport [seatName=" + seatName + ", securityCode=" + securityCode + ", securityName="
				+ securityName + ", dealQuantity=" + dealQuantity + ", dealTotalPrice=" + dealTotalPrice
				+ ", brokerage=" + brokerage + ", stamps=" + stamps + ", handleFee=" + handleFee + ", transferFee="
				+ transferFee + ", manageFee=" + manageFee + ", exchangeCode=" + exchangeCode + ", secrityType="
				+ secrityType + "]";
	}
	 
}
