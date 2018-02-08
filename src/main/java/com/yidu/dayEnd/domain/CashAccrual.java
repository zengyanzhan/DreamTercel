package com.yidu.dayEnd.domain;

import java.sql.Date;

/**
 * 现金计息实体类
 * @author 邓涛
 * @date 2017年11月22日
 * @time 下午6:26:21
 */
public class CashAccrual {
	private String cashAccountBankName;//银行名称
	private String cashAccountBankCard;//银行卡号
	private String fundCode;//基金编号
	private String cashAccountCode;//现金账户表id
	private Double cashBlance;//现金余额
	private Date cashStatisticDate;//业务日期
	private Integer cashAccountDepositType;//存款类型
	private Double cashAccountCardRate;//年利率
	private Integer cashAccountInterestPeriod;//计息期间
	private String strDate;//字符串日期
	
	private String businessDateWhere;	//业务日期条件
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式
	private String qualification;		//查询条件
	/**
	 * 空的构造方法
	 */
	public CashAccrual(){
		
	}
	/**
	 * 带参数的构造方法
	 * @param cashAccountBankName 银行名称
	 * @param cashAccountBankCard 银行卡号
	 * @param fundCode 基金编号
	 * @param cashAccountCode 现金账户表id
	 * @param cashBlance 现金余额 
	 * @param businessDate 业务日期
	 * @param cashAccountDepositType 存款类型
	 * @param cashAccountCardRate 年利率
	 * @param cashAccountInterestPeriod 计息期间
	 * @param strDate 字符串日期
	 */
	public CashAccrual(String cashAccountBankName, String cashAccountBankCard, String fundCode, String cashAccountCode,
			Double cashBlance, Date cashStatisticDate, Integer cashAccountDepositType, Double cashAccountCardRate,
			Integer cashAccountInterestPeriod, String strDate) {
		super();
		this.cashAccountBankName = cashAccountBankName;
		this.cashAccountBankCard = cashAccountBankCard;
		this.fundCode = fundCode;
		this.cashAccountCode = cashAccountCode;
		this.cashBlance = cashBlance;
		this.cashStatisticDate = cashStatisticDate;
		this.cashAccountDepositType = cashAccountDepositType;
		this.cashAccountCardRate = cashAccountCardRate;
		this.cashAccountInterestPeriod = cashAccountInterestPeriod;
		this.strDate = strDate;
	}
	public CashAccrual(String cashAccountBankName, String cashAccountBankCard, String fundCode, String cashAccountCode,
			Double cashBlance, Date cashStatisticDate, Integer cashAccountDepositType, Double cashAccountCardRate,
			Integer cashAccountInterestPeriod, String strDate, String businessDateWhere, String tableName, Integer page,
			Integer rows, Integer rowsTotal, String orderColumn, String orderStyle) {
		super();
		this.cashAccountBankName = cashAccountBankName;
		this.cashAccountBankCard = cashAccountBankCard;
		this.fundCode = fundCode;
		this.cashAccountCode = cashAccountCode;
		this.cashBlance = cashBlance;
		this.cashStatisticDate = cashStatisticDate;
		this.cashAccountDepositType = cashAccountDepositType;
		this.cashAccountCardRate = cashAccountCardRate;
		this.cashAccountInterestPeriod = cashAccountInterestPeriod;
		this.strDate = strDate;
		this.businessDateWhere = businessDateWhere;
		this.tableName = tableName;
		this.page = page;
		this.rows = rows;
		this.rowsTotal = rowsTotal;
		this.orderColumn = orderColumn;
		this.orderStyle = orderStyle;
	}
	public String getCashAccountBankName() {
		return cashAccountBankName;
	}
	public void setCashAccountBankName(String cashAccountBankName) {
		this.cashAccountBankName = cashAccountBankName;
	}
	public String getCashAccountBankCard() {
		return cashAccountBankCard;
	}
	public void setCashAccountBankCard(String cashAccountBankCard) {
		this.cashAccountBankCard = cashAccountBankCard;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getCashAccountCode() {
		return cashAccountCode;
	}
	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
	}
	public Double getCashBlance() {
		return cashBlance;
	}
	public void setCashBlance(Double cashBlance) {
		this.cashBlance = cashBlance;
	}
	public Date getCashStatisticDate() {
		return cashStatisticDate;
	}
	public void setCashStatisticDate(Date cashStatisticDate) {
		this.cashStatisticDate = cashStatisticDate;
	}
	public Integer getCashAccountDepositType() {
		return cashAccountDepositType;
	}
	public void setCashAccountDepositType(Integer cashAccountDepositType) {
		this.cashAccountDepositType = cashAccountDepositType;
	}
	public Double getCashAccountCardRate() {
		return cashAccountCardRate;
	}
	public void setCashAccountCardRate(Double cashAccountCardRate) {
		this.cashAccountCardRate = cashAccountCardRate;
	}
	public Integer getCashAccountInterestPeriod() {
		return cashAccountInterestPeriod;
	}
	public void setCashAccountInterestPeriod(Integer cashAccountInterestPeriod) {
		this.cashAccountInterestPeriod = cashAccountInterestPeriod;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getBusinessDateWhere() {
		return businessDateWhere;
	}
	public void setBusinessDateWhere(String businessDateWhere) {
		this.businessDateWhere = businessDateWhere;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
	public Integer getRowsTotal() {
		return rowsTotal;
	}
	public void setRowsTotal(Integer rowsTotal) {
		this.rowsTotal = rowsTotal;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getOrderStyle() {
		return orderStyle;
	}
	public void setOrderStyle(String orderStyle) {
		this.orderStyle = orderStyle;
	}
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "CashCount [cashAccountBankName=" + cashAccountBankName + ", cashAccountBankCard=" + cashAccountBankCard
				+ ", fundCode=" + fundCode + ", cashAccountCode=" + cashAccountCode + ", cashBlance=" + cashBlance
				+ ", cashStatisticDate=" + cashStatisticDate + ", cashAccountDepositType=" + cashAccountDepositType
				+ ", cashAccountCardRate=" + cashAccountCardRate + ", cashAccountInterestPeriod="
				+ cashAccountInterestPeriod + ", strDate=" + strDate + "]";
	}
}
