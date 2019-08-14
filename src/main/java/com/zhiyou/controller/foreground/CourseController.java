package com.zhiyou.controller.foreground;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Course;
import com.zhiyou.service.foreground.CourseForegroundService;
import com.zhiyou.utils.VideoResult;

@Controller
@RequestMapping("foreground")
public class CourseController {

	@Autowired
	private CourseForegroundService courseForegroundService;

	@RequestMapping("courseList.do")
	public String CourseWithVideoAndSubject(String subjectId,HttpServletRequest req) {
		List<Course> list = courseForegroundService.selectIncludeVideoAndSubjectBySubjectId(Integer.valueOf(subjectId));
		if(list.isEmpty()) {
			System.out.println("无");
			req.setAttribute("msg", "木有课，别点我");
			return "index";
		}
		VideoResult videoResult = new VideoResult();
		videoResult.setData(list);
		videoResult.setStatus(200);
		videoResult.setMsg("ok");
		req.setAttribute("videoResult", videoResult);
		return "/foreground/CourseShow";
	}

}
