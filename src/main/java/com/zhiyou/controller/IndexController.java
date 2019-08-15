package com.zhiyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	@RequestMapping("index")
	public String index() {
		
		return"index";
	}
	
	@RequestMapping("/foreground/PersonalCenter.do")
	public String personalCenter() {
		return "/personalCenter/PersonalCenter";
		
	}
}
