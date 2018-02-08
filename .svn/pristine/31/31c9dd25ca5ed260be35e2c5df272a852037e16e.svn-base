package com.yidu.dayEnd.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yidu.businessData.domain.CashArap;
import com.yidu.businessData.domain.PriceData;
import com.yidu.businessData.domain.SecurityArap;
import com.yidu.dayEnd.dao.AssetValuationDao;
import com.yidu.dayEnd.service.AssetValuationService;
import com.yidu.parameters.domain.CashAccount;
import com.yidu.stockControl.domain.CashArapStock;
import com.yidu.stockControl.domain.SecurityArapStock;
import com.yidu.stockControl.domain.SecurityStock;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.taManagement.domain.TaTradData;
import com.yidu.transactionProcessing.domain.DealData;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;


/**
 * 资产估值Service实现类
 * @author Lee
 * @date 2017年11月14日
 * @time 上午9:41:57
 */

@Service("assetValuationService")
public class AssetValuationServiceImpl implements AssetValuationService{
	@Autowired
	AssetValuationDao assetValuationDao;
	@Autowired
	AutoBianService autoBianService;
	@Override
	/**
	 * 估值增值
	 * @param guZhiDate 日期
	 * @param fundId 基金代码id
	 */
	public String appraisement(String guZhiDate, String fundCode) {
		String flagGuZhi="guZhi";
		//证券应收应付
		SecurityArap securityArap=new SecurityArap();
		//成本
		double cost=0;
		//金额
		double money=0;
		//证券库存list
		List securities=null;
		//证券行情
		List<PriceData> quotation = null ;
		//证券为零
		int ZQ=0;
		//定一个字符串
		String strWhere="";
		//条件拼接
		//判断基金代码id不等于空 且 基金代码id为字符串
		if(fundCode!=null && !fundCode.equals(""))
		{
			strWhere +=" and fund_code like'%"+ fundCode +"%'";
		}
		Map hashmap=new HashMap<>();
		hashmap.put("funCode", fundCode);
		hashmap.put("businessDate", guZhiDate);
		//先删除证券应收应付库存里的估值增值类型的数据
		this.assetValuationDao.deleteSecurityStockByFunCode(hashmap);
		//再删除证券应收应付数据里的估值增值类型的数据
		int i=this.assetValuationDao.deleteSecurityArapData(hashmap);
		//证券应收应付库存实体
		SecurityArapStock securityArapStock=new SecurityArapStock();
		//查询证券库存
		Map<Object, Object> selectmap=new HashMap<>();
		selectmap.put("fundCode", fundCode);
		selectmap.put("securityStatisticsDate", guZhiDate);
		List<SecurityStock> securityList=this.assetValuationDao.selectSecurityStockKuCun(selectmap);
		//判断有没有证券数据
		System.err.println("securityList============"+securityList.size());
		if(securityList.size()==0){
			flagGuZhi="证券库存没有数据";
		}//判断证券库存集合大于零
		
		else if(securityList.size()>0){
			//循环证券库存集合
			double guZhiValue=0;
			for(ZQ=0;ZQ<securityList.size();ZQ++){
				SecurityStock securityStock=(SecurityStock) securityList.get(ZQ);
				//判断市代码不为空
				if(securityStock.getSecurityCode()==null || "".equals(securityStock.getSecurityCode())){
					flagGuZhi="没有证券代码信息";
				}
				//节假日集合
				List<HoildayXiao> holiList=null;
				//节假日查询集合
				holiList=this.assetValuationDao.selectHolidayList(guZhiDate);
				//节假日不为空 大小不等于零
				if(holiList!=null && holiList.size()!=0){
					//如果是节假日则查询最近一天的数据
					//得到节假日前一天日期
					String beforeDate=null;
					Date	sqlBeforeDate=null;
					try {
						sqlBeforeDate = AllUtil.getDate(guZhiDate,-1);
						beforeDate =AllUtil.getStringDate(sqlBeforeDate);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					boolean holidayFlag=true;

					while (holidayFlag) {
						//再次查询
						holiList=this.assetValuationDao.selectHolidayList(beforeDate);
						if(holiList.size()==0){
							holidayFlag=false;
							break;//跳出
						}else{
							//再次节假日前一天日期
							try {
								sqlBeforeDate=AllUtil.getDate(beforeDate,-1);
								beforeDate =AllUtil.getStringDate(sqlBeforeDate);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

					HashMap hangMaxMap=new HashMap();
					//上市证券代码
					hangMaxMap.put("SecurityCode",securityStock.getSecurityCode());
					//行情日期
					hangMaxMap.put("businessDate", beforeDate);
					quotation=this.assetValuationDao.selectHangQingCha(hangMaxMap);
					if(quotation.size()==0){
						flagGuZhi="没有当天的行情信息.";
					}
					else{
						//得到行情数据
						PriceData priceDataEntity=(PriceData) quotation.get(0);
						System.out.println("行情实体类"+priceDataEntity);
						System.out.println("收盘价"+priceDataEntity.getClosingPrice());
						//得到收盘价
						double closingPrice=priceDataEntity.getClosingPrice();
						//用到四舍五入
						closingPrice=Math.round(closingPrice*100);
						closingPrice=closingPrice/100;
						//得到单位成本
						cost=securityStock.getSecurityUtilCost();
						System.out.println("得到单位成本："+cost);
						//得到证券数量
						double securityQuantity=securityStock.getSecurityQuantity();
						System.out.println("得到证券的数量："+securityQuantity);
						//计算日期  得到前一天的日期
						Date dates=null;
						try {
							dates = AllUtil.getDate(guZhiDate,-1);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("得到前一天的日期："+beforeDate);
						HashMap selectMap=new HashMap();
						//把基金代码放到集合中
						selectMap.put("fundCode", fundCode);
						//把日期放到集合中
						selectMap.put("businessDate", beforeDate);
						//把现金账户id放到集合中
						selectMap.put("cashAccountId", securityStock.getAccountCode());
						System.out.println("现金账户="+securityStock.getAccountCode());
						//把证券上市代码id放到集合中
						selectMap.put("securityId", securityStock.getSecurityCode());
						double zengZhiGuZhi=0;
						System.out.println("证券应收应付----"+ new Gson().toJson(selectMap));
						//证券应收应付数据查
						ArrayList yingShouYingFu=(ArrayList) this.assetValuationDao.selectSecurityArapStockYSYFKuCun(selectMap);
						System.out.println("前一天的应收应付："+yingShouYingFu.size());
						//判断证券应收应付大小大于零 则进
						if(yingShouYingFu.size()>0)
						{
							securityArapStock=(SecurityArapStock) yingShouYingFu.get(0);
							//证券应收应付金额
							money=securityArapStock.getTotalMoney();
							//估值=数量*收盘价-成本         //- 金额 * 状态       - beforeJinMoney*Integer.parseInt(securityArapStockEntity.getStatus())
							zengZhiGuZhi=securityQuantity *(closingPrice-cost);
						}else{
							//估值=数量*（收盘价-成本）
							zengZhiGuZhi=securityQuantity *(closingPrice-cost);
							//四舍五入
							zengZhiGuZhi=Math.round(zengZhiGuZhi*100);
							zengZhiGuZhi=zengZhiGuZhi/100;
							System.out.println("证券数量="+securityQuantity);
							System.out.println("收盘价="+closingPrice);
							System.out.println("单位成本="+cost);
						}
						System.out.println("增值估值11111："+zengZhiGuZhi);
						flagGuZhi=String.valueOf(zengZhiGuZhi);
						//日期格式转换
						java.sql.Date bianhaoDate=null;
						try {
							bianhaoDate = AllUtil.getDate(guZhiDate,0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//调用公共方法日期
						String securityArapStockCode = null;
						try {
							securityArapStockCode = autoBianService.getAutoBianhao("security_arap_stock", "ZJYSYFKC", "security_arap_stock_code", "business_date", bianhaoDate);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("securityArapStockCode=="+securityArapStockCode);
						//证券应收应付库存编号
						securityArapStock.setSecurityArapStockCode(securityArapStockCode);
						//引用现金账户表Code
						securityArapStock.setCashAccountCode(securityStock.getAccountCode());
						//引用基金表的基金代码 
						securityArapStock.setFundCode(fundCode);
						//证券id
						securityArapStock.setSecurityCode( securityStock.getSecurityCode());
						//业务类型(1估值增值,2清算款,3银行计息)
						securityArapStock.setBusinessType(1);
						//总金额 默认为0 
						securityArapStock.setTotalMoney(zengZhiGuZhi);
						//期初标志(1导入数据,2不导入)
						securityArapStock.setPeriodFlag(2);
						//业务状态(1代表应收，2代表应付)
						securityArapStock.setBusinessStatus(1);
						//
						java.sql.Date businessDate=null;
						try {
							businessDate = AllUtil.getDate(guZhiDate,0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//业务日期
						securityArapStock.setBusinessDate(businessDate);
						//备注可扩展
						securityArapStock.setSecurityArapStockDesc("");
						//插入证券应收应付库存表
						this.assetValuationDao.insertSecurityArapStock(securityArapStock);
					}
				}
				else{
					
					HashMap hangMaxMap=new HashMap();
					//上市证券代码
					hangMaxMap.put("SecurityCode",securityStock.getSecurityCode());
					//行情日期
					hangMaxMap.put("businessDate", guZhiDate);
					quotation=this.assetValuationDao.selectHangQingCha(hangMaxMap);
					if(quotation.size()==0){
						flagGuZhi="没有当天的行情信息.";
					}else{
						//得到行情数据
						PriceData priceDataEntity=(PriceData) quotation.get(0);
						System.out.println("行情实体类"+priceDataEntity);
						System.out.println("收盘价"+priceDataEntity.getClosingPrice());
						//得到收盘价
						double closingPrice=priceDataEntity.getClosingPrice();
						//用到四舍五入
						closingPrice=Math.round(closingPrice*100);
						closingPrice=closingPrice/100;
						//得到单位成本
						cost=securityStock.getSecurityUtilCost();
						System.out.println("得到单位成本："+cost);
						//得到证券数量
						double securityQuantity=securityStock.getSecurityQuantity();
						System.out.println("得到证券的数量："+securityQuantity);
						//计算日期  得到前一天的日期
						Date dates=null;
						String strDates=null;
						try {
							dates = AllUtil.getDate(guZhiDate,-1);
							strDates=AllUtil.getStringDate(dates);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("得到前一天的日期："+strDates);
						HashMap selectMap=new HashMap();
						//把基金代码放到集合中
						selectMap.put("fundCode", fundCode);
						//把日期放到集合中
						selectMap.put("businessDate", strDates);
						//把现金账户id放到集合中
						selectMap.put("cashAccountId", securityStock.getAccountCode());
						System.out.println("现金账户="+securityStock.getAccountCode());
						//把证券上市代码id放到集合中
						selectMap.put("securityId", securityStock.getSecurityCode());
						double zengZhiGuZhi=0;
						System.out.println("证券应收应付----"+ new Gson().toJson(selectMap));
						//证券应收应付数据查
						ArrayList yingShouYingFu=(ArrayList) this.assetValuationDao.selectSecurityArapStockYSYFKuCun(selectMap);
						System.out.println("前一天的应收应付："+yingShouYingFu.size());
						//判断证券应收应付大小大于零 则进
						if(yingShouYingFu.size()>0)
						{
							securityArapStock=(SecurityArapStock) yingShouYingFu.get(0);
							//证券应收应付金额
							money=securityArapStock.getTotalMoney();
							//估值=数量*收盘价-成本         //- 金额 * 状态       - beforeJinMoney*Integer.parseInt(securityArapStockEntity.getStatus())
							zengZhiGuZhi=securityQuantity *(closingPrice-cost);
						}else{
							//估值=数量*（收盘价-成本）
							zengZhiGuZhi=securityQuantity *(closingPrice-cost);
							//四舍五入
							zengZhiGuZhi=Math.round(zengZhiGuZhi*100);
							zengZhiGuZhi=zengZhiGuZhi/100;
							System.out.println("证券数量="+securityQuantity);
							System.out.println("收盘价="+closingPrice);
							System.out.println("单位成本="+cost);
						}
						System.out.println("增值估值22222："+zengZhiGuZhi);
						guZhiValue=guZhiValue+zengZhiGuZhi;
						System.out.println(guZhiValue+"========money");
						//四舍五入
						guZhiValue=Math.round(guZhiValue*100);
						guZhiValue=guZhiValue/100;
						System.out.println(guZhiValue+"========money");
						flagGuZhi=String.valueOf(guZhiValue);
						//日期格式转换
						java.sql.Date bianhaoDate=null;
						try {
							bianhaoDate = AllUtil.getDate(guZhiDate,0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//调用公共方法日期
						String securityArapStockCode = null;
						try {
							securityArapStockCode = autoBianService.getAutoBianhao("security_arap_stock", "ZJYSYFKC", "security_arap_stock_code", "business_date", bianhaoDate);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("securityArapStockCode=="+securityArapStockCode);
						//证券应收应付库存编号
						securityArapStock.setSecurityArapStockCode(securityArapStockCode);
						//引用现金账户表Code
						securityArapStock.setCashAccountCode(securityStock.getAccountCode());
						//引用基金表的基金代码 
						securityArapStock.setFundCode(fundCode);
						//证券id
						securityArapStock.setSecurityCode( securityStock.getSecurityCode());
						//业务类型(1估值增值,2清算款,3银行计息)
						securityArapStock.setBusinessType(1);
						//总金额 默认为0 
						securityArapStock.setTotalMoney(zengZhiGuZhi);
						//期初标志(1导入数据,2不导入)
						securityArapStock.setPeriodFlag(2);
						//业务状态(1代表应收，2代表应付)
						securityArapStock.setBusinessStatus(1);
						//
						java.sql.Date businessDate=null;
						try {
							businessDate = AllUtil.getDate(guZhiDate,0);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//业务日期
						securityArapStock.setBusinessDate(businessDate);
						//备注可扩展
						securityArapStock.setSecurityArapStockDesc("");
						//插入证券应收应付库存表
						this.assetValuationDao.insertSecurityArapStock(securityArapStock);
					}
				}
			}
		};
		return flagGuZhi;
	}

	@Override
	public String clearingModel(String guZhiDate, String fundCode) {
		String flagQingSuan="qingSuan";
		List taTradeDataList=null;
		double jinE=0;
		double jinE2=0;
		//现金账户实体
		CashAccount cashAccount=null;
		//现金应收应付
		CashArap cashArap=null;
		//ta交易数据
		TaTradData taTradData=null;
		//定一个字符串
		String strWhere="";
		//条件拼接 
		//判断基金代码id不等于空 且 基金代码id为字符串
		if(fundCode!=null && !fundCode.equals(""))
		{
			strWhere +=" and fundCode like'%"+ fundCode +"%'";
		}
		//创建一个清算哈希映射集合   先删除清算款
		HashMap qingMap=new HashMap();
		//把基金代码放到集合中

		qingMap.put("fundCode",fundCode);
		//把日期放到集合中
		qingMap.put("businessDate", guZhiDate);
		//创建一个ta哈希映射集合
		HashMap taSelectMap=new HashMap();
		//把基金代码放到集合中
		taSelectMap.put("fundCode", fundCode.trim());
		//把日期放到集合中
		taSelectMap.put("businessDate", guZhiDate);
		//证券应收应付数据清算款删除
		int securityArapX=this.assetValuationDao.deleteSecurityArapYSYF( qingMap);
		//现金应收应付数据删除
		int cashArapY=this.assetValuationDao.deleteCashArapXanJin( qingMap);
		//根据ta统计日期进行查询
		taTradeDataList=this.assetValuationDao .selectTaTradeDataRiQi( taSelectMap);
		//ta小于等于零 则没有数据
		if(taTradeDataList.size()<=0){
			flagQingSuan="没有TA数据";
		}else{
			//循环ta交易数据集合
			for(int i=0;i<taTradeDataList.size();i++){
				//现金应收应付数据
				cashArap=new CashArap();
				//得到ta
				taTradData=(TaTradData) taTradeDataList.get(i);
				//得到实际金额 累加
				jinE+=taTradData.getTaRealMoney();
				//得用Ta现金账户id
				String cashAccountId=taTradData.getCashAccountCode();
				//根据现金账户卡号查询得到账号ID
				List<CashAccount> cashAccountList=this.assetValuationDao.selectCashAccountID(cashAccountId);
				//现金账户实体类
				cashAccount= (CashAccount) cashAccountList.get(0);
				//得到现金ID
				String xianJin= cashAccount.getCashAccountCode();
				//基金代码id
				cashArap.setFundCode(fundCode);
				//现金ID
				cashArap.setCashAccountCode(xianJin);
				//ta交易类型  1为认购 ，2 为 申购 3 为 赎回
				Integer tradeType=taTradData.getTaRadeType();
				if(tradeType.equals("1"))
				{
					//现金应收应付业务类型cashArapType
					cashArap.setCashArapType(1);
					//资金流向
					cashArap.setMoneyDirection(-1);
				}
				if(tradeType.equals("2"))
				{
					//现金应收应付业务类型
					cashArap.setCashArapType(1);
					//资金流向
					cashArap.setMoneyDirection(-1);
				}
				if(tradeType.equals("3"))
				{
					//现金应收应付业务类型
					cashArap.setCashArapType(1);
					//资金流向
					cashArap.setMoneyDirection(-1);
				}
				//上市代码
				cashArap.setCashAccountCode(cashAccountId);
				//实际金额

				cashArap.setMoney(taTradData.getTaRealMoney());
				//	System.out.println("现金应收应付num=="+NumUtil.getNum("t_cashArap", guZhiDate));
				//日期格式转换
				java.sql.Date bianhaoDates=null;
				try {
					bianhaoDates = AllUtil.getDate(guZhiDate,0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//现金应收应付库存实体
				CashArapStock  cashArapStock=new CashArapStock();
				String cashArapStockCode =null;
				try {
					cashArapStockCode = autoBianService.getAutoBianhao("cash_arap_stock", "XJYSYFKC", "cash_arap_stock_code", "business_date", bianhaoDates);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//现金应收应付库存编号(以每一笔记)
				cashArapStock.setCashArapStockCode(cashArapStockCode);
				//外键 引用现金账户表的ID
				cashArapStock.setCashAccountCode(cashAccount.getCashAccountCode());
				//外键 引用基金表的基金代码
				cashArapStock.setFundCode(fundCode);
				//业务类型(1清算款,2存款利息)
				cashArapStock.setBusinessType(1);
				//总金额
				cashArapStock.setTotalMoney(jinE);
				//不为空 业务状态 1代表应收，-1代表应付
				cashArapStock.setStatus(-1);
				//日期格式转换
				java.sql.Date businessDate=null;
				try {
					businessDate = AllUtil.getDate(guZhiDate,0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//不为空 业务日期 日期
				cashArapStock.setBusinessDate(businessDate);
				//不为空 期初标志 是否从其他系统导入的期初数据  1：不是  2：是
				cashArapStock.setPeriodFlag(1);
				//备注可扩展
				cashArapStock.setCashArapStockDesc("");

				//增加申购赎回数据到应该应付数据表
				this.assetValuationDao.insertCashArapStock(cashArapStock);

			}
		}
		//证券应收应付数据
		SecurityArapStock securityArap=new SecurityArapStock();
		//创建一个交易哈希映射集合
		HashMap jiaoYiMap=new HashMap();
		//把基金代码放到集合中
		jiaoYiMap.put("fundCode", fundCode.trim());
		//把日期放到集合中
		jiaoYiMap.put("businessDate",guZhiDate);
		//交易数据查询
		List<DealData> dealList=this.assetValuationDao.selectDealData(jiaoYiMap);
		//交易数据等等于零 则没有数据
		if(dealList.size()==0)
		{
			flagQingSuan="没有交易数据";
		}else{
			//循环交易数据集合
			for(int i=0;i<dealList.size();i++)
			{
				//得到交易数据
				DealData dealEntity= (DealData) dealList.get(i);
				//基金id
				securityArap.setFundCode(dealEntity.getFundCode());
				//上市代码
				securityArap.setSecurityCode(dealEntity.getSecurityCode());
				//交易账户id
				securityArap.setCashAccountCode(dealEntity.getCashAccountCode());
				//交易方式   1买入、2卖出，3分红，4送股
				Integer dealType=dealEntity.getDealType();
				if(dealType==1 || dealType==3)
				{
					//证券应收应付库存类型	1估值增值 2证券清算款 3债券利息
					securityArap.setBusinessType(2);
					//资金流动方向	1流入 -1流出
					securityArap.setBusinessStatus(-1);
				}
				if(dealType==2)
				{
					//证券应收应付库存类型	1估值增值 2证券清算款 3债券利息
					securityArap.setBusinessType(2);
					//资金流动方向	1流入 -1流出
					securityArap.setBusinessStatus(1);
				}
				//RealCollectFee 实收金额
				securityArap.setTotalMoney(dealEntity.getRealCollectFee());
				//日期格式转换
				java.sql.Date businessDate=null;
				try {
					businessDate = AllUtil.getDate(guZhiDate,0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//业务日期
				securityArap.setBusinessDate(businessDate);
				//备注  为字符串
				securityArap.setSecurityArapStockDesc("");
				//调用公共方法日期
				String securityArapStockCode=null;
				try {
					securityArapStockCode = autoBianService.getAutoBianhao("security_arap_stock", "ZJYSYFKC", "security_arap_stock_code", "business_date", businessDate);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				securityArap.setPeriodFlag(1);
				//证券应收应付库存编号
				securityArap.setSecurityArapStockCode(securityArapStockCode);
				//增加到证券应收应付中
				this.assetValuationDao.insertSecurityArapStock(securityArap);
				//得到实际金额 再累加
				jinE2+=dealEntity.getRealCollectFee();
			}
		}
		//转String型 金额加起来，传到界面
		if(jinE+jinE2!=0.0){
			flagQingSuan=String.valueOf(jinE+jinE2);
		}
		//返回结果
		return flagQingSuan;
	}

	@Override
	public List<HoildayXiao> selectHoildayBydate(String guZhiDate) {
		// TODO Auto-generated method stub
		return this.assetValuationDao.selectHolidayList(guZhiDate);
	}


}