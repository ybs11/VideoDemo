package com.zhiyou.config.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.zhiyou.model.Admin;
import com.zhiyou.model.User;

public class MyInterceptorUser implements HandlerInterceptor{
	
	
		
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute("user"); 
		System.out.println("=========="+user);
		  if (null == user) {
			  response.sendRedirect("http://localhost:8080/"); 
			  return false; 
			  }
		  request.getSession().setAttribute("user", user);
		  return true;
	}
}
