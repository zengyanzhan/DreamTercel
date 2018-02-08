package com.yidu.parameters.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yidu.parameters.domain.StockPlate;

/**
 * 股票信息数据库操作抽象类
 * @author 杨丽
 * @date 2017年11月16日	
 * @time 下午3:02:27
 *
 */
@Repository
public interface StockPlateDao {
	/**
	 * 查询父功能
	 * @return	返回list集合
	 */
	public List<StockPlate> selectStockPlates(StockPlate stockPlate);
 	/**
 	 * 条件拼接
 	 * @param stockPlate	股票信息对象
 	 * @return	拼接好的条件
 	 */
	public String bufferWhere(StockPlate stockPlate);
	/**
	 * 通过父功能编号去查找子模块
	 * @param stockBlockFatherCode	父功能id
	 * @return	list集合
	 */
	public List<StockPlate> selectStockPlatesById(String stockBlockFatherCode);
	/**
	 * 自动生成编号
	 * @param stockBlockCode 父功能Id
	 * @return
	 */
	public String autoId(@Param("stockBlockCode")String stockBlockCode);
	/**
	 * 增加的方法
	 * @param stockPlate	股票板块信息对象
	 * @return	返回1 增加成功	返回0 增加失败
	 */
	public int insertStockPlate(StockPlate stockPlate);
	/**
	 * 删除子功能的方法
	 * @param stockBlockCode	股票板块id
	 */
	public void deleteStockPlateByIds(String stockBlockCode);
	/**
	 * 删除父功能内子功能的方法
	 * @param stockBlockFatherCode	父板块编号
	 */
	public void deleteStockBlockFatherCodes(String stockBlockFatherCode);
	/**
	 * 修改的方法
	 * @param stockPlate	股票信息对象
	 */
	public StockPlate updateStockPlateByIds(@Param("stockBlockCodeId")String  stockBlockCodeId);
	/**
	 * 修改的方法
	 * @param stockPlate	股票板块信息对象
	 */
	public void updateStockPlate(StockPlate stockPlate);
}
