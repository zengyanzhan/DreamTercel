package com.yidu.system.domain;

public class RoleRight {

	private String roleCode;
	private String rightCode;
	private Integer insertFlag;
	private Integer updateFlag;
	private Integer deleteFlag;
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRightCode() {
		return rightCode;
	}
	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
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
	public RoleRight(String roleCode, String rightCode, Integer insertFlag, Integer updateFlag, Integer deleteFlag) {
		super();
		this.roleCode = roleCode;
		this.rightCode = rightCode;
		this.insertFlag = insertFlag;
		this.updateFlag = updateFlag;
		this.deleteFlag = deleteFlag;
	}
	public RoleRight(){}
	@Override
	public String toString() {
		return "RoleRight [roleCode=" + roleCode + ", rightCode=" + rightCode + ", insertFlag=" + insertFlag
				+ ", updateFlag=" + updateFlag + ", deleteFlag=" + deleteFlag + "]";
	}
	
	
	
}
