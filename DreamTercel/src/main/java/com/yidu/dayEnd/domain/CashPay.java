package com.yidu.dayEnd.domain;

import java.sql.Date;

/**
 * 现金账户和两费实体类
 * @author 肖光宇
 * @date 2017年11月22日
 * @time 下午2:33:43
 *
 */
public class CashPay {
	private String cashArapCode;//现金应收应付编号
	private String cashAccountCode;//现金编号
	private Integer businessType;//业务类型
	private String fundCode;//基金代码
	private String accountName;//账户名称
	private String cardNum;//卡号
	private Integer moneyDirection;//资金流向
	private double money;//资金余额
	private Date businessDate;//业务日期
	private String desc;//备注
	private String strBusiness;
	public CashPay(){}
	public String getCashArapCode() {
		return cashArapCode;
	}
	public void setCashArapCode(String cashArapCode) {
		this.cashArapCode = cashArapCode;
	}
	public String getCashAccountCode() {
		return cashAccountCode;
	}
	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
	}
	public Integer getBusinessType() {
		return businessType;
	}
	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Integer getMoneyDirection() {
		return moneyDirection;
	}
	public void setMoneyDirection(Integer moneyDirection) {
		this.moneyDirection = moneyDirection;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStrBusiness() {
		return strBusiness;
	}
	public void setStrBusiness(String strBusiness) {
		this.strBusiness = strBusiness;
	}
	
}
