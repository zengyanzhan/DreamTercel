package com.yidu.businessData.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 存款业务的实体类
 * @author ChenJiaLong
 * @date 2017年11月13日
 * @time 上午9:11:10
 *
 */
public class SaveingBusinessdomain implements Serializable{
	
	
    private String SaveingSavingCode;//存款业务的编号
    private String FundCode;//基金信息的编号（名称）
    private String OutCashAccountCode;//流出现金账户Code（外键）
    private String InCashAccountCode;//流入现金账户Code（外键）
    private Date BusinessDate;//业务办理时间
    private Double BusinessType;//业务类型 1代表3天，2代表7天
    private Double SavingMoney;//存款的金额数目
    private Double SavingInterest;//存款业务所得的利息
    private Date SavingEndDat;//存款业务到期的时间
    private Double Flag;//到期办理标志 1到期未办理 2到期已办理
    private String Desc;//备注
    
    
    public SaveingBusinessdomain(){}

	public SaveingBusinessdomain(String saveingSavingCode, String fundCode, String outCashAccountCode,
			String inCashAccountCode, Date businessDate, Double businessType, Double savingMoney, Double savingInterest,
			Date savingEndDat, Double flag, String desc) {
		super();
		SaveingSavingCode = saveingSavingCode;
		FundCode = fundCode;
		OutCashAccountCode = outCashAccountCode;
		InCashAccountCode = inCashAccountCode;
		BusinessDate = businessDate;
		BusinessType = businessType;
		SavingMoney = savingMoney;
		SavingInterest = savingInterest;
		SavingEndDat = savingEndDat;
		Flag = flag;
		Desc = desc;
	}

	public String getSaveingSavingCode() {
		return SaveingSavingCode;
	}

	public void setSaveingSavingCode(String saveingSavingCode) {
		SaveingSavingCode = saveingSavingCode;
	}

	public String getFundCode() {
		return FundCode;
	}

	public void setFundCode(String fundCode) {
		FundCode = fundCode;
	}

	public String getOutCashAccountCode() {
		return OutCashAccountCode;
	}

	public void setOutCashAccountCode(String outCashAccountCode) {
		OutCashAccountCode = outCashAccountCode;
	}

	public String getInCashAccountCode() {
		return InCashAccountCode;
	}

	public void setInCashAccountCode(String inCashAccountCode) {
		InCashAccountCode = inCashAccountCode;
	}

	public Date getBusinessDate() {
		return BusinessDate;
	}

	public void setBusinessDate(Date businessDate) {
		BusinessDate = businessDate;
	}

	public Double getBusinessType() {
		return BusinessType;
	}

	public void setBusinessType(Double businessType) {
		BusinessType = businessType;
	}

	public Double getSavingMoney() {
		return SavingMoney;
	}

	public void setSavingMoney(Double savingMoney) {
		SavingMoney = savingMoney;
	}

	public Double getSavingInterest() {
		return SavingInterest;
	}

	public void setSavingInterest(Double savingInterest) {
		SavingInterest = savingInterest;
	}

	public Date getSavingEndDat() {
		return SavingEndDat;
	}

	public void setSavingEndDat(Date savingEndDat) {
		SavingEndDat = savingEndDat;
	}

	public Double getFlag() {
		return Flag;
	}

	public void setFlag(Double flag) {
		Flag = flag;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	@Override
	public String toString() {
		return "BankSavingEntity [SaveingSavingCode=" + SaveingSavingCode + ", FundCode=" + FundCode
				+ ", OutCashAccountCode=" + OutCashAccountCode + ", InCashAccountCode=" + InCashAccountCode
				+ ", BusinessDate=" + BusinessDate + ", BusinessType=" + BusinessType + ", SavingMoney=" + SavingMoney
				+ ", SavingInterest=" + SavingInterest + ", SavingEndDat=" + SavingEndDat + ", Flag=" + Flag + ", Desc="
				+ Desc + "]";
	}

	
    
    
}  
