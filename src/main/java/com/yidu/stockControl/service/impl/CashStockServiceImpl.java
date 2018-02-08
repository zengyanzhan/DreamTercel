package com.yidu.stockControl.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yidu.stockControl.dao.CashStockDao;
import com.yidu.stockControl.domain.CashStock;
import com.yidu.stockControl.service.CashStockService;
/**
 * 
 * @author ChenJiaLong
 * @date 2017年11月15日
 * @time 上午10:16:54
 *
 */
@Transactional
@Service
public class CashStockServiceImpl implements CashStockService{

	@Autowired
	private CashStockDao cashStockDao;
	/**
	 * 新增方法
	 */
	@Override
	public int insertCashStock(CashStock cashStockdomain) {
		// TODO Auto-generated method stub
		return cashStockDao.insertCashStock(cashStockdomain);
	}
    /**
     * 删除方法
     */
	@Override
	public int deleteCashStock(String CashStockCode) {
		// TODO Auto-generated method stub
		String[] split=CashStockCode.split(",");//截取字段“,”
		int size=0;
		for(int i=0;i<split.length;i++){
			size=cashStockDao.deleteCashStock(split[i]);//调用删除现金库存的方法
			++size;
		}
		return size;
		 
	}
	/**
     * 查询方法
     */
	@Override
	public Map<String,Object> selectCashStock(CashStock cashStockdomain) {
		StringBuffer bufferStr = new StringBuffer("");//StringBuffer 用于条件拼接
		//判断条件是否为空
		if(cashStockdomain.getCashStockCode()!= null && !cashStockdomain.getCashStockCode().equals("")){
			bufferStr.append(" and cash_stock_code='"+cashStockdomain.getCashStockCode()+"'");
		}
		else if(cashStockdomain.getStrDate()!= null && !cashStockdomain.getStrDate().equals("")){
			bufferStr.append(" and cash_statistic_date=to_date('"+cashStockdomain.getStrDate()+"','yyyy-mm-dd')");
		}
		Map<String, Object> map = new HashMap<String, Object>();//创建HashMap
		
		String tableName="(select cs.cash_stock_code as CashStockCode,"
				+ "f.fund_code as FundCode,f.fund_name as fundName"
				+ "cs.cash_blance as CashBlance,"
				+ "cs.cash_account_code as CashAccountCode,"
				+ "cs.cash_statistic_date as StatisticDate,"
				+ "cs.cash_period_flag as PeriodFlag,"
				+ "cs.cash_stock as CashDesc "
				+ "from cash_stock cs "
				+ "join(select * from fund )f on cs.fund_code=f.fund_code)tab "
				+ "join (select * from cash_account) ca "
				+ "on tab.cashAccountCode=ca.cash_account_code";
		
		map.put("tabName", "cash_stock");//表名
		map.put("qualification", bufferStr.toString());
		map.put("page", cashStockdomain.getPage());//显示的页面
		map.put("rows", cashStockdomain.getRows());//页面所显示的行数
		map.put("orderColumn", "cash_stock_code");//列字段
		map.put("orderStyle", cashStockdomain.getOrderStyle());//表格排列方式
		cashStockDao.selectCashStock(map);//调用查询现金库存的方法

		return map;//返回map到jsp	
		
		//return cashStockDao.selectCashStock(cashStockdomain);
	}
	/**
     * 修改方法
     */
	@Override
	public int updateCashStock(CashStock cashStockdomain) {
		// TODO Auto-generated method stub
		return cashStockDao.updateCashStock(cashStockdomain);
	}
	/**
	 * 通过编号查询一条数据
	 */
	@Override
	public CashStock selectOneByCode(String CashStockCode) {
		// TODO Auto-generated method stub
		return cashStockDao.selectOneByCode(CashStockCode);
	}

}
