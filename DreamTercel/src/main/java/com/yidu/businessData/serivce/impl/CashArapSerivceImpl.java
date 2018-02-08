package com.yidu.businessData.serivce.impl;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yidu.businessData.dao.CashArapDao;
import com.yidu.businessData.domain.CashArap;
import com.yidu.businessData.service.CashArapService;
/**
 * 现金应收应付实现类
 * @author 邓涛
 * @date 2017年11月14日
 * @time 下午3:56:53
 */
@Service
public class CashArapSerivceImpl implements CashArapService{
	@Autowired
	CashArapDao cashArapDao;
	/**
	 * 增加的方法
	 */
	@Override
	public int insertCashArap(CashArap cashArap) {
		System.err.println(cashArap);
		// TODO Auto-generated method stub
		return cashArapDao.insertCashArap(cashArap);
		
	}
	/**
	 * 删除的方法
	 */
	@Override
	public int deleteCashArap(CashArap cashArap) {
		// TODO Auto-generated method stub
		return cashArapDao.deleteCashArap(cashArap);
	}
	/**
	 * 修改的方法
	 */
	@Override
	public int updateCashArap(CashArap cashArap) {
		// TODO Auto-generated method stub
		return cashArapDao.updateCashArap(cashArap);
	}
	/**
	 * 通过code查询的方法
	 */
	@Override
	public CashArap selectCashArapById(String cashArapCode) {
		// TODO Auto-generated method stub
		return cashArapDao.selectCashArapById(cashArapCode);
	}
	/**
	 * 查询的方法
	 */
	@Override
	public Map<String, Object> selectCashArap(CashArap cashArap) {
		//得到现金应收应付的基金
		String fundCode=cashArap.getFundCode();
		//这里需要对条件进行拼接 使用缓冲字符串
		StringBuffer buffwhere=new StringBuffer("  and fund_code='"+fundCode+"'");
		//如果得到的日期不等于空 且不等于空字符串
		if(cashArap.getStrDateWhere() !=null && !cashArap.getStrDateWhere().equals("")){
			//追加
			buffwhere.append(" and business_date=  to_date(' "+cashArap.getStrDateWhere()+"','yyyy-MM-dd')");
		}
		//如果得到的类型不等于空 且不等于0
		if(cashArap.getCashArapType() != null && cashArap.getCashArapType()!=0){
			//追加
			buffwhere.append(" and cash_arap_type= "+cashArap.getCashArapType());
		}
		//创建一个map集合 
		HashMap<String, Object> map=new HashMap<String, Object>();
		//表名
		map.put("tabName", "cash_arap");
		//条件
		map.put("qualification",buffwhere.toString());
		//页
		map.put("page",cashArap.getPage());
		//行
		map.put("rows",cashArap.getRows());
		//排序的列
		map.put("orderColumn","cash_arap_code");
		//排序方式
		map.put("orderStyle",cashArap.getOrderStyle());
		//调用查询的方法
		cashArapDao.selectCashArap(map);
		return map;
	}
	/**
	 * 删除的方法
	 */
	@Override
	public int deleteSqlWhereCashArap(String cashAccountCode, Date businessDate, String fundCode,
			Integer cashArapType) {
		
		return cashArapDao.deleteSqlWhereCashArap(cashAccountCode, businessDate, fundCode, cashArapType);
	}

	
}