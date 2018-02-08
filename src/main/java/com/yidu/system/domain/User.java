package com.yidu.system.domain;

import java.sql.Date;

/**
 * 用户表的实体类
 * @author ZouJianwen
 * @data  2017年11月13日
 * @time  上午9:35:33
 *
 */
public class User { 
	private String userCode ;//用户ID 
	private String userName ;//用户名
	private String userPwd ;//密码
	private Date userCreateDate ;//创建日期
	private String roleCode ;//用户角色Id
	private Integer userFlag ;//用户状态 
	private String userDesc ;//备注字段
	private Integer page;//当前页数
	private Integer rows;//当前行数
	private String sortName;//要排序的列
	private String sortOrder;//排序的方式
	private String createDate;//字符串日期
	 
	 
	public User(){}
	
	public User(String userCode, String userName, String userPwd, Date userCreateDate, String roleCode,
			Integer userFlag, String userDesc, Integer page, Integer rows, String sortName, String sortOrder,
			String createDate) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userCreateDate = userCreateDate;
		this.roleCode = roleCode;
		this.userFlag = userFlag;
		this.userDesc = userDesc;
		this.page = page;
		this.rows = rows;
		this.sortName = sortName;
		this.sortOrder = sortOrder;
		this.createDate = createDate;
	}



	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Date getUserCreateDate() {
		return userCreateDate;
	}
	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public Integer getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	@Override
	public String toString() {
		return "User [userCode=" + userCode + ", userName=" + userName + ", userPwd=" + userPwd + ", userCreateDate="
				+ userCreateDate + ", roleCode=" + roleCode + ", userFlag=" + userFlag + ", userDesc=" + userDesc
				+ ", page=" + page + ", rows=" + rows + ", sortName=" + sortName + ", sortOrder=" + sortOrder
				+ ", createDate=" + createDate + "]";
	}
	
}
