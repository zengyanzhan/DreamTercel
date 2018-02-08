package com.yidu.businessData.domain;
import java.io.Serializable;
import java.sql.Date;
/**
 * 现金应收应付实体类
 * @author 邓涛
 * @date 2017年11月14日
 * @time 下午3:56:35
 */
public class CashArap implements Serializable{
	private String cashArapCode;//现金应收应付编号
	private String cashAccountCode;//银行卡号
	private String fundCode;//基金编号
	private Integer cashArapType;//证券应收应付业务类型
	private Integer moneyDirection;//资金流向
	private Double money;//金额
	private Date  businessDate;//业务日期
	private String cashArapDesc;//备注
	private Integer page;//当前显示的页数
	private Integer rows;//当前显示的行数
	private String orderColumn;//排序的列
	private String orderStyle;//排序方式
	private String strDate;//字符串日期
	
	private String strDateWhere;//日期条件
	/**
	 * 空的构造方法
	 */
	public CashArap(){
		
	}
	/**
	 * 带参数的构造方法
	 * @param cashArapCode 现金应收应付编号
	 * @param cashAccountCode 银行卡号
	 * @param fundCode 基金编号
	 * @param cashArapType 证券应收应付业务类型
	 * @param moneyDirection 资金流向
	 * @param money 金额
	 * @param businessDate 业务日期
	 * @param cashArapDesc 备注
	 */
	 
	public String getCashArapCode() {
		return cashArapCode;
	}
	public CashArap(String cashArapCode, String cashAccountCode, String fundCode, Integer cashArapType,
			Integer moneyDirection, Double money, Date businessDate, String cashArapDesc) {
		super();
		this.cashArapCode = cashArapCode;
		this.cashAccountCode = cashAccountCode;
		this.fundCode = fundCode;
		this.cashArapType = cashArapType;
		this.moneyDirection = moneyDirection;
		this.money = money;
		this.businessDate = businessDate;
		this.cashArapDesc = cashArapDesc;
	}
	public CashArap(String cashArapCode, String cashAccountCode, String fundCode, Integer cashArapType,
			Integer moneyDirection, Double money, Date businessDate, String cashArapDesc, Integer page, Integer rows,
			String orderColumn, String orderStyle, String strDate) {
		super();
		this.cashArapCode = cashArapCode;
		this.cashAccountCode = cashAccountCode;
		this.fundCode = fundCode;
		this.cashArapType = cashArapType;
		this.moneyDirection = moneyDirection;
		this.money = money;
		this.businessDate = businessDate;
		this.cashArapDesc = cashArapDesc;
		this.page = page;
		this.rows = rows;
		this.orderColumn = orderColumn;
		this.orderStyle = orderStyle;
		this.strDate = strDate;
	}
	public void setCashArapCode(String cashArapCode) {
		this.cashArapCode = cashArapCode;
	}
	public String getCashAccountCode() {
		return cashAccountCode;
	}
	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public Integer getCashArapType() {
		return cashArapType;
	}
	public void setCashArapType(Integer cashArapType) {
		this.cashArapType = cashArapType;
	}
	public Integer getMoneyDirection() {
		return moneyDirection;
	}
	public void setMoneyDirection(Integer moneyDirection) {
		this.moneyDirection = moneyDirection;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Date getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}
	public String getCashArapDesc() {
		return cashArapDesc;
	}
	public void setCashArapDesc(String cashArapDesc) {
		this.cashArapDesc = cashArapDesc;
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
	
	public String getStrDateWhere() {
		return strDateWhere;
	}
	public void setStrDateWhere(String strDateWhere) {
		this.strDateWhere = strDateWhere;
	}
	@Override
	public String toString() {
		return "CashArap [cashArapCode=" + cashArapCode + ", cashAccountCode=" + cashAccountCode + ", fundCode="
				+ fundCode + ", cashArapType=" + cashArapType + ", moneyDirection=" + moneyDirection + ", money="
				+ money + ", businessDate=" + businessDate + ", cashArapDesc=" + cashArapDesc + ", page=" + page
				+ ", rows=" + rows + ", orderColumn=" + orderColumn + ", orderStyle=" + orderStyle + ", strDate="
				+ strDate + "]";
	}
	 
}
