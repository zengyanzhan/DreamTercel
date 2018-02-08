package com.yidu.parameters.domain;

import java.sql.Date;

/**
 * 现金账号表
 * @author 肖向恩
 *	
 */

public class CashAccount {
	private String cashAccountCode;//现金账户表ID
	private String cashAccountBankCard;//银行卡号
	private String cashAccountName;//账户名称,以公司的名义开户
	private String cashAccountBankName;//银行名称  中国建设银行
	private Double cashAccountDepositType;//存款类型  活期为1 ,定期为 2
	private Double cashAccountCardRate;//卡号利率
	private	Double cashAccountInterestPeriod;//计息期间,1为360,2为35,3为366，
	private Date   cashAccountStartTime;//开户时间
	private Date   cashAccountEndTime;//结束时间
	private String cashAccountDesc;//现金账户表的备用字段
	private Integer page;				//页数
	private Integer rows;				//行数
	private String strStart;  //日期转字符串开户时间
	private String strEnd;		//日期转字符串结束时间
	public CashAccount(){}
	
	
	public CashAccount(String cashAccountCode, String cashAccountBankCard, String cashAccountName,
			String cashAccountBankName, Double cashAccountDepositType, Double cashAccountCardRate,
			Double cashAccountInterestPeriod, Date cashAccountStartTime, Date cashAccountEndTime,
			String cashAccountDesc, Integer page, Integer rows) {
		super();
		this.cashAccountCode = cashAccountCode;
		this.cashAccountBankCard = cashAccountBankCard;
		this.cashAccountName = cashAccountName;
		this.cashAccountBankName = cashAccountBankName;
		this.cashAccountDepositType = cashAccountDepositType;
		this.cashAccountCardRate = cashAccountCardRate;
		this.cashAccountInterestPeriod = cashAccountInterestPeriod;
		this.cashAccountStartTime = cashAccountStartTime;
		this.cashAccountEndTime = cashAccountEndTime;
		this.cashAccountDesc = cashAccountDesc;
		this.page = page;
		this.rows = rows;
	}
	
	public String getStrStart() {
		return strStart;
	}


	public void setStrStart(String strStart) {
		this.strStart = strStart;
	}


	public String getStrEnd() {
		return strEnd;
	}


	public void setStrEnd(String strEnd) {
		this.strEnd = strEnd;
	}


	public String getCashAccountCode() {
		return cashAccountCode;
	}
	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
	}
	public String getCashAccountBankCard() {
		return cashAccountBankCard;
	}
	public void setCashAccountBankCard(String cashAccountBankCard) {
		this.cashAccountBankCard = cashAccountBankCard;
	}
	public String getCashAccountName() {
		return cashAccountName;
	}
	public void setCashAccountName(String cashAccountName) {
		this.cashAccountName = cashAccountName;
	}
	public String getCashAccountBankName() {
		return cashAccountBankName;
	}
	public void setCashAccountBankName(String cashAccountBankName) {
		this.cashAccountBankName = cashAccountBankName;
	}
	public Double getCashAccountDepositType() {
		return cashAccountDepositType;
	}
	public void setCashAccountDepositType(Double cashAccountDepositType) {
		this.cashAccountDepositType = cashAccountDepositType;
	}
	public Double getCashAccountCardRate() {
		return cashAccountCardRate;
	}
	public void setCashAccountCardRate(Double cashAccountCardRate) {
		this.cashAccountCardRate = cashAccountCardRate;
	}
	public Double getCashAccountInterestPeriod() {
		return cashAccountInterestPeriod;
	}
	public void setCashAccountInterestPeriod(Double cashAccountInterestPeriod) {
		this.cashAccountInterestPeriod = cashAccountInterestPeriod;
	}
	public Date getCashAccountStartTime() {
		return cashAccountStartTime;
	}
	public void setCashAccountStartTime(Date cashAccountStartTime) {
		this.cashAccountStartTime = cashAccountStartTime;
	}
	public Date getCashAccountEndTime() {
		return cashAccountEndTime;
	}
	public void setCashAccountEndTime(Date cashAccountEndTime) {
		this.cashAccountEndTime = cashAccountEndTime;
	}
	public String getCashAccountDesc() {
		return cashAccountDesc;
	}
	public void setCashAccountDesc(String cashAccountDesc) {
		this.cashAccountDesc = cashAccountDesc;
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


	@Override
	public String toString() {
		return "CashAccount [cashAccountCode=" + cashAccountCode + ", cashAccountBankCard=" + cashAccountBankCard
				+ ", cashAccountName=" + cashAccountName + ", cashAccountBankName=" + cashAccountBankName
				+ ", cashAccountDepositType=" + cashAccountDepositType + ", cashAccountCardRate=" + cashAccountCardRate
				+ ", cashAccountInterestPeriod=" + cashAccountInterestPeriod + ", cashAccountStartTime="
				+ cashAccountStartTime + ", cashAccountEndTime=" + cashAccountEndTime + ", cashAccountDesc="
				+ cashAccountDesc + ", page=" + page + ", rows=" + rows + ", strStart=" + strStart + ", strEnd="
				+ strEnd + "]";
	}

	
	
	
}
