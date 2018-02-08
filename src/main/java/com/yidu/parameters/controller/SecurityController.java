package com.yidu.parameters.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.yidu.parameters.domain.Security;
import com.yidu.parameters.domain.StockPlate;
import com.yidu.parameters.service.SecurityService;
import com.yidu.parameters.service.StockPlateService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;


/**
 *证券信息的控制器类 
 * @author 杨丽
 * @date 2017年11月20日	
 * @time 下午3:11:44
 *
 */
@Controller
public class SecurityController {
	@Autowired
	SecurityService securityService;
	@Autowired
	AutoBianService autoBianService;
	@Autowired
	StockPlateService stockPlateService;
	/**
	 * 查询所有证劵信息
	 * @param response	响应参数
	 * @param request	请求参数
	 * @param bond	债劵信息对象
	 * @return	返回一个json对象
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="selectSecuritys.action")
	public HashMap<String,Object> selectSecuritys(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")Security security) throws Exception{
		System.out.println("查询的方法");	
		//判断时间不为空   将string类型转为date类型赋值到发行日期
		if(security.getPublishDates()!=null && !security.getPublishDates().equals("")){
				security.setPublishDate(AllUtil.getDate(security.getPublishDates()));	
		}
		//得到拼接的条件
		String sqlWhere=securityService.bufferWhere(security);
		//new一个hashmap 调用查询方法
		HashMap<String,Object> map=securityService.selectSecuritys("security", sqlWhere,security.getPage(),security.getRows(),security.getRowsTotal(),security.getOrderColumn(),security.getOrderStyle());
		System.out.println(security.getTableName());
		//创建一个集合
		List<Security> list=(List<Security>) map.get("securityList");
		System.out.println("list sb ,MMM"+list);
		//循环遍历集合  将将时间set赋值到网页发行日期和延迟日期
		for(Security securitys:list){
			securitys.setPublishDates(securitys.getPublishDate().toString());
			securitys.setDelayDates(securitys.getDelayDate().toString());
		}
		//new一个hashmap
		HashMap<String,Object> jsonMap=new HashMap<String,Object>();
		System.out.println(jsonMap);
		//总条数
		jsonMap.put("total",map.get("rowsTotal"));
		//所有list数据
		jsonMap.put("rows",list);
		
		return jsonMap;
	}
	
	/**
	 * 增加证劵信息的方法
	 * @param response	响应参数
	 * @param request	请求参数
	 * @param bond	证劵信息对象
	 * @return	返回1	增加成功 返回0	增加失败
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="insertSecuritys.action")
	public String insertSecurity(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")Security security)throws Exception{
		System.out.println(security);
		System.out.println("增加的方法");
		//判断发行和延迟日期不为空
		if(security.getPublishDates()!=null && !security.getPublishDates().equals("")){
			security.setPublishDate(AllUtil.getDate(security.getPublishDates()));	
		}
		if(security.getDelayDates()!=null && !security.getDelayDates().equals("")){
			security.setDelayDate(AllUtil.getDate(security.getDelayDates()));	
		}
		//定义值接收
		int flag=securityService.insertSecurity(security);
		System.out.println(security);
		//判断成功或者失败
		if(flag!=0){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 通过证劵id删除的方法
	 * @param response	响应参数
	 * @param request	请求参数
	 * @param security	证劵信息对象
	 * @return	返回0 删除失败 返回大于0 删除成功
	 * @throws Exception	抛出异常	
	 */
	@ResponseBody
	@RequestMapping(value="deleteSecurityByIds.action")
	public String deleteSecurityByIds(HttpServletResponse response,HttpServletRequest request)throws Exception{
		//得到证券id
		String securityCode=request.getParameter("securityCode");
		//创建数组
		String [] arr=securityCode.split(",");
		//定义一个变量
		int size=0;
		//循环遍历数组
		for (int i = 0; i < arr.length; i++) {
			size=securityService.deleteSecurityByIds(arr[i]); 
		}
		//返回成功或失败
		if(size!=0){
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	/**
	 *修改证劵信息的方法 
	 * @param response	响应参数
	 * @param request	请求参数
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="updateSecurity.action")
	public void updateSecurity(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")Security security)throws Exception{
		//判断发行和延迟日期不为空
		if(security.getPublishDates()!=null && !security.getPublishDates().equals("")){
			security.setPublishDate(AllUtil.getDate(security.getPublishDates()));	
		}
		if(security.getDelayDates()!=null && !security.getDelayDates().equals("")){
			security.setDelayDate(AllUtil.getDate(security.getDelayDates()));	
		}
		//调用修改的方法
		securityService.updateSecurity(security);
	}
	/**
	 * 通过id查询证劵信息
	 * @param response	响应对象
	 * @param request	请求对象
	 * @param security	证劵信息对象
	 * @throws Exception	抛出异常
	 */
	@ResponseBody
	@RequestMapping(value="selectSecurityByIds.action")
	public Security selectSecurityByIds(HttpServletResponse response,HttpServletRequest request,@ModelAttribute("SpringWeb")Security security)throws Exception{
		//调用通过id查询的方法	得到id
		security=securityService.selectSecurityByIds(security.getSecurityCode());
		//判断发行和延迟日期不为空
		if(security.getPublishDate()!=null && !security.getPublishDate().equals("")){
			security.setPublishDates(AllUtil.getStringDate(security.getPublishDate()));	
		}
		if(security.getDelayDate()!=null && !security.getDelayDate().equals("")){
			security.setDelayDates(AllUtil.getStringDate(security.getDelayDate()));	
		}
		System.out.println(security.getPublishDates());
		System.out.println(security.getDelayDates());
		System.out.println(security.getSecurityCode());

		return security;
	}
	
	/**
	 * 证券信息设置导入的方法
	 * @param request	请求对象
	 * @param response	响应对象
	 * @return		网页路径
	 * @throws Exception	抛出异常
	 */
	@RequestMapping(value="securityReadExcel.action")
	public ModelAndView  SecurityReadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		//创建一个集合
		ArrayList<Security> securityList=new ArrayList<Security>();
		//创建工作簿
		String str=autoBianService.upload(request, response, "file");
		//new一个file
		File file = new File(str);
		String fileType = str.substring(str.lastIndexOf(".")+1);
		//定义一个wb
		Workbook workbook = null;
		InputStream is = new FileInputStream(str);
		System.out.println("fileType"+fileType);
		if (fileType.equalsIgnoreCase("xlsx")) {
			workbook = new XSSFWorkbook(is);
		}else if(fileType.equalsIgnoreCase("xls")){
			workbook = new HSSFWorkbook(is);
		}else {
			throw new Exception("暂时只支持xlsx和xls格式的excel读取");
		}
		System.out.println("workbook.getNumberOfSheets()"+workbook.getNumberOfSheets());
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
			Sheet sheetAt = workbook.getSheetAt(numSheet);
			if (sheetAt == null) {
				continue;
			}
			// 循环行Row
			System.out.println("sheetAt.getLastRowNum():"+sheetAt.getLastRowNum());
			
			for (int rowNum = 1; rowNum <= sheetAt.getLastRowNum()-2; rowNum++) {
				Row row = sheetAt.getRow(rowNum);
				if (row != null) {
					Cell  cell=row.getCell(0);
					Cell  cell1=row.getCell(1);
					Cell  cell2=row.getCell(2);
					Cell  cell3=row.getCell(3);
					Cell  cell4=row.getCell(4);
					Cell  cell5=row.getCell(5);
					Cell  cell6=row.getCell(6);
					Cell  cell7=row.getCell(7);
					
					
					//new实体类
					Security security=new Security();
					security.setSecurityCode(cell+"");	
					security.setSecurityName(cell1+"");
					
					
					String i=cell4+"";
					if(i=="股票"){
						security.setSecurityType(1);
					}else{
						security.setSecurityType(2);
					}
					
					String p=cell5+"";
					if(i=="上交所"){
						security.setExchangeName(1);
					}else{
						security.setExchangeName(2);
					}
					security.setPublishDate(AllUtil.getDate(cell2+""));
					security.setDelayDate(AllUtil.getDate(cell3+""));
					security.setStockPlateCode(cell6+"");
					security.setSecurityDesc(cell7+"");
					//将实体类添加到集合里
					securityList.add(security);
				}
			}
		}
		//循环遍历集合大小
		for (int j = 0; j < securityList.size(); j++) {
			Security securitys=securityList.get(j);
			securityService.insertSecurity(securitys);
			
			
			
		}
		
		
		return new ModelAndView("redirect:jsp/security.jsp");
		
	} 
	@ResponseBody
	@RequestMapping(value="getSelect.action")
	public List<StockPlate>  getSelect(){
		System.err.println("查询的方法");
		//得到股票父功能id
		StockPlate stockPlate=new StockPlate();
		stockPlate.setStockBlockCode("");
		stockPlate.setStockBlockName("");
		//调用股票查询方法
		List<StockPlate> stockPlates=stockPlateService.selectStockPlates(stockPlate);
		//循环遍历股票集合
		for (StockPlate stock : stockPlates) {
			stock.setId(stock.getStockBlockCode());
			stock.setText(stock.getStockBlockName());
			List<StockPlate> stockPlatesList=stockPlateService.selectStockPlatesById(stock.getStockBlockCode());
			for (StockPlate stockPlate2 : stockPlatesList) {
				stockPlate2.setId(stockPlate2.getStockBlockCode());
				stockPlate2.setText(stockPlate2.getStockBlockName());
			}
			stock.setChildren(stockPlatesList);
		}
		
		return stockPlates;
	}
}
