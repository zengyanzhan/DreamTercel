package com.yidu.taManagement.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.taManagement.dao.TaTradDataDao;
import com.yidu.taManagement.domain.TaTradData;
import com.yidu.taManagement.service.TaTradDataService;
@Transactional
@Service
public class TaTradDataServiceImpl implements TaTradDataService{
	@Autowired
	TaTradDataDao taTradDataDao;
	@Override
	public HashMap<String, Object> selectTaTradData(
			String tableName,
			String qualification, 
			Integer page,
			Integer rows,
			String orderColumn, 
			String orderStyle
			) {
		//分页查询条件map
		HashMap<String,Object> map = new HashMap<String,Object>();
		//分页条件查询的条件
		map.put("tableName", tableName);
		map.put("qualification",qualification);
		map.put("page",page);
		map.put("rows", rows);
		map.put("orderColumn","");
		map.put("orderStyle","" );
		//执行查询方法
		taTradDataDao.selectTaTradData(map);
		map.get("taTradDataList");
		System.err.println("service的map"+map);
		return map;
	}

	@Override
	public String bufferWhere(TaTradData taTradData) {
		StringBuffer buffer=new StringBuffer("");
		//判断funcode是否为空
		if(taTradData.getTaRadeTypeWhere()!=null&&!taTradData.getTaRadeTypeWhere().equals("")){
			buffer =buffer.append("	   and  ta_rade_type   =   "+taTradData.getTaRadeTypeWhere());
		}
		if(taTradData.getTaTradeStatusWhere()!=null&&!taTradData.getTaTradeStatusWhere().equals("")){
			buffer=buffer.append("   and ta_trade_status ="+taTradData.getTaTradeStatusWhere()+" ");
		}
		if(taTradData.getSettleDateWhere()!=null&&!taTradData.getSettleDateWhere().equals("")){
			buffer=buffer.append("   and   settle_date =to_date(' "+taTradData.getSettleDateWhere()+"','yyyy-mm-dd')");
		}
		if (taTradData.getTaTradeStatus()!=null&&!taTradData.getTaTradeStatus().equals("")) {
			buffer=buffer.append("    and   ta_trade_status	   =  "+taTradData.getTaTradeStatus()+"");

		}
		if(taTradData.getTaTradeDateWhere()!=null&&!taTradData.getTaTradeDateWhere().equals("")){
			buffer=buffer.append("   and   ta_trade_date	 = to_date(' "+taTradData.getTaTradeDateWhere()+"','yyyy-mm-dd')");
		}
		/*if(taTradData.getFundCode()!=null&&!taTradData.getFundCode().equals("")){
			buffer=buffer.append("    and   f.fund_code	   = '"+taTradData.getFundCode()+"'");
		}*/

		String flag=buffer.toString();
		System.err.println("flag="+flag);
		return flag;	
	}
	/**
	 * 删除
	 */
	@Override
	public int deleteTaTradDataByTaTradDataId(String taTradDataCode) {
		String[] split=taTradDataCode.split(",");
		int size=0;
		for(int i=0;i<split.length;i++){
			//调用删除的方法
			size=taTradDataDao.deleteTaTradDataByTaTradDataId(split[i]);
			++size;
		}
		return size;
	}
	/**
	 * 修改
	 * 
	 */
	@Override
	public int updateTaTradData(TaTradData taTradData) {
		return taTradDataDao.updateTaTradData(taTradData);
	}
	/**
	 * 增加
	 */
	@Override
	public int insertTaTradData(TaTradData taTradData) {
		// TODO Auto-generated method stub
		return taTradDataDao.insertTaTradData(taTradData);
	}

	/**
	 * 根据Id查询
	 */
	public TaTradData selectTaTradDataById(String taTradDataCode) {
		// TODO Auto-generated method stub
		return taTradDataDao.selectTaTradDataById(taTradDataCode);
	}
	/**
	 * 修改Ta交易结算
	 */
	@Override
	public int updateStatus(TaTradData taTradData) {
		// TODO Auto-generated method stub
		return taTradDataDao.updateStatus(taTradData);
	}

}
