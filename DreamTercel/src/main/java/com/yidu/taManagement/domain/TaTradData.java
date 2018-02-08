package com.yidu.taManagement.domain;

import java.io.Serializable;
/**
 * Ta交易数据信息的实体类
 * @author  ZhouMuJiao
 * @date2017年11月14日
 * @time下午2:15:56
 */
import java.sql.Date;
public class TaTradData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String taTradDataCode;//交易的单子号(主键)(TAJYSJ20171107001)
	private String fundCode;//基金代码（外键）
	private Double taTradQuality;//基e金的数量
	private String cashAccountCode;//账号Code
	private Double taTotalMoney;//总金额
	private Double taRealMoney;//实际交易的金额
	private Date taTradeDate;//交易的日期
	private Date settleDate;//结算的日期
	private Double taUnitMoney;//单价
	private Double fee;//费e用
	private String agencies;//代销的机构
	private Integer taRadeType;//交易的类型
	private Integer taTradeStatus;//交易的状态
	private String taTradDataDesc;//备注
	
	
	
	

	private Date statisticDateWhere;	//统计日期条件
	private String tableName;			//表名
	private Integer page;				//页数
	private Integer rows;				//行数
	private Integer rowsTotal;			//总行数
	private String orderColumn; 		//排序的列
	private String orderStyle;			//排序方式
	private Integer taRadeTypeWhere; //交易类型的条件
	private Integer taTradeStatusWhere;//状态的条件
	private String settleDateWhere;//结算的日期的条件

	private String settlesDate;	//结算的日期
	private String tradeDate;//交易日期字符串
	private String taTradeDateWhere;//交易的日期条件

	public TaTradData(){}

	/**
	 * 申购赎回导入的实体类
	 * @param taTradDataCode		主键id
	 * @param fundCode				基金代码
	 * @param taTradQuality			基金数量
	 * @param cashAccountCode		账户id
	 * @param taTotalMoney			总金额	
	 * @param taRealMoney			实际交易的金额	
	 * @param taTradeDate			交易的日期
	 * @param settleDate			结算的日期
	 * @param taUnitMoney			单价
	 * @param fee					费用
	 * @param agencies				代销的机构的Code（外键）		1建行2农行3工行
	 * @param taRadeType			你交易的类型	not null	1如认购 2如申购 3 赎回
	 * @param taTradeStatus			你交易的状态	not null	1结算 2未结算
	 * @param taTradDataDesc		备注	
	 */
	public TaTradData(String taTradDataCode, String fundCode, Double taTradQuality, String cashAccountCode,
			Double taTotalMoney, Double taRealMoney, Date taTradeDate, Date settleDate, Double taUnitMoney, Double fee,
			String agencies, Integer taRadeType, Integer taTradeStatus, String taTradDataDesc) {
		super();
		this.taTradDataCode = taTradDataCode;
		this.fundCode = fundCode;
		this.taTradQuality = taTradQuality;
		this.cashAccountCode = cashAccountCode;
		this.taTotalMoney = taTotalMoney;
		this.taRealMoney = taRealMoney;
		this.taTradeDate = taTradeDate;
		this.settleDate = settleDate;
		this.taUnitMoney = taUnitMoney;
		this.fee = fee;
		this.agencies = agencies;
		this.taRadeType = taRadeType;
		this.taTradeStatus = taTradeStatus;
		this.taTradDataDesc = taTradDataDesc;
	}


	public TaTradData(String taTradDataCode, String fundCode, Double taTradQuality, String cashAccountCode,
			Double taTotalMoney, Double taRealMoney, Date taTradeDate, Date settleDate, Double taUnitMoney, Double fee,
			String agencies, Integer taRadeType, Integer taTradeStatus, String taTradDataDesc, Date statisticDateWhere,
			String tableName, Integer page, Integer rows, Integer rowsTotal, String orderColumn, String orderStyle,
			Integer taRadeTypeWhere, Integer taTradeStatusWhere, String settleDateWhere, String settlesDate,
			String tradeDate) {
		super();
		this.taTradDataCode = taTradDataCode;
		this.fundCode = fundCode;
		this.taTradQuality = taTradQuality;
		this.cashAccountCode = cashAccountCode;
		this.taTotalMoney = taTotalMoney;
		this.taRealMoney = taRealMoney;
		this.taTradeDate = taTradeDate;
		this.settleDate = settleDate;
		this.taUnitMoney = taUnitMoney;
		this.fee = fee;
		this.agencies = agencies;
		this.taRadeType = taRadeType;
		this.taTradeStatus = taTradeStatus;
		this.taTradDataDesc = taTradDataDesc;
		this.statisticDateWhere = statisticDateWhere;
		this.tableName = tableName;
		this.page = page;
		this.rows = rows;
		this.rowsTotal = rowsTotal;
		this.orderColumn = orderColumn;
		this.orderStyle = orderStyle;
		this.taRadeTypeWhere = taRadeTypeWhere;
		this.taTradeStatusWhere = taTradeStatusWhere;
		this.settleDateWhere = settleDateWhere;
		this.settlesDate = settlesDate;
		this.tradeDate = tradeDate;
	}


	public String getTaTradDataCode() {
		return taTradDataCode;
	}


	public void setTaTradDataCode(String taTradDataCode) {
		this.taTradDataCode = taTradDataCode;
	}


	public String getFundCode() {
		return fundCode;
	}


	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}


	public Double getTaTradQuality() {
		return taTradQuality;
	}


	public void setTaTradQuality(Double taTradQuality) {
		this.taTradQuality = taTradQuality;
	}


	public String getCashAccountCode() {
		return cashAccountCode;
	}


	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
	}


	public Double getTaTotalMoney() {
		return taTotalMoney;
	}


	public void setTaTotalMoney(Double taTotalMoney) {
		this.taTotalMoney = taTotalMoney;
	}


	public Double getTaRealMoney() {
		return taRealMoney;
	}


	public void setTaRealMoney(Double taRealMoney) {
		this.taRealMoney = taRealMoney;
	}


	public Date getTaTradeDate() {
		return taTradeDate;
	}


	public void setTaTradeDate(Date taTradeDate) {
		this.taTradeDate = taTradeDate;
	}


	public Date getSettleDate() {
		return settleDate;
	}


	public void setSettleDate(Date settleDate) {
		this.settleDate = settleDate;
	}


	public Double getTaUnitMoney() {
		return taUnitMoney;
	}


	public void setTaUnitMoney(Double taUnitMoney) {
		this.taUnitMoney = taUnitMoney;
	}


	public Double getFee() {
		return fee;
	}


	public void setFee(Double fee) {
		this.fee = fee;
	}


	public String getAgencies() {
		return agencies;
	}


	public void setAgencies(String agencies) {
		this.agencies = agencies;
	}


	public Integer getTaRadeType() {
		return taRadeType;
	}


	public void setTaRadeType(Integer taRadeType) {
		this.taRadeType = taRadeType;
	}


	public Integer getTaTradeStatus() {
		return taTradeStatus;
	}


	public void setTaTradeStatus(Integer taTradeStatus) {
		this.taTradeStatus = taTradeStatus;
	}


	public String getTaTradDataDesc() {
		return taTradDataDesc;
	}


	public void setTaTradDataDesc(String taTradDataDesc) {
		this.taTradDataDesc = taTradDataDesc;
	}


	public Date getStatisticDateWhere() {
		return statisticDateWhere;
	}


	public void setStatisticDateWhere(Date statisticDateWhere) {
		this.statisticDateWhere = statisticDateWhere;
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


	public Integer getTaRadeTypeWhere() {
		return taRadeTypeWhere;
	}


	public void setTaRadeTypeWhere(Integer taRadeTypeWhere) {
		this.taRadeTypeWhere = taRadeTypeWhere;
	}


	public Integer getTaTradeStatusWhere() {
		return taTradeStatusWhere;
	}


	public void setTaTradeStatusWhere(Integer taTradeStatusWhere) {
		this.taTradeStatusWhere = taTradeStatusWhere;
	}


	public String getSettleDateWhere() {
		return settleDateWhere;
	}


	public void setSettleDateWhere(String settleDateWhere) {
		this.settleDateWhere = settleDateWhere;
	}


	public String getSettlesDate() {
		return settlesDate;
	}


	public void setSettlesDate(String settlesDate) {
		this.settlesDate = settlesDate;
	}


	public String getTradeDate() {
		return tradeDate;
	}


	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}


	public String getTaTradeDateWhere() {
		return taTradeDateWhere;
	}


	public void setTaTradeDateWhere(String taTradeDateWhere) {
		this.taTradeDateWhere = taTradeDateWhere;
	}


	@Override
	public String toString() {
		return "TaTradData [taTradDataCode=" + taTradDataCode + ", fundCode=" + fundCode + ", taTradQuality="
				+ taTradQuality + ", cashAccountCode=" + cashAccountCode + ", taTotalMoney=" + taTotalMoney
				+ ", taRealMoney=" + taRealMoney + ", taTradeDate=" + taTradeDate + ", settleDate=" + settleDate
				+ ", taUnitMoney=" + taUnitMoney + ", fee=" + fee + ", agencies=" + agencies + ", taRadeType="
				+ taRadeType + ", taTradeStatus=" + taTradeStatus + ", taTradDataDesc=" + taTradDataDesc
				+ ", statisticDateWhere=" + statisticDateWhere + ", tableName=" + tableName + ", page=" + page
				+ ", rows=" + rows + ", rowsTotal=" + rowsTotal + ", orderColumn=" + orderColumn + ", orderStyle="
				+ orderStyle + ", taRadeTypeWhere=" + taRadeTypeWhere + ", taTradeStatusWhere=" + taTradeStatusWhere
				+ ", settleDateWhere=" + settleDateWhere + ", settlesDate=" + settlesDate + ", tradeDate=" + tradeDate
				+ "]";
	}

}
