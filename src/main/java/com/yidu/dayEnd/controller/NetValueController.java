package com.yidu.dayEnd.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.dayEnd.domain.ExeportNetValue;
import com.yidu.dayEnd.domain.NetValue;
import com.yidu.dayEnd.service.NetValueService;
import com.yidu.parameters.dao.FundDao;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.service.FundService;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.system.service.HoildayXiaoSerice;
import com.yidu.transactionProcessing.domain.DealData;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 净值统计的控制器类
 * @author 向燕春
 * @date 2017年11月19日
 * @time 上午8:29:02
 *
 */
@Controller
@RequestMapping("/netValue")
public class NetValueController {
	@Autowired
	NetValueService netValueService;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	HoildayXiaoSerice hoildayXiaoSerice;
	@Autowired
	FundDao fundDao;
	/**
	 * 查询净值统计的所有数据
	 * @param response 响应对象
	 * @param request 请求对象
	 * @param netValue 净值统计对象
	 * @return json格式的map
	 * @throws IOException io异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectNetValues.action")
	public HashMap<String, Object> selectNetValues(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")NetValue netValue) throws IOException{
		//得到统计日期
		String statisticDateWhere=netValue.getStatisticDateWhere();
		//判断统计日期是否为空
		if(statisticDateWhere==null||statisticDateWhere.equals("")){
			//创建一个日期
			Date date=new Date();
			//格式化日期
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			//给统计日期赋值
			statisticDateWhere=sdf.format(date);
		}
		//创建一个session会话
		HttpSession session=request.getSession(false);
		if(session==null){
			request.getSession(true);
		}
		//得到基金实体对象
		Fund fund=(Fund) session.getAttribute("fund");
		//判断基金实体类不为空，则给将得到的基金代码赋值到净值统计里
		if(fund!=null){
			netValue.setFundCode(fund.getFundCode());
		}
		//重新给净值统计的数据赋值
		NetValue netValueFirst=new NetValue(netValue.getFundCode(), "F",statisticDateWhere);
		//调用拼接条件的方法
		String firstWhere=netValueService.strWhere(netValueFirst);
		//调用查询净值统计数据的方法
		HashMap<String, Object> firstMap=netValueService.selectNetValues("net_value", firstWhere, netValue.getPage(), netValue.getRows(), netValue.getRowsTotal(), netValue.getOrderColumn(), netValue.getOrderStyle());
		//得到净值统计数据第一节游标集合
		List<NetValue> firstList=(List<NetValue>) firstMap.get("netValueList");
		//判断游标集合不等于空
		if(firstList.size()!=0){
			//将统计日期转换成字符串
			for(NetValue netValues:firstList){
				netValues.setStatisticDateWhere(netValues.getStatisticDate().toString());
			}
			//创建一个map集合
			HashMap<String, Object> map=new HashMap<String, Object>();
			//循环第一节游标集合
			for (int i = 0; i < firstList.size(); i++) {
				//得到当前正在循环的第一个集合的 树节点code
				String firstTreeCode=firstList.get(i).getTreeCode();
				//根据第一级树节点code  查询对应的第二级树节点集合
				NetValue netValueSecond=new NetValue(netValue.getFundCode(),firstTreeCode, statisticDateWhere );
				//调用拼接条件的方法
				String secondWhere=netValueService.strWhere(netValueSecond);
				//调用查询净值统计数据的方法
				HashMap<String, Object> secondMap=netValueService.selectNetValues("net_value", secondWhere, netValue.getPage(), netValue.getRows(), netValue.getRowsTotal(), netValue.getOrderColumn(), netValue.getOrderStyle());
				//得到净值统计数据第二节游标集合
				List<NetValue> secondList=(List<NetValue>) secondMap.get("netValueList");
				//将第二节树节点的数据放到session里面去
				session.setAttribute("secondList", secondList);
				//循环第二节游标集合
				for (int j = 0; j < secondList.size(); j++) {
					//得到当前正在循环的第二个集合的 树节点code
					String secondTreeCode=secondList.get(j).getTreeCode();
					//根据第二级树节点code  查询对应的第三级树节点集合
					NetValue netValueThird=new NetValue(netValue.getFundCode(), secondTreeCode,statisticDateWhere );
					//调用拼接条件的方法
					String thirdWhere=netValueService.strWhere(netValueThird);
					//调用查询净值统计数据的方法
					HashMap<String, Object> thirdMap=netValueService.selectNetValues("net_value", thirdWhere, netValue.getPage(), netValue.getRows(), netValue.getRowsTotal(), netValue.getOrderColumn(), netValue.getOrderStyle());
					//得到净值统计数据第三节游标集合
					List<NetValue> thirdList=(List<NetValue>) thirdMap.get("netValueList");
					//判断是否有第三级节点   有  则将第三节树节点放到第二节树节点
					if(thirdList!=null&&thirdList.size()!=0){
						secondList.get(j).setChildren(thirdList);
					}
				}
				//判断是否有第二级节点   有  则将第二节树节点放到第一节树节点
				if(secondList!=null&&secondList.size()!=0){
					firstList.get(i).setChildren(secondList);
				}
			}
			//将总条数和行数添加到map集合
			map.put("total", firstMap.get("rowsTotal"));
			map.put("rows", firstList);
			return map;
		}else{
			return null;
		}
	}
	/**
	 * 点击统计的方法
	 * @param response 响应对象
	 * @param request 请求对象
	 * @param netValue 净值统计实体对象
	 * @return 是否统计成功
	 * @throws Exception 所有异常
	 */
	@ResponseBody
	@RequestMapping(value="/netValueStatistics.action")
	public String netValueStatistics(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")NetValue netValue) throws Exception{
		//创建session会话
		HttpSession session=request.getSession();
		//得到基金对象
		Fund fund=(Fund) session.getAttribute("fund");
		//给基金代码赋值
		netValue.setFundCode(fund.getFundCode());
		//给业务日期和行情录入日期赋值
		netValue.setEnteringDate(netValue.getStatisticDateWhere());
		netValue.setBusinessDate(netValue.getStatisticDateWhere());
		try {
			//判断基金代码和日期不为空
			if(netValue.getFundCode()!=null&&!netValue.equals("")&&netValue.getStatisticDateWhere()!=null&&!netValue.getStatisticDateWhere().equals("")){
				//统计是先删除后增加
				//调用删除的方法
				netValueService.deleteNetValue(netValue);
				//调用查询账户总信息的方法
				List<NetValue> cashAccountList=netValueService.selectCashAccount(netValue);
				//查询证券的总数据（债券+股票的总数据）
				NetValue securityAll=netValueService.selectSecurityAll(netValue);
				//判断证券信息和账户信息不为空
				if(cashAccountList.size()==0&&securityAll==null){
					return "证券库存和现金库存都没有统计,请先统计库存！";
				}else{
					//判断证券总信息不为空
					if(securityAll!=null){
						//给项目名称，基金代码，项目名称，行情价格，统计日期点赋值
						securityAll.setProjectName("证券");
						securityAll.setFundCode(netValue.getFundCode());
						securityAll.setProjectCode(" ");
						securityAll.setPrice(0d);
						securityAll.setStatisticDateWhere(netValue.getStatisticDateWhere());
						//给树节点，父类树节赋值
						securityAll.setTreeCode(AllUtil.getNetValue(securityAll).getTreeCode());
						securityAll.setTreeFatherCode(AllUtil.getNetValue(securityAll).getTreeFatherCode());
						
						//查询出证券下面股票的信息，当证券类型=1是股票
						netValue.setSecurityType(1);
						//调用查询股票的总数据的方法
						NetValue  securityBlock=netValueService.selectSecurity(netValue);
						//判断股票的总信息不为空
						if(securityBlock!=null){
							//给项目名称、行情价格，基金编号，统计日期赋值
							securityBlock.setProjectName("股票");
							securityBlock.setProjectCode(" ");
							securityBlock.setPrice(0d);
							securityBlock.setFundCode(netValue.getFundCode());
							securityBlock.setStatisticDateWhere(netValue.getStatisticDateWhere());
							//给树节点，父类树节点赋值
							securityBlock.setTreeCode(AllUtil.getNetValue(securityBlock).getTreeCode());
							securityBlock.setTreeFatherCode(securityAll.getTreeCode());
							//得到净值统计的自动生成编号
							securityBlock.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
							//调用增加的方法（增加股票总数据）
							netValueService.insertNetValue(securityBlock);

							
							//调用查询股票详细信息的方法
							List<NetValue> securityBlockDetailList=netValueService.selectSecurityDetail(netValue);
							//判断集合不为空
							if(securityBlockDetailList.size()!=0){
								for (int i = 0; i < securityBlockDetailList.size(); i++) {
									//循环得到股票详细信息的数据
									NetValue securityBlockDetail=securityBlockDetailList.get(i);
									//给基金编号赋值
									securityBlockDetail.setFundCode(netValue.getFundCode());
									//得到净值统计的自动生成编号
									securityBlockDetail.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
									//给统计日期赋值
									securityBlockDetail.setStatisticDateWhere(netValue.getStatisticDateWhere());
									//给父类树节点、树节点赋值
									securityBlockDetail.setTreeFatherCode(securityBlock.getTreeCode());
									securityBlockDetail.setTreeCode(AllUtil.getNetValue(securityBlockDetail).getTreeCode());
									//调用增加的方法（增加股票详细信息的数据）
									netValueService.insertNetValue(securityBlockDetail);
								}
							}
						}else{
							//如果股票头部信息为空，则给所有数据重新赋值
							securityBlock=new NetValue(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())), fund.getFundCode(), "股票", " ", 0,0d,0d, 0d, netValue.getStatisticDateWhere(), 0d, " ", " ");
							//给树节点、父类树节点赋值
							securityBlock.setTreeCode(AllUtil.getNetValue(securityBlock).getTreeCode());
							securityBlock.setTreeFatherCode(AllUtil.getNetValue(securityBlock).getTreeFatherCode());
							//调用增加爱的方法（增加股票的头部信息）
							netValueService.insertNetValue(securityBlock);
						}


						//查询出证券下面股票的信息，当证券类型=2是债券
						netValue.setSecurityType(2);
						//调用查询债券的总数据的方法
						NetValue securityBond=netValueService.selectSecurity(netValue);
						//判断债券不为空
						if(securityBond!=null){
							//给项目名称、项目代码、行情价格、基金编号、统计日期赋值
							securityBond.setProjectName("债券");
							securityBond.setProjectCode(" ");
							securityBond.setPrice(0d);
							securityBond.setFundCode(netValue.getFundCode());
							securityBond.setStatisticDateWhere(netValue.getStatisticDateWhere());
							//给树父类树节点、树节点赋值
							securityBond.setTreeFatherCode(securityAll.getTreeCode());
							securityBond.setTreeCode(AllUtil.getNetValue(securityBond).getTreeCode());
							

							//调用查询债券的详细信息的方法
							List<NetValue> securityBondDetailList=netValueService.selectSecurityDetail(netValue);
							//判断债券的详细信息数据不为空
							if(securityBondDetailList.size()!=0){
								for (int i = 0; i < securityBondDetailList.size(); i++) {
									//循环得到所有的债券详细信息
									NetValue securityBondDetail=securityBondDetailList.get(i);
									//给基金编号、统计日期赋值
									securityBondDetail.setFundCode(netValue.getFundCode());
									securityBondDetail.setStatisticDateWhere(netValue.getStatisticDateWhere());
									//得到净值统计的自动生成编号
									securityBondDetail.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
									//给父类树节点、树节点赋值
									securityBondDetail.setTreeFatherCode(securityBond.getTreeCode());
									securityBondDetail.setTreeCode(AllUtil.getNetValue(securityBondDetail).getTreeCode());
									//调用增加的方法（增加债券的详细信息）
									netValueService.insertNetValue(securityBondDetail);
								}
							}


							//查询债券利息
							NetValue bondLiXi=netValueService.selectBondLiXi(netValue);
							//判断债券利息不为空
							if(bondLiXi!=null){
								//得到净值统计的自动生成编号
								bondLiXi.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
								//给项目名称、项目代码、基金编号、数量、行情价格、市值、估值增值、统计日期赋值
								bondLiXi.setProjectName("债券利息");
								bondLiXi.setProjectCode(" ");
								bondLiXi.setFundCode(netValue.getFundCode());
								bondLiXi.setQuantity(0);
								bondLiXi.setPrice(0d);
								bondLiXi.setMarketValue(0d);
								bondLiXi.setValueAdd(0d);
								bondLiXi.setStatisticDateWhere(netValue.getStatisticDateWhere());
								//给父类树节点、树节点赋值
								bondLiXi.setTreeFatherCode(securityBond.getTreeCode());
								bondLiXi.setTreeCode(AllUtil.getNetValue(bondLiXi).getTreeCode());
								//调用增加的方法（增加债券利息）
								netValueService.insertNetValue(bondLiXi);
								
								
							}else{
								//如果没有债券利息，则债券利息的数据赋为空值
								bondLiXi=new NetValue(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())), fund.getFundCode(), "债券利息", "", 0, 0d, 0d, 0d, netValue.getStatisticDateWhere(), 0d, "", "");
								//给父类树节点、树节点赋值
								bondLiXi.setTreeFatherCode(securityBond.getTreeCode());
								bondLiXi.setTreeCode(AllUtil.getNetValue(bondLiXi).getTreeCode());
								//调用增加的方法（增加债券利息）
								netValueService.insertNetValue(bondLiXi);
							}
							//给债券的总数据的成本重新赋值（债券成本+债券利息成本）
							securityBond.setCosting(securityBond.getCosting()+bondLiXi.getCosting());
							//得到净值统计的自动生成编号
							securityBond.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
							//调用增加的方法（增加债券总数据）
							netValueService.insertNetValue(securityBond);

						}else{
							//如果债券的数据为空，则把债券赋为空值
							securityBond=new NetValue(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())), fund.getFundCode(), "债券", " ", 0,0d,0d, 0d, netValue.getStatisticDateWhere(), 0d, " ", " ");
							//给树节点、赋值树节点赋值
							securityBond.setTreeCode(AllUtil.getNetValue(securityBond).getTreeCode());
							securityBond.setTreeFatherCode(AllUtil.getNetValue(securityBond).getTreeFatherCode());
							//调用增加个的方法（增加债券的头部信息）
							netValueService.insertNetValue(securityBond);
						}
						//得到净值统计的自动生成编号
						securityAll.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
						//给证券的成本重新赋值（股票成本+债券成本）
						securityAll.setCosting(securityBond.getCosting()+securityBlock.getCosting());
						//调用增加个的方法（增加债券的头部信息）
						netValueService.insertNetValue(securityAll);
					}else{ 
						//如果证券的总头部信息为空，则把证券赋为空值
						NetValue securityAllElse=new NetValue(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())), fund.getFundCode(), "证券", " ", 0,0d,0d, 0d, netValue.getStatisticDateWhere(), 0d, " ", " ");
						//给树节点、赋值树节点赋值
						securityAllElse.setTreeCode(AllUtil.getNetValue(securityAllElse).getTreeCode());
						securityAllElse.setTreeFatherCode(AllUtil.getNetValue(securityAllElse).getTreeFatherCode());
						//调用增加个的方法（增加证券的头部信息）
						netValueService.insertNetValue(securityAllElse);
					}
					
					
					
					//创建空的现金头部信息
					NetValue xianJinValue=new NetValue();
					//给基金代码、项目代码、项目名称、统计日期、数量
					//行情价格、市值、赋值增值、成本赋值
					xianJinValue.setFundCode(netValue.getFundCode());
					xianJinValue.setProjectName("现金");
					xianJinValue.setProjectCode(" ");
					xianJinValue.setStatisticDateWhere(netValue.getStatisticDateWhere());
					xianJinValue.setQuantity(0);
					xianJinValue.setPrice(0d);
					xianJinValue.setMarketValue(0d);
					xianJinValue.setValueAdd(0d);
				
					//给父类树节点、树节点赋值
					xianJinValue.setTreeFatherCode(AllUtil.getNetValue(xianJinValue).getTreeCode());
					xianJinValue.setTreeCode(AllUtil.getNetValue(xianJinValue).getTreeCode());
					
					
					//定义一个变量用来接收负债
					Double fuZhai=0d;
					//判断现金账户有没有信息
					//定义一个变量用来接收现金账户的信息
					NetValue cashAccount=null;
					//判断现金账户的头部信息不为空
					if(cashAccountList.size()!=0){
						for (int i = 0; i < cashAccountList.size(); i++) {
							//循环得到现金账户头部的数据
							cashAccount=cashAccountList.get(i);
							//给基金代码、统计日期、数量、行情价格、市值、赋值增值赋值
							cashAccount.setFundCode(netValue.getFundCode());
							//set统计日期
							cashAccount.setStatisticDateWhere(netValue.getStatisticDateWhere());
							cashAccount.setQuantity(0);
							cashAccount.setPrice(0d);
							cashAccount.setMarketValue(0d);
							cashAccount.setValueAdd(0d);
							//给父类树节点、树节点赋值
							cashAccount.setTreeFatherCode(xianJinValue.getTreeCode());
							cashAccount.setTreeCode(AllUtil.getNetValue(cashAccount).getTreeCode());
							//循环加入管理费、托管费、存款利息、TA清算款
							for (int j = 1; j < 5; j++) {
								//根据业务类型，账户编号查询现金账户的应收应付详情
								netValue.setBusinessType(j);
								netValue.setCashAccountCode(cashAccount.getProjectCode());
								NetValue fee=netValueService.selectCashAccountDetail(netValue);
								//判断有查到费用的数据
								if(fee!=null){
									//判断业务类型为托管费或者管理费
									if(j==1 || j==2){
										//得到所有的托管费和管理费
										fuZhai=fuZhai+(fee.getCosting()>0?fee.getCosting():fee.getCosting()*-1);
									}
									//得到净值统计的自动生成编号
									fee.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
									//给数量、行情、市值、项目名称都赋值为空
									fee.setQuantity(0);
									fee.setPrice(0d);
									fee.setMarketValue(0d);
									//给基金代码赋值
									fee.setFundCode(netValue.getFundCode());
									//给统计日期、赋值增值赋值
									fee.setStatisticDateWhere(netValue.getStatisticDateWhere());
									fee.setValueAdd(0d);
									//给树节点、父类树节点赋值
									fee.setTreeCode(AllUtil.getNetValue(fee).getTreeCode());
									fee.setTreeFatherCode(cashAccount.getTreeCode());
									//给每个账户的成本赋值（账户成本+所有的费用）
									cashAccount.setCosting(fee.getCosting()+cashAccount.getCosting());
									//调用增加的方法（循环增加费用）
									netValueService.insertNetValue(fee);
								}
							}
							//得到现金账户的项目代码,重新赋值给净值统计
							netValue.setCashAccountCode(cashAccount.getProjectCode());
							//查询证券应收应付详情
							NetValue securityArapDetail=netValueService.selectSecurityArapDetail(netValue);
							if(securityArapDetail!=null){
								//得到净值统计的自动生成编号
								securityArapDetail.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
								//给数量、行情、市值、项目名称、基金编号赋值
								securityArapDetail.setQuantity(0);
								securityArapDetail.setProjectName("证券清算款");
								securityArapDetail.setPrice(0d);
								securityArapDetail.setMarketValue(0d);
								securityArapDetail.setFundCode(netValue.getFundCode());
								//给统计日期、估值增值赋值
								securityArapDetail.setStatisticDateWhere(netValue.getStatisticDateWhere());
								securityArapDetail.setValueAdd(0d);
								//给树节点、父类树节点赋值
								securityArapDetail.setTreeCode(AllUtil.getNetValue(securityArapDetail).getTreeCode());
								securityArapDetail.setTreeFatherCode(cashAccount.getTreeCode());
								//给每个账户的成本赋值（账户成本+清算款成本）
								cashAccount.setCosting(securityArapDetail.getCosting()+cashAccount.getCosting());
								//调用增加的方法（证券应收应付详情）
								netValueService.insertNetValue(securityArapDetail);
							}
							//得到净值统计的自动生成编号
							cashAccount.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
							//调用增加到净值统计的方法（增加账户的总信息） 
							netValueService.insertNetValue(cashAccount);
							//循环给现金账户的成本赋值
							xianJinValue.setCosting(cashAccount.getCosting()+xianJinValue.getCosting());
						}
					}
					
					//得到净值统计的自动生成编号
					xianJinValue.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
					//调用增加到净值统计的方法（增加现金的总信息）
					netValueService.insertNetValue(xianJinValue);
					
					
					
					/*
					 * 1.对合计进行计算
					 *   创建一个实体类用来接收合计的数据
					 */
					NetValue heJiNetValue=new NetValue();
					//得到净值统计的自动生成编号
					heJiNetValue.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date",AllUtil.getDate(netValue.getStatisticDateWhere())));
					//给项目代码、项目名称、基金代码，统计日期赋值
					heJiNetValue.setProjectCode(" ");
					heJiNetValue.setProjectName("合计");
					heJiNetValue.setFundCode(netValue.getFundCode());
					heJiNetValue.setStatisticDateWhere(netValue.getStatisticDateWhere());
					//给数量、行情价格、市值、成本、赋值增值赋值
					heJiNetValue.setQuantity(0);
					heJiNetValue.setPrice(0d);
					heJiNetValue.setMarketValue(0d);
					heJiNetValue.setCosting(0d);
					heJiNetValue.setValueAdd(0d);
					//给父类树节点、树节点赋值
					heJiNetValue.setTreeFatherCode(AllUtil.getNetValue(heJiNetValue).getTreeFatherCode());
					heJiNetValue.setTreeCode(AllUtil.getNetValue(heJiNetValue).getTreeCode());
					//调用增加的方法（合计信息）
					netValueService.insertNetValue(heJiNetValue);


					/*
					 * 2.对基金份额进行计算
					 * 	 调用查询TA交易数量的方法
					 */
					Integer taQuantity=netValueService.selectTaQuantity(netValue);
					if(taQuantity==null){
						taQuantity=0;
					}
					if(taQuantity!=null){
						//创建一个实体类用来接收基金总份额的数据
						NetValue taQuantityNetValue=new NetValue();
						//给项目代码、项目名称、基金代码，统计日期赋值
						taQuantityNetValue.setProjectName("基金总份额");
						taQuantityNetValue.setProjectCode(taQuantity+"");
						taQuantityNetValue.setFundCode(netValue.getFundCode());
						taQuantityNetValue.setStatisticDateWhere(netValue.getStatisticDateWhere());
						//给数量、行情价格、市值、估值增值赋值
						taQuantityNetValue.setQuantity(0);
						taQuantityNetValue.setPrice(0d);
						taQuantityNetValue.setMarketValue(0d);
						taQuantityNetValue.setCosting(0d);
						taQuantityNetValue.setValueAdd(0d);
						//得到净值统计的自动生成编号
						taQuantityNetValue.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date", AllUtil.getDate(netValue.getStatisticDateWhere())));
						//给父类树节点、树节点赋值
						taQuantityNetValue.setTreeFatherCode(heJiNetValue.getTreeCode());
						taQuantityNetValue.setTreeCode(AllUtil.getNetValue(taQuantityNetValue).getTreeCode());
						//调用增加的方法（基金数量）
						netValueService.insertNetValue(taQuantityNetValue);
					}
					/*
					 * 3.对负债进行计算
					 * 	 创建一个实体类用来接收负债的数据
					 */
					NetValue fuZhaiNetValue=new NetValue();
					//给项目名称、项目代码（保留三位小数）、基金代码、统计日期赋值
					fuZhaiNetValue.setProjectName("负债");
					fuZhaiNetValue.setProjectCode(AllUtil.scientificCountintMethedToNumber(fuZhai, 3));
					fuZhaiNetValue.setFundCode(netValue.getFundCode());
					fuZhaiNetValue.setStatisticDateWhere(netValue.getStatisticDateWhere());
					//对数量、行情数据、市值、成本、估值增值赋值
					fuZhaiNetValue.setQuantity(0);
					fuZhaiNetValue.setPrice(0d);
					fuZhaiNetValue.setMarketValue(0d);
					fuZhaiNetValue.setCosting(0d);
					fuZhaiNetValue.setValueAdd(0d);
					//得到净值统计的自动生成编号
					fuZhaiNetValue.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date", AllUtil.getDate(netValue.getStatisticDateWhere())));
					fuZhaiNetValue.setTreeFatherCode(heJiNetValue.getTreeCode());
					fuZhaiNetValue.setTreeCode(AllUtil.getNetValue(fuZhaiNetValue).getTreeCode());
					netValueService.insertNetValue(fuZhaiNetValue);


					/*
					 * 4.对资产合计进行
					 *   创建一个实体类用来接收资产合计的数据
					 */
					NetValue ziChanHeJiNetValue=new NetValue();
					//给项目名称赋值
					ziChanHeJiNetValue.setProjectName("资产合计");
					//将负债转为Double类型
					fuZhai=Double.parseDouble(fuZhaiNetValue.getProjectCode());
					//定义一个变量用来接收资产合计的数据
					Double ziChanHeJi=null;
					//判断证券头部信息为空，资产合计=现金成本+负债
					if(securityAll==null||securityAll.equals("")){
						ziChanHeJi=0+xianJinValue.getCosting()+fuZhai;
					}
					//判断现金头部信息为空，资产合计=证券成本+负债
					else if(xianJinValue==null||xianJinValue.equals("")){
						ziChanHeJi=securityAll.getMarketValue()+0+fuZhai;
					}else{
						//资产合计(现金总金额+证券总金额+负债)
						ziChanHeJi=securityAll.getMarketValue()+xianJinValue.getCosting()+fuZhai;
					}
					//给项目代码（保留三位小数）、基金代码、统计日期赋值
					ziChanHeJiNetValue.setProjectCode(AllUtil.scientificCountintMethedToNumber(ziChanHeJi,3));
					ziChanHeJiNetValue.setFundCode(netValue.getFundCode());
					ziChanHeJiNetValue.setStatisticDateWhere(netValue.getStatisticDateWhere());
					//给数量、行情价格、市值、成本、估值增值赋值
					ziChanHeJiNetValue.setQuantity(0);
					ziChanHeJiNetValue.setPrice(0d);
					ziChanHeJiNetValue.setMarketValue(0d);
					ziChanHeJiNetValue.setCosting(0d);
					ziChanHeJiNetValue.setValueAdd(0d);
					//得到净值统计的自动生成编号
					ziChanHeJiNetValue.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date", AllUtil.getDate(netValue.getStatisticDateWhere())));
					//给父类树节点、树节点赋值
					ziChanHeJiNetValue.setTreeFatherCode(heJiNetValue.getTreeCode());
					ziChanHeJiNetValue.setTreeCode(AllUtil.getNetValue(ziChanHeJiNetValue).getTreeCode());
					//调用增加的方法（资产合计）
					netValueService.insertNetValue(ziChanHeJiNetValue);


					/*
					 * 5.对资产净值进行计算
					 *   创建一个实体类用来接收资产合计的数据
					 */
					NetValue ziChanJingZhiNetValue=new NetValue();
					//得到资产合计，并且转成double类型
					ziChanHeJi=Double.parseDouble(ziChanHeJiNetValue.getProjectCode());
					//定义一个变量用来计算资产净值(资产合计-负债)
					Double ziChanJingZhi=ziChanHeJi-fuZhai;
					//给项目代码（保留3位小数）、项目名称、统计日期赋值
					ziChanJingZhiNetValue.setProjectCode(AllUtil.scientificCountintMethedToNumber(ziChanJingZhi,3));
					ziChanJingZhiNetValue.setFundCode(netValue.getFundCode());
					ziChanJingZhiNetValue.setProjectName("资产净值");
					ziChanJingZhiNetValue.setStatisticDateWhere(netValue.getStatisticDateWhere());
					//给数量、行情价格、市值、成本、估值增值赋值
					ziChanJingZhiNetValue.setQuantity(0);
					ziChanJingZhiNetValue.setPrice(0d);
					ziChanJingZhiNetValue.setMarketValue(0d);
					ziChanJingZhiNetValue.setCosting(0d);
					ziChanJingZhiNetValue.setValueAdd(0d);
					//得到净值统计的自动生成编号
					ziChanJingZhiNetValue.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date", AllUtil.getDate(netValue.getStatisticDateWhere())));
					//给父类树节点、树节点赋值
					ziChanJingZhiNetValue.setTreeFatherCode(heJiNetValue.getTreeCode());
					ziChanJingZhiNetValue.setTreeCode(AllUtil.getNetValue(ziChanJingZhiNetValue).getTreeCode());
					 //调用增加的方法（资产净值）
					netValueService.insertNetValue(ziChanJingZhiNetValue);


					/*
					 * 6.对单位净值进行计算
					 *   创建一个实体类用来重新赋值
					 */
					NetValue danWeiJingZhiNetValue=new NetValue();
					//得到资产净值
					ziChanJingZhi=Double.parseDouble(ziChanJingZhiNetValue.getProjectCode());
					//定义一个变量用来计算单位净值(资产净值/数量)
					Double util=0d;
					if(taQuantity==0){
						util=ziChanJingZhi/1;
					}else{
						util=ziChanJingZhi/taQuantity;
					}
					//给项目代码（保留3位）、项目名称、基金代码、统计日期赋值
					danWeiJingZhiNetValue.setProjectCode(AllUtil.scientificCountintMethedToNumber(util,3));
					danWeiJingZhiNetValue.setProjectName("单位资产净值");
					danWeiJingZhiNetValue.setFundCode(netValue.getFundCode());
					danWeiJingZhiNetValue.setStatisticDateWhere(netValue.getStatisticDateWhere());
     				//给数量、行情价格、市值、成本、估值增值赋值
					danWeiJingZhiNetValue.setQuantity(0);
					danWeiJingZhiNetValue.setPrice(0d);
					danWeiJingZhiNetValue.setMarketValue(0d);
					danWeiJingZhiNetValue.setCosting(0d);
					danWeiJingZhiNetValue.setValueAdd(0d);
					//得到净值统计的自动生成编号
					danWeiJingZhiNetValue.setNetValueCode(autoBianService.getAutoBianhao("net_value", "JZTJ", "net_value_code", "statistic_date", AllUtil.getDate(netValue.getStatisticDateWhere())));
					//给父类树节点、树节点赋值
					danWeiJingZhiNetValue.setTreeFatherCode(heJiNetValue.getTreeCode());
					danWeiJingZhiNetValue.setTreeCode(AllUtil.getNetValue(danWeiJingZhiNetValue).getTreeCode());
					//调用增加个方法（单位资产净值）
					netValueService.insertNetValue(danWeiJingZhiNetValue);
				}
				return "统计成功";

			}else{
				return "基金代码、日期为空";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			//调用删除的方法
			netValueService.deleteNetValue(netValue);
			return "统计失败";
		}
	}
	/**
	 * 判断是否是节假日
	 * @param response 响应对象
	 * @param request 请求对象
	 * @param netValue 净值统计实体对象
	 * @return 是否是节假日
	 * @throws Exception 所有异常
	 */
	@ResponseBody
	@RequestMapping(value="/isHoilday.action")
	public String isHoilday(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")NetValue netValue) throws Exception{
		//得到统计日期
		String date=netValue.getStatisticDateWhere();
		//判断统计日期是否是节假日
		List<HoildayXiao> hoildayXiaoList=hoildayXiaoSerice.selectHoildayBydate(date);
		if(hoildayXiaoList.size()!=0){
			return null;
		}else{
			return "不是节假日";
		}


	}
	/**
	 * 净值统计导出
	 * @param response 响应对象
	 * @param request 请求对象
	 * @param netValue 净值统计实体对象
	 * @return 字符
	 * @throws Exception 所有异常
	 * 
	 * @author 肖光宇
	 * @date 2017年11月19日
	 * @time 上午8:29:02
	 */
	@ResponseBody
	@RequestMapping(value="/exeportNetValue.action")
	public String exeportNetValue(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")NetValue netValue) throws Exception{
		//创建Session会话
		HttpSession session=request.getSession(false);
		if(session==null){
			session=request.getSession(true);
		}
		System.err.println("netValue="+netValue.getStatisticDate());
		//设置页面类型
		response.setContentType("octets/stream");
		List<NetValue> secondList=(List<NetValue>) session.getAttribute("secondList");//得到数据
		//循环遍历
		for (NetValue twoList :secondList) {
			//基金名称
			String fundName=fundDao.selectFundName(twoList.getFundCode());
			netValue.setStrFundName(fundName);
			netValue.setStrFundCode(twoList.getFundCode());
			if(twoList.getProjectName().equals("资产净值")){
				//得到资产净值
				String money=twoList.getProjectCode();
				netValue.setStrTotalMoney(money);
			}
			if(twoList.getProjectName().equals("单位资产净值")){
				//得到单位资产净值
				String danWeiMoney=twoList.getProjectCode();
				netValue.setStrMoney(danWeiMoney);
			}

		}
		ExeportNetValue exeportNetValue=new ExeportNetValue();
		//得到应用上下文路径
		String strPath=request.getServletContext().getRealPath("/")+"xlsx\\基金净值统计数据模板.xlsx";
		try{
			exeportNetValue.getSheet(strPath,netValue);
			//得到文件保存的目录
			String realpath = request.getSession().getServletContext().getRealPath("/xlsx");
			//创建每天的文件夹
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			realpath =realpath +"\\netvalue"+format.format(new java.util.Date(System.currentTimeMillis()))+".xlsx";
			File pathFile = new File(realpath);
			exeportNetValue.exportToNewFile(realpath);//导出
			autoBianService.downLoad(realpath, request, response);
			return "导出成功";
		}
		catch(Exception e){
			return "导出失败";
		}
	}

}
