package com.yidu.Android.domain;
import java.sql.Date;
/**
 * 证券市值变动表实体类
 * @author 邓涛
 * @date 2017年12月8日
 * @time 上午10:54:01
 */
public class SecurityMarket {
	private String securityCode;//证券代码
	private String securityName;//证券名称
	private Double securityUtilCost;//单位成本
	private Double securityQuantity;//证券数量
	private Double projectCode;//资产净值
	private Double price;//行情价格
	private Date statisticDate;//统计日期
	private String StrStatisticDate;//字符串日期
	private Double marketChange;//市值变动
	private Double marketNetWorth;//市值净值
	private Double totolMoney;
	private String businessDateWhere;	//业务日期条件
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String sortOrder; 		//排序的列
	private String orderStyle;			//排序方式
	private String qualification;		//查询条件
	public SecurityMarket(){}
	
	public Double getTotolMoney() {
		return totolMoney;
	}

	public void setTotolMoney(Double totolMoney) {
		this.totolMoney = totolMoney;
	}

	public SecurityMarket(String securityCode, String securityName, Double securityUtilCost, Double securityQuantity,
			Double projectCode, Double price, Date statisticDate, Double marketChange, Double marketNetWorth) {
		super();
		this.securityCode = securityCode;
		this.securityName = securityName;
		this.securityUtilCost = securityUtilCost;
		this.securityQuantity = securityQuantity;
		this.projectCode = projectCode;
		this.price = price;
		this.statisticDate = statisticDate;
		this.marketChange = marketChange;
		this.marketNetWorth = marketNetWorth;
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
	public Double getSecurityUtilCost() {
		return securityUtilCost;
	}
	public void setSecurityUtilCost(Double securityUtilCost) {
		this.securityUtilCost = securityUtilCost;
	}
	public Double getSecurityQuantity() {
		return securityQuantity;
	}
	public void setSecurityQuantity(Double securityQuantity) {
		this.securityQuantity = securityQuantity;
	}
	public Double getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(Double projectCode) {
		this.projectCode = projectCode;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getStatisticDate() {
		return statisticDate;
	}
	public void setStatisticDate(Date statisticDate) {
		this.statisticDate = statisticDate;
	}
	public String getStrStatisticDate() {
		return StrStatisticDate;
	}
	public void setStrStatisticDate(String strStatisticDate) {
		StrStatisticDate = strStatisticDate;
	}
	public Double getMarketChange() {
		return marketChange;
	}
	public void setMarketChange(Double marketChange) {
		this.marketChange = marketChange;
	}
	public Double getMarketNetWorth() {
		return marketNetWorth;
	}
	public void setMarketNetWorth(Double marketNetWorth) {
		this.marketNetWorth = marketNetWorth;
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
	
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
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
		return "SecurityMarket [securityCode=" + securityCode + ", securityName=" + securityName + ", securityUtilCost="
				+ securityUtilCost + ", securityQuantity=" + securityQuantity + ", projectCode=" + projectCode
				+ ", price=" + price + ", statisticDate=" + statisticDate + ", StrStatisticDate=" + StrStatisticDate
				+ ", marketChange=" + marketChange + ", marketNetWorth=" + marketNetWorth + ", businessDateWhere="
				+ businessDateWhere + ", tableName=" + tableName + ", page=" + page + ", rows=" + rows + ", rowsTotal="
				+ rowsTotal + ", sortOrder=" + sortOrder + ", orderStyle=" + orderStyle + ", qualification="
				+ qualification + "]";
	}
	
}
