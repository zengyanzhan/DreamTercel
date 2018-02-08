package com.yidu.reportManagement.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yidu.parameters.domain.Fund;
import com.yidu.reportManagement.domain.FundInvestGroup;
import com.yidu.reportManagement.service.FundInvestGroupService;
import com.yidu.util.AllUtil;
/**
 * 现金应收应付库存的控制器类
 * @author 向燕春
 * @date 2017年11月14日
 * @time 下午2:36:48
 *
 */
@Controller
public class FundInvestGroupController{
	@Autowired
	FundInvestGroupService fundInvestGroupService;
	@ResponseBody
	@RequestMapping(value="selectFundInvestGroups.action",produces="text/html;charset=UTF-8")
	public String selectFundInvestGroups(HttpServletRequest request,@ModelAttribute("SpringWeb")FundInvestGroup fundInvestGroup) throws IOException{
		HttpSession session=request.getSession();
		Fund fund=(Fund) session.getAttribute("fund");
		//给基金赋值
		fundInvestGroup.setFundCode(fund.getFundCode());
		String sqlWhere=fundInvestGroupService.bufferWhere(fundInvestGroup);
		HashMap<String, Object> map=fundInvestGroupService.selectFundInvestGroups(fundInvestGroup.getTableName(), sqlWhere, fundInvestGroup.getPage(), fundInvestGroup.getRows(), fundInvestGroup.getRowsTotal(), fundInvestGroup.getOrderColumn(), fundInvestGroup.getOrderStyle());
		List<FundInvestGroup> list=(List<FundInvestGroup>) map.get("list");
		for (int i = 0; i < list.size(); i++) {
			FundInvestGroup fundInvestGroupTotal=list.get(i);
			fundInvestGroup.setProjectName("资产净值");
			//调用查询净值统计表的方法
			FundInvestGroup projectCode=fundInvestGroupService.selectNetValue(fundInvestGroup);
			//得到查询的项目代码(资产净值)
			String ziChanJingZhi=projectCode.getProjectCode();


			/*
			 * 计算成本占净值
			 */
			//得到证券成本
			Double securityCosting=fundInvestGroupTotal.getSecurityCosting();
			Double chengBen=securityCosting/Double.parseDouble(ziChanJingZhi)*100;
			//四舍五入
			Double costingPercentage=AllUtil.getRoundUp(chengBen, 2);
			fundInvestGroupTotal.setCostingPercentage(costingPercentage);



			/*
			 * 计算市值占净值 
			 */
			//得到证券市值
			Double marketValue=fundInvestGroupTotal.getMarketValue();
			//计算出市值占净值百分比
			Double ShiZhi=marketValue/Double.parseDouble(ziChanJingZhi)*100;
			//四舍五入
			Double marketValuePercentage=AllUtil.getRoundUp(ShiZhi, 2);
			fundInvestGroupTotal.setMarketValuePercentage(marketValuePercentage);	
		}

		//查询股票security_type=1
		fundInvestGroup.setSecurityType(1);
		FundInvestGroup guPiao=fundInvestGroupService.selectSecurity(fundInvestGroup);
		//得到股票投资合计总金额
		Double guPiaoZongJinE=guPiao.getTotalMoney();
		//四舍五入
		Double guPiaoTotalMoney=AllUtil.getRoundUp(guPiaoZongJinE, 2);
		FundInvestGroup fundInvestGroupGuPiao=new FundInvestGroup();
		fundInvestGroupGuPiao.setSecurityName("股票投资合计");
		fundInvestGroupGuPiao.setMarketValue(guPiaoTotalMoney);
		list.add(new FundInvestGroup());
		list.add(fundInvestGroupGuPiao);

		//查询债券security_type=2
		fundInvestGroup.setSecurityType(2);
		FundInvestGroup zhaiQuan=fundInvestGroupService.selectSecurity(fundInvestGroup);
		//得到股票投资合计总金额
		Double zhaiQuanZongJinE=zhaiQuan.getTotalMoney();
		//四舍五入
		Double zhaiQuanTotalMoney=AllUtil.getRoundUp(zhaiQuanZongJinE, 2);
		FundInvestGroup fundInvestGroupZhaiQuan=new FundInvestGroup();
		fundInvestGroupZhaiQuan.setSecurityName("债券投资合计");
		fundInvestGroupZhaiQuan.setMarketValue(zhaiQuanTotalMoney);
		list.add(fundInvestGroupZhaiQuan);

		//证券投资合计
		//得到债券总金额+股票总金额
		FundInvestGroup fundInvestGroupZhengQuan=new FundInvestGroup();
		Double zhengQuan=fundInvestGroupZhaiQuan.getMarketValue()+fundInvestGroupGuPiao.getMarketValue();
		Double zhengQuanTotalMoney=AllUtil.getRoundUp(zhengQuan, 2);
		fundInvestGroupZhengQuan.setSecurityName("证券投资合计");
		fundInvestGroupZhengQuan.setMarketValue(zhengQuanTotalMoney);
		list.add(fundInvestGroupZhengQuan);


		//资产类合计
		fundInvestGroup.setProjectName("资产合计");
		//调用查询净值统计表的方法
		FundInvestGroup zongZiChanprojectCode=fundInvestGroupService.selectNetValue(fundInvestGroup);
		//得到查询的项目代码(总资产)
		String zongZiChan=zongZiChanprojectCode.getProjectCode();
		Double doubleZongZiChan=Double.parseDouble(zongZiChan);
		//四舍五入
		Double zongZiChanValue=AllUtil.getRoundUp(doubleZongZiChan, 2);
		zongZiChanprojectCode.setMarketValue(zongZiChanValue);
		zongZiChanprojectCode.setSecurityName("资产类合计");
		list.add(new FundInvestGroup());
		list.add(zongZiChanprojectCode);



		//负债类合计
		fundInvestGroup.setProjectName("负债");
		//调用查询净值统计表的方法
		FundInvestGroup fuZhaiProjectCode=fundInvestGroupService.selectNetValue(fundInvestGroup);
		//得到查询的项目代码(总资产)
		String fuZhai=fuZhaiProjectCode.getProjectCode();
		Double doubleFuZhai=Double.parseDouble(fuZhai);
		//四舍五入
		Double fuZhaiValue=AllUtil.getRoundUp(doubleFuZhai, 2);
		fuZhaiProjectCode.setMarketValue(fuZhaiValue);
		fuZhaiProjectCode.setSecurityName("负债类合计");
		list.add(fuZhaiProjectCode);


		//基金净值
		fundInvestGroup.setProjectName("资产净值");
		//调用查询净值统计表的方法
		FundInvestGroup jiJingJingZhiProjectCode=fundInvestGroupService.selectNetValue(fundInvestGroup);
		//得到查询的项目代码(总资产)
		String jiJinJingZhi=jiJingJingZhiProjectCode.getProjectCode();
		Double doubleJiJinJingZhi=Double.parseDouble(jiJinJingZhi);
		//四舍五入
		Double jiJinJingZhiValue=AllUtil.getRoundUp(doubleJiJinJingZhi, 2);
		jiJingJingZhiProjectCode.setMarketValue(jiJinJingZhiValue);
		jiJingJingZhiProjectCode.setSecurityName("基金净值");
		list.add(new FundInvestGroup());
		list.add(jiJingJingZhiProjectCode);



		//创建Gson
		Gson gson=new Gson();
		HashMap<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", map.get("rowsTotal"));
		jsonMap.put("rows", list);
		//集合转成gson对象
		return gson.toJson(jsonMap);

	}

}
