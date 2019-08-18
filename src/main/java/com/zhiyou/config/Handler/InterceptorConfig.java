package com.zhiyou.config.Handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	//添加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截所有，除了user/index
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/course/**","/speaker/**","/admin/**","/video/**")
		.excludePathPatterns("/adminLogin.do","/userLogin.do","/regUser.do");
	
		registry.addInterceptor(new MyInterceptorUser()).addPathPatterns("/personal/**","/foreground/PersonalCenter.do","/foreground/videoPlay.do")
		.excludePathPatterns("/adminLogin.do","/userLogin.do","/regUser.do");
	}

	
}
