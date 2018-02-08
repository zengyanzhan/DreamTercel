package com.yidu.businessData.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 权益数据实体类
 * @author XiaoYuJie
 * @date 2017年11月13日
 * @time 下午4:42:53
 */
public class EquityData implements Serializable{
	private String eqDataCode;//交易的单子号(主键)
	private String cashAccountCode;//账号Code 引用外键（现金账户表）
	private String securityCode;//证券表的Code 外键（证券表的Code）
	private Date eqRegisterDay;//权益登记日
	private Date eqExDay;//权益除权日
	private Integer eqShareOutBonusScale;//权益类型 1为分红，2为送股
	private Double eqSendStockScale;//比例
	private Date eqToAccountDate;//到账日期
	private String fundCode;
	private String eqDesc;//备注
	
	
	private String strDate;//权益登记日期转换
	private String streqExDayDate;
	private String streqToAccountDate;
	private int page;
	private int rows;
	private String orderColumn;//排序的列
	private String orderStyle;//排序方式
	public EquityData(){}
	



	public EquityData(String eqDataCode, String cashAccountCode, String securityCode, Date eqRegisterDay, Date eqExDay,
			Integer eqShareOutBonusScale, Double eqSendStockScale, Date eqToAccountDate, String eqDesc) {
		super();
		this.eqDataCode = eqDataCode;
		this.cashAccountCode = cashAccountCode;
		this.securityCode = securityCode;
		this.eqRegisterDay = eqRegisterDay;
		this.eqExDay = eqExDay;
		this.eqShareOutBonusScale = eqShareOutBonusScale;
		this.eqSendStockScale = eqSendStockScale;
		this.eqToAccountDate = eqToAccountDate;
		this.eqDesc = eqDesc;
	}




	public String getFundCode() {
		return fundCode;
	}




	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}




	public String getEqDataCode() {
		return eqDataCode;
	}

	public void setEqDataCode(String eqDataCode) {
		this.eqDataCode = eqDataCode;
	}


	public String getCashAccountCode() {
		return cashAccountCode;
	}

	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Date getEqRegisterDay() {
		return eqRegisterDay;
	}

	public void setEqRegisterDay(Date eqRegisterDay) {
		this.eqRegisterDay = eqRegisterDay;
	}

	public Date getEqExDay() {
		return eqExDay;
	}

	public void setEqExDay(Date eqExDay) {
		this.eqExDay = eqExDay;
	}

	public Integer getEqShareOutBonusScale() {
		return eqShareOutBonusScale;
	}

	public void setEqShareOutBonusScale(Integer eqShareOutBonusScale) {
		this.eqShareOutBonusScale = eqShareOutBonusScale;
	}

	public Double getEqSendStockScale() {
		return eqSendStockScale;
	}

	public void setEqSendStockScale(Double eqSendStockScale) {
		this.eqSendStockScale = eqSendStockScale;
	}

	public Date getEqToAccountDate() {
		return eqToAccountDate;
	}

	public void setEqToAccountDate(Date eqToAccountDate) {
		this.eqToAccountDate = eqToAccountDate;
	}

	public String getEqDesc() {
		return eqDesc;
	}

	public void setEqDesc(String eqDesc) {
		this.eqDesc = eqDesc;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
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


	public String getStrDate() {
		return strDate;
	}


	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}


	public String getStreqExDayDate() {
		return streqExDayDate;
	}


	public void setStreqExDayDate(String streqExDayDate) {
		this.streqExDayDate = streqExDayDate;
	}


	public String getStreqToAccountDate() {
		return streqToAccountDate;
	}


	public void setStreqToAccountDate(String streqToAccountDate) {
		this.streqToAccountDate = streqToAccountDate;
	}


	@Override
	public String toString() {
		return "EquityData [eqDataCode=" + eqDataCode + ", cashAccountCode=" + cashAccountCode + ", securityCode="
				+ securityCode + ", eqRegisterDay=" + eqRegisterDay + ", eqExDay=" + eqExDay + ", eqShareOutBonusScale="
				+ eqShareOutBonusScale + ", eqSendStockScale=" + eqSendStockScale + ", eqToAccountDate="
				+ eqToAccountDate + ", eqDesc=" + eqDesc + ", strDate=" + strDate + ", streqExDayDate=" + streqExDayDate
				+ ", streqToAccountDate=" + streqToAccountDate + ", page=" + page + ", rows=" + rows + ", orderColumn="
				+ orderColumn + ", orderStyle=" + orderStyle + "]";
	}

	
}
