package com.yidu.Android.domain;

import java.io.Serializable;
/**
 * 净值统计实体类
 * @author Lee
 * @date 2017年12月14日
 * @time 上午10:47:27
 */
public class NetValueEntity implements Serializable{
	private  String fundCode;//基金代码
	private  String date;//日期
	private  String netAssetValue;//资产净值
	private  String netAssetValueMoney;//资产净值金额
	private  String unitNet;//单位净值
	private  String unitNetMoney;//单位净值金额
	public NetValueEntity(){}
	public NetValueEntity(String netAssetValue, String netAssetValueMoney, String unitNet, String unitNetMoney) {
		super();
		this.netAssetValue = netAssetValue;
		this.netAssetValueMoney = netAssetValueMoney;
		this.unitNet = unitNet;
		this.unitNetMoney = unitNetMoney;
	}
	public NetValueEntity(String fundCode, String date, String netAssetValue, String netAssetValueMoney, String unitNet,
			String unitNetMoney) {
		super();
		this.fundCode = fundCode;
		this.date = date;
		this.netAssetValue = netAssetValue;
		this.netAssetValueMoney = netAssetValueMoney;
		this.unitNet = unitNet;
		this.unitNetMoney = unitNetMoney;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNetAssetValue() {
		return netAssetValue;
	}
	public void setNetAssetValue(String netAssetValue) {
		this.netAssetValue = netAssetValue;
	}
	public String getNetAssetValueMoney() {
		return netAssetValueMoney;
	}
	public void setNetAssetValueMoney(String netAssetValueMoney) {
		this.netAssetValueMoney = netAssetValueMoney;
	}
	public String getUnitNet() {
		return unitNet;
	}
	public void setUnitNet(String unitNet) {
		this.unitNet = unitNet;
	}
	public String getUnitNetMoney() {
		return unitNetMoney;
	}
	public void setUnitNetMoney(String unitNetMoney) {
		this.unitNetMoney = unitNetMoney;
	}
	@Override
	public String toString() {
		return "NetValueEntity [fundCode=" + fundCode + ", date=" + date + ", netAssetValue=" + netAssetValue
				+ ", netAssetValueMoney=" + netAssetValueMoney + ", unitNet=" + unitNet + ", unitNetMoney="
				+ unitNetMoney + "]";
	};

}
