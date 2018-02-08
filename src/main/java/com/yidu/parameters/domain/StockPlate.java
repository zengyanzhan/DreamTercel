package com.yidu.parameters.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 股票板块信息设置实体类
 * @author 杨丽
 * @date 2017年11月16日	
 * @time 下午2:51:25
 *
 */
@SuppressWarnings("serial")
public class StockPlate implements Serializable{
	private String stockBlockCode;	//股票板块的ID
	private	 String stockBlockFatherCode;	//父板块Id引用股票板块信息表的板Id(自己引用自己的主键)
	private String stockBlockName;	//股票板块名称
	private String stockBlockDesc;	//股票板块信息备注字段
	
	
	private List<StockPlate> children;
	private String id;
	private String text;
	/**
	 * 构造方法
	 */
	public StockPlate(){}
	public StockPlate(String stockBlockCode, String stockBlockFatherCode, String stockBlockName,
			String stockBlockDesc) {
		super();
		this.stockBlockCode = stockBlockCode;
		this.stockBlockFatherCode = stockBlockFatherCode;
		this.stockBlockName = stockBlockName;
		this.stockBlockDesc = stockBlockDesc;
	}
	/**
	 * get/set方法
	 * 
	 */
	public String getStockBlockCode() {
		return stockBlockCode;
	}
	public void setStockBlockCode(String stockBlockCode) {
		this.stockBlockCode = stockBlockCode;
	}
	public String getStockBlockFatherCode() {
		return stockBlockFatherCode;
	}
	public void setStockBlockFatherCode(String stockBlockFatherCode) {
		this.stockBlockFatherCode = stockBlockFatherCode;
	}
	public String getStockBlockName() {
		return stockBlockName;
	}
	public void setStockBlockName(String stockBlockName) {
		this.stockBlockName = stockBlockName;
	}
	public String getStockBlockDesc() {
		return stockBlockDesc;
	}
	public void setStockBlockDesc(String stockBlockDesc) {
		this.stockBlockDesc = stockBlockDesc;
	}
	
		public List<StockPlate> getChildren() {
		return children;
	}
	public void setChildren(List<StockPlate> children) {
		this.children = children;
	}
	
	
		public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
		@Override
	public String toString() {
		return "StockPlate [stockBlockCode=" + stockBlockCode + ", stockBlockFatherCode=" + stockBlockFatherCode
				+ ", stockBlockName=" + stockBlockName + ", stockBlockDesc=" + stockBlockDesc + "]";
	}
		
}
