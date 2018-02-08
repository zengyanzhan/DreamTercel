package com.yidu.parameters.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 债劵信息设置实体类
 * @author 杨丽
 * @date 2017年11月13日	
 * @time 下午2:49:03
 *
 *
 */
@SuppressWarnings("serial")
public class Bond implements Serializable{
	private String bondCode;		//债券的代码 唯一id
	private String bondName;		//债券名称
	private Date interestStarDate;		//计息起始日 
	private Date interestEndDate;		//计息结束日	结束日期
	private Integer bondType;			//债券的类型   银行间为1 , 非银行间 为2
	private Double couponRate;		//票面利率   年利率计算
	private Double bondInterest;		//债券利息 一般为%
	private Double couponMoney;	//票面金额  一开始为100，一般可增可减
	private Double paymentCount;		//付息次数 1为一年一次，2为一年两次
	private String bondDesc;			//备用字段
	
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式
	
	private String strInterestStarDate;//格式起始日期
	private String strInterestEndDate;//格式结束日期
	/**
	 * 构造方法
	 */
	public Bond(){}
	public Bond(String bondCode, String bondName, Date interestStarDate, Date interestEndDate, Integer bondType,
			Double couponRate, Double bondInterest, Double couponMoney, Double paymentCount, String bondDesc) {
		super();
		this.bondCode = bondCode;
		this.bondName = bondName;
		this.interestStarDate = interestStarDate;
		this.interestEndDate = interestEndDate;
		this.bondType = bondType;
		this.couponRate = couponRate;
		this.bondInterest = bondInterest;
		this.couponMoney = couponMoney;
		this.paymentCount = paymentCount;
		this.bondDesc = bondDesc;
	}
	
	/**
	 * get/set方法
	 */
	public String getBondCode() {
		return bondCode;
	}
	public void setBondCode(String bondCode) {
		this.bondCode = bondCode;
	}
	public String getBondName() {
		return bondName;
	}
	public void setBondName(String bondName) {
		this.bondName = bondName;
	}
	public Date getInterestStarDate() {
		return interestStarDate;
	}
	public void setInterestStarDate(Date interestStarDate) {
		this.interestStarDate = interestStarDate;
	}
	public Date getInterestEndDate() {
		return interestEndDate;
	}
	public void setInterestEndDate(Date interestEndDate) {
		this.interestEndDate = interestEndDate;
	}
	public Integer getBondType() {
		return bondType;
	}
	public void setBondType(Integer bondType) {
		this.bondType = bondType;
	}
	public Double getCouponRate() {
		return couponRate;
	}
	public void setCouponRate(Double couponRate) {
		this.couponRate = couponRate;
	}
	public Double getBondInterest() {
		return bondInterest;
	}
	public void setBondInterest(Double bondInterest) {
		this.bondInterest = bondInterest;
	}
	public Double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(Double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public Double getPaymentCount() {
		return paymentCount;
	}
	public void setPaymentCount(Double paymentCount) {
		this.paymentCount = paymentCount;
	}
	public String getBondDesc() {
		return bondDesc;
	}
	public void setBondDesc(String bondDesc) {
		this.bondDesc = bondDesc;
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
	
	public String getStrInterestStarDate() {
		return strInterestStarDate;
	}
	public void setStrInterestStarDate(String strInterestStarDate) {
		this.strInterestStarDate = strInterestStarDate;
	}
	public String getStrInterestEndDate() {
		return strInterestEndDate;
	}
	public void setStrInterestEndDate(String strInterestEndDate) {
		this.strInterestEndDate = strInterestEndDate;
	}
	@Override
	public String toString() {
		return "Bond [bondCode=" + bondCode + ", bondName=" + bondName + ", interestStarDate=" + interestStarDate
				+ ", interestEndDate=" + interestEndDate + ", bondType=" + bondType + ", couponRate=" + couponRate
				+ ", bondInterest=" + bondInterest + ", couponMoney=" + couponMoney + ", paymentCount=" + paymentCount
				+ ", bondDesc=" + bondDesc + ", tableName=" + tableName + ", page=" + page + ", rows=" + rows
				+ ", rowsTotal=" + rowsTotal + ", orderColumn=" + orderColumn + ", orderStyle=" + orderStyle
				+ ", strInterestStarDate=" + strInterestStarDate + ", strInterestEndDate=" + strInterestEndDate + "]";
	}
	
}
