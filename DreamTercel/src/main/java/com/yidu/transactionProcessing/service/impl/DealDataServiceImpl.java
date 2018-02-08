package com.yidu.transactionProcessing.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFReader;
import com.yidu.cashManagement.dao.MoneyAllotDao;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.cashManagement.service.MoneyAllotService;
import com.yidu.parameters.dao.BroketDao;
import com.yidu.parameters.dao.CashAccountDao;
import com.yidu.parameters.dao.ExchangeRateDao;
import com.yidu.parameters.dao.FundDao;
import com.yidu.parameters.dao.ManagerDao;
import com.yidu.parameters.dao.SeatDao;
import com.yidu.parameters.dao.SecurityDao;
import com.yidu.parameters.domain.Bond;
import com.yidu.parameters.domain.Broket;
import com.yidu.parameters.domain.CashAccount;
import com.yidu.parameters.domain.ExchangeRate;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.domain.Seat;
import com.yidu.parameters.domain.Security;
import com.yidu.parameters.service.BondService;
import com.yidu.system.dao.UserDao;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.system.domain.User;
import com.yidu.system.service.HoildayXiaoSerice;
import com.yidu.transactionProcessing.dao.DealDataDao;
import com.yidu.transactionProcessing.domain.DealData;
import com.yidu.transactionProcessing.domain.Interests;
import com.yidu.transactionProcessing.service.DealDataService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

/**
 * 交易数据业务处理实现层
 * @author Wang
 * @date 2017年11月18日
 * @time 上午10:28:07
 */
@Service
@Transactional
public class DealDataServiceImpl implements DealDataService{
	@Autowired
	DealDataDao dealDataDao;
	@Autowired
	SeatDao seatDao;
	@Autowired
	CashAccountDao cashAccountDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	AutoBianService autoBianHao;
	@Autowired
	MoneyAllotService moneyAllotService;
	@Autowired
	MoneyAllotDao moneyAllotDao;
	@Autowired
	SecurityDao securityDao;
	@Autowired
	BroketDao broketDao;
	@Autowired 
	UserDao userDao;
	@Autowired
	HoildayXiaoSerice hoildayXiaoSerice;
	@Autowired
	FundDao fundDao;
	@Autowired
	ExchangeRateDao exchangeRateDao;
	@Autowired
	BondService bondService;
	@Autowired
	DealDataService DealDataService;
	@Override
	public Map<String, Object> selectDealData(DealData dealData,String fundCode) {
		 //条件查询的条件
		StringBuffer qualification=new StringBuffer("");
		//证券编号
		if(dealData.getSecurityCode()!=null&&!dealData.getSecurityCode().equals("")){
			qualification.append("  and security_code like '%"+dealData.getSecurityCode()+"%'");
		}
		//交易日期
		if(dealData.getStrDealDate()!=null&&!dealData.getStrDealDate().equals("")){
			qualification.append(" and deal_date   =to_date('"+dealData.getStrDealDate()+"','yyyy-MM-dd')");
		}
		//基金代码
		qualification.append(" and fund_code="+fundCode);
		//分页查询条件map
		Map<String, Object> map=new HashMap<String, Object>();
		//分页条件查询的条件
		map.put("tableName", "deal_data");
		map.put("qualification", qualification.toString());
		map.put("page", dealData.getPage());
		map.put("rows", dealData.getRows());
		map.put("orderColumn", "deal_data_code");
		map.put("orderStyle", dealData.getSortOrder());
		//执行查询方法
		dealDataDao.selectDealData(map);
		//得到交易费率数据的集合
		List<DealData> dealDataList=(List<DealData>) map.get("cursor");
		for (int i = 0; i < dealDataList.size(); i++) {
			dealData=dealDataList.get(i);
			//得到交易日期和结算日期
			Date dealDate=dealData.getDealDate();
			Date setAccountDate=dealData.getSetAccountDate();
			//转日期格式
			try {
				String strDealDate=AllUtil.getStringDate(dealDate);
				String strSetAccountDate=AllUtil.getStringDate(setAccountDate);
				dealData.setStrDealDate(strDealDate);
				dealData.setStrSetAccountDate(strSetAccountDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//得到账户
			CashAccount cashAccount=cashAccountDao.selectCashAccountIds(dealData.getCashAccountCode());
			//得到证券
			Security security=securityDao.selectSecurityByIds(dealData.getSecurityCode());
			//得到券商
			if(dealData.getBrokerCode()!=null&&!dealData.getBrokerCode().equals("")){
				List<Broket> broketList=broketDao.selectBroketById(dealData.getBrokerCode());
				Broket broket=null;
				for (int j = 0; j < broketList.size(); j++) {
					broket=broketList.get(j);
				}
				dealData.setBrokerCode(broket.getBrokerName());
			}else{
				dealData.setBrokerCode("无");
			}
			dealData.setCashAccountCode(cashAccount.getCashAccountName());
			dealData.setSecurityCode(security.getSecurityName());
		}
		//得到查询总条数
		int rowsTotal=(int) map.get("rowsTotal");
		//分页集合map
		Map<String, Object> dealDataMap=new HashMap<String, Object>();
		dealDataMap.put("total", rowsTotal);
		dealDataMap.put("rows", dealDataList);
		return dealDataMap;
	}

	@Override
	public int insertDealData(DealData dealData) {
		//转日期格式
		// TODO Auto-generated method stub
		try {
			dealData.setDealDate(AllUtil.getDate(dealData.getStrDealDate()));
			dealData.setSetAccountDate(AllUtil.getDate(dealData.getStrSetAccountDate()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//增加
		return dealDataDao.insertDealData(dealData);
	}

	@Override
	public int updateDealData(DealData dealData) {
		//转日期格式
		// TODO Auto-generated method stub
		try {
			dealData.setDealDate(AllUtil.getDate(dealData.getStrDealDate()));
			dealData.setSetAccountDate(AllUtil.getDate(dealData.getStrSetAccountDate()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//修改
		return dealDataDao.updateDealData(dealData);
	}

	@Override
	public int deleteDealData(DealData dealData) {
		// TODO Auto-generated method stub
		return dealDataDao.deleteDealData(dealData);
	}

	@Override
	public List<DealData> selectDealDataById(String dealDataCode) {
		//通过编号查询交易数据
		List<DealData> dealDataList=dealDataDao.selectDealDataById(dealDataCode);
		for (int i = 0; i < dealDataList.size(); i++) {
			DealData dealData=dealDataList.get(i);
			//得到交易日期和结算日期
			Date dealDate=dealData.getDealDate();
			Date setAccountDate=dealData.getSetAccountDate();
			//转日期格式
			try {
				String strDealDate=AllUtil.getStringDate(dealDate);
				String strSetAccountDate=AllUtil.getStringDate(setAccountDate);
				dealData.setStrDealDate(strDealDate);
				dealData.setStrSetAccountDate(strSetAccountDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dealDataList;
	}

	@Override
	public List<Seat> selectSeatByBorketCode(String borketCode) {
		// TODO Auto-generated method stub
		return seatDao.selectSeatByBorketCode(borketCode);
	}

	@Override
	public List<CashAccount> selectCashAccountSel() {
		//查询现金账户
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("tableName","cash_account");
		map.put("qualification","");
		map.put("page",0);
		map.put("rows",9999);
		map.put("orderColumn","CASH_ACCOUNT_CODE");
		map.put("orderStyle","asc");
		cashAccountDao.selectCashAccount(map);
		List<CashAccount> cashAccountList=(List<CashAccount>) map.get("bondList");
		return cashAccountList;
	}

	@Override
	public List<User> selectMaragerSel() {
		//查询投资经理
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tableName", "users");
		map.put("qualification", "");
		map.put("page",0);
		map.put("rows",9999);
		map.put("orderColumn", "user_code");
		map.put("orderStyle", "asc");
		userDao.selectUser(map);
		List<User> userList=(List<User>) map.get("cursor");
		return userList;
	}

	@Override
	public Map<String, Object> selectTradeSettle(DealData dealData) {
		//条件查询
		StringBuffer qualification=new StringBuffer("");
		//交易日期
		if(dealData.getStrDealDate()!=null&&!dealData.getStrDealDate().equals("")){
			qualification.append(" and deal_date= to_date('"+dealData.getStrDealDate()+"','yyyy-MM-dd')");
		}
		//交易类型
		if(dealData.getDealType()!=null&&!dealData.getDealType().equals("")){
			qualification.append(" and deal_type="+dealData.getDealType());
		}
		//交易状态
		if(dealData.getDealStatus()!=null&&!dealData.getDealStatus().equals("")){
			if(dealData.getDealStatus()==1){
				qualification.append(" and deal_status=1");
			}else if(dealData.getDealStatus()==2){
				qualification.append(" and deal_status=2");
			}
		}
		//基金代码
		qualification.append(" and fund_code="+dealData.getFundCode());
		Map<String, Object> map=new HashMap<String, Object>();
		//分页条件查询的条件
		map.put("tableName", "deal_data");
		map.put("qualification", qualification.toString());
		map.put("page", dealData.getPage());
		map.put("rows", dealData.getRows());
		map.put("orderColumn", "deal_data_code");
		map.put("orderStyle", dealData.getSortOrder());
		dealDataDao.selectTradeSettle(map);
		//得到交易费率数据的集合
		List<DealData> dealDataList=(List<DealData>) map.get("cursor");
		for (int i = 0; i < dealDataList.size(); i++) {
			dealData=dealDataList.get(i);
			//得到交易日日和结算日期
			Date dealDate=dealData.getDealDate();
			Date setAccountDate=dealData.getSetAccountDate();
			//转日期格式
			try {
				String strDealDate=AllUtil.getStringDate(dealDate);
				String strSetAccountDate=AllUtil.getStringDate(setAccountDate);
				dealData.setStrDealDate(strDealDate);
				dealData.setStrSetAccountDate(strSetAccountDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//得到现金账户
			CashAccount cashAccount=cashAccountDao.selectCashAccountIds(dealData.getCashAccountCode());
			//得到证券信息
			Security security=securityDao.selectSecurityByIds(dealData.getSecurityCode());
			//得到券商信息
			if(dealData.getBrokerCode()!=null&&!dealData.getBrokerCode().equals("")){
				List<Broket> broketList=broketDao.selectBroketById(dealData.getBrokerCode());
				Broket broket=null;
				for (int j = 0; j < broketList.size(); j++) {
					broket=broketList.get(j);
				}
				dealData.setBrokerCode(broket.getBrokerName());
			}else{
				dealData.setBrokerCode("无");
			}
			dealData.setCashAccountCode(cashAccount.getCashAccountName());
			dealData.setSecurityCode(security.getSecurityName());
		}
		//得到查询总条数
		int rowsTotal=(int) map.get("rowsTotal");
		//分页集合map
		Map<String, Object> dealDataMap=new HashMap<String, Object>();
		dealDataMap.put("total", rowsTotal);
		dealDataMap.put("rows", dealDataList);
		return dealDataMap;
	}

	@Override
	public int insertTradeNotSettle(DealData dealData) {
		int rows=0;//是否增加成功
		//得到交易数据编号
		String strDealDataCode=dealData.getDealDataCode();
		//切割得到编号数组
		String [] DealDataCodeArr=strDealDataCode.split(",");
		//买入，卖出，分红
		String code="";
		//得到单独的编号
		for (int i = 0; i < DealDataCodeArr.length; i++) {
			//通过编号查询信息
			List<DealData> dealDataList=dealDataDao.selectDealDataById(DealDataCodeArr[i]);
			//循环交易数据集合
			for (int j = 0; j < dealDataList.size(); j++) {
				//得到交易数据对象
				DealData dealDatabyCode=dealDataList.get(j);
				//得到交易类型
				Integer dealType=dealDatabyCode.getDealType();
				//送股
				if(dealType==4){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("status", 1);
					map.put("dealDataCode", dealDatabyCode.getDealDataCode());
					rows=dealDataDao.updateDealStatus(map);
				}else{
					if(code!=null&&!code.equals("")){
						code=AllUtil.getLocalhostAutoBianHao(code);
					}else{
						try {
							//自动生成编号
							System.out.println(dealDatabyCode.getDealDate());
							code=autoBianHao.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date", dealDatabyCode.getDealDate());
							System.out.println(code);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//得到基金编号
					String fundCode=dealDatabyCode.getFundCode();
					//交易金额
					Double money=dealDatabyCode.getRealCollectFee();
					//现金账户
					String accountCode=dealDatabyCode.getCashAccountCode();
					//资金调拨方向状态
					Integer direction = null;
					if(dealType==1){
						direction=-1;
					}else if(dealType==2){
						direction=1;
					}else if(dealType==3){
						direction=1;
					}
					//调拨日期
					Date date=dealDatabyCode.getSetAccountDate();
					//业务日期
					Date businessDate=dealDatabyCode.getDealDate();
					//业务编号
					String businessCode=dealDatabyCode.getDealDataCode();
					//类型
					Integer type=3;
					String desc="";
					//添加资金调拨
					MoneyAllot moneyAllot=new MoneyAllot(code, fundCode, money, accountCode, direction, date, businessDate, businessCode, type, desc);
					rows=moneyAllotService.insertMoneyAllot(moneyAllot);
					if(rows!=0){
						//修改交易数据的状态
						Map<String, Object> map=new HashMap<String, Object>();
						map.put("status", 1);
						map.put("dealDataCode", dealDatabyCode.getDealDataCode());
						rows=dealDataDao.updateDealStatus(map);
					}

				}
			}
		}
		return rows;
	}

	@Override
	public int insertTradeAlreadySettle(DealData dealData) {
		int rows=0;
		//得到交易数据编号
		String strDealDataCode=dealData.getDealDataCode();
		//切割得到编号数组
		String [] DealDataCodeArr=strDealDataCode.split(",");
		//得到单独的编号
		for (int i = 0; i < DealDataCodeArr.length; i++) {
			//通过编号查询信息
			List<DealData> dealDataList=dealDataDao.selectDealDataById(DealDataCodeArr[i]);
			for (int j = 0; j < dealDataList.size(); j++) {
				DealData dealDataByCode=dealDataList.get(j);
				//得到交易类型
				Integer dealType=dealDataByCode.getDealType();
				//送股
				if(dealType==4){
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("status", 2);
					map.put("dealDataCode", dealDataByCode.getDealDataCode());
					//修改状态
					rows=dealDataDao.updateDealStatus(map);
				}else{
					String dealDataCode=dealDataByCode.getDealDataCode();
					String fundCode=dealDataByCode.getFundCode();
					MoneyAllot moneyAllot=new MoneyAllot();
					moneyAllot.setFundCode(fundCode);
					moneyAllot.setBusinessCode(dealDataCode);
					//删除资金调拨
					rows=moneyAllotDao.deleteAllotCode(moneyAllot);
					//修改交易状态
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("status", 2);
					map.put("dealDataCode", dealDataByCode.getDealDataCode());
					rows=dealDataDao.updateDealStatus(map);
				}
			}
		}
		return rows;
	}

	@Override
	public List<DealData> selectDealDataCode(Interests interests) {
		Integer type;
		if(interests.getEquityType()==1){
			type=3;
		}else{
			type=4;
		}
		StringBuffer qualification=new StringBuffer("");
		qualification.append(" and fund_code="+interests.getFundCode()+" and security_code="+interests.getSecurityCode()+" and deal_type="+type +"and deal_date=to_date('"+interests.getStrDate()+"','yyyy-MM-dd')");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("tableName", "deal_data");
		map.put("qualification", qualification.toString());
		map.put("page", 1);
		map.put("rows", 5);
		map.put("orderColumn", "deal_data_code");
		map.put("orderStyle", "asc");
		//执行查询方法
		dealDataDao.selectDealDataCode(map);
		//得到交易费率数据的集合
		List<DealData> dealDataList=(List<DealData>) map.get("cursor");
		return dealDataList;
	}

	@Override
	public int imputShangHaiGuoHu(String path,String fundCode,String userName) {
		int rows=0;
		InputStream fis=null;
		List<DealData> dealDataList=new ArrayList<DealData>();
		try {
			// 读取文件的输入流 
			fis=new FileInputStream(path);
			try {
				//根据输入流初始化一个DBFReader实例，用来读取DBF文件信息 
				DBFReader reader=new DBFReader(fis);
				Object[] rowValues;
				while ((rowValues = reader.nextRecord()) != null) {
					//交易单号
					String dealDataCode=(rowValues[3]+"").trim();
					//成交日期
					String strDealDate=(rowValues[2]+"").trim();
					//席位号
					String  tradeSeatCode=(rowValues[4]+"").trim();
					//成交数量
					String strDealQuantity=(rowValues[5]+"").trim();
					Double dealQuantity=Double.parseDouble(strDealQuantity);
					//证券代码
					String securityCode=(rowValues[7]+"").trim();
					//成交价格
					String strDealPrice=(rowValues[10]+"").trim();
					Double dealPrice=Double.parseDouble(strDealPrice);
					//成交金额
					String strDealTotalPrice=(rowValues[11]+"").trim();
					Double dealTotalPrice=Double.parseDouble(strDealTotalPrice);
					//买卖方向
					String strDealType=(rowValues[13]+"").trim();
					//转字符串时间格式
					StringBuffer stringBuffer=new StringBuffer(strDealDate);
					stringBuffer.insert(4, "-");
					stringBuffer.insert(7, "-");
					Date dealDate=null;
					//转date格式
					try {
						dealDate=AllUtil.getDate(stringBuffer.toString());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//得到结算时间
					Date setAccountDate = null;
					try {
						setAccountDate = AllUtil.getDate(stringBuffer.toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					List<HoildayXiao> hoildayXiaoList=null;
					do {
						try {
							setAccountDate=AllUtil.getDate(AllUtil.getStringDate(setAccountDate), 1);
							hoildayXiaoList=hoildayXiaoSerice.selectHoildayBydate(AllUtil.getStringDate(setAccountDate));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} while (hoildayXiaoList.size()!=0);
					
					
					//现金账户
					Fund fund=new Fund();
					fund.setFundCode(fundCode);
					fund=fundDao.selectFundByCode(fund);
					String cashAccountCode=fund.getCashAccountCode();
					//证券利息
					Double securityFnterest=null;
					//证券表的Code（外键）
					Security security=securityDao.selectSecurityByIds(securityCode);
					DealData computeDealData=new DealData();
					computeDealData.setStrDealDate(stringBuffer.toString());
					computeDealData.setSecurityCode(securityCode);
					computeDealData.setDealQuantity(dealQuantity);
					//判断此证券是股票还是债券
					Integer securityType=security.getSecurityType();
					if(securityType==1){
						securityFnterest=0d;
					}else if(securityType==2){
						//计算债券利息
						try {   
							securityFnterest=DealDataService.computeSecurityFnterest(computeDealData);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//得到券商编号
					String brokerCode=null;
					//通过席位编号查询席位
					List<Seat> seatList=seatDao.selectSeatById(tradeSeatCode);
					Double commissionRate=null;
					for (Seat seat:seatList) {
						commissionRate=seat.getCommissionRate();
						brokerCode=seat.getBrokerCode();
					}
					//佣金费率
					Double commissionFee=dealTotalPrice*commissionRate;
					//印花税
					Double stampDuty=null;
					//征管费
					Double managementFee=null;
					//过户费（交易所）
					Double transferFee=null;
					//-经手费（交易所）
					Double brokerageFee=null;
					ExchangeRate exchangeRate=new ExchangeRate();
					exchangeRate.setExchangeType(securityType);
					exchangeRate.setExchangeName(1);
					List< ExchangeRate> exchangeRateList=exchangeRateDao.selectExchangeRateByExchangeNameAndSecurityType(exchangeRate);
					//计算费率
					for (ExchangeRate rate:exchangeRateList) {
						stampDuty=dealTotalPrice*rate.getStampDuty();
						managementFee=dealTotalPrice*rate.getManagementFee();
						transferFee=dealTotalPrice*rate.getTransferFee();
						brokerageFee=dealTotalPrice*rate.getBrokerageFee();
					}
					Double realCollectFee=null;
					Integer dealType=null;
					Integer dealFlag=null;
					//判断是否是买入。卖出
					if(strDealType.equalsIgnoreCase("B")){
						dealType=1;
						dealFlag=-1;
						realCollectFee=dealTotalPrice+commissionFee+stampDuty+managementFee+transferFee+brokerageFee+securityFnterest;
					}else if(strDealType.equalsIgnoreCase("S")){
						dealType=2;
						dealFlag=1;
						realCollectFee=dealTotalPrice-commissionFee-stampDuty-managementFee-transferFee-brokerageFee-securityFnterest;
					}
					Integer dealStatus=2;
					//交易数据实体对象
					DealData dealData=new DealData(dealDataCode, fundCode, securityCode, dealDate, setAccountDate, "", "",userName, brokerCode, tradeSeatCode, dealType, dealFlag, cashAccountCode, dealPrice, dealQuantity, dealTotalPrice, stampDuty, managementFee, transferFee, commissionFee, brokerageFee, realCollectFee, securityFnterest, dealStatus, "");
					dealDataList.add(dealData);
				}
			} catch (DBFException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//增加交易数据
		for (int i = 0; i <dealDataList.size(); i++) {
			rows=dealDataDao.insertDealData(dealDataList.get(i));
		}
		System.out.println("rows="+rows);
		return rows;
	}
	/**
	 * 计算债券利息
	 * @param dealData 交易数据实体
	 * @return 债券利息
	 * @throws Exception 异常
	 */
	@Override
	public Double computeSecurityFnterest(DealData dealData) throws Exception{
		Double securityFnterest=null;
		Bond bond=bondService.selectBondByIds(dealData.getSecurityCode());
		//付息日，
		List<java.util.Date> fuXiRiList=new ArrayList<java.util.Date>();
		//创建一个高丽日历  
		GregorianCalendar gregorianCalendar=new GregorianCalendar();
		//得到交易日期
		String strDealDate=dealData.getStrDealDate();
		Double dealQuantity=dealData.getDealQuantity();
		if(strDealDate!=null&&!strDealDate.equals("")&&dealQuantity!=null&&!dealQuantity.equals("")){
			//得到计息起始日
			Date interestStarDate=bond.getInterestStarDate();
			//判断交易日是否在起始日之前
			if(AllUtil.getDate(strDealDate).getTime()>interestStarDate.getTime()){
			//得到结束起始日
			Date interestEndDate=bond.getInterestEndDate();
			Calendar calenStarDate=Calendar.getInstance();
			Calendar calenEndDate=Calendar.getInstance();
			calenStarDate.setTime(interestStarDate);
			calenEndDate.setTime(interestEndDate);
			//得到计息周期
			int jiXiZhouQi=calenEndDate.get(Calendar.YEAR)-calenStarDate.get(Calendar.YEAR);
			//付息次数
			Double paymentCount=bond.getPaymentCount();
			java.util.Date javStarDate=new java.util.Date(interestStarDate.getTime());
			gregorianCalendar.setTime(javStarDate);
			if(paymentCount==1){//付息次数为一
				//得到12个月后的时间
				for(int i=0;i<jiXiZhouQi*paymentCount;i++){
					gregorianCalendar.add(Calendar.MONTH,12);
					fuXiRiList.add(gregorianCalendar.getTime());
				}
			}else if(paymentCount==2){      
				for (int i = 0; i < jiXiZhouQi*paymentCount; i++) {
					gregorianCalendar.add(Calendar.MONTH, 6);
					fuXiRiList.add(gregorianCalendar.getTime());
				}
			}else if(paymentCount==4){
				for (int i = 0; i < jiXiZhouQi*paymentCount; i++) {
					gregorianCalendar.add(Calendar.MONTH, 3);
					fuXiRiList.add(gregorianCalendar.getTime());
				}
			}
			fuXiRiList.add(interestStarDate);
			///时间差集合
			List<Long> timeList=new ArrayList<Long>();
			///得到交易数据的毫秒数
			Long strDealDateTime=new java.util.Date(AllUtil.getDate(strDealDate).getTime()).getTime();
			for (int i = 0; i < fuXiRiList.size(); i++) {
				java.util.Date fuXiRi=fuXiRiList.get(i);
				Long fuXiRiTime=fuXiRi.getTime();
				Long fxrCjr=fuXiRiTime-strDealDateTime;
				if(fxrCjr<0){
					timeList.add(fxrCjr);
				}
			}
			//和付息日相差的毫秒数
			Long timeDifference=AllUtil.getMinTime(timeList);
			//相差的天数     
			Integer tianDifference =(new Long(timeDifference/1000/60/60/24)).intValue();
			//债券利率票面利率
			Double bondInterest=bond.getCouponRate();
			securityFnterest=dealQuantity*bondInterest/365*(tianDifference*-1)*100;
			}else{
				securityFnterest=0d;
			}
		}
		return securityFnterest;
	}
}
