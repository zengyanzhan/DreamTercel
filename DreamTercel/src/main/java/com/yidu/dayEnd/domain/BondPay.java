package com.yidu.dayEnd.domain;

import java.sql.Date;

/**
 * 债券计息
 * @author 肖光宇
 * @date 2017年11月18日
 * @time 上午9:53:15
 *
 */
public class BondPay {
	private  String securityCode;//证券编号
	private String bondCode;//债券编号
	private String fundCode;//基金编号
	private String  cashArapCode;//现金应收应付
	private String bondName;//债券名称
	private String businessType;//业务类型
	private String bondType;//债券类型
	private Integer direction;
	private double allMoney;//资金余额
	private Date businessDate;//业务日期
	private Integer securityType;//证券类型
	private String desc;//备注
	private String securityAparType;//证券应收应付
	private String businessCode;//业务编号
	private String accountCode;//现金的编号
	private Date date;//调拨日期
	private String strBusiness;
	private String strDate;
	private String data;
	public BondPay(){}
	
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getBondCode() {
		return bondCode;
	}
	public void setBondCode(String bondCode) {
		this.bondCode = bondCode;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getCashArapCode() {
		return cashArapCode;
	}
	public void setCashArapCode(String cashArapCode) {
		this.cashArapCode = cashArapCode;
	}
	public String getBondName() {
		return bondName;
	}
	public void setBondName(String bondName) {
		this.bondName = bondName;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getBondType() {
		return bondType;
	}
	public void setBondType(String bondType) {
		this.bondType = bondType;
	}
	public double getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(double allMoney) {
		this.allMoney = allMoney;
	}
	public Date getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}
	public Integer getSecurityType() {
		return securityType;
	}
	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSecurityAparType() {
		return securityAparType;
	}
	public void setSecurityAparType(String securityAparType) {
		this.securityAparType = securityAparType;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStrBusiness() {
		return strBusiness;
	}
	public void setStrBusiness(String strBusiness) {
		this.strBusiness = strBusiness;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BondPay [securityCode=" + securityCode + ", bondCode=" + bondCode + ", fundCode=" + fundCode
				+ ", cashArapCode=" + cashArapCode + ", bondName=" + bondName + ", businessType=" + businessType
				+ ", bondType=" + bondType + ", direction=" + direction + ", allMoney=" + allMoney + ", businessDate="
				+ businessDate + ", securityType=" + securityType + ", desc=" + desc + ", securityAparType="
				+ securityAparType + ", businessCode=" + businessCode + ", accountCode=" + accountCode + ", date="
				+ date + ", strBusiness=" + strBusiness + ", strDate=" + strDate + ", data=" + data + "]";
	}

}
