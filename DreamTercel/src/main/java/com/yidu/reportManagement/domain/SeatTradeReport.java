package com.yidu.reportManagement.domain;
/**
 * 席位交易量统计表
 * @author ZengYanZhan
 * @date 2017年12月1日
 * @time 下午7:13:30
 */
public class SeatTradeReport {
	private String borkerCode;//券商编号
	private double inputPlate;//买入股票
	private double outputPlate;//卖出股票
	private double inputBond;//买入债券
	private double outputBond;//卖出债券
	private double totalMoney;//合计金额
	private double tradeMeasure;//交易量比例
	private String seatName;//席位名称
	private double dealQuantity;//交易数量
	private double dealTotalPrice;//交易金额
	private Integer securityType;//证券类型  1 股票 , 2 债券
	private double dealFlag;//交易标识  1 流入 ,-1 流出
	private String fundCode;//基金编号
	private Integer exchangeCode;//交易所 1是上海 2是深圳

	public SeatTradeReport(){}

	public SeatTradeReport(String borkerCode, double inputPlate, double outputPlate, double inputBond,
			double outputBond, double totalMoney, double tradeMeasure, String seatName, double dealQuantity,
			double dealTotalPrice, Integer securityType, double dealFlag, String fundCode, Integer exchangeCode) {
		super();
		this.borkerCode = borkerCode;
		this.inputPlate = inputPlate;
		this.outputPlate = outputPlate;
		this.inputBond = inputBond;
		this.outputBond = outputBond;
		this.totalMoney = totalMoney;
		this.tradeMeasure = tradeMeasure;
		this.seatName = seatName;
		this.dealQuantity = dealQuantity;
		this.dealTotalPrice = dealTotalPrice;
		this.securityType = securityType;
		this.dealFlag = dealFlag;
		this.fundCode = fundCode;
		this.exchangeCode = exchangeCode;
	}

	public String getBorkerCode() {
		return borkerCode;
	}

	public void setBorkerCode(String borkerCode) {
		this.borkerCode = borkerCode;
	}

	public double getInputPlate() {
		return inputPlate;
	}

	public void setInputPlate(double inputPlate) {
		this.inputPlate = inputPlate;
	}

	public double getOutputPlate() {
		return outputPlate;
	}

	public void setOutputPlate(double outputPlate) {
		this.outputPlate = outputPlate;
	}

	public double getInputBond() {
		return inputBond;
	}

	public void setInputBond(double inputBond) {
		this.inputBond = inputBond;
	}

	public double getOutputBond() {
		return outputBond;
	}

	public void setOutputBond(double outputBond) {
		this.outputBond = outputBond;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public double getTradeMeasure() {
		return tradeMeasure;
	}

	public void setTradeMeasure(double tradeMeasure) {
		this.tradeMeasure = tradeMeasure;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
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

	public Integer getSecurityType() {
		return securityType;
	}

	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}

	public double getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(double dealFlag) {
		this.dealFlag = dealFlag;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public Integer getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(Integer exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	@Override
	public String toString() {
		return "SeatTradeReport [borkerCode=" + borkerCode + ", inputPlate=" + inputPlate + ", outputPlate="
				+ outputPlate + ", inputBond=" + inputBond + ", outputBond=" + outputBond + ", totalMoney=" + totalMoney
				+ ", tradeMeasure=" + tradeMeasure + ", seatName=" + seatName + ", dealQuantity=" + dealQuantity
				+ ", dealTotalPrice=" + dealTotalPrice + ", securityType=" + securityType + ", dealFlag=" + dealFlag
				+ ", fundCode=" + fundCode + ", exchangeCode=" + exchangeCode + "]";
	}

}
