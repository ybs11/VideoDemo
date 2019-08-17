package com.zhiyou.config.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.zhiyou.model.Admin;

public class MyInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Admin admin = (Admin) request.getSession().getAttribute("admin"); 
		System.out.println("=========="+admin);
		  if (null == admin) {
			  response.sendRedirect("http://localhost:8080/"); 
			  return false; 
			  }
		  request.getSession().setAttribute("admin", admin);
		  return true;
		}


}
