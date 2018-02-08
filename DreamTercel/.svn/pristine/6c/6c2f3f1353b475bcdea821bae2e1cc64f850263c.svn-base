package com.yidu.parameters.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import com.yidu.parameters.domain.Fund;
import com.yidu.parameters.service.FundService;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;


@Controller
@RequestMapping(value="/fund")
public class FundController {
	@Autowired
	AutoBianService autoBianHao;
	@Autowired 
	FundService fundService;
	@Autowired
	AutoBianService autoBianService;
	@ResponseBody
	@RequestMapping(value="/selectFundRow.action",produces="text/html;charset=UTF-8")
	public String selectFundRow(@ModelAttribute("spring")Fund fund) throws Exception{
		System.out.println("进了");
		System.out.println(fund.getPage());
		//map 服务类 查询的方法
		Map<String , Object> map=fundService.selectFundRow(fund);
		//集合L map得到查询的数据
		List<Fund> fundList=(List) map.get("cursor");
		
		for(Fund fundEntity:fundList){
			//数据库的时间是DATE，得到日期
			Date date=fundEntity.getEstablishDate();
			//用一个字符串类型的接受 工具类的到时间
			String  fundString=AllUtil.getStringDate(date);
			//赋值给字符串的时间日期
			fundEntity.setStrEstablishDate(fundString);
		}
		//一个int的包装类得到他的总行数
		Integer rows=(Integer) map.get("rowsTotal");
		//创建一个hash集合
		Map<String , Object> hashMap=new HashMap<String , Object>();
		hashMap.put("total", rows);
		hashMap.put("rows", fundList);
		Gson gson=new Gson();
		String fundGson= gson.toJson(hashMap);
		return fundGson;
	}
	
	@ResponseBody
	@RequestMapping(value="/insertFundRow.action",produces="text/html;charset=UTF-8")
	public String insertFundRow(@ModelAttribute("springWeb")Fund fund) throws Exception{
		//给要转的时间日期在工具类中得到时间
		fund.setEstablishDate(AllUtil.getDate(fund.getStrEstablishDate()));
		System.out.println("天堂"+fund);
		//增加的方法
		int flag=fundService.insertFundRow(fund);
		
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	@ResponseBody
	@RequestMapping(value="/updateFund.action",produces="text/html;charset=UTF-8")
	public String updateFund(@ModelAttribute("springWeb")Fund fund) throws Exception{
		System.err.println(fund);
		//给要转的时间日期在工具类中得到时间
		fund.setEstablishDate(AllUtil.getDate(fund.getStrEstablishDate()));
		//基金信息的服务类 修改的方法
		int flag=fundService.updateFund(fund);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/deleteFund.action",produces="text/html;charset=UTF-8")
	public String deleteFund(@ModelAttribute("springWeb")Fund fund) throws Exception{
		System.err.println(fund.getFundCode());
		//基金信息的服务类 删除的方法
		int flag=fundService.deleteFund(fund);
		
		System.err.println(flag);
		if(flag!=0){
			return "成功删除"+flag+"条数据";


		}else{
			return "操作失败";
		}
	}
	@ResponseBody
	@RequestMapping(value="autoBianhao",produces="text/html;charset=UTF-8")
	public String autoBianhao () throws Exception{
		return autoBianService.getAutoBianhao("fund", "", "FUND_CODE", null, null);

	}
	@ResponseBody
	@RequestMapping(value="selectFundByCode",produces="text/html;charset=UTF-8")
	/**
	 * 查询
	 * @param role
	 * @return
	 */
	public String selectFundByCode(@ModelAttribute("springWeb")Fund fund) throws Exception{
		System.out.println("进了查询了");
		//服务类查询的编号
		Fund jsonFund = fundService.selectFundByCode(fund);
		//给格式日期 转 成数据中的日期
		jsonFund.setStrEstablishDate(AllUtil.getStringDate(jsonFund.getEstablishDate()));
		Gson gson = new Gson();
		return gson.toJson(jsonFund);
		
	}
}
