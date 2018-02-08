package com.yidu.businessData.service;

import java.util.Map;

import com.yidu.businessData.domain.SaveingBusiness;

/**
 * 业务库存的操作类
 * @author ChenJiaLong
 * @date 2017年11月17日
 * @time 下午2:27:35
 *
 */
public interface SaveingBusinessService {

	/**
	 * 对存款业务表进行的增加方法
	 * @param map
	 * @return
	 */
	public Map<String, Object> selectSaveingBusiness(SaveingBusiness saveingBusiness);
	
	/**
	 * 增加一条现金库存数据
	 * @param saveingBusiness 实体类
	 * @return int i 
	 */
	public int insertSaveingBusiness(SaveingBusiness saveingBusiness);
	/**
	 * 删除一条现金库存数据
	 * @param CashStockCode   id
	 * @return int i 
	 */
	public int deleteSaveingBusiness(SaveingBusiness saveingBusiness);
	
	/**
	 * 修改现金库存数据
	 * @param saveingBusiness 
	 * @return 返回 int i 
	 */
	public int updateSaveingBusiness(SaveingBusiness saveingBusiness);
	
	/**
	 * 通过编号查询一条数据
	 * @param saveingBusiness
	 * @return
	 */
	public SaveingBusiness selectSaveingBusinessByCode(String SavingCode);
}
