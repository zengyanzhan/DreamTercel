/*package com.yidu.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@ResponseBody
	@RequestMapping("testAction1.action")
	public String  test()throws Exception{



		System.out.println("我是DreamTelcle组的一员");
		String str="[";
		for (int i = 0; i <66; i++) {
			
			
			str=str+"{ \"tem\": \""+Math.round(Math.random()*50)+"\", \"hum\":\""+Math.round(Math.random()*50)+"\", \"pa\": \"1"+Math.round(Math.random()*50)+"\", \"rain\": \"7"+Math.round(Math.random()*50)+"\", \"win_sp\": \""+Math.round(Math.random()*50)+"\", \"dateStr\": \"2017-11-"+i+"\" },";
			
		}
					return str.substring(0,str.length()-1)+"]";

	}


}
*/