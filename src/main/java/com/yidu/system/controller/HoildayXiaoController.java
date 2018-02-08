package com.yidu.system.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.system.domain.HoildayXiao;
import com.yidu.system.domain.Role;
import com.yidu.system.service.HoildayXiaoSerice;
import com.yidu.util.AllUtil;



/**
 * 节假日控制器
 * @author XiaoYuJie
 * @date 2017年11月24日
 * @time 上午9:56:22
 */
@Controller
public class HoildayXiaoController {
	@Autowired
	HoildayXiaoSerice hoildayXiaoSerice;
	@ResponseBody
	@RequestMapping(value="selectHoildayXiao.action",produces="text/html;charset=UTF-8")
	public String selectHoildayXiao(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springMvc")HoildayXiao  hoildayXiao) throws Exception{
		Integer date =Integer.parseInt( request.getParameter("senddate"));
		List<HoildayXiao> list=hoildayXiaoSerice.selectHoildayXiao(date);
		for(HoildayXiao  hoildayXiaos:list){
			hoildayXiaos.setStrDate(AllUtil.getStringDate(hoildayXiaos.gethDate()));
		}
		Gson gson = new Gson();
		return gson.toJson(list);
	} 
	
	@ResponseBody
	@RequestMapping(value="insertHoildayXiao.action",produces="text/html;charset=UTF-8")
	public void insertHoildayXiao(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springMvc")HoildayXiao  hoildayXiao) throws Exception{
		System.out.println("增加");
		System.err.println("hoildayXiao"+hoildayXiao);
		String date = request.getParameter("senddate");
		System.out.println("date"+date);
		String year = request.getParameter("year");
		System.err.println("year"+year);
		int i=0;
		for (String datestr : date.split(",")) 
		{
			System.out.println(datestr);
				String [] split = datestr.split("-");
				hoildayXiao.sethDate(AllUtil.getDate(datestr));
				hoildayXiao.sethYear(new Integer(Integer.parseInt((split[0]))));
				hoildayXiao.sethMonth(new Integer(Integer.parseInt((split[1]))));
				hoildayXiao.sethDay(new Integer(Integer.parseInt((split[2]))));
				
				i=hoildayXiaoSerice.insertHoildayXiao(hoildayXiao);
		}	
		PrintWriter out= response.getWriter();
		if(i>0){
			out.print("增加成功");
		}else{
			out.print("增加失败");
		}		
	} 
	
	@ResponseBody
	@RequestMapping(value="deleteHoildayXiao.action",produces="text/html;charset=UTF-8")
	public void deleteHoildayXiao(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("springMvc")HoildayXiao  hoildayXiao) throws Exception{
		String date="";
		int i=hoildayXiaoSerice.deleteHoildayXiao(date);
		PrintWriter out= response.getWriter();
		if(i>0){
			out.print("删除成功");
		}else{
			out.print("删除失败");
		}
	} 
}
