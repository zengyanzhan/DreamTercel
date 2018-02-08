package com.yidu.stockControl.domain;

import java.io.Serializable;
import java.sql.Date;
/**
 * 现金应收应付库存的实体类
 * @author 向燕春
 * @date 2017年11月13日
 * @time 下午2:58:34
 *
 */
@SuppressWarnings("serial")
public class CashArapStock implements Serializable{
	private String cashArapStockCode;	//现金应收应付库存编号(以每一笔记)
	private String cashAccountCode ;	//外键 引用现金账户表的ID
	private String fundCode ;			//外键 引用基金表的基金代码
	private Integer businessType ;		//业务类型(1管理费,2托管费,3存款利息,4TA清算款)
	private Double totalMoney ;			//总金额
	private Integer status ;			//不为空 业务状态 1代表应收，-1代表应付
	private Date businessDate ;			//不为空 业务日期 日期
	private Integer periodFlag ;		//不为空 期初标志 是否从其他系统导入的期初数据  1：不是  2：是
	private String cashArapStockDesc ; 	//备注可扩展
	
	private String strDate; 			//字符串格式日期
	private String cashAccountName ;	//外键 引用现金账户表的ID
	private String fundName ;			//外键 引用基金表的基金代码
	
	private String businessDateWhere;	//业务日期条件
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式
	
	public CashArapStock(){}
		
	public CashArapStock(String cashArapStockCode, String cashAccountCode, String fundCode, Integer businessType,
			Double totalMoney, Integer status, Date businessDate, Integer periodFlag, String cashArapStockDesc) {
		super();
		this.cashArapStockCode = cashArapStockCode;
		this.cashAccountCode = cashAccountCode;
		this.fundCode = fundCode;
		this.businessType = businessType;
		this.totalMoney = totalMoney;
		this.status = status;
		this.businessDate = businessDate;
		this.periodFlag = periodFlag;
		this.cashArapStockDesc = cashArapStockDesc;
	}
	public CashArapStock(String cashArapStockCode, String cashAccountCode, String fundCode, Integer businessType,
			Double totalMoney, Integer status, Date businessDate, Integer periodFlag, String cashArapStockDesc,
			String businessDateWhere, String tableName, Integer page, Integer rows, Integer rowsTotal, String orderColumn,
			String orderStyle) {
		super();
		this.cashArapStockCode = cashArapStockCode;
		this.cashAccountCode = cashAccountCode;
		this.fundCode = fundCode;
		this.businessType = businessType;
		this.totalMoney = totalMoney;
		this.status = status;
		this.businessDate = businessDate;
		this.periodFlag = periodFlag;
		this.cashArapStockDesc = cashArapStockDesc;
		this.businessDateWhere = businessDateWhere;
		this.tableName = tableName;
		this.page = page;
		this.rows = rows;
		this.rowsTotal = rowsTotal;
		this.orderColumn = orderColumn;
		this.orderStyle = orderStyle;
	}

	public String getCashAccountName() {
		return cashAccountName;
	}

	public void setCashAccountName(String cashAccountName) {
		this.cashAccountName = cashAccountName;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
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
	public String getCashArapStockCode() {
		return cashArapStockCode;
	}
	public void setCashArapStockCode(String cashArapStockCode) {
		this.cashArapStockCode = cashArapStockCode;
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
	public Integer getBusinessType() {
		return businessType;
	}
	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPeriodFlag() {
		return periodFlag;
	}
	public void setPeriodFlag(Integer periodFlag) {
		this.periodFlag = periodFlag;
	}
	public String getCashArapStockDesc() {
		return cashArapStockDesc;
	}
	public void setCashArapStockDesc(String cashArapStockDesc) {
		this.cashArapStockDesc = cashArapStockDesc;
	}
	public Date getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}

	public String getBusinessDateWhere() {
		return businessDateWhere;
	}

	public void setBusinessDateWhere(String businessDateWhere) {
		this.businessDateWhere = businessDateWhere;
	}

	@Override
	public String toString() {
		return "CashArapStock [cashArapStockCode=" + cashArapStockCode + ", cashAccountCode=" + cashAccountCode
				+ ", fundCode=" + fundCode + ", businessType=" + businessType + ", totalMoney=" + totalMoney
				+ ", status=" + status + ", businessDate=" + businessDate + ", periodFlag=" + periodFlag
				+ ", cashArapStockDesc=" + cashArapStockDesc + ", strDate=" + strDate + ", cashAccountName="
				+ cashAccountName + ", fundName=" + fundName + ", businessDateWhere=" + businessDateWhere
				+ ", tableName=" + tableName + ", page=" + page + ", rows=" + rows + ", rowsTotal=" + rowsTotal
				+ ", orderColumn=" + orderColumn + ", orderStyle=" + orderStyle + "]";
	}
}
