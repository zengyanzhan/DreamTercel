package com.yidu.stockControl.service.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yidu.stockControl.dao.CashArapStockDao;
import com.yidu.stockControl.domain.CashArapStock;
import com.yidu.stockControl.service.CashArapStockService;
/**
 * 现金应收应付库存逻辑层实现类
 * @author 向燕春
 * @date 2017年11月14日
 * @time 上午10:03:05
 *
 */
@Transactional
@Service
public class CashArapStockServiceImpl implements CashArapStockService {
	@Autowired
	CashArapStockDao cashArapStockDao;
	@Override
	public HashMap<String,Object> selectCashArapStocks(
			String tableName,
			String qualification,
			Integer page,
			Integer rows,
			Integer rowsTotal,
			String orderColumn, 
			String orderStyle
			) {
		//穿件一个map集合
		HashMap<String,Object> map = new HashMap<String,Object>();
		tableName="(select cas.cash_arap_stock_code as cashArapStockCode,"
				+ "cas.cash_account_code as cashAccountCode,"
				+ "f.fund_code as fundCode,f.fund_name as fundName, "
				+ "cas.business_type as businessType,"
				+ "cas.total_money as totalMoney,cas.status as status,"
				+ "cas.business_date as businessDate,"
				+ "cas.period_flag as periodFlag,"
				+ "cas.cash_arap_stock_desc as cashArapStockDesc "
				+ "from cash_arap_stock cas "
				+ "join(select * from fund )f on cas.fund_code=f.fund_code)tab "
				+ "join (select * from cash_account) ca "
				+ "on tab.cashAccountCode=ca.cash_account_code";
		map.put("tableName", tableName);
		map.put("qualification",qualification);
		map.put("page",page);
		map.put("rows", rows);
		map.put("rowsTotal",rowsTotal );
		map.put("orderColumn","tab.cashArapStockCode" );
		map.put("orderStyle","" );
		//调用查询现金应收应付库存的方法
		cashArapStockDao.selectCashArapStocks(map);
		map.get("cashArapStockList");
		return map;
	}
	@Override
	public String bufferWhere(CashArapStock cashArapStock) {
		StringBuffer buffer=new StringBuffer("");
		//判断基金代码是否为空
		if(cashArapStock.getFundCode()!=null&&!cashArapStock.getFundCode().equals("")){
			buffer=buffer.append(" and tab.fundCode ='"+cashArapStock.getFundCode()+"'");
		}
		//判断业务日期是否为空select * from cash_arap_stock where  business_date   = to_date('2017-11-10','yy-MM-dd');
		if(cashArapStock.getBusinessDateWhere()!=null&&!cashArapStock.getBusinessDateWhere().equals("")){
			buffer =buffer.append("	  and  tab.businessDate  =  to_date(' "+cashArapStock.getBusinessDateWhere()+"','yy-MM-dd')");
		}
		String flag=buffer.toString();
		return flag;	
	}
	@Override
	public int deleteCashArapStock(String cashArapStockCodes) {
		return cashArapStockDao.deleteCashArapStock(cashArapStockCodes);
	}
	@Override
	public int insertCashArapStock(CashArapStock cashArapStock) {
		// TODO Auto-generated method stub
		return cashArapStockDao.insertCashArapStock(cashArapStock);
	}
	@Override
	public int updateCashArapStock(CashArapStock cashArapStock) {
		// TODO Auto-generated method stub
		return cashArapStockDao.updateCashArapStock(cashArapStock);
	}
	@Override
	public CashArapStock selectCashArapStockById(String cashArapStockCode) {
		// TODO Auto-generated method stub
		return cashArapStockDao.selectCashArapStockById(cashArapStockCode);
	}

}
