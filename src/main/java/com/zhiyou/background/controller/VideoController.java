package com.zhiyou.background.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.background.service.CourseService;
import com.zhiyou.background.service.SpeakerService;
import com.zhiyou.background.service.VideoService;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.VideoExtends;
import com.zhiyou.utils.Page;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	public CourseService courseService;
	
	@RequestMapping("/show.do")
	public String show(Model model,VideoExtends video) {
		//查询老师
		List<Speaker> speakerAll = speakerService.selectAll();
		//查询课程
		List<Course> courseAll = courseService.selectAll();
		model.addAttribute("speakerAll", speakerAll);
		model.addAttribute("courseAll", courseAll);
		
		Page<VideoExtends> page = videoService.selectByVideo(video);
		model.addAttribute("page", page);
		return "background/BackgroundVideoShow";
	}
	
	@RequestMapping("/addVideoShow.do")
	public String addVideoShow(Model model) {
		//查询老师
		List<Speaker> speakerAll = speakerService.selectAll();
		//查询课程
		List<Course> courseAll = courseService.selectAll();
		model.addAttribute("speakerAll", speakerAll);
		model.addAttribute("courseAll", courseAll);
		return "background/BackgroundVideoAdd";
	}
	
	@RequestMapping("/addVideo.do")
	public String addVideo(VideoExtends video) {
		videoService.insert(video);
		return "redirect:show.do";
	}
	
	@RequestMapping("/edit.do")
	public String edit(Model model,Integer videoId) {
		//查询老师
		List<Speaker> speakerAll = speakerService.selectAll();
		//查询课程
		List<Course> courseAll = courseService.selectAll();
		model.addAttribute("speakerAll", speakerAll);
		model.addAttribute("courseAll", courseAll);
		VideoExtends video = videoService.selectByPrimaryKey(videoId);
		model.addAttribute("video", video);
		return "background/BackgroundVideoUpdate";
	}
	
	@RequestMapping("/update.do")
	public String update(VideoExtends video) {
		videoService.updateByPrimaryKey(video);
		return "redirect:show.do";
	}
	
	@RequestMapping("/delVideoById.do")
	@ResponseBody
	public String delVideoById(Integer id) {
		String msg = "fail";
		try {
			videoService.deleteByPrimaryKey(id);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping("/deleteAll.do")
	@ResponseBody
	public String deleteAll(String ids) {
		String msg = "false";
		String[] ss = ids.split(",");
		Integer[] id = new Integer[ss.length];
		for (int i = 0; i < ss.length; i++) {
			id[i] = Integer.valueOf(ss[i]);
		}
		try {
			videoService.deleteAll(id);
			msg = "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
}
