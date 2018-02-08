package com.yidu.stockControl.domain;

import java.io.Serializable;
import java.sql.Date;
/**
 * 现金库存的实体类
 * @author ChenJiaLong
 * @date 2017年11月13日
 * @time 上午9:43:52
 *
 */
public class CashStock implements Serializable{
	 
	
	private String CashStockCode;//现金库存编号
	private String FundCode;//基金信息编号（名称）
	private Double CashBlance;//现金库存余额
	private String CashAccountCode;//现金账户的编号（名称）
	private Date StatisticDate;//统计日期
	private Double PeriodFlag;//期初数据(1导入 2不导入)
	private String CashDesc;//备注
	private String strDate;
	
	private int page;//页面
	private int rows;//行数
	private String orderColumn;//排序的列
	private String orderStyle;//排序方式
	
	public CashStock(){}

	
	public CashStock(String cashStockCode, String fundCode, Double cashBlance, String cashAccountCode,
			Date statisticDate, Double periodFlag, String cashDesc, String strDate) {
		super();
		CashStockCode = cashStockCode;
		FundCode = fundCode;
		CashBlance = cashBlance;
		CashAccountCode = cashAccountCode;
		StatisticDate = statisticDate;
		PeriodFlag = periodFlag;
		CashDesc = cashDesc;
		this.strDate = strDate;
	}


	public String getCashStockCode() {
		return CashStockCode;
	}


	public void setCashStockCode(String cashStockCode) {
		CashStockCode = cashStockCode;
	}


	public String getFundCode() {
		return FundCode;
	}


	public void setFundCode(String fundCode) {
		FundCode = fundCode;
	}


	public Double getCashBlance() {
		return CashBlance;
	}


	public void setCashBlance(Double cashBlance) {
		CashBlance = cashBlance;
	}


	public String getCashAccountCode() {
		return CashAccountCode;
	}


	public void setCashAccountCode(String cashAccountCode) {
		CashAccountCode = cashAccountCode;
	}


	public Date getStatisticDate() {
		return StatisticDate;
	}


	public void setStatisticDate(Date statisticDate) {
		StatisticDate = statisticDate;
	}


	public Double getPeriodFlag() {
		return PeriodFlag;
	}


	public void setPeriodFlag(Double periodFlag) {
		PeriodFlag = periodFlag;
	}


	public String getCashDesc() {
		return CashDesc;
	}


	public void setCashDesc(String cashDesc) {
		CashDesc = cashDesc;
	}


	public String getStrDate() {
		return strDate;
	}


	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
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


	@Override
	public String toString() {
		return "CashStock [CashStockCode=" + CashStockCode + ", FundCode=" + FundCode + ", CashBlance=" + CashBlance
				+ ", CashAccountCode=" + CashAccountCode + ", StatisticDate=" + StatisticDate + ", PeriodFlag="
				+ PeriodFlag + ", CashDesc=" + CashDesc + ", strDate=" + strDate + ", page=" + page + ", rows=" + rows
				+ ", orderColumn=" + orderColumn + ", orderStyle=" + orderStyle + "]";
	}







	/*public CashStock(String cashStockCode, String fundCode, Double cashBlance, String cashAccountCode,
			Date statisticDate, Double periodFlag, String cashDesc, int page, int rows, String orderColumn,
			String orderStyle) {
		super();
		CashStockCode = cashStockCode;
		FundCode = fundCode;
		CashBlance = cashBlance;
		CashAccountCode = cashAccountCode;
		StatisticDate = statisticDate;
		PeriodFlag = periodFlag;
		CashDesc = cashDesc;
		this.page = page;
		this.rows = rows;
		this.orderColumn = orderColumn;
		this.orderStyle = orderStyle;
	}*/

	

}
