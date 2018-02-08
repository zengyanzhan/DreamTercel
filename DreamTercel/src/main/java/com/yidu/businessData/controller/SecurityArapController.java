package com.yidu.businessData.controller;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.yidu.businessData.domain.SecurityArap;
import com.yidu.businessData.service.SecurityArapService;
import com.yidu.parameters.domain.Fund;
import com.yidu.util.AllUtil;
import com.yidu.util.service.AutoBianService;
/**
 * 证券应收应付控制器
 * @author 邓涛
 * @date 2017年11月19日
 * @time 下午3:51:36
 */
@Controller 
public class SecurityArapController {
	@Autowired
	SecurityArapService securityArapService;
	@Autowired
	AutoBianService autoBianService;
	/**
	 * 查询的方法
	 * @param securityArap 证券应收应付实体类
	 * @return json数组传到js
	 */
	@ResponseBody
	@RequestMapping(value="selectSecurityArap.action",produces="text/html;charset=utf-8")
	public String selectSecurityArap(@ModelAttribute("SpringWeb")SecurityArap securityArap,HttpServletRequest request) throws Exception {
		//得到一个会话
		HttpSession session=request.getSession(false);
	    if(session==null){
	    	session=request.getSession(true);
	    }
	    //得到基金实体类
	    Fund fund=(Fund)session.getAttribute("fund");
	    //把基金表基金放入证券应收应付表基金
	    securityArap.setFundCode(fund.getFundCode());
	    //调用查询的方法
		Map<String, Object>map=securityArapService.selectSecurityArap(securityArap);
		List<SecurityArap> securityArapList=(List) map.get("cursor");
		//遍历循环
		for(SecurityArap SecurityArapEntity:securityArapList){
			//将date类型转换为字符串类型
			SecurityArapEntity.setStrDate(AllUtil.getStringDate(SecurityArapEntity.getBusinessDate()));
		}
		//得到总条数
		Integer rows=(Integer) map.get("rowsTotal");
		//创建Map集合 里面装的是总条数 和 集合
		HashMap<String, Object> maps=new HashMap<String, Object>();
		maps.put("total", rows);
		maps.put("rows", securityArapList);
		//创建一个gson
		Gson gson=new Gson();
		//把gson转成json
		String securityArapGson=gson.toJson(maps);
		return securityArapGson;
	}
	/**
	 * 
	 * @param securityArap 证券应收应付实体类
	 * @return flag为1 则删除成功
	 */
	@ResponseBody
	@RequestMapping(value="deleteSecurityArap.action",produces="text/html;charset=UTF-8")
	public String deleteSecurityArap(@ModelAttribute("SpringWeb")SecurityArap securityArap){
		//调用删除的方法
		int flag=securityArapService.deleteSecurityArap(securityArap);
		if(flag==1){
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	/**
	 * 增加的方法
	 * @param securityArap 证券应收应付实体类
	 * @return flag 为1 则增加成功
	 */
	@ResponseBody
	@RequestMapping(value="/insertSecurityArap.action",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	public String insertSecurityArap(@ModelAttribute("SpringWeb") SecurityArap securityArap) throws Exception{
		//把字符串类型转换为Date类型
		securityArap.setBusinessDate(AllUtil.getDate(securityArap.getStrDate()));
		//调用增加的方法
		int flag=securityArapService.insertSecurityArap(securityArap);
		if(flag==1){
			return "增加成功";
		}else{
			return "增加失败";
		}
	}
	/**
	 * 修改的方法
	 * @param securityArap 证券应收应付实体类
	 * @return flag为1则修改成功
	 */
	@ResponseBody
	@RequestMapping(value="/updateSecurityArap",produces="text/html;charset=UTF-8")
	public String updateSecurityArap(@ModelAttribute("SpringWeb") SecurityArap securityArap) throws Exception{
		//将Date类型转换为字符串类型
		securityArap.setBusinessDate(AllUtil.getDate(securityArap.getStrDate()));
		//调用修改的方法
		int flag= securityArapService.updateSecurityArap(securityArap);
		if(flag==1){
			return "修改成功";
		}else{
			return "修改失败";
		}
	}
	/**
	 * 通过id查询
	 * @param securityArap 实体类
	 * @return gson数据传到js
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectSecurityArapById",produces="text/html;charset=UTF-8")
	public String selectSecurityArapById(@ModelAttribute("SpringWeb") SecurityArap securityArap,@RequestParam("securityArapCode")String  securityArapCode) throws Exception{
		//调用通过code查询的方法
		SecurityArap  securityArapEntity=securityArapService.selectSecurityArapById(securityArapCode);
		//把date日期转化为字符串
		securityArapEntity.setStrDate(AllUtil.getStringDate(securityArapEntity.getBusinessDate()));
		//创建一个gson
		Gson gson=new Gson();
		//把gson转为json
		return gson.toJson(securityArapEntity);
	}
	/**
	 * 调用自动生成编号
	 * @return security_arap 表名 ZJYSYF生成编号前缀  SECURITY_ARAP_CODE字段名
	 */
	@ResponseBody
	@RequestMapping(value="/autoSecurityArapBianhao",produces="text/html;charset=UTF-8")
	public String autoSecurityArapBianhao() throws Exception{
		return autoBianService.getAutoBianhao("security_arap", "ZJYSYF", "SECURITY_ARAP_CODE", "business_date", new Date(System.currentTimeMillis()));
	}
}