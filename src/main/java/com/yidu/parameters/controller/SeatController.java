package com.yidu.parameters.controller;

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
import com.yidu.parameters.domain.Seat;
import com.yidu.parameters.service.BroketService;
import com.yidu.parameters.service.SeatService;
import com.yidu.util.service.AutoBianService;

/**
 * 交易席位控制器类
 * @author Wang
 * @date 2017年11月16日
 * @time 下午6:06:22
 */
@Controller
public class SeatController {
	@Autowired
	SeatService seatService;
	@Autowired
	AutoBianService autoBianHao;
	@Autowired
	BroketService broketService;
	/**
	 * 查询交易席位信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectSeat.action",produces="text/html;charset=UTF-8")
	protected String selectSeat(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") Seat seat) throws Exception {
		System.err.println(seat);
		Map<String, Object> seatMap=seatService.selectSeat(seat);
		System.err.println(seatMap);
		Gson gson=new Gson();
		return gson.toJson(seatMap);
	}

	/**
	 * 添加交易席位信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/insertSeat.action",produces="text/html;charset=UTF-8")
	protected String insertSeat(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") Seat seat) throws Exception {
		System.err.println(seat);
		int rows=seatService.insertSeat(seat);
		return rows+"";
	}
	/**
	 * 修改交易席位信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/updateSeat.action",produces="text/html;charset=UTF-8")
	protected String updateSeat(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") Seat seat) throws Exception {
		System.out.println("idfdikjkjdidwihj");
		System.err.println(seat);
		int rows=seatService.updateSeat(seat);
		return rows+"";
	}
	/**
	 * 删除交易席位信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/deleteSeat.action",produces="text/html;charset=UTF-8")
	protected String deleteSeat(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") Seat seat) throws Exception {
		System.err.println(seat);
		int rows=seatService.deleteSeat(seat);
		return rows+"";
	}  
	/**
	 * 通过交易席位编号查询交易席位信息
	 * @param request 请求对象
	 * @param response 响应对象
	 * @return 编号
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value="/selectSeatById.action",produces="text/html;charset=UTF-8")
	protected String selectSeatById(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("springWeb") Seat seat) throws Exception {
		System.out.println("adsadsa");   
		System.out.println(seat);
		List<Seat> seatList=seatService.selectSeatById(seat.getSeatCode());
		Gson gson=new Gson();
		String seatJson=gson.toJson(seatList);
		return seatJson;
	}
	
}
