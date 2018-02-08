package com.yidu.taManagement.service;

import java.util.HashMap;

import com.yidu.stockControl.domain.TaStock;
import com.yidu.taManagement.domain.TaTradData;

public interface TaTradDataService {
	/**
	 * 查询所有ta交易数据
	 * @param tableName 表名
	 * @param qualification 条件
	 * @param page 页数
	 * @param rows 行数
	 * @param rowsTotal 总行数
	 * @param orderColumn 排序的列
	 * @param orderStyle 排序的方式
	 * @return map集合
	 */
	public HashMap<String,Object> selectTaTradData(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			String orderColumn, 
			String orderStyle
			);
	/**
	 * 条件拼接
	 * @param taTradData ta交易数据实体对象
	 * @return 拼接好的条件
	 */
	public String bufferWhere(TaTradData taTradData);
	/**
	 * 删除
	 */
	public int deleteTaTradDataByTaTradDataId(String taTradDataCode);
	/**
	 * 修改
	 * @param taTradData
	 * @return
	 */
	public int updateTaTradData(TaTradData taTradData);
	/**
	 * 增加
	 * @param taTradData
	 * @return
	 */
	public int insertTaTradData(TaTradData taTradData);
	/**
	 * 根据Id查询
	 * @param taTradDataCode
	 * @return
	 */
	public TaTradData selectTaTradDataById(String taTradDataCode);
	/**
	 * 修改ta交易结算
	 * @param TaTradDataCode
	 * @return
	 */
	public int updateStatus(TaTradData taTradData);
}
