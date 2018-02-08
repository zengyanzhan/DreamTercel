package com.yidu.dayEnd.domain;
import java.sql.Date;
/**
 * 两费实体类
 * @author 邓涛
 * @date 2017年12月4日
 * @time 下午11:33:07
 */
public class TwoCost {
	private String  trusteeCode ;
	private String  trusteeName ;
	private String  trusteeAddres; 
	private String 	trusteeCompany; 
	private String trusteePhone ;
	private Integer  trusteeFee ;
	private String trusteeDesc; 
	private String managerCode;
	private String managerName;
	private String managerAge;
	private char managerSex;
	private String managerCompany;
	private String managerPhone;
	private Integer managerFee;
	private String managerDesc;
	private String fundCode;
	private String fundName;
	private String cashAccountCode;
	private String fundDesc;
	private Integer fundScale;
	private Double manageRate;
	private Double trusteeRate;
	private Integer initFundValue;
	private Integer fundType;
	private Integer feePeriodDay;
	private Date establishDate;
	private String cashAccountBankCard;
	private String cashAccountName;
	private String cashAccountBankName;
	private String cashAccountDesc;
	private Integer cashAccountDepositType;
	private Integer cashAccountCardRate;
	private Integer cashAccountInterestPeriod;
	private Date cashAccountStartTime;
	private Date cashAccountEndTime;
	private String netValueCode;
	private String projectName;
	private String projectCode;
	private String treeCode;
	private String treeFatherCode;
	private Integer quantity;
	private Integer price;
	private Integer costing;
	private Integer marketValue;
	private Integer valueAdd;
	private String StrstatisticDate;
	private String flag;//日期标志
	private Date statisticDate;//统计日期 来自净值统计表
	private String setDate;//基金成立日期
	private Double fundWorth;//基金成立资产净值
	private String sqlWhere;//拼接条件
	private String businessDateWhere;//日期
	public TwoCost(){}
	public TwoCost(String trusteeCode, String trusteeName, String trusteeAddres, String trusteeCompany,
			String trusteePhone, Integer trusteeFee, String trusteeDesc, String managerCode, String managerName,
			String managerAge, char managerSex, String managerCompany, String managerPhone, Integer managerFee,
			String managerDesc, String fundCode, String fundName, String cashAccountCode, String fundDesc,
			Integer fundScale, Double manageRate, Double trusteeRate, Integer initFundValue, Integer fundType,
			Integer feePeriodDay, Date establishDate, String cashAccountBankCard, String cashAccountName,
			String cashAccountBankName, String cashAccountDesc, Integer cashAccountDepositType,
			Integer cashAccountCardRate, Integer cashAccountInterestPeriod, Date cashAccountStartTime,
			Date cashAccountEndTime, String netValueCode, String projectName, String projectCode, String treeCode,
			String treeFatherCode, Integer quantity, Integer price, Integer costing, Integer marketValue,
			Integer valueAdd, String strstatisticDate, String flag, Date statisticDate, String setDate,
			Double fundWorth, String sqlWhere, String businessDateWhere) {
		super();
		this.trusteeCode = trusteeCode;
		this.trusteeName = trusteeName;
		this.trusteeAddres = trusteeAddres;
		this.trusteeCompany = trusteeCompany;
		this.trusteePhone = trusteePhone;
		this.trusteeFee = trusteeFee;
		this.trusteeDesc = trusteeDesc;
		this.managerCode = managerCode;
		this.managerName = managerName;
		this.managerAge = managerAge;
		this.managerSex = managerSex;
		this.managerCompany = managerCompany;
		this.managerPhone = managerPhone;
		this.managerFee = managerFee;
		this.managerDesc = managerDesc;
		this.fundCode = fundCode;
		this.fundName = fundName;
		this.cashAccountCode = cashAccountCode;
		this.fundDesc = fundDesc;
		this.fundScale = fundScale;
		this.manageRate = manageRate;
		this.trusteeRate = trusteeRate;
		this.initFundValue = initFundValue;
		this.fundType = fundType;
		this.feePeriodDay = feePeriodDay;
		this.establishDate = establishDate;
		this.cashAccountBankCard = cashAccountBankCard;
		this.cashAccountName = cashAccountName;
		this.cashAccountBankName = cashAccountBankName;
		this.cashAccountDesc = cashAccountDesc;
		this.cashAccountDepositType = cashAccountDepositType;
		this.cashAccountCardRate = cashAccountCardRate;
		this.cashAccountInterestPeriod = cashAccountInterestPeriod;
		this.cashAccountStartTime = cashAccountStartTime;
		this.cashAccountEndTime = cashAccountEndTime;
		this.netValueCode = netValueCode;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.treeCode = treeCode;
		this.treeFatherCode = treeFatherCode;
		this.quantity = quantity;
		this.price = price;
		this.costing = costing;
		this.marketValue = marketValue;
		this.valueAdd = valueAdd;
		StrstatisticDate = strstatisticDate;
		this.flag = flag;
		this.statisticDate = statisticDate;
		this.setDate = setDate;
		this.fundWorth = fundWorth;
		this.sqlWhere = sqlWhere;
		this.businessDateWhere = businessDateWhere;
	}


	public String getTrusteeCode() {
		return trusteeCode;
	}

	public void setTrusteeCode(String trusteeCode) {
		this.trusteeCode = trusteeCode;
	}

	public String getTrusteeName() {
		return trusteeName;
	}

	public void setTrusteeName(String trusteeName) {
		this.trusteeName = trusteeName;
	}

	public String getTrusteeAddres() {
		return trusteeAddres;
	}

	public void setTrusteeAddres(String trusteeAddres) {
		this.trusteeAddres = trusteeAddres;
	}

	public String getTrusteeCompany() {
		return trusteeCompany;
	}

	public void setTrusteeCompany(String trusteeCompany) {
		this.trusteeCompany = trusteeCompany;
	}

	public String getTrusteePhone() {
		return trusteePhone;
	}

	public void setTrusteePhone(String trusteePhone) {
		this.trusteePhone = trusteePhone;
	}

	public Integer getTrusteeFee() {
		return trusteeFee;
	}

	public void setTrusteeFee(Integer trusteeFee) {
		this.trusteeFee = trusteeFee;
	}

	public String getTrusteeDesc() {
		return trusteeDesc;
	}

	public void setTrusteeDesc(String trusteeDesc) {
		this.trusteeDesc = trusteeDesc;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerAge() {
		return managerAge;
	}

	public void setManagerAge(String managerAge) {
		this.managerAge = managerAge;
	}

	public char getManagerSex() {
		return managerSex;
	}

	public void setManagerSex(char managerSex) {
		this.managerSex = managerSex;
	}

	public String getManagerCompany() {
		return managerCompany;
	}

	public void setManagerCompany(String managerCompany) {
		this.managerCompany = managerCompany;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public Integer getManagerFee() {
		return managerFee;
	}

	public void setManagerFee(Integer managerFee) {
		this.managerFee = managerFee;
	}

	public String getManagerDesc() {
		return managerDesc;
	}

	public void setManagerDesc(String managerDesc) {
		this.managerDesc = managerDesc;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getCashAccountCode() {
		return cashAccountCode;
	}

	public void setCashAccountCode(String cashAccountCode) {
		this.cashAccountCode = cashAccountCode;
	}

	public String getFundDesc() {
		return fundDesc;
	}

	public void setFundDesc(String fundDesc) {
		this.fundDesc = fundDesc;
	}

	public Integer getFundScale() {
		return fundScale;
	}

	public void setFundScale(Integer fundScale) {
		this.fundScale = fundScale;
	}

	public Double getManageRate() {
		return manageRate;
	}

	public void setManageRate(Double manageRate) {
		this.manageRate = manageRate;
	}

	public Double getTrusteeRate() {
		return trusteeRate;
	}

	public void setTrusteeRate(Double trusteeRate) {
		this.trusteeRate = trusteeRate;
	}

	public Integer getInitFundValue() {
		return initFundValue;
	}

	public void setInitFundValue(Integer initFundValue) {
		this.initFundValue = initFundValue;
	}

	public Integer getFundType() {
		return fundType;
	}

	public void setFundType(Integer fundType) {
		this.fundType = fundType;
	}

	public Integer getFeePeriodDay() {
		return feePeriodDay;
	}

	public void setFeePeriodDay(Integer feePeriodDay) {
		this.feePeriodDay = feePeriodDay;
	}

	public Date getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	public String getCashAccountBankCard() {
		return cashAccountBankCard;
	}

	public void setCashAccountBankCard(String cashAccountBankCard) {
		this.cashAccountBankCard = cashAccountBankCard;
	}

	public String getCashAccountName() {
		return cashAccountName;
	}

	public void setCashAccountName(String cashAccountName) {
		this.cashAccountName = cashAccountName;
	}

	public String getCashAccountBankName() {
		return cashAccountBankName;
	}

	public void setCashAccountBankName(String cashAccountBankName) {
		this.cashAccountBankName = cashAccountBankName;
	}

	public String getCashAccountDesc() {
		return cashAccountDesc;
	}

	public void setCashAccountDesc(String cashAccountDesc) {
		this.cashAccountDesc = cashAccountDesc;
	}

	public Integer getCashAccountDepositType() {
		return cashAccountDepositType;
	}

	public void setCashAccountDepositType(Integer cashAccountDepositType) {
		this.cashAccountDepositType = cashAccountDepositType;
	}

	public Integer getCashAccountCardRate() {
		return cashAccountCardRate;
	}

	public void setCashAccountCardRate(Integer cashAccountCardRate) {
		this.cashAccountCardRate = cashAccountCardRate;
	}

	public Integer getCashAccountInterestPeriod() {
		return cashAccountInterestPeriod;
	}

	public void setCashAccountInterestPeriod(Integer cashAccountInterestPeriod) {
		this.cashAccountInterestPeriod = cashAccountInterestPeriod;
	}

	public Date getCashAccountStartTime() {
		return cashAccountStartTime;
	}

	public void setCashAccountStartTime(Date cashAccountStartTime) {
		this.cashAccountStartTime = cashAccountStartTime;
	}

	public Date getCashAccountEndTime() {
		return cashAccountEndTime;
	}

	public void setCashAccountEndTime(Date cashAccountEndTime) {
		this.cashAccountEndTime = cashAccountEndTime;
	}

	public String getNetValueCode() {
		return netValueCode;
	}

	public void setNetValueCode(String netValueCode) {
		this.netValueCode = netValueCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public String getTreeFatherCode() {
		return treeFatherCode;
	}

	public void setTreeFatherCode(String treeFatherCode) {
		this.treeFatherCode = treeFatherCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCosting() {
		return costing;
	}

	public void setCosting(Integer costing) {
		this.costing = costing;
	}

	public Integer getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Integer marketValue) {
		this.marketValue = marketValue;
	}

	public Integer getValueAdd() {
		return valueAdd;
	}

	public void setValueAdd(Integer valueAdd) {
		this.valueAdd = valueAdd;
	}

	public String getStrstatisticDate() {
		return StrstatisticDate;
	}

	public void setStrstatisticDate(String strstatisticDate) {
		StrstatisticDate = strstatisticDate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getStatisticDate() {
		return statisticDate;
	}

	public void setStatisticDate(Date statisticDate) {
		this.statisticDate = statisticDate;
	}

	public String getSetDate() {
		return setDate;
	}

	public void setSetDate(String setDate) {
		this.setDate = setDate;
	}

	public Double getFundWorth() {
		return fundWorth;
	}

	public void setFundWorth(Double fundWorth) {
		this.fundWorth = fundWorth;
	}
	public String getSqlWhere() {
		return sqlWhere;
	}
	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}
	public String getBusinessDateWhere() {
		return businessDateWhere;
	}
	public void setBusinessDateWhere(String businessDateWhere) {
		this.businessDateWhere = businessDateWhere;
	}
	@Override
	public String toString() {
		return "TwoCost [trusteeCode=" + trusteeCode + ", trusteeName=" + trusteeName + ", trusteeAddres="
				+ trusteeAddres + ", trusteeCompany=" + trusteeCompany + ", trusteePhone=" + trusteePhone
				+ ", trusteeFee=" + trusteeFee + ", trusteeDesc=" + trusteeDesc + ", managerCode=" + managerCode
				+ ", managerName=" + managerName + ", managerAge=" + managerAge + ", managerSex=" + managerSex
				+ ", managerCompany=" + managerCompany + ", managerPhone=" + managerPhone + ", managerFee=" + managerFee
				+ ", managerDesc=" + managerDesc + ", fundCode=" + fundCode + ", fundName=" + fundName
				+ ", cashAccountCode=" + cashAccountCode + ", fundDesc=" + fundDesc + ", fundScale=" + fundScale
				+ ", manageRate=" + manageRate + ", trusteeRate=" + trusteeRate + ", initFundValue=" + initFundValue
				+ ", fundType=" + fundType + ", feePeriodDay=" + feePeriodDay + ", establishDate=" + establishDate
				+ ", cashAccountBankCard=" + cashAccountBankCard + ", cashAccountName=" + cashAccountName
				+ ", cashAccountBankName=" + cashAccountBankName + ", cashAccountDesc=" + cashAccountDesc
				+ ", cashAccountDepositType=" + cashAccountDepositType + ", cashAccountCardRate=" + cashAccountCardRate
				+ ", cashAccountInterestPeriod=" + cashAccountInterestPeriod + ", cashAccountStartTime="
				+ cashAccountStartTime + ", cashAccountEndTime=" + cashAccountEndTime + ", netValueCode=" + netValueCode
				+ ", projectName=" + projectName + ", projectCode=" + projectCode + ", treeCode=" + treeCode
				+ ", treeFatherCode=" + treeFatherCode + ", quantity=" + quantity + ", price=" + price + ", costing="
				+ costing + ", marketValue=" + marketValue + ", valueAdd=" + valueAdd + ", StrstatisticDate="
				+ StrstatisticDate + ", flag=" + flag + ", statisticDate=" + statisticDate + ", setDate=" + setDate
				+ ", fundWorth=" + fundWorth + "]";
	}
}
