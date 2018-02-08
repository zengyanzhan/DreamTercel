package com.yidu.stockControl.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yidu.stockControl.dao.TaStockDao;
import com.yidu.stockControl.domain.TaStock;
import com.yidu.stockControl.service.TaStockService;
/**
 * TA库存Service的实现类
 * @author  ZhouMuJiao
 * @date2017年11月27日
 * @time上午8:38:14
 */
@Transactional
@Service
public class TaStockServiceImpl implements TaStockService {
	@Autowired
	TaStockDao taStockDao;
	@Override
	public HashMap<String,Object> selectTaStocks(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle
			) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("tableName", tableName);
		map.put("qualification",qualification);
		map.put("page",page);
		map.put("rows", rows);
		map.put("rowsTotal",rowsTotal );
		map.put("orderColumn","ta_stock_code" );
		map.put("orderStyle",orderStyle );
		taStockDao.selectTaStocks(map);
		map.get("taStockList");
		return map;
	}
	@Override
	public String bufferWhere(TaStock taStock) {
		StringBuffer buffer=new StringBuffer("");
		//判断funcode是否为空
		if(taStock.getFundCode()!=null&&!taStock.getFundCode().equals("")){
			buffer =buffer.append("	  and  fund_code   =   "+taStock.getFundCode());
		}
		if(taStock.getStatisticDateWhere()!=null&&!taStock.getStatisticDateWhere().equals("")){
			buffer=buffer.append(" and statistic_date =to_date(' "+taStock.getStatisticDateWhere()+"','yyyy-mm-dd')");
		}
		String flag=buffer.toString();
		return flag;	
	}
	/**
	 * 删除
	 */
	@Override
	public int deleteTaStockByTaStockId(String taStockCode) {
		String[] split = taStockCode.split(",");
		int size=0;
		for (int i = 0; i < split.length; i++) {
			size=taStockDao.deleteTaStockByTaStockId(split[i]);
			++size;
		}
		return size;
	}
	/**
	 * 修改
	 */
	@Override
	public int updateTaStock(TaStock taStock) {
		
		// TODO Auto-generated method stub
		if(taStock.getStatisticDate()!=null&&!taStock.getStatisticDate().equals("")){
			//buffer=buffer.append(" and statistic_date =to_date(' "+taStock.getStatisticDate()+"','yyyy-mm-dd')");
		}
		return taStockDao.updateTaStock(taStock);
	}
	/**
	 * 增加
	 */
	@Override
	public int insertTaStock(TaStock taStock) {
		
		return taStockDao.insertTaStock(taStock);
	}
	/**
	 * 根据ID查询
	 */
	@Override
	public TaStock selectTaStockById(String taStockCode) {
		// TODO Auto-generated method stub
		return taStockDao.selectTaStockById(taStockCode);
	}

}
