package com.yidu.reportManagement.domain;

import java.io.Serializable;

public class OffsetBalance implements Serializable{
	private String securityId;											//证券id
	private String securityName;									//证券名称
	private Double outMoney;										//今日流出金额
	private Double inMoney;											//今日流入金额
	private Double clearMoney;									//今日清算金额
	private Double handleFee;										//经手费
	private Double stamps;											//印花税
	private Double transferFee;										//过户费
	private Double connectionAndManagementFees;			//征管费
	private Double money;												//实际清算金额
	
	public OffsetBalance(){}

	public OffsetBalance(String securityId, String securityName, Double outMoney, Double inMoney, Double clearMoney,
			Double handleFee, Double stamps, Double transferFee, Double connectionAndManagementFees, Double money) {
		super();
		this.securityId = securityId;
		this.securityName = securityName;
		this.outMoney = outMoney;
		this.inMoney = inMoney;
		this.clearMoney = clearMoney;
		this.handleFee = handleFee;
		this.stamps = stamps;
		this.transferFee = transferFee;
		this.connectionAndManagementFees = connectionAndManagementFees;
		this.money = money;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public Double getOutMoney() {
		return outMoney;
	}

	public void setOutMoney(Double outMoney) {
		this.outMoney = outMoney;
	}

	public Double getInMoney() {
		return inMoney;
	}

	public void setInMoney(Double inMoney) {
		this.inMoney = inMoney;
	}

	public Double getClearMoney() {
		return clearMoney;
	}

	public void setClearMoney(Double clearMoney) {
		this.clearMoney = clearMoney;
	}

	public Double getHandleFee() {
		return handleFee;
	}

	public void setHandleFee(Double handleFee) {
		this.handleFee = handleFee;
	}

	public Double getStamps() {
		return stamps;
	}

	public void setStamps(Double stamps) {
		this.stamps = stamps;
	}

	public Double getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(Double transferFee) {
		this.transferFee = transferFee;
	}

	public Double getConnectionAndManagementFees() {
		return connectionAndManagementFees;
	}

	public void setConnectionAndManagementFees(Double connectionAndManagementFees) {
		this.connectionAndManagementFees = connectionAndManagementFees;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "OffsetBalance [securityId=" + securityId + ", securityName=" + securityName + ", outMoney=" + outMoney
				+ ", inMoney=" + inMoney + ", clearMoney=" + clearMoney + ", handleFee=" + handleFee + ", stamps="
				+ stamps + ", transferFee=" + transferFee + ", connectionAndManagementFees="
				+ connectionAndManagementFees + ", money=" + money + "]";
	}
}
