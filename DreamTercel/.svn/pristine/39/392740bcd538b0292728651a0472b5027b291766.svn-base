package com.yidu.dayEnd.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 净值统计表的实体类
 * @author 向燕春
 * @date 2017年11月18日
 * @time 下午9:45:56
 *
 */
@SuppressWarnings("serial")
public class NetValue implements Serializable{
	private String netValueCode;	//主键 净值统计表的编号 
	private String fundCode;		//外键 基金编号 引用基金表 t_fund中的主键列fundId
	private String projectName;		//不为空 项目名称 股票
	private String projectCode="";	//不为空 项目编号
	private Integer quantity=0;		//数量  股数/票面数
	private Double price=0d;		//不为空 行情价格 行情价格
	private Double costing=0d ;		//不为空 成本 成本
	private Double marketValue=0d;	//不为空 市值 市值
	private Date statisticDate;		//不为空 统计日期 统计日期
	private Double valueAdd=0d;		//不为空 估值增值 估值增值
	private String treeCode;		//不为空 树节点
	private String treeFatherCode; 	//父类树节点


	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式
	private String statisticDateWhere;	//转换日期格式的字段

	private String cashAccountCode;		//现金账户
	private Integer businessType;      	//业务类型（存款利息、两费）
	private Integer securityType;		//证券类型
	private String enteringDate;		//收盘日期
	private String businessDate;		//业务日期


	private String strFundCode;
	private String strFundName;
	private String strMoney;
	private String strTotalMoney;		//资产净值
	private List<NetValue> children;	//子节点
	public NetValue(){}

	public NetValue(String fundCode, String statisticDateWhere) {
		super();
		this.fundCode = fundCode;
		this.statisticDateWhere = statisticDateWhere;
	}

	public NetValue(String fundCode, String treeFatherCode, String statisticDateWhere) {
		super();
		this.fundCode = fundCode;
		this.treeFatherCode = treeFatherCode;
		this.statisticDateWhere = statisticDateWhere;
	}

	public NetValue(String netValueCode, String fundCode, String projectName, String projectCode, Integer quantity,
			Double price, Double costing, Double marketValue, String statisticDateWhere, Double valueAdd, String treeCode,
			String treeFatherCode) {
		super();
		this.netValueCode = netValueCode;
		this.fundCode = fundCode;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.quantity = quantity;
		this.price = price;
		this.costing = costing;
		this.marketValue = marketValue;
		this.statisticDateWhere = statisticDateWhere;
		this.valueAdd = valueAdd;
		this.treeCode = treeCode;
		this.treeFatherCode = treeFatherCode;
	}

	public String getStrFundCode() {
		return strFundCode;
	}

	public void setStrFundCode(String strFundCode) {
		this.strFundCode = strFundCode;
	}


	public String getStrFundName() {
		return strFundName;
	}

	public void setStrFundName(String strFundName) {
		this.strFundName = strFundName;
	}

	public String getStrMoney() {
		return strMoney;
	}

	public void setStrMoney(String strMoney) {
		this.strMoney = strMoney;
	}

	public String getStrTotalMoney() {
		return strTotalMoney;
	}

	public void setStrTotalMoney(String strTotalMoney) {
		this.strTotalMoney = strTotalMoney;
	}

	public String getNetValueCode() {
		return netValueCode;
	}


	public void setNetValueCode(String netValueCode) {
		this.netValueCode = netValueCode;
	}


	public Integer getSecurityType() {
		return securityType;
	}
	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
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


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getCosting() {
		return costing;
	}


	public void setCosting(Double costing) {
		this.costing = costing;
	}


	public Double getMarketValue() {
		return marketValue;
	}


	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}


	public Date getStatisticDate() {
		return statisticDate;
	}


	public void setStatisticDate(Date statisticDate) {
		this.statisticDate = statisticDate;
	}


	public Double getValueAdd() {
		return valueAdd;
	}


	public void setValueAdd(Double valueAdd) {
		this.valueAdd = valueAdd;
	}


	public String getTreeCode() {
		return treeCode;
	}


	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}


	public String getTreeFatherCode() {
		return treeFatherCode;
	}


	public void setTreeFatherCode(String treeFatherCode) {
		this.treeFatherCode = treeFatherCode;
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

	public List<NetValue> getChildren() {
		return children;
	}
	public void setChildren(List<NetValue> children) {
		this.children = children;
	}
	public String getStatisticDateWhere() {
		return statisticDateWhere;
	}
	public void setStatisticDateWhere(String statisticDateWhere) {
		this.statisticDateWhere = statisticDateWhere;
	}

	public String getEnteringDate() {
		return enteringDate;
	}
	public void setEnteringDate(String enteringDate) {
		this.enteringDate = enteringDate;
	}
	public String getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "NetValue [netValueCode=" + netValueCode + ", fundCode=" + fundCode + ", projectName=" + projectName
				+ ", projectCode=" + projectCode + ", quantity=" + quantity + ", price=" + price + ", costing="
				+ costing + ", marketValue=" + marketValue + ", statisticDate=" + statisticDate + ", valueAdd="
				+ valueAdd + ", treeCode=" + treeCode + ", treeFatherCode=" + treeFatherCode + ", tableName="
				+ tableName + ", page=" + page + ", rows=" + rows + ", rowsTotal=" + rowsTotal + ", orderColumn="
				+ orderColumn + ", orderStyle=" + orderStyle + ", statisticDateWhere=" + statisticDateWhere
				+ ", cashAccountCode=" + cashAccountCode + ", businessType=" + businessType + ", securityType="
				+ securityType + ", enteringDate=" + enteringDate + ", businessDate=" + businessDate + ", strFundCode="
				+ strFundCode + ", strFundName=" + strFundName + ", strMoney=" + strMoney + ", strTotalMoney="
				+ strTotalMoney + ", children=" + children + "]";
	}

//	@Override
//	public String toString() {
//		return "NetValue [netValueCode净值统计代码=" + netValueCode + ", fundCode基金代码=" + fundCode + ", projectName项目名称=" + projectName
//				+ ", projectCode项目代码=" + projectCode + ", quantity数量=" + quantity + ", price行情价格=" + price + ", costing成本="
//				+ costing + ", marketValue市值=" + marketValue + ", valueAdd估值增值=" + valueAdd + ", treeCode树形code=" + treeCode
//				+ ", treeFatherCode树形父类Code=" + treeFatherCode + ", statisticDateWhere统计日期=" + statisticDateWhere + "]";
//	}
	

}
