package com.yidu.system.filter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yidu.parameters.domain.Fund;
import com.yidu.system.domain.User;
public class LoginFileter implements Filter{

	@SuppressWarnings("unused")
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest requests, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=((HttpServletRequest)requests);
		HttpServletResponse responsed=(HttpServletResponse)response;
		HttpSession session =request.getSession(false);
		if(session==null){
			session =request.getSession();
		}
		//得到请求格式
		String requestType = request.getHeader("X-Requested-With");
		//若requestType 为XMLHttpRequest 说明是ajax请求
		if(requestType!=null){
			if(requestType.equals("XMLHttpRequest")){
				chain.doFilter(request, responsed);
				return;
			}
		}
		String requestURI=request.getRequestURI();
		System.out.println(requestType);
		//得到用户是否登录
		User user=(User)session.getAttribute("user");
		System.err.println("用户编号=="+user);

		int flag=removalOfFiltration(requestURI);
		if(flag!=0){
			chain.doFilter(request, responsed);
		}
		if(user==null){
			//过滤几个特定的请求
			responsed.sendRedirect("index.jsp");
		}else{
			//得到基金是存在session
			Fund fund=(Fund)session.getAttribute("fund");
			System.err.println("基金编号=="+fund);
			if(fund==null){
				responsed.sendRedirect("index.jsp");
			}else{
				chain.doFilter(request, responsed);
			}

		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

		this.config=config;


	}

	public int removalOfFiltration(String requestURI){

		if(requestURI.indexOf("checkLogin.action")!=-1){
			return 1;
		}
		if(requestURI.indexOf("selectFundRow.action")!=-1){

			return 1;
		}

		return 0;
	}

}
