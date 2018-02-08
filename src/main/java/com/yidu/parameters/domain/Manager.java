package com.yidu.parameters.domain;
/**
* @author YiWenQi 
* @version 创建时间：2017年11月20日 上午10:37:24
* 管理人的实体类
*/

public class Manager {
	private String managerCode;//管理人的ID
	private String managerName;//管理人姓名
	private String managerAge;//管理人年龄
	private String managerSex;//管理人性别
	private String managerCompany;//所在公司
	private String managerPhone;//管理人电话
	private Double managerFee;//管理费
	private String managerDesc;//管理人备注
	private Integer page;//當前頁
	private Integer rows;//當前行
	private String sortName;//排序的列
	private String sortOrder;//排序的方式
	public  Manager(){}
	
	public Manager(String managerCode, String managerName, String managerAge, String managerSex, String managerCompany,
			String managerPhone, Double managerFee, String managerDesc) {
		super();
		this.managerCode = managerCode;
		this.managerName = managerName;
		this.managerAge = managerAge;
		this.managerSex = managerSex;
		this.managerCompany = managerCompany;
		this.managerPhone = managerPhone;
		this.managerFee = managerFee;
		this.managerDesc = managerDesc;
	}

	public String getManagerCode() {
		return managerCode;
	}
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerAge() {
		return managerAge;
	}
	public void setManagerAge(String managerAge) {
		this.managerAge = managerAge;
	}
	public String getManagerSex() {
		return managerSex;
	}
	public void setManagerSex(String managerSex) {
		this.managerSex = managerSex;
	}
	public String getManagerCompany() {
		return managerCompany;
	}
	public void setManagerCompany(String managerCompany) {
		this.managerCompany = managerCompany;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public Double getManagerFee() {
		return managerFee;
	}
	public void setManagerFee(Double managerFee) {
		this.managerFee = managerFee;
	}
	public String getManagerDesc() {
		return managerDesc;
	}
	public void setManagerDesc(String managerDesc) {
		this.managerDesc = managerDesc;
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
		return "Manager [managerCode=" + managerCode + ", managerName=" + managerName + ", managerAge=" + managerAge
				+ ", managerSex=" + managerSex + ", managerCompany=" + managerCompany + ", managerPhone=" + managerPhone
				+ ", managerFee=" + managerFee + ", managerDesc=" + managerDesc + ", page=" + page + ", rows=" + rows
				+ ", sortName=" + sortName + ", sortOrder=" + sortOrder + "]";
	}
	
	
	
	
}
