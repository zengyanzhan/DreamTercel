package com.yidu.taManagement.service.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yidu.taManagement.dao.TaTradDataDao;
import com.yidu.taManagement.domain.TaTradeSettle;
import com.yidu.taManagement.service.TaTradeSettleService;
@Transactional
@Service
public class TaTradeSettleServiceImpl implements TaTradeSettleService{
	@Autowired
	TaTradDataDao taTradDataDao;
	
	@Override
	public HashMap<String, Object> selectTaTradData(String tableName, String qualification, Integer page, Integer rows,
			String orderColumn, String orderStyle) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("tableName", tableName);
		map.put("qualification",qualification);
		map.put("page",page);
		map.put("rows", rows);
		map.put("orderColumn",orderColumn);
		map.put("orderStyle",orderStyle );
		taTradDataDao.selectTaTradData(map);
		map.get("taTradDataList");
		return map;
	}

	@Override
	public String bufferWhere(TaTradeSettle taTradeSettle) {
		StringBuffer buffer=new StringBuffer("");
		//得到条件进行判断
		if (taTradeSettle.getTaRadeType()!=null&&!taTradeSettle.getTaRadeType().equals("")) {
			buffer.append("  and  ta_rade_type	 ="+taTradeSettle.getTaRadeType()+" ");
		}
		if (taTradeSettle.getTaTradeDate()!=null&&!taTradeSettle.getTaTradeDate().equals("")) {
			buffer.append("  and  ta_trade_date ="+taTradeSettle.getTaTradeDate()+" ");
		}
		System.err.println("得到的条件凭借是    ====="+buffer.toString());
		return buffer.toString();
	}


}
