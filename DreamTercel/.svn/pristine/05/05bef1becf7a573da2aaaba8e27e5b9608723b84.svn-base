package com.yidu.reportManagement.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 股票权益报表实体类
 * @author XiaoYuJie
 * @date 2017年12月6日
 * @time 下午7:35:27
 */
public class StockeQuity implements Serializable{
	private String securityCode;//股票代码
	private String securityName;//股票名称
	private Date exRights;//除权日
	private Double securityquantity;//数量
	private Double totalmoney;//金额
	private Integer equityType;//权益类型
	
	private String strDate;
	
	private String tableName;//表名
	private Integer page;//第几页
	private Integer rows;//多少行
	private Integer rowsTotal;
	private String orderColumn;//排序的列
	private String orderStyle;//排序方式
	
	
	public StockeQuity(){}
	
	
	public StockeQuity(String securityCode, String securityName, Date exRights, Double securityquantity,
			Double totalmoney,Integer equityType) {
		super();
		this.securityCode = securityCode;
		this.securityName = securityName;
		this.exRights = exRights;
		this.securityquantity = securityquantity;
		this.totalmoney = totalmoney;
		this.equityType=equityType;
	}


	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public Date getExRights() {
		return exRights;
	}
	public void setExRights(Date exRights) {
		this.exRights = exRights;
	}
	public Double getSecurityquantity() {
		return securityquantity;
	}
	public void setSecurityquantity(Double securityquantity) {
		this.securityquantity = securityquantity;
	}
	public Double getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}
	
	public Integer getEquityType() {
		return equityType;
	}


	public void setEquityType(Integer equityType) {
		this.equityType = equityType;
	}


	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
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


	@Override
	public String toString() {
		return "StockeQuity [securityCode=" + securityCode + ", securityName=" + securityName + ", exRights=" + exRights
				+ ", securityquantity=" + securityquantity + ", totalmoney=" + totalmoney + ", strDate=" + strDate
				+ ", tableName=" + tableName + ", page=" + page + ", rows=" + rows + ", rowsTotal=" + rowsTotal
				+ ", orderColumn=" + orderColumn + ", orderStyle=" + orderStyle + "]";
	}
	
	
	
	
	
}
