package com.yidu.system.domain;

import java.sql.Date;
/**
 * 日志实体类
 * @author HeXiXian
 * @date   2017年11月22日
 * @time   下午2:53:02
 *
 */
public class LogManage {
	private String dailyCode;//日志编号
	private String userCode;//操作的编号
	private String dailyTable;//操作的表名
	private String dailyType;//操作的类型
	private String   dailyDate;//操作的时间
	private String dailyIp;//用户名
	private String rightDesc;//备注字段
	private  Integer page;//当前的页数
	private  Integer rows;//当前的行数
	private  String  sortName;//要排序的列
	private  String  sortOrder;//排序的方式
	private  String  createDate;//字符串日期
	
	public LogManage(){}

	public LogManage(String dailyCode, String userCode, String dailyTable, String dailyType, String dailyDate,
			String dailyIp, String rightDesc, Integer page, Integer rows, String sortName, String sortOrder,
			String createDate) {
		super();
		this.dailyCode = dailyCode;
		this.userCode = userCode;
		this.dailyTable = dailyTable;
		this.dailyType = dailyType;
		this.dailyDate = dailyDate;
		this.dailyIp = dailyIp;
		this.rightDesc = rightDesc;
		this.page = page;
		this.rows = rows;
		this.sortName = sortName;
		this.sortOrder = sortOrder;
		this.createDate = createDate;
	}

	public String getDailyCode() {
		return dailyCode;
	}

	public void setDailyCode(String dailyCode) {
		this.dailyCode = dailyCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getDailyTable() {
		return dailyTable;
	}

	public void setDailyTable(String dailyTable) {
		this.dailyTable = dailyTable;
	}

	public String getDailyType() {
		return dailyType;
	}

	public void setDailyType(String dailyType) {
		this.dailyType = dailyType;
	}

	public String getDailyDate() {
		return dailyDate;
	}

	public void setDailyDate(String dailyDate) {
		this.dailyDate = dailyDate;
	}

	public String getDailyIp() {
		return dailyIp;
	}

	public void setDailyIp(String dailyIp) {
		this.dailyIp = dailyIp;
	}

	public String getRightDesc() {
		return rightDesc;
	}

	public void setRightDesc(String rightDesc) {
		this.rightDesc = rightDesc;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "LogManage [dailyCode=" + dailyCode + ", userCode=" + userCode + ", dailyTable=" + dailyTable
				+ ", dailyType=" + dailyType + ", dailyDate=" + dailyDate + ", dailyIp=" + dailyIp + ", rightDesc="
				+ rightDesc + ", page=" + page + ", rows=" + rows + ", sortName=" + sortName + ", sortOrder="
				+ sortOrder + ", createDate=" + createDate + "]";
	}

}
