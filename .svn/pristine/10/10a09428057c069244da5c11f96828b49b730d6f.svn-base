package com.yidu.parameters.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 证劵信息设置实体类
 * @author 杨丽
 * @date 2017年11月20日	
 * @time 下午2:36:08
 *
 */
@SuppressWarnings("serial")
public class Security implements Serializable{
	private String securityCode;	//证券上市唯一代码
	private String securityName;	//券商名称
	private Date publishDate;	//发行日期
	private Date delayDate;	//延迟日期
	private Integer securityType;	//1=股票  2=债券
	private Integer exchangeName;	//引用交易所品种费率表交易所名称1=上交所;2深交所 外键引用
	private String stockPlateCode;	//引用板块信息表中的板块stock_block_code,可以为空
	private String securityDesc;		//证劵信息备注
	
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式
	
	private String publishDates;	//发行日期
	private String delayDates;	//延迟日期
	
	/**
	 * 构造方法
	 */
	public Security(){}

	public Security(String securityCode, String securityName, Date publishDate, Date delayDate, Integer securityType,
			Integer exchangeName, String stockPlateCode, String securityDesc, String publishDates, String delayDates) {
		super();
		this.securityCode = securityCode;
		this.securityName = securityName;
		this.publishDate = publishDate;
		this.delayDate = delayDate;
		this.securityType = securityType;
		this.exchangeName = exchangeName;
		this.stockPlateCode = stockPlateCode;
		this.securityDesc = securityDesc;
		this.publishDates = publishDates;
		this.delayDates = delayDates;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getDelayDate() {
		return delayDate;
	}

	public void setDelayDate(Date delayDate) {
		this.delayDate = delayDate;
	}

	public Integer getSecurityType() {
		return securityType;
	}

	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}

	public Integer getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(Integer exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getStockPlateCode() {
		return stockPlateCode;
	}

	public void setStockPlateCode(String stockPlateCode) {
		this.stockPlateCode = stockPlateCode;
	}

	public String getSecurityDesc() {
		return securityDesc;
	}

	public void setSecurityDesc(String securityDesc) {
		this.securityDesc = securityDesc;
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

	public String getPublishDates() {
		return publishDates;
	}

	public void setPublishDates(String publishDates) {
		this.publishDates = publishDates;
	}

	public String getDelayDates() {
		return delayDates;
	}

	public void setDelayDates(String delayDates) {
		this.delayDates = delayDates;
	}

	@Override
	public String toString() {
		return "Security [securityCode=" + securityCode + ", securityName=" + securityName + ", publishDate="
				+ publishDate + ", delayDate=" + delayDate + ", securityType=" + securityType + ", exchangeName="
				+ exchangeName + ", stockPlateCode=" + stockPlateCode + ", securityDesc=" + securityDesc
				+ ", tableName=" + tableName + ", page=" + page + ", rows=" + rows + ", rowsTotal=" + rowsTotal
				+ ", orderColumn=" + orderColumn + ", orderStyle=" + orderStyle + ", publishDates=" + publishDates
				+ ", delayDates=" + delayDates + "]";
	}
	
	
	
}
