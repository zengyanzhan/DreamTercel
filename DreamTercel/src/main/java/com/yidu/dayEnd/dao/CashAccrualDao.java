package com.yidu.dayEnd.dao;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yidu.dayEnd.domain.CashAccrual;
/**
 * 现金计息接口
 * @author 邓涛
 * @date 2017年11月23日
 * @time 上午10:48:34
 */
@Repository
public interface CashAccrualDao {
	/**
	 * 查询现金利息
	 * @param map 集合
	 * @return 把现金利息收入集合
	 */
	public void selectCashAccrual(HashMap<String,Object > map);
	/**
	 * 现金计息总条数
	 * @return 整型
	 */
	public int size();
	/**
	 * 通过账户id 统计日期 查询现金计息的方法
	 * @param statisticDate 日期
	 * @param cashAccountCode 账户id
	 * @return List集合
	 */
	public List<CashAccrual> selectByIdCashAccrual(@Param("businessDateWhere")String businessDateWhere,@Param("cashAccountCode")String cashAccountCode);
	
}
