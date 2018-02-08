package com.yidu.reportManagement.domain;

import java.sql.Date;
/**
 * 股票波动
 * @author HeXiXian
 * @date   2017年12月6日
 * @time   下午4:00:19
 *
 */
public class StockFluctuate {
	private String priceDataCode;//行情数据ID
	private String securityCode;//证券ID
	private Date enteringDate;//录入日期
	private Double openingPrice;//开盘价格
	private Double closingPrice; //收盘价格
	private String Desc;//备注
	private String strEnteringDate;//日期格式
	private Integer page;//當前頁
	private Integer rows;//當前行
	private String sortName;//排序的列
	private String sortOrder;//排序的方式
	private Double pricelimit;//涨跌幅
	private String securityName;//证券名字


	private String startEnteringDate;//开始时间
	private String endEnteringDate;//结束时间
	public StockFluctuate(){}
	public StockFluctuate(String priceDataCode, String securityCode, Date enteringDate, Double openingPrice,
			Double closingPrice, String desc, String strEnteringDate, Integer page, Integer rows, String sortName,
			String sortOrder, Double pricelimit, String securityName, String startEnteringDate,
			String endEnteringDate) {
		super();
		this.priceDataCode = priceDataCode;
		this.securityCode = securityCode;
		this.enteringDate = enteringDate;
		this.openingPrice = openingPrice;
		this.closingPrice = closingPrice;
		Desc = desc;
		this.strEnteringDate = strEnteringDate;
		this.page = page;
		this.rows = rows;
		this.sortName = sortName;
		this.sortOrder = sortOrder;
		this.pricelimit = pricelimit;
		this.securityName = securityName;
		this.startEnteringDate = startEnteringDate;
		this.endEnteringDate = endEnteringDate;
	}





	public String getStartEnteringDate() {
		return startEnteringDate;
	}


	public String getSecurityName() {
		return securityName;
	}


	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}


	public void setStartEnteringDate(String startEnteringDate) {
		this.startEnteringDate = startEnteringDate;
	}


	public String getEndEnteringDate() {
		return endEnteringDate;
	}


	public void setEndEnteringDate(String endEnteringDate) {
		this.endEnteringDate = endEnteringDate;
	}


	public String getPriceDataCode() {
		return priceDataCode;
	}
	public void setPriceDataCode(String priceDataCode) {
		this.priceDataCode = priceDataCode;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public Date getEnteringDate() {
		return enteringDate;
	}
	public void setEnteringDate(Date enteringDate) {
		this.enteringDate = enteringDate;
	}
	public Double getOpeningPrice() {
		return openingPrice;
	}
	public void setOpeningPrice(Double openingPrice) {
		this.openingPrice = openingPrice;
	}
	public Double getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(Double closingPrice) {
		this.closingPrice = closingPrice;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public String getStrEnteringDate() {
		return strEnteringDate;
	}
	public void setStrEnteringDate(String strEnteringDate) {
		this.strEnteringDate = strEnteringDate;
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
	public Double getPricelimit() {
		return pricelimit;
	}
	public void setPricelimit(Double pricelimit) {
		this.pricelimit = pricelimit;
	}
	@Override
	public String toString() {
		return "StockFluctuate [priceDataCode=" + priceDataCode + ", securityCode=" + securityCode + ", enteringDate="
				+ enteringDate + ", openingPrice=" + openingPrice + ", closingPrice=" + closingPrice + ", Desc=" + Desc
				+ ", strEnteringDate=" + strEnteringDate + ", page=" + page + ", rows=" + rows + ", sortName="
				+ sortName + ", sortOrder=" + sortOrder + ", pricelimit=" + pricelimit + ", securityName="
				+ securityName + ", startEnteringDate=" + startEnteringDate + ", endEnteringDate=" + endEnteringDate
				+ "]";
	}


}