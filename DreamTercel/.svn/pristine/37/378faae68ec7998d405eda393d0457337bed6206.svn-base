package com.yidu.taManagement.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.yidu.cashManagement.dao.MoneyAllotDao;
import com.yidu.cashManagement.domain.MoneyAllot;
import com.yidu.cashManagement.service.MoneyAllotService;
import com.yidu.parameters.dao.FundDao;
import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.service.FundService;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.system.service.HoildayXiaoSerice;
import com.yidu.taManagement.domain.TaTradData;
import com.yidu.taManagement.service.TaTradDataService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;

/**
 * TA交易数据的控制类
 * @author  ZhouMuJiao
 * @date2017年11月16日
 * @time下午4:46:02
 */
@Controller
public class TaTradDataController {
	/**
	 * 查询
	 */
	@Autowired
	TaTradDataService taTradDataService;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	FundService fundService;
	@Autowired
	MoneyAllotDao moneyAllotDao;//调用资金调拨
	@Autowired
	MoneyAllotService moneyAllotService;
	@Autowired
	HoildayXiaoSerice hoildayXiaoSerice;
	@Autowired
	FundDao fundDao;//注入基金操作类


	@ResponseBody
	@RequestMapping(value="/selectTaTradData.action",produces="text/html;charset=UTF-8")
	public String selectTaTradData(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaTradData taTradData) throws Exception{
		String tableName="((select * from ta_trad_data ta  join fund f on ta.fund_code=f.fund_code))";
		HttpSession session=request.getSession(false);
		//判断session是否为空
		if(session==null){
			session=request.getSession(true);
		}
		//得到登录时候的基金
		Fund fund=(Fund) session.getAttribute("fund");
		if(fund==null){
			//得到基金代码
			taTradData.setFundCode("000363");
		}else{
			taTradData.setFundCode(fund.getFundCode());
		}
		String bufferWhere = taTradDataService.bufferWhere(taTradData);
		//String sqlWhere=taTradDataService.bufferWhere(taTradData);
		//调用查询的方法，返回一个HashMap
		HashMap<String, Object> map=taTradDataService.selectTaTradData(tableName, bufferWhere, 
				taTradData.getPage(), taTradData.getRows(),"","");
		@SuppressWarnings("unchecked")
		//通过map得到一个集合
		List<TaTradData> taTradDataList=(List<TaTradData>) map.get("taTradDataList");
		//for循环得到的集合
		for (TaTradData taTradDataEntity:taTradDataList) {
			//将日期转换为字符串
			taTradDataEntity.setSettlesDate(AllUtil.getStringDate(taTradDataEntity.getSettleDate()));//结算日期
			taTradDataEntity.setTradeDate(AllUtil.getStringDate(taTradDataEntity.getTaTradeDate()));//交易日期

		}
		//创建Gson
		Gson gson=new Gson();
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", map.get("taTradDataList"));
		//集合转成gson对象
		return gson.toJson(jsonMap);
	}
	/**
	 * 删除
	 * @param response 响应对象
	 * @param request  请求对象
	 * @param taTradData TA交易数据实体类
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/deleteTaTradDataByTaTradDataId.action",produces="text/html;charset=UTF-8")
	public String deleteTaTradDataByTaTradDataId(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaTradData taTradData) throws Exception{
	//调用删除的方法，返回一个int
		int i=taTradDataService.deleteTaTradDataByTaTradDataId(taTradData.getTaTradDataCode());
		if(i>0){
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	/**
	 * 修改
	 * @param response 响应对象
	 * @param request 请求对象
	 * @param taTradData TA交易数据实体类
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/updateTaTradData.action")
	public String updateTaTradData(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaTradData taTradData)throws Exception{
		//将日期转换为字符串
		taTradData.setTaTradeDate(AllUtil.getDate(taTradData.getTradeDate()));
		taTradData.setSettleDate(AllUtil.getDate(taTradData.getSettlesDate()));
		int size=taTradDataService.updateTaTradData(taTradData);
		if(size>0){
			return "修改成功";
		}else{
			return "修改失败";
		}
	}
	/**
	 * 增加
	 * @param response响应对象
	 * @param request 请求对象
	 * @param taTradData TA交易数据实体类
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertTaTradData.action")
	public String insertTaTradData(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaTradData taTradData)throws Exception{
		taTradData.setTaTradDataDesc("");
		response.setCharacterEncoding("UTF-8");
		//判断它是否为空
		if(taTradData.getTradeDate()!=null && !taTradData.getTradeDate().equals("")){
			//将日期转换为字符串
			taTradData.setTaTradeDate(AllUtil.getDate(taTradData.getTradeDate()));
		}
		//判断它是否为空
		if(taTradData.getSettlesDate()!=null && !taTradData.getSettlesDate().equals("")){
			//将日期转换为字符串
			taTradData.setSettleDate(AllUtil.getDate(taTradData.getSettlesDate()));
		}
		//调用修改的方法，返回一个int
		int size=taTradDataService.insertTaTradData(taTradData);
		if(size!=0){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 根据Id查询
	 * @param response 响应对象
	 * @param request 请求对象
	 * @param taTradData TA交易数据实体类
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectTaTradDataById.action")
	public TaTradData selectTaTradDataById(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaTradData taTradData)throws Exception{
		TaTradData data= taTradDataService.selectTaTradDataById(taTradData.getTaTradDataCode());
		data.setSettlesDate(AllUtil.getStringDate(data.getSettleDate()));
		data.setTradeDate(AllUtil.getStringDate(data.getTaTradeDate()));
		return data;
	}
	/**
	 * TA 数据结算方法
	 * @param response  响应对象
	 * @param request	请求对象
	 * @param taTradData	数据
	 * @return		返回标志   成功或者失败
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="/taTradeSettle.action")
	public String taTradeSettle(HttpServletResponse response,HttpServletRequest request,HttpSession session,@ModelAttribute("SpringWeb")TaTradData taTradData)throws Exception{
		//把得到的ID按照点切割
		String[] split = taTradData.getTaTradDataCode().split(",");
		//创建list集合进行装载按ID查询的数据
		int updateTaTradDataById=0;
		//资金调拨方向状态
		int insertMoneyAllot =0;
		//自动生成编号
		//得到session中的基金ID
		Fund fund=(Fund) session.getAttribute("fund");
		//for循环根据ID进行数据查找
		for (int i = 0; i < split.length; i++) {
			TaTradData selectTaTradDataById = taTradDataService.selectTaTradDataById(split[i]);
			//修改交易数据的状态 已结算
			selectTaTradDataById.setTaTradeStatus(1);
			updateTaTradDataById=taTradDataService.updateStatus(selectTaTradDataById);
			Date settleDate = selectTaTradDataById.getSettleDate();
			if(updateTaTradDataById!=0){
				Integer direction = null;
				if(selectTaTradDataById.getTaRadeType()==1){
					direction=1;
				}else if(selectTaTradDataById.getTaRadeType()==2){
					direction=1;
				}else if(selectTaTradDataById.getTaRadeType()==3){
					direction=-1;
				}
				//自动增长列
				String autoBianhao =autoBianService.getAutoBianhao("fund_allot", "ZJDB", "fund_allot_code", "business_date",selectTaTradDataById.getSettleDate());
				
				MoneyAllot moneyAllot=new MoneyAllot(autoBianhao,fund.getFundCode(), 
						selectTaTradDataById.getTaRealMoney(), selectTaTradDataById.getCashAccountCode(), 
						direction, settleDate, selectTaTradDataById.getTaTradeDate(), selectTaTradDataById.getTaTradDataCode(), 
						selectTaTradDataById.getTaRadeType(),"2222");
				insertMoneyAllot = moneyAllotDao.insertMoneyAllot(moneyAllot);
			}
		}
		if(insertMoneyAllot>0&&updateTaTradDataById>0){
			return "TA结算成功";
		}else{
			return "TA结算失败";
		}
	}
	/**
	 * TA 数据反结算方法
	 * @param response  响应对象
	 * @param request	请求对象
	 * @param taTradData	数据
	 * @return		返回标志   成功或者失败
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="/taReTradeSettle.action")
	public String taReTradeSettle(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaTradData taTradData)throws Exception{
		//把得到的ID按照点切割
		String[] split = taTradData.getTaTradDataCode().split(",");
		//创建list集合进行装载按ID查询的数据
		int updateTaTradDataById=0;
		int deleteMoneyAllot=0;
		//for循环根据ID进行数据查找
		for (int i = 0; i < split.length; i++) {
			//根据得到的数据ID进行查找对应的数据
			TaTradData selectTaTradDataById = taTradDataService.selectTaTradDataById(split[i]);
			//修改交易数据的状态 已结算
			selectTaTradDataById.setTaTradeStatus(2);
			updateTaTradDataById=taTradDataService.updateStatus(selectTaTradDataById);
			if(updateTaTradDataById>0){
				MoneyAllot moneyAllot=new MoneyAllot();
				moneyAllot.setBusinessCode(selectTaTradDataById.getTaTradDataCode());
				deleteMoneyAllot = moneyAllotDao.deleteAllotCode(moneyAllot);
			}
		}
		if(deleteMoneyAllot>0){
			return "TA反结算成功";
		}else{
			return "TA反结算失败";
		}
	}
	@ResponseBody
	@RequestMapping(value="/taReTradeByFundId.action",produces="text/html;charset=UTF-8")
	public void taReTradeByFundId(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaTradData taTradData) throws Exception {
		HttpSession session=request.getSession(false);
		Fund fund=(Fund) session.getAttribute("fund");
		String fundCode=fund.getFundCode();
		response.getWriter().print(fundCode);
	}
	/**
	 * 查询交易结算日
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param taTradData TA交易数据
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/taTradeData/selectHoildayByDradeDate.action",produces="text/html;charset=UTF-8")
	public String selectHoildayByDradeDate(@ModelAttribute("springWeb") TaTradData taTradData) throws Exception {
		List<HoildayXiao> hoildayXiaoList=null;
		String strDealDate=taTradData.getTradeDate();
		//strDealDate=AllUtil.getStringDate(AllUtil.getDate(strDealDate, taTradData.getTaRadeType()));
		for (int i = 0; i <taTradData.getTaRadeType(); i++) {
			do {
				strDealDate = AllUtil.getStringDate(AllUtil.getDate(strDealDate,1));
				hoildayXiaoList=hoildayXiaoSerice.selectHoildayBydate(strDealDate);
			} while (hoildayXiaoList.size()!=0);
		}


		return strDealDate;
	}
	/**
	 * 自动增长
	 * @param response 响应对象
	 * @param request 请求对象
	 * @param taTradData TA交易数据
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/ziDongShengChengBH.action",produces="text/html;charset=utf-8")
	public void ziDongShengCheng(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")TaTradData taTradData)throws Exception{
		String taTradDataCode=autoBianService.getAutoBianhao("ta_trad_data", "TAJYSJ", "ta_trad_data_code", "Ta_Trade_date",taTradData.getTaTradeDate());
		response.getWriter().print(taTradDataCode);
	}
	/**
	 * *TA申购的导入
	 * @param file 
	 * @return	TA交易数据的集合
	 * @throws Exception 
	 */
	@SuppressWarnings("resource")
	@RequestMapping(value="/TaTradeDataUpload.action",produces="text/html;charset=utf-8")
	public ModelAndView TaTradeDataUpload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//创建工作簿
		String str=autoBianService.upload(request, response, "file");
		String fileType=str.substring(str.lastIndexOf(".")+1);
		Workbook workbook=null;
		//从输入流得到工作簿
		InputStream is=new FileInputStream(str);
		if(fileType.equalsIgnoreCase("xlsx")){
			workbook=new XSSFWorkbook(is);
		}else if(fileType.equalsIgnoreCase("xls")){
			workbook=new HSSFWorkbook(is);
		}else{
			throw new Exception("暂时只支持xlsx和xls格式");
		}
		TaTradData taTradData1=null;
		String autoBianhao = "";
		//循环工作表Sheet
		for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
			Sheet sheet=workbook.getSheetAt(numSheet);
			if(sheet==null){
				continue;
			}
			//循环工作表row
			for (int rowNum = 1; rowNum <=sheet.getLastRowNum(); rowNum++) {
				Fund fund=new Fund();//创建基金实体类
				Row row=sheet.getRow(rowNum);
				if(row !=null){
					String taTradeDates=row.getCell(1)+"";//交易时间  需要转成yyyy-MM-DD
					Cell fundCode=row.getCell(3);//基金代码
					String agencies=row.getCell(5)+"";//代销的机构的Code（外键）		1建行2农行3工行
					Cell taTotalMoney=row.getCell(6);//总金额	default 0	你应该交易多少钱？？？
					Cell taRealMoney=row.getCell(7);//实际交收的金额
					Cell fee=row.getCell(8);//费用	default 0	额外的费用 如佣金 手续费呀
					Cell taTradQuality=row.getCell(11);//基金的数量

					fund.setFundCode(fundCode+"");//得到的基金代码赋值给基金实体类
					Fund selectFundByCode = fundDao.selectFundByCode(fund);//基金数据

					//通过交易时间得到结算时间
					//设置日期格式
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					//将从dbf文件读取出的   成交日期   转换成   日期类型
					Date date=new Date(sdf.parse(taTradeDates).getTime());
					//将结算日期转化成   日期类型
					//Date date2=sdf.parse(setAccountDate);
					//重新设置日期格式
					sdf.applyPattern("yyyy-MM-dd");
					//将转化后的   成交  日期    转化成字符类型
					taTradeDates=sdf.format(date);//成交日期的最新格式  yyyy-MM-dd
					Date taTradeDate = AllUtil.getDate(taTradeDates);//得到交易日期
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
					List<HoildayXiao> hoildayXiaoList=null;
					Date settleDate=taTradeDate;//结算时间等于交易时间
					String format2=AllUtil.getStringDate(settleDate);
					for (int i = 0; i <2; i++) {
						do {
							settleDate = AllUtil.getDate(format2,1);
							format2 = dateFormat.format(settleDate);//把结算日期转成字符串
							hoildayXiaoList=hoildayXiaoSerice.selectHoildayBydate(format2);//查询数据库中是否拥有此日期
						} while (hoildayXiaoList.size()!=0);
					}
					//得到代销机构
					if (agencies.equals("建行")) {
						agencies="1";
					}else if(agencies.equals("农行")){
						agencies="2";
					}else{
						agencies="3";
					}
					//调用自动生成编号的方法
					if (autoBianhao==null||autoBianhao.equals("")) {
						autoBianhao = autoBianService.getAutoBianhao("ta_trad_data", "TAJYSJ", "ta_trad_data_code", "ta_trade_date",taTradeDate);
					}else{
						autoBianhao=AllUtil.getLocalhostAutoBianHao(autoBianhao);
					}

					taTradData1=new TaTradData(autoBianhao, fundCode+"", Double.parseDouble(taTradQuality+""),
							selectFundByCode.getCashAccountCode()+"", Double.parseDouble(taTotalMoney+""),
							Double.parseDouble(taRealMoney+""), taTradeDate, 
							settleDate, Double.parseDouble(taRealMoney+"")/Double.parseDouble(taTradQuality+""), 
							Double.parseDouble(fee+""), agencies, 2, 2, "");
				}
				taTradDataService.insertTaTradData(taTradData1);
			}
		}
		return new ModelAndView("redirect:jsp/taTradeData.jsp");
	}
	/**
	 * *TA赎回的导入
	 * 	  @param file 
	 * @return	TA交易数据的集合
	 * @throws Exception 
	 */
	@SuppressWarnings("resource")
	@RequestMapping(value="/TaTradeDataTaShOutputUpload.action",produces="text/html;charset=utf-8")
	public ModelAndView TaTradeDataTaShOutputUpload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//创建工作簿
		String str=autoBianService.upload(request, response, "file");
		String fileType=str.substring(str.lastIndexOf(".")+1);
		Workbook workbook=null;
		//从输入流得到工作簿
		InputStream is=new FileInputStream(str);
		if(fileType.equalsIgnoreCase("xlsx")){
			workbook=new XSSFWorkbook(is);
		}else if(fileType.equalsIgnoreCase("xls")){
			workbook=new HSSFWorkbook(is);
		}else{
			throw new Exception("暂时只支持xlsx和xls格式");
		}
		TaTradData taTradData1=null;
		String autoBianhao="";
		//循环工作表Sheet
		for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
			Sheet sheet=workbook.getSheetAt(numSheet);
			if(sheet==null){
				continue;
			}

			//循环工作表row
			for (int rowNum = 1; rowNum <=sheet.getLastRowNum(); rowNum++) {
				Fund fund=new Fund();//创建基金实体类
				Row row=sheet.getRow(rowNum);
				if(row !=null){
					String taTradeDates=row.getCell(1)+"";//交易时间  需要转成yyyy-MM-DD
					Cell fundName=row.getCell(2);//基金名称
					Cell fundCode=row.getCell(3);//基金代码
					String agencies=row.getCell(5)+"";//代销的机构的Code（外键）		1建行2农行3工行
					Cell taTradQuality=row.getCell(6);//基金的数量
					Cell taTotalMoney=row.getCell(7);//总金额	default 0	你应该交易多少钱？？？  赎回份额
					Cell fee=row.getCell(8);//费用	default 0	额外的费用 如佣金 手续费呀
					Cell taRealMoney=row.getCell(14);//实际交收的金额
					fund.setFundCode(fundCode+"");
					Fund selectFundByCode = fundDao.selectFundByCode(fund);//基金数据

					//通过交易时间得到结算时间
					//设置日期格式
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					//将从dbf文件读取出的   成交日期   转换成   日期类型
					Date date=new Date(sdf.parse(taTradeDates).getTime());
					//将结算日期转化成   日期类型
					//Date date2=sdf.parse(setAccountDate);
					//重新设置日期格式
					sdf.applyPattern("yyyy-MM-dd");
					//将转化后的   成交  日期    转化成字符类型
					taTradeDates=sdf.format(date);//成交日期的最新格式  yyyy-MM-dd
					Date taTradeDate = AllUtil.getDate(taTradeDates);//得到交易日期
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
					//							String format = dateFormat.format(taTradeDate);//交易date  转字符串
					List<HoildayXiao> hoildayXiaoList=null;
					Date settleDate=taTradeDate;//结算时间等于交易时间
					String format2=AllUtil.getStringDate(settleDate);
					for (int i = 0; i <3; i++) {
						do {
							settleDate = AllUtil.getDate(format2,1);
							format2 = dateFormat.format(settleDate);//把结算日期转成字符串
							hoildayXiaoList=hoildayXiaoSerice.selectHoildayBydate(format2);//查询数据库中是否拥有此日期
						} while (hoildayXiaoList.size()!=0);
					}
					//得到代销机构
					if (agencies.equals("建行")) {
						agencies="1";
					}else if(agencies.equals("农行")){
						agencies="2";
					}else{
						agencies="3";
					}

					//调用自动生成编号的方法
					if (autoBianhao==null||autoBianhao.equals("")) {
						autoBianhao = autoBianService.getAutoBianhao("ta_trad_data", "TAJYSJ", "ta_trad_data_code", "ta_trade_date",taTradeDate);
					}else{
						autoBianhao=AllUtil.getLocalhostAutoBianHao(autoBianhao);
					}

					taTradData1=new TaTradData(autoBianhao, fundCode+"", Double.parseDouble(taTradQuality+""),
							selectFundByCode.getCashAccountCode()+"", Double.parseDouble(taTotalMoney+""),
							Double.parseDouble(taRealMoney+""), taTradeDate, 
							settleDate, Double.parseDouble(taRealMoney+"")/Double.parseDouble(taTradQuality+""), 
							Double.parseDouble(fee+""), agencies, 3, 2, "");
				}
				taTradDataService.insertTaTradData(taTradData1);
			}
		}
		return new ModelAndView("redirect:jsp/taTradeData.jsp");
	}
}
