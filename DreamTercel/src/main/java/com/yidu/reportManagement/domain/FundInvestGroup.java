package com.yidu.reportManagement.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 基金投资组合报表的实体类
 * @author 向燕春
 * @date 2017年12月5日
 * @time 下午1:38:33
 *
 */
@SuppressWarnings("serial")
public class FundInvestGroup implements Serializable{
	private String securityCode;//证券代码
	private String securityName;//证券名称
	private Integer securityQuantity;//库存数量
	private Double securityUnitCost;//证券单位成本
	private Double securityCosting;//证券成本
	
	private Double price;//行情
	private Double marketValue;//证券市值
	
	private Double totalMoney;//总金额（查询证券库存的总金额）
	private Integer securityType;//证券类型
	private String totalAssetsHeJi;//总资产合计
	
	private String fundCode;//基金代码
	private Date statisticDate;//统计日期
	private String projectName;//项目名称
	private String projectCode;//项目代码
	
	
	private Double costingPercentage;//成本占净值%
	private Double marketValuePercentage;//市值占净值%

	
	
	private String statisticDateWhere;//统计日期的条件
	
	
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式

	public FundInvestGroup(){}
	
	public FundInvestGroup(String securityCode, String securityName, Integer securityQuantity, Double securityUnitCost,
			Double securityCosting, Double price, Double marketValue, Double totalMoney, Integer securityType,
			String totalAssetsHeJi, String fundCode, Date statisticDate, String projectName, String projectCode,
			Double costingPercentage, Double marketValuePercentage, String statisticDateWhere) {
		super();
		this.securityCode = securityCode;
		this.securityName = securityName;
		this.securityQuantity = securityQuantity;
		this.securityUnitCost = securityUnitCost;
		this.securityCosting = securityCosting;
		this.price = price;
		this.marketValue = marketValue;
		this.totalMoney = totalMoney;
		this.securityType = securityType;
		this.totalAssetsHeJi = totalAssetsHeJi;
		this.fundCode = fundCode;
		this.statisticDate = statisticDate;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.costingPercentage = costingPercentage;
		this.marketValuePercentage = marketValuePercentage;
		this.statisticDateWhere = statisticDateWhere;
	}


	public Integer getSecurityType() {
		return securityType;
	}
	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
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
	public Integer getSecurityQuantity() {
		return securityQuantity;
	}
	public void setSecurityQuantity(Integer securityQuantity) {
		this.securityQuantity = securityQuantity;
	}
	public Double getSecurityUnitCost() {
		return securityUnitCost;
	}
	public void setSecurityUnitCost(Double securityUnitCost) {
		this.securityUnitCost = securityUnitCost;
	}
	public Double getSecurityCosting() {
		return securityCosting;
	}
	public void setSecurityCosting(Double securityCosting) {
		this.securityCosting = securityCosting;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public Date getStatisticDate() {
		return statisticDate;
	}
	public void setStatisticDate(Date statisticDate) {
		this.statisticDate = statisticDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public Double getCostingPercentage() {
		return costingPercentage;
	}
	public void setCostingPercentage(Double costingPercentage) {
		this.costingPercentage = costingPercentage;
	}
	public Double getMarketValuePercentage() {
		return marketValuePercentage;
	}
	public void setMarketValuePercentage(Double marketValuePercentage) {
		this.marketValuePercentage = marketValuePercentage;
	}
	public String getTotalAssetsHeJi() {
		return totalAssetsHeJi;
	}
	public void setTotalAssetsHeJi(String totalAssetsHeJi) {
		this.totalAssetsHeJi = totalAssetsHeJi;
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
	@Override
	public String toString() {
		return "FundInvestGroup [securityCode=" + securityCode + ", securityName=" + securityName
				+ ", securityQuantity=" + securityQuantity + ", securityUnitCost=" + securityUnitCost
				+ ", securityCosting=" + securityCosting + ", price=" + price + ", marketValue=" + marketValue
				+ ", fundCode=" + fundCode + ", statisticDate=" + statisticDate + ", projectName=" + projectName
				+ ", projectCode=" + projectCode + ", costingPercentage=" + costingPercentage
				+ ", marketValuePercentage=" + marketValuePercentage 
				+ ", totalAssetsHeJi=" + totalAssetsHeJi + ", statisticDateWhere=" + statisticDateWhere + ", tableName="
				+ tableName + ", page=" + page + ", rows=" + rows + ", rowsTotal=" + rowsTotal + ", orderColumn="
				+ orderColumn + ", orderStyle=" + orderStyle + "]";
	}
}
