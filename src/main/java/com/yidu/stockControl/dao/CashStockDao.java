package com.yidu.stockControl.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.stockControl.domain.CashStock;

/**
 * 现金库存的实现类
 * @author ChenJiaLong
 * @date 2017年11月15日
 * @time 上午9:51:31
 *
 */
@Repository
public interface CashStockDao {
	/**
	 * 现金库存的查询方法
	 * @param map
	 * @return 
	 */
     public Map<String,Object> selectCashStock(Map<String, Object> map);
    	 
     /**
      * 现金库存的删除方法
      * @param CashStockCode
      * @return 
      */
     public int deleteCashStock(String CashStockCode);
     
     /**
      * 现金库存的修改方法
      * @param cashStockdomain
      * @return
      */
     public int updateCashStock(CashStock cashStockdomain);
     
     /**
      * 现金库存的新增方法
      * @param cashStockdomain
      * @return
      */
     public int insertCashStock(CashStock cashStockdomain);
     
     /**
      * 通过编号查询一条数据
      * @param cashStockdomain
      * @return
      */
     public CashStock selectOneByCode(String CashStockCode);
    	 
		
}
