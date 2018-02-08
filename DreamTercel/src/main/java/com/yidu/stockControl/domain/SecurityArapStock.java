package com.yidu.stockControl.domain;

import java.sql.Date;

/**
 *  证券应收应付库存  实体
 * @author 肖向恩
 * 
 * 
 */
public class SecurityArapStock {
	private String securityArapStockCode;//证券应收应付库存编号
	private String cashAccountCode;//引用现金账户表Code
	private String fundCode;//引用基金表的基金代码 
	private String securityCode; //证券id
	private Integer businessType;//业务类型(1估值增值,2清算款,3银行计息)
	private double totalMoney;//总金额 默认为0 
	private  Integer periodFlag;//期初标志(1导入数据,2不导入)
	private  Integer businessStatus;//业务状态(1代表应收，2代表应付)
	private  Date businessDate;//业务日期
	private String securityArapStockDesc;//备注可扩展
	
	private String bondCodeWhere;		//债券的代码 唯一id
	private Date interestStarDateWhere;		//计息起始日	
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式
	private String strStart;  //日期转字符串开户时间
	public SecurityArapStock(){}
	
	public SecurityArapStock(String securityArapStockCode, String cashAccountCode, String fundCode, String securityCode,
			Integer businessType, double totalMoney, Integer periodFlag, Integer businessStatus, Date businessDate,
			String securityArapStockDesc, String bondCodeWhere, Date interestStarDateWhere, String tableName,
			Integer page, Integer rows, Integer rowsTotal, String orderColumn, String orderStyle, String strStart) {
		super();
		this.securityArapStockCode = securityArapStockCode;
		this.cashAccountCode = cashAccountCode;
		this.fundCode = fundCode;
		this.securityCode = securityCode;
		this.businessType = businessType;
		this.totalMoney = totalMoney;
		this.periodFlag = periodFlag;
		this.businessStatus = businessStatus;
		this.businessDate = businessDate;
		this.securityArapStockDesc = securityArapStockDesc;
		this.bondCodeWhere = bondCodeWhere;
		this.interestStarDateWhere = interestStarDateWhere;
		this.tableName = tableName;
		this.page = page;
		this.rows = rows;
		this.rowsTotal = rowsTotal;
		this.orderColumn = orderColumn;
		this.orderStyle = orderStyle;
		this.strStart = strStart;
	}
	public String getSecurityArapStockCode() {
		return securityArapStockCode;
	}
	public void setSecurityArapStockCode(String securityArapStockCode) {
		this.securityArapStockCode = securityArapStockCode;
	}
	public String getCashAccountCode() {
		return cashAccountCode;
	}
	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
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
	public Integer getBusinessType() {
		return businessType;
	}
	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Integer getPeriodFlag() {
		return periodFlag;
	}
	public void setPeriodFlag(Integer periodFlag) {
		this.periodFlag = periodFlag;
	}
	public Integer getBusinessStatus() {
		return businessStatus;
	}
	public void setBusinessStatus(Integer businessStatus) {
		this.businessStatus = businessStatus;
	}
	public Date getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}
	public String getSecurityArapStockDesc() {
		return securityArapStockDesc;
	}
	public void setSecurityArapStockDesc(String securityArapStockDesc) {
		this.securityArapStockDesc = securityArapStockDesc;
	}
	public String getBondCodeWhere() {
		return bondCodeWhere;
	}
	public void setBondCodeWhere(String bondCodeWhere) {
		this.bondCodeWhere = bondCodeWhere;
	}
	public Date getInterestStarDateWhere() {
		return interestStarDateWhere;
	}
	public void setInterestStarDateWhere(Date interestStarDateWhere) {
		this.interestStarDateWhere = interestStarDateWhere;
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
	public String getStrStart() {
		return strStart;
	}
	public void setStrStart(String strStart) {
		this.strStart = strStart;
	}
	@Override
	public String toString() {
		return "SecurityArapStock [securityArapStockCode=" + securityArapStockCode + ", cashAccountCode="
				+ cashAccountCode + ", fundCode=" + fundCode + ", securityCode=" + securityCode + ", businessType="
				+ businessType + ", totalMoney=" + totalMoney + ", periodFlag=" + periodFlag + ", businessStatus="
				+ businessStatus + ", businessDate=" + businessDate + ", securityArapStockDesc=" + securityArapStockDesc
				+ ", bondCodeWhere=" + bondCodeWhere + ", interestStarDateWhere=" + interestStarDateWhere
				+ ", tableName=" + tableName + ", page=" + page + ", rows=" + rows + ", rowsTotal=" + rowsTotal
				+ ", orderColumn=" + orderColumn + ", orderStyle=" + orderStyle + ", strStart=" + strStart + "]";
	}
	
	


}
