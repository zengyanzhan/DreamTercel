package com.yidu.stockControl.domain;

import java.io.Serializable;
import java.sql.Date;
/**
 * TA库存信息的实体类
 * @author  ZhouMuJiao
 * @date2017年11月14日
 * @time下午2:13:56
 */

@SuppressWarnings("serial")
public class TaStock implements Serializable{
	private String taStockCode;//TA库存id
	private String fundCode;//引用基金表的主键基金编号
	private double taStockQuantity;//TA申购赎回的数量
	private double taStockMoney;//TA交易的金额
	private Date statisticDate;//统计日期
	private Integer periodFlag;//期初数据(1是;2不是)
	private String taStockDesc;//备注
	
	private String fundCodeWhere;//基金编号条件
	private String statisticDateWhere;	//统计日期条件
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式
	
	private String strDate;	//格式统计日期
	
	public TaStock(){}
	public TaStock(String taStockCode, String fundCode, double taStockQuantity, double taStockMoney, Date statisticDate,
			Integer periodFlag, String taStockDesc) {
		super();
		this.taStockCode = taStockCode;
		this.fundCode = fundCode;
		this.taStockQuantity = taStockQuantity;
		this.taStockMoney = taStockMoney;
		this.statisticDate = statisticDate;
		this.periodFlag = periodFlag;
		this.taStockDesc = taStockDesc;
	}
	public TaStock(String taStockCode, String fundCode, double taStockQuantity, double taStockMoney, Date statisticDate,
			Integer periodFlag, String taStockDesc, String fundCodeWhere, String statisticDateWhere, String tableName,
			Integer page, Integer rows, Integer rowsTotal, String orderColumn, String orderStyle) {
		super();
		this.taStockCode = taStockCode;
		this.fundCode = fundCode;
		this.taStockQuantity = taStockQuantity;
		this.taStockMoney = taStockMoney;
		this.statisticDate = statisticDate;
		this.periodFlag = periodFlag;
		this.taStockDesc = taStockDesc;
		this.fundCodeWhere = fundCodeWhere;
		this.statisticDateWhere = statisticDateWhere;
		this.tableName = tableName;
		this.page = page;
		this.rows = rows;
		this.rowsTotal = rowsTotal;
		this.orderColumn = orderColumn;
		this.orderStyle = orderStyle;
	}

	public String getTaStockCode() {
		return taStockCode;
	}
	public void setTaStockCode(String taStockCode) {
		this.taStockCode = taStockCode;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public double getTaStockQuantity() {
		return taStockQuantity;
	}
	public void setTaStockQuantity(double taStockQuantity) {
		this.taStockQuantity = taStockQuantity;
	}
	public double getTaStockMoney() {
		return taStockMoney;
	}
	public void setTaStockMoney(double taStockMoney) {
		this.taStockMoney = taStockMoney;
	}
	public Date getStatisticDate() {
		return statisticDate;
	}
	public void setStatisticDate(Date statisticDate) {
		this.statisticDate = statisticDate;
	}
	public Integer getPeriodFlag() {
		return periodFlag;
	}
	public void setPeriodFlag(Integer periodFlag) {
		this.periodFlag = periodFlag;
	}
	public String getTaStockDesc() {
		return taStockDesc;
	}
	public void setTaStockDesc(String taStockDesc) {
		this.taStockDesc = taStockDesc;
	}
	
	public String getFundCodeWhere() {
		return fundCodeWhere;
	}
	public void setFundCodeWhere(String fundCodeWhere) {
		this.fundCodeWhere = fundCodeWhere;
	}
	public String getStatisticDateWhere() {
		return statisticDateWhere;
	}
	public void setStatisticDateWhere(String statisticDateWhere) {
		this.statisticDateWhere = statisticDateWhere;
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
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	@Override
	public String toString() {
		return "TaStock [taStockCode=" + taStockCode + ", fundCode=" + fundCode + ", taStockQuantity=" + taStockQuantity
				+ ", taStockMoney=" + taStockMoney + ", statisticDate=" + statisticDate + ", periodFlag=" + periodFlag
				+ ", taStockDesc=" + taStockDesc + ", fundCodeWhere=" + fundCodeWhere + ", statisticDateWhere="
				+ statisticDateWhere + ", tableName=" + tableName + ", page=" + page + ", rows=" + rows + ", rowsTotal="
				+ rowsTotal + ", orderColumn=" + orderColumn + ", orderStyle=" + orderStyle + ", strDate=" + strDate
				+ "]";
	}
}
