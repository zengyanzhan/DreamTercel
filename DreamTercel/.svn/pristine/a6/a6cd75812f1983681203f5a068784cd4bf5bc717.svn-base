package com.yidu.reportManagement.domain;

import java.sql.Date;

/**
 * 报表参数设置实体类
 * @author ZengYanZhan
 * @date 2017年12月2日
 * @time 下午2:56:39
 */
public class ReportParams {
	private String fundCode;//基金代码
	private String firstStrDate;//字符串开始日期
	private String secondStrDate;//字符串结束日期
	private String borkerCode;//券商编号
	private Integer page;//第几页
	private Integer rows;//多少行数据
	private String sortOrder;//排序方式
	private Integer exchangeCode;//交易所编号
	private Integer securityType;//证券类型 1是股票 2是债券

	public ReportParams(){}

	public ReportParams(String fundCode, String firstStrDate, String secondStrDate, String borkerCode, Integer page,
			Integer rows, String sortOrder, Integer exchangeCode, Integer securityType) {
		super();
		this.fundCode = fundCode;
		this.firstStrDate = firstStrDate;
		this.secondStrDate = secondStrDate;
		this.borkerCode = borkerCode;
		this.page = page;
		this.rows = rows;
		this.sortOrder = sortOrder;
		this.exchangeCode = exchangeCode;
		this.securityType = securityType;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFirstStrDate() {
		return firstStrDate;
	}

	public void setFirstStrDate(String firstStrDate) {
		this.firstStrDate = firstStrDate;
	}

	public String getSecondStrDate() {
		return secondStrDate;
	}

	public void setSecondStrDate(String secondStrDate) {
		this.secondStrDate = secondStrDate;
	}

	public String getBrokerCode() {
		return borkerCode;
	}

	public void setBrokerCode(String borkerCode) {
		this.borkerCode = borkerCode;
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

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(Integer exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public Integer getSecurityType() {
		return securityType;
	}

	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}

	@Override
	public String toString() {
		return "ReportParams [fundCode=" + fundCode + ", firstStrDate=" + firstStrDate + ", secondStrDate="
				+ secondStrDate + ", borkerCode=" + borkerCode + ", page=" + page + ", rows=" + rows + ", sortOrder="
				+ sortOrder + ", exchangeCode=" + exchangeCode + ", securityType=" + securityType + "]";
	}

}
