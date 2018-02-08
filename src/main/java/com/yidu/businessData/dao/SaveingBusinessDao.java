package com.yidu.businessData.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yidu.businessData.domain.SaveingBusiness;


/**
 * 存款业务表的数据库连接类
 * @author ChenJiaLong
 * @date 2017年11月17日
 * @time 下午2:29:25
 *
 */
@Repository
public interface SaveingBusinessDao {

	/**
	 * 对存款业务表进行的增加方法
	 * @param map
	 * @return
	 */
	public Map<String, Object> selectSaveingBusiness(Map<String,Object> map);
	
	/**
     * 存款业务表的删除方法
     * @param CashStockCode
     * @return
     */
    public int deleteSaveingBusiness(SaveingBusiness saveingBusiness);
    
    /**
     * 存款业务表的修改方法
     * @param saveingBusiness
     * @return
     */
    public int updateSaveingBusiness(SaveingBusiness saveingBusiness);
    
    /**
     * 存款业务表的新增方法
     * @param saveingBusiness
     * @return
     */
    public int insertSaveingBusiness(SaveingBusiness saveingBusiness);
    
    /**
     * 通过编号查询一条数据
     * @param savingCode
     * @return
     */
    public SaveingBusiness selectSaveingBusinessByCode(String savingCode);
}
