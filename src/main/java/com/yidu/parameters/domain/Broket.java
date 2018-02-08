package com.yidu.parameters.domain;

import java.io.Serializable;

/**
 * 券商信息实体类
 * @author Wang
 * @date 2017年11月16日
 * @time 上午10:49:54
 */
public class Broket implements Serializable{
	private String brokerCode;//券商id(QS001)
	private String brokerName;//券商名称
	private String brokerExplain;//-券商的说明
	private String brokerDesc ;//券商表的备用字段
	private Integer page;//分页页数
	private Integer rows;//分页行数
	private String sortName;//排序的列
	private String sortOrder;//排序方式
	public Broket() {
		super();
	}
	public Broket(String brokerCode, String brokerName, String brokerExplain, String brokerDesc) {
		super();
		this.brokerCode = brokerCode;
		this.brokerName = brokerName;
		this.brokerExplain = brokerExplain;
		this.brokerDesc = brokerDesc;
	}
	public String getBrokerCode() {
		return brokerCode;
	}
	public void setBrokerCode(String brokerCode) {
		this.brokerCode = brokerCode;
	}
	public String getBrokerName() {
		return brokerName;
	}
	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
	public String getBrokerExplain() {
		return brokerExplain;
	}
	public void setBrokerExplain(String brokerExplain) {
		this.brokerExplain = brokerExplain;
	}
	public String getBrokerDesc() {
		return brokerDesc;
	}
	public void setBrokerDesc(String brokerDesc) {
		this.brokerDesc = brokerDesc;
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
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	@Override
	public String toString() {
		return "Broket [brokerCode=" + brokerCode + ", brokerName=" + brokerName + ", brokerExplain=" + brokerExplain
				+ ", brokerDesc=" + brokerDesc + ", page=" + page + ", rows=" + rows + ", sortName=" + sortName
				+ ", sortOrder=" + sortOrder + "]";
	}
	
}
