package com.yidu.reportManagement.domain;

/**
 * 现金头寸报表实体类
 * @author ZengYanZhan
 * @date 2017年12月2日
 * @time 下午7:59:36
 */
public class CashPositionReport {
	private String projectId;//科目编号
	private String projectName;//科目名称
	private Double projectPrice;//头寸金额 
	private Integer exchangeCode;//交易所类型
	private String flag;//标志
	
	public CashPositionReport(){}

	public CashPositionReport(String projectId, String projectName, Double projectPrice, Integer exchangeCode,
			String flag) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectPrice = projectPrice;
		this.exchangeCode = exchangeCode;
		this.flag = flag;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Double getProjectPrice() {
		return projectPrice;
	}

	public void setProjectPrice(Double projectPrice) {
		this.projectPrice = projectPrice;
	}

	public Integer getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(Integer exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "CashPositionReport [projectId=" + projectId + ", projectName=" + projectName + ", projectPrice="
				+ projectPrice + ", exchangeCode=" + exchangeCode + ", flag=" + flag + "]";
	}

}
