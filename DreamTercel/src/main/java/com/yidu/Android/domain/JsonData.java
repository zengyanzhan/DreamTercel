package com.yidu.Android.domain;
/**
 * 证券市值变动表
 * @author Lee
 * @date 2017年12月14日
 * @time 上午10:46:57
 */

public class JsonData {
private String name;
private Double  money ;
private String strDate;
public JsonData(){}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getMoney() {
	return money;
}
public void setMoney(Double money) {
	this.money = money;
}
public String getStrDate() {
	return strDate;
}
public void setStrDate(String strDate) {
	this.strDate = strDate;
}
@Override
public String toString() {
	return "JsonData [name=" + name + ", money=" + money + ", strDate=" + strDate + "]";
}

}
