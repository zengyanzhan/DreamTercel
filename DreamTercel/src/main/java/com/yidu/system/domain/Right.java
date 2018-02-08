package com.yidu.system.domain;

import java.io.Serializable;

/**
 * 功能表对应的实体类
 * @author ZouJianwen
 * @data  2017年11月13日
 * @time  上午8:27:35
 *
 */
@SuppressWarnings("serial")
public class Right implements Serializable{



	private  String rightCode; //功能编号
	private String rightParentCode;//父功能编号
	private String rightType;//功能类别
	private String rightText;//功能名称
	private String rightUrl;//功能对应菜单链接的路径 
	private String rightIcon;//功能图标名
	private String checkFlag;
	private Integer insertFlag;
	private Integer updateFlag;
	private Integer deleteFlag;

	private boolean checked;
	private Integer page;//当前页数
	private Integer rows;//当前行数
	private String sortName;//要排序的列
	private String sortOrder;//排序的方式
	
	public Right(){}
	
	public Right(String rightCode, String rightParentCode, String rightType, String rightText, String rightUrl,
			String rightIcon, String checkFlag, Integer insertFlag, Integer updateFlag, Integer deleteFlag,
			boolean checked, Integer page, Integer rows, String sortName, String sortOrder) {
		super();
		this.rightCode = rightCode;
		this.rightParentCode = rightParentCode;
		this.rightType = rightType;
		this.rightText = rightText;
		this.rightUrl = rightUrl;
		this.rightIcon = rightIcon;
		this.checkFlag = checkFlag;
		this.insertFlag = insertFlag;
		this.updateFlag = updateFlag;
		this.deleteFlag = deleteFlag;
		this.checked = checked;
		this.page = page;
		this.rows = rows;
		this.sortName = sortName;
		this.sortOrder = sortOrder;
	}
	public String getRightCode() {
		return rightCode;
	}
	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}
	public String getRightParentCode() {
		return rightParentCode;
	}
	public void setRightParentCode(String rightParentCode) {
		this.rightParentCode = rightParentCode;
	}
	public String getRightType() {
		return rightType;
	}
	public void setRightType(String rightType) {
		this.rightType = rightType;
	}
	public String getRightText() {
		return rightText;
	}
	public void setRightText(String rightText) {
		this.rightText = rightText;
	}
	public String getRightUrl() {
		return rightUrl;
	}
	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}
	public String getRightIcon() {
		return rightIcon;
	}
	public void setRightIcon(String rightIcon) {
		this.rightIcon = rightIcon;
	}
	public String getCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}
	public Integer getInsertFlag() {
		return insertFlag;
	}
	public void setInsertFlag(Integer insertFlag) {
		this.insertFlag = insertFlag;
	}
	public Integer getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(Integer updateFlag) {
		this.updateFlag = updateFlag;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
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
		return "Right [rightCode=" + rightCode + ", rightParentCode=" + rightParentCode + ", rightType=" + rightType
				+ ", rightText=" + rightText + ", rightUrl=" + rightUrl + ", rightIcon=" + rightIcon + ", checkFlag="
				+ checkFlag + ", insertFlag=" + insertFlag + ", updateFlag=" + updateFlag + ", deleteFlag=" + deleteFlag
				+ ", checked=" + checked + ", page=" + page + ", rows=" + rows + ", sortName=" + sortName
				+ ", sortOrder=" + sortOrder + "]";
	}

}
