package com.zhiyou.foreground.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.foreground.service.CourseService;
import com.zhiyou.foreground.service.VideoService;
import com.zhiyou.model.Course;
import com.zhiyou.model.Video;
import com.zhiyou.model.extension.CourseExtension;
import com.zhiyou.model.extension.VideoExtension;
import com.zhiyou.service.foreground.impl.CourseForegroundService;
import com.zhiyou.service.foreground.impl.VideoForegroundService;
import com.zhiyou.utils.VideoResult;

@Controller
@RequestMapping("/foreground")
public class VideoForegroundController {

	@Autowired
	private VideoService videoForegroundService;
	
	@Autowired
	private CourseService courseForegroundService;
	
	@RequestMapping("/videoPlay.do")
	public String videoPlay(String videoId,String subjectId,HttpServletRequest req) {
		
	    VideoExtension video = videoForegroundService.selectById(Integer.valueOf(videoId));
		//System.out.println(video);
		Integer playNum = video.getPlayNum()+1;
	    //System.out.println(playNum);
		video.setPlayNum(playNum);
		videoForegroundService.update(video);

		
		List<CourseExtension> course = courseForegroundService.selectIncludeVideoAndSubjectBySubjectId(Integer.valueOf(subjectId));

		
		Map map=new HashMap<String, Object>();
		
		map.put("video", video);
		map.put("course", course);
		
		VideoResult videoResult = new VideoResult();
		videoResult.setData(map);
		videoResult.setStatus(200);
		videoResult.setMsg("ok");
		req.setAttribute("videoResult", videoResult);
	
		return "/foreground/VideoPlay";
	}
}
