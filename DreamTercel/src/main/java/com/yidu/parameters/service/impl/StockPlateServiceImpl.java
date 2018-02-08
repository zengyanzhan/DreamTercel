package com.yidu.parameters.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.parameters.dao.StockPlateDao;
import com.yidu.parameters.domain.StockPlate;
import com.yidu.parameters.service.StockPlateService;

/**
 * 股票信息数据库业务逻辑操作抽象接口实现类
 * @author 杨丽
 * @date 2017年11月16日	
 * @time 下午3:41:11
 */
@Transactional
@Service
public class StockPlateServiceImpl implements StockPlateService{
	@Autowired
	StockPlateDao stockPlateDao;
	
	@Override
	public String bufferWhere(StockPlate stockPlate) {
		// TODO Auto-generated method stub
		StringBuffer buffer=new StringBuffer("");
		//判断股票编号是否为空
		if(stockPlate.getStockBlockCode()!=null && !stockPlate.getStockBlockCode().equals("")){
			buffer=buffer.append(" and stock_block_code = "+stockPlate.getStockBlockCode());
		}
		//判断股票名称是否为空
		if(stockPlate.getStockBlockName()!=null && !stockPlate.getStockBlockName().equals("")){
			buffer=buffer.append(" and stock_block_name = "+stockPlate.getStockBlockName());
		}
		String flag=buffer.toString();
		return flag;
	}

	@Override
	public List<StockPlate> selectStockPlates(StockPlate stockPlate) {
		// TODO Auto-generated method stub
		//调用查询股票板块的方法 加入集合
		List<StockPlate> stockPlates=stockPlateDao.selectStockPlates(stockPlate);
		return stockPlates;
	}

	@Override
	public List<StockPlate> selectStockPlatesById(String stockBlockFatherCode) {
		// TODO Auto-generated method stub
		//调用通过父id查询股票板块的方法 加入集合
		List<StockPlate> stockPlates=stockPlateDao.selectStockPlatesById(stockBlockFatherCode);
		return stockPlates;
	}

	@Override
	public String autoId(String stockBlockCode) {
		//调用自动生成id的方法
		String id=stockPlateDao.autoId(stockBlockCode);
		//判断id是否为空
		if(id==null || id.equals("")){
			return stockBlockCode+"01";
		}
		//id长度
		String strId=id.substring(1, id.length());
		int intId=Integer.parseInt(strId);
		intId=intId+1;
		id=intId+"";
		//判断id长度
		if(id.length()==3){
			id="P0"+id;
		}else{
			if(id.length()==1){
				id="P0"+id;
			}else{
				id="P"+id;
			}
		}
		return id;
	}

	@Override
	public int insertStockPlate(StockPlate stockPlate) {
		// TODO Auto-generated method stub
		//调用股票板块增加的方法
		int size=stockPlateDao.insertStockPlate(stockPlate);
		return size;
	}

	@Override
	public void deleteStockPlateByIds(String stockBlockCode) {
		// TODO Auto-generated method stub
		//调用股票板块删除的方法
		stockPlateDao.deleteStockPlateByIds(stockBlockCode);
	}

	@Override
	public StockPlate updateStockPlateByIds(String stockBlockCodeId) {
		// TODO Auto-generated method stubs
		//调用通过id修改股票板块的方法
		StockPlate stockPlate = stockPlateDao.updateStockPlateByIds(stockBlockCodeId);
		return stockPlate;
	}
	@Override
	public void updateStockPlate(StockPlate stockPlate){
		//调用修改股票板块的方法
		stockPlateDao.updateStockPlate(stockPlate);
	}

	@Override
	public void deleteStockBlockFatherCodes(String stockBlockFatherCode) {
		// TODO Auto-generated method stub
		//调用通过股票板块id删除的方法
		stockPlateDao.deleteStockBlockFatherCodes(stockBlockFatherCode);
	}

}
