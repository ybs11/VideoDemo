package com.zhiyou.foreground.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.foreground.service.CourseService;
import com.zhiyou.model.Course;
import com.zhiyou.model.extension.CourseExtension;
import com.zhiyou.utils.VideoResult;

@Controller
@RequestMapping("foreground")
public class CourseForegroundController {

	@Autowired
	private CourseService courseForegroundService;

	@RequestMapping("courseList.do")
	public String CourseWithVideoAndSubject(String subjectId,HttpServletRequest req) {
		List<CourseExtension> list = courseForegroundService.selectIncludeVideoAndSubjectBySubjectId(Integer.valueOf(subjectId));
		if(list.isEmpty()) {
			
			req.setAttribute("msg", "木有课，别点我");
			return "redirect:/index";
		}
		VideoResult videoResult = new VideoResult();
		Map map =new HashMap<String, Object>();
		map.put("list", list);
		map.put("subjectId",subjectId);
		videoResult.setData(map);
		videoResult.setStatus(200);
		videoResult.setMsg("ok");
		req.setAttribute("videoResult", videoResult);
		return "/foreground/CourseShow";
	}

}
