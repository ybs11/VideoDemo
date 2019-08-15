package com.zhiyou.background.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zhiyou.background.service.SpeakerService;
import com.zhiyou.model.Speaker;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
	
	@Autowired
	private SpeakerService speakerService;
	
	@RequestMapping("/show.do")
	public String show(Model model) {
		System.out.println("====");
		List<Speaker> list = speakerService.selectAll();
		model.addAttribute("list", list);
		return "background/BackgroundSpeakerShow";
	}
	
	
}
