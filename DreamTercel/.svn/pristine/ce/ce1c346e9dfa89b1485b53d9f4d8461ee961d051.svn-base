package com.yidu.dayEnd.domain;
import java.sql.Date;
/**
 * 债券计息实体类
 * @author 邓涛
 * @date 2017年11月26日
 * @time 下午5:44:14
 */
public class BondAccrual {
	private	String bondCode;		//债券代码 
	private String bondName;    	//债券名称	
	private	Date interestStarDate;	//计息起始日
	private	Date interestEndDate;	//计息结束日
	private	Integer bondType;		//债券类型
	private	Double couponRate;		//票面利率
	private Integer bondInterest;	//债券利息
	private	Double couponMoney;		//票面金额
	private	Integer paymentCount;	//付息次数
	private String bondDesc; 		//备注
	private String securityStockCode; //证券库存的编号
	private	String securityCode;//证券Id
	private	String fundCode;//基金信息表的主键
	private	String cashAccountCode;//现金账户Id 
	private	String securityName;//证券名称
	private Integer securityType;//证券类型
	private	Integer securityUtilCost;//单位成本
	private	Integer securityQuantity;//证券数量	
	private	Integer securityTotalMoney;//总成本
	private	Date securityStatisticsDate;//统计日期
	private String  strSecurityStatisticsDate;//字符串日期
	private	Integer securityPeriodFlag;//期初标志
	private String securityStockDesc;//备注
	private String StrStarDate;//起始日字符串日期
	private String StrEndDate;//结束日字符串日期	
	private String businessDateWhere;	//业务日期条件
	private Integer row;//每页显示的条数
	private Integer page;//当前页数
	private String sqlWhere;//拼接条件
	public BondAccrual(){}
	public BondAccrual(String bondCode, String bondName, Date interestStarDate, Date interestEndDate, Integer bondType,
			Double couponRate, Integer bondInterest, Double couponMoney, Integer paymentCount, String bondDesc,
			String securityStockCode, String securityCode, String fundCode, String cashAccountCode, String securityName,
			Integer securityType, Integer securityUtilCost, Integer securityQuantity, Integer securityTotalMoney,
			Date securityStatisticsDate, String strSecurityStatisticsDate, Integer securityPeriodFlag,
			String securityStockDesc, String strStarDate, String strEndDate, String businessDateWhere, Integer row,
			Integer page, String sqlWhere) {
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
		this.securityStockCode = securityStockCode;
		this.securityCode = securityCode;
		this.fundCode = fundCode;
		this.cashAccountCode = cashAccountCode;
		this.securityName = securityName;
		this.securityType = securityType;
		this.securityUtilCost = securityUtilCost;
		this.securityQuantity = securityQuantity;
		this.securityTotalMoney = securityTotalMoney;
		this.securityStatisticsDate = securityStatisticsDate;
		this.strSecurityStatisticsDate = strSecurityStatisticsDate;
		this.securityPeriodFlag = securityPeriodFlag;
		this.securityStockDesc = securityStockDesc;
		StrStarDate = strStarDate;
		StrEndDate = strEndDate;
		this.businessDateWhere = businessDateWhere;
		this.row = row;
		this.page = page;
		this.sqlWhere = sqlWhere;
	}


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
	public Integer getBondInterest() {
		return bondInterest;
	}
	public void setBondInterest(Integer bondInterest) {
		this.bondInterest = bondInterest;
	}
	public Double getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(Double couponMoney) {
		this.couponMoney = couponMoney;
	}
	public Integer getPaymentCount() {
		return paymentCount;
	}
	public void setPaymentCount(Integer paymentCount) {
		this.paymentCount = paymentCount;
	}
	public String getBondDesc() {
		return bondDesc;
	}
	public void setBondDesc(String bondDesc) {
		this.bondDesc = bondDesc;
	}
	public String getSecurityStockCode() {
		return securityStockCode;
	}
	public void setSecurityStockCode(String securityStockCode) {
		this.securityStockCode = securityStockCode;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getCashAccountCode() {
		return cashAccountCode;
	}
	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public Integer getSecurityType() {
		return securityType;
	}
	public void setSecurityType(Integer securityType) {
		this.securityType = securityType;
	}
	public Integer getSecurityUtilCost() {
		return securityUtilCost;
	}
	public void setSecurityUtilCost(Integer securityUtilCost) {
		this.securityUtilCost = securityUtilCost;
	}
	public Integer getSecurityQuantity() {
		return securityQuantity;
	}
	public void setSecurityQuantity(Integer securityQuantity) {
		this.securityQuantity = securityQuantity;
	}
	public Integer getSecurityTotalMoney() {
		return securityTotalMoney;
	}
	public void setSecurityTotalMoney(Integer securityTotalMoney) {
		this.securityTotalMoney = securityTotalMoney;
	}
	public Date getSecurityStatisticsDate() {
		return securityStatisticsDate;
	}
	public void setSecurityStatisticsDate(Date securityStatisticsDate) {
		this.securityStatisticsDate = securityStatisticsDate;
	}
	public Integer getSecurityPeriodFlag() {
		return securityPeriodFlag;
	}
	public void setSecurityPeriodFlag(Integer securityPeriodFlag) {
		this.securityPeriodFlag = securityPeriodFlag;
	}
	public String getSecurityStockDesc() {
		return securityStockDesc;
	}
	public void setSecurityStockDesc(String securityStockDesc) {
		this.securityStockDesc = securityStockDesc;
	}
	public String getStrStarDate() {
		return StrStarDate;
	}
	public void setStrStarDate(String strStarDate) {
		StrStarDate = strStarDate;
	}
	public String getStrEndDate() {
		return StrEndDate;
	}
	public void setStrEndDate(String strEndDate) {
		StrEndDate = strEndDate;
	}
	public String getBusinessDateWhere() {
		return businessDateWhere;
	}
	public void setBusinessDateWhere(String businessDateWhere) {
		this.businessDateWhere = businessDateWhere;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getSqlWhere() {
		return sqlWhere;
	}
	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}
	public String getStrSecurityStatisticsDate() {
		return strSecurityStatisticsDate;
	}
	public void setStrSecurityStatisticsDate(String strSecurityStatisticsDate) {
		this.strSecurityStatisticsDate = strSecurityStatisticsDate;
	}
}
