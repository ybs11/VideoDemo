package com.zhiyou.background.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.background.service.SpeakerService;
import com.zhiyou.model.Speaker;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
	
	@Autowired
	private SpeakerService speakerService;
	
	@RequestMapping("/show.do")
	public String show(Model model) {
		List<Speaker> list = speakerService.selectAll();
		model.addAttribute("list", list);
		return "background/BackgroundSpeakerShow";
	}
	
	@RequestMapping("/addSpeakerShow.do")
	public String addSpeakerShow() {
		return "background/BackgroundSpeakerAdd";
	}
	
	@RequestMapping("/addSpeaker.do")
	public String addSpeaker(Speaker speaker) {
		speakerService.insert(speaker);
		return "redirect:show.do";
	}
	
	@RequestMapping("/delSpeakerById.do")
	@ResponseBody
	public String delSpeakerById(Integer id) {
		String msg = "fail";
		try {
			speakerService.deleteByPrimaryKey(id);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	/*批量删除*/
	@RequestMapping(value="/deleteAll.do",method=RequestMethod.POST)
	@ResponseBody
	public String deleteAll(String ids) {
		String[] ss = ids.split(",");
		Integer[] id = new Integer[ss.length];
		for (int i = 0; i < ss.length; i++) {
			id[i] = Integer.valueOf(ss[i]);
		}
		speakerService.deleteAll(id);
		return "true";
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.POST)
	public String edit(Model model,Integer id) {
		Speaker speaker = speakerService.selectByPrimaryKey(id);
		model.addAttribute("speaker", speaker);
		return "background/BackgroundSpeakerUpdate";
	}
	
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String update(Speaker speaker) {
		speakerService.updateByPrimaryKey(speaker);
		return "forward:show.do";
	}	

}
