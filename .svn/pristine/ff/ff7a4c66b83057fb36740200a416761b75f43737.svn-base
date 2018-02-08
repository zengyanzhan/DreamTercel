package com.yidu.transactionProcessing.service;

import java.util.List;
import java.util.Map;

import com.yidu.parameters.domain.CashAccount;
import com.yidu.parameters.domain.Manager;
import com.yidu.parameters.domain.Seat;
import com.yidu.system.domain.User;
import com.yidu.transactionProcessing.domain.DealData;
import com.yidu.transactionProcessing.domain.Interests;

/**
 * 交易数据业务处理层
 * @author Wang
 * @date 2017年11月18日
 * @time 上午10:27:09
 */
public interface DealDataService {
	/**
	 * 查询交易数据
	 * @param dealData 交易数据实体对象
	 * @return 交易数据和总条数map
	 */
	public Map<String,Object> selectDealData(DealData dealData,String fundCode);
	/**
	 * 添加交易数据
	 * @param dealData 交易数据实体对象
	 * @return 受影响行数
	 */
	public int insertDealData(DealData dealData);
	/**
	 * 修改交易数据
	 * @param dealData 交易数据实体对象
	 * @return 受影响行数
	 */
	public int updateDealData(DealData dealData);
	/**
	 * 删除交易数据
	 * @param dealData 交易数据实体对象
	 * @return 受影响行数
	 */
	public int deleteDealData(DealData dealData);
	/**
	 * 通过交易数据编号查询交易数据
	 * @param dealDataCode 交易数据编号
	 * @return 交易数据实体集合
	 */
	public List<DealData> selectDealDataById(String dealDataCode);
	/**
	 * 通过券商编号查询交易席位信息
	 * @param borketCode 券商编号
	 * @return 交易席位信息
	 */
	public List<Seat> selectSeatByBorketCode(String borketCode);
	/**
	 * 查询现金账户表下拉列表
	 * @return 现金账户对象集合
	 */
	public List<CashAccount> selectCashAccountSel();
	/**
	 * 查询管理人信息 
	 * @return  管理人信息对象集合
	 */
	public List<User> selectMaragerSel();
	/**
	 * 查询交易结算的数据信息
	 * @param dealData 交易数据
	 * @param fundCode 基金代码
	 * @return 未结算的数据信息
	 */
	public Map<String, Object>selectTradeSettle(DealData dealData);
	/**
	 * 交易数据结算
	 * @param dealData 交易数据
	 * @return 是否结算成功
	 */
	public int insertTradeNotSettle(DealData dealData);
	/**
	 * 交易数据反结算
	 * @param dealData 交易数据
	 * @return 是否结算成功
	 */
	public int insertTradeAlreadySettle(DealData dealData);
	/**
	 * 获得交易单子号
	 * @param dealData 交易数据实体对象
	 * @return 交易数据实体集合
	 */
	public List<DealData> selectDealDataCode(Interests interests);
	/**
	 * 上海过户库接口导入
	 * @param fileName 文件路径
	 * @param fundCode 基金编号
	 * @param userName 用户名称
	 * @return 是否增加成功
	 */
	public int imputShangHaiGuoHu(String fileName,String fundCode,String userName);
	/**
	 * 计算债券利息
	 * @param dealData 交易数据实体对象
	 * @return 债券利息
	 * @throws Exception 
	 */
	public Double computeSecurityFnterest(DealData dealData)  throws Exception;
}
