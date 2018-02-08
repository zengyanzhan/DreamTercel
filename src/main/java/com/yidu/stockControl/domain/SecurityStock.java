package com.yidu.stockControl.domain;

import java.sql.Date;

/**
 * 证券库存实体类
 * @author ZengYanZhan
 * @date 2017年11月13日
 * @time 下午2:03:24
 */
public class SecurityStock {
	private String code; //证券库存编号
	private String fundName;//基金名称
	private String fundCode; //基金编号id
	private String accountCode;//账户编号id
	private String securityCode; //证券id
	private String securityName; //证券名称
	private Double securityQuantity;//证券数量
	private Double securityUtilCost;//证券单位成本
	private Double totalMoney;//总金额
	private Date datetimeInner;//统计日期
	private Integer securityType;//证券类型
	private Integer periodFlag;//期初标志
	private String securityDesc;//证券备注
	private Integer rows;//每页显示行数
	private Integer page;//第几页
	private String datetime;//查询日期 或者 统计日期
	private String sortOrder; //排序的方式
	private String sortName;//排序的列字段
	private String staticticsDate; //字符串格式日期
	
	public SecurityStock(){}

	public SecurityStock(String code, String fundName, String fundCode, String accountCode, String securityCode,
			String securityName, Double securityQuantity, Double securityUtilCost, Double totalMoney,
			Date datetimeInner, Integer securityType, Integer periodFlag, String securityDesc, Integer rows,
			Integer page, String datetime, String sortOrder, String sortName, String staticticsDate) {
		super();
		this.code = code;
		this.fundName = fundName;
		this.fundCode = fundCode;
		this.accountCode = accountCode;
		this.securityCode = securityCode;
		this.securityName = securityName;
		this.securityQuantity = securityQuantity;
		this.securityUtilCost = securityUtilCost;
		this.totalMoney = totalMoney;
		this.datetimeInner = datetimeInner;
		this.securityType = securityType;
		this.periodFlag = periodFlag;
		this.securityDesc = securityDesc;
		this.rows = rows;
		this.page = page;
		this.datetime = datetime;
		this.sortOrder = sortOrder;
		this.sortName = sortName;
		this.staticticsDate = staticticsDate;
	}


	public Integer getPeriodFlag() {
		return periodFlag;
	}


	public void setPeriodFlag(Integer periodFlag) {
		this.periodFlag = periodFlag;
	}
	 

	public Integer getRows() {
		return rows;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
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

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Date getDatetimeInner() {
		return datetimeInner;
	}

	public void setDatetimeInner(Date datetimeInner) {
		this.datetimeInner = datetimeInner;
	}

	public Integer getSecurityType() {
		return securityType;
	}

	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}

	public String getSecurityDesc() {
		return securityDesc;
	}

	public void setSecurityDesc(String securityDesc) {
		this.securityDesc = securityDesc;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}


	public String getSortOrder() {
		return sortOrder;
	}


	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}


	public String getSortName() {
		return sortName;
	}


	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getStaticticsDate() {
		return staticticsDate;
	}

	public void setStaticticsDate(String staticticsDate) {
		this.staticticsDate = staticticsDate;
	}



	public Double getSecurityQuantity() {
		return securityQuantity;
	}

	public void setSecurityQuantity(Double securityQuantity) {
		this.securityQuantity = securityQuantity;
	}

	@Override
	public String toString() {
		return "SecurityStock [code=" + code + ", fundName=" + fundName + ", fundCode=" + fundCode + ", accountCode="
				+ accountCode + ", securityCode=" + securityCode + ", securityName=" + securityName
				+ ", securityQuantity=" + securityQuantity + ", securityUtilCost=" + securityUtilCost + ", totalMoney="
				+ totalMoney + ", datetimeInner=" + datetimeInner + ", securityType=" + securityType + ", periodFlag="
				+ periodFlag + ", securityDesc=" + securityDesc + ", rows=" + rows + ", page=" + page + ", datetime="
				+ datetime + ", sortOrder=" + sortOrder + ", sortName=" + sortName + ", staticticsDate="
				+ staticticsDate + "]";
	}
	 
}
