package com.yidu.dayEnd.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yidu.dayEnd.dao.CashAccrualDao;
import com.yidu.dayEnd.domain.CashAccrual;
import com.yidu.dayEnd.service.CashAccrualService;
/**
 * 现金计息实现类
 * @author 邓涛
 * @date 2017年11月23日
 * @time 上午11:31:47
 */
@Transactional
@Service
public class CashAccrualServiceImpl implements CashAccrualService{
	@Autowired
	CashAccrualDao cashAccrualDao;
	/**
	 * 查询的方法
	 */
	@Override
	public HashMap<String, Object> selectCashAccrual(CashAccrual cashAccrual) {
		//创建一个变量 用于接收拼接条件
		StringBuffer buffer=new StringBuffer("");
		//如果日期不等于空 且不等于空字符串
		if(cashAccrual.getBusinessDateWhere() != null && !cashAccrual.getBusinessDateWhere().equals("")){
			//拼接条件
			buffer.append(" and cash_statistic_date=  to_date(' "+cashAccrual.getBusinessDateWhere()+"','yy-MM-dd')");
		}
		//创建map
		HashMap<String,Object> map = new HashMap<String,Object>();
		//表名 里面放的是sql语句
		String tableName="   (select  ca.cash_account_bank_name,ca.cash_account_bank_card,cs.fund_code,ca.cash_account_code,cs.cash_blance,cs.cash_statistic_date,ca.cash_account_deposit_type,ca.cash_account_card_rate,ca.cash_account_interest_period"
						+"   from cash_account ca  join (select * from cash_stock)cs on ca.cash_account_code=cs.cash_account_code)" ;
		//表名
		map.put("tableName", tableName);
		//条件
		map.put("qualification",buffer.toString());
		//页
		map.put("page",cashAccrual.getPage());
		//行
		map.put("rows",cashAccrual.getRows());
		//总条数
		map.put("rowsTotal",cashAccrual.getRowsTotal());
		//排序的列
		map.put("orderColumn",cashAccrual.getOrderColumn());
		//排序方式
		map.put("orderStyle",cashAccrual.getOrderStyle());
		//调用查询方法 
		cashAccrualDao.selectCashAccrual(map);
		//得到游标
		map.get("cashAccrualList");
		return map;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return cashAccrualDao.size();
	}
	/**
	 * 通过id查询的方法
	 */
	@Override
	public List<CashAccrual> selectByIdCashAccrual(String businessDateWhere, String cashAccountCode) {
		// TODO Auto-generated method stub
		return cashAccrualDao.selectByIdCashAccrual(businessDateWhere, cashAccountCode);
	}

}
