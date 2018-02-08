package com.yidu.dayEnd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.dayEnd.domain.Stock;
import com.yidu.dayEnd.service.StockService;
import com.yidu.parameters.domain.Fund;

/**
 * 日终库存统计控制器
 * @author ZengYanZhan
 * @date 2017年11月15日
 * @time 下午4:03:45
 */
@Controller
public class StockController {
	@Autowired
	private StockService stockService;//自动装配库存统计业务处理接口类

	/**
	 * 查询所有的库存并显示到界面表格
	 * @return List 库存管理下的所有库存数据
	 */
	@ResponseBody
	@RequestMapping(value="/selectStock.action",produces="text/html;charset=UTF-8")
	public String selectStock(@ModelAttribute("SpringWeb") Stock stock){
		Map<String,Object> cursor=stockService.selectStock(stock);//调用业务逻辑处理层
		List<Stock> stockList=(List<Stock>)cursor.get("cursor");
		Map<String,Object> map=new HashMap<String,Object>();//创建Map存储
		map.put("total", cursor.get("rowsTotal"));
		map.put("rows", stockList);
		Gson gson=new Gson();//转为json对象
		return gson.toJson(map);
	}

	/**
	 * 统计需要统计的库存方法
	 * @param stock 界面参数
	 * @return List 返回统计好的库存数据
	 * @throws Exception  异常
	 */
	@ResponseBody
	@RequestMapping(value="/stockStatistics.action",produces="text/html;charset=UTF-8")
	public String stockStatistics(@ModelAttribute("SpringWeb") Stock stock) throws Exception{
		String name=new String(stock.getStockName().getBytes("ISO-8859-1"),"UTF-8");//转码
		String[] strName=name.split(",");//切割从库存统计传来的库存名字的字符串
		List<Stock> stockList=new ArrayList<Stock>(); //创建一个集合存贮数据
		for(int i=0;i<strName.length;i++){//循环判断
			if(strName[i].equals("证券库存")){//当stockName包含证券库存进入该判断
				Stock stockEntity=stockService.securityStockStatistics(stock); //调用证券库存方法
				stockEntity.setStockName(strName[i]);//设置该库存名字为对应的库存
				stockList.add(stockEntity);
			}
			if(strName[i].equals("现金库存")){//当stockName包含现金库存时
				Stock stockEntity=stockService.cashStockStatistics(stock);//调用现金库存方法
				 stockEntity.setStockName(strName[i]);
				 stockList.add(stockEntity);
			}
			if(strName[i].equals("证券应收应付库存")){//当stockName包含证券应收应付库存时
				Stock stockEntity=stockService.securityArapStockStatistics(stock);
				stockEntity.setStockName(strName[i]);
				stockList.add(stockEntity);
			}
			if(strName[i].equals("现金应收应付库存")){//当stockName包含现金应收应付库存时
				Stock stockEntity=stockService.cashArapStockStatistics(stock);
				stockEntity.setStockName(strName[i]);
				stockList.add(stockEntity);
			}
			if(strName[i].equals("TA库存")){//当stockName包含TA库存时
				Stock stockEntity=stockService.taStockStatistics(stock);
				stockEntity.setStockName(strName[i]);
				stockList.add(stockEntity);
			}
		}
		Gson gson=new Gson();//解析为json对象
		return gson.toJson(stockList);
	}

}
