package com.zhiyou.background.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.background.service.CourseService;
import com.zhiyou.background.service.SubjectService;
import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;
import com.zhiyou.utils.Page;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired 
	private SubjectService subjectService;
	
	
	@RequestMapping("/list.do")
	public String list(Model model,Course course){
		Page<Course> page = courseService.selectByCourse(course);
		model.addAttribute("page", page);
		return "background/BackgroundCourseShow";
	}
	
	@RequestMapping("/addCourseShow.do")
	public String addCourseShow(Model model) {
		List<Subject> list = subjectService.selectAll();
		model.addAttribute("list", list);
		return "background/BackgroundCourseAdd";
	}
	
	@RequestMapping("/addCourse.do")
	public String addCourse(Course course) {
		courseService.insert(course);
		return "forward:list.do";
	}
	
	@RequestMapping("/delCourseById.do")
	@ResponseBody
	public String delCourseById(Integer id) {
		String msg = "fail";
		try {
			courseService.deleteByPrimaryKey(id);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	//批量删除
	@RequestMapping(value="/deleteAll.do",method=RequestMethod.POST)
	@ResponseBody
	public String deleteAll(String ids) {
		String[] ss = ids.split(",");
		Integer[] id = new Integer[ss.length];
		for (int i = 0; i < ss.length; i++) {
			id[i]=Integer.valueOf(ss[i]);
		}
		courseService.deleteAll(id);
		return "true";
	}
	
	
	@RequestMapping("/edit.do")
	public String edit(Model model,Integer id) {
		List<Subject> list = subjectService.selectAll();
		Course course = courseService.selectByPrimaryKey(id);
		model.addAttribute("list", list);
		model.addAttribute("course", course);
		return "background/BackgroundCourseUpdate";
	}
	
	@RequestMapping("/update.do")
	public String update(Course course) {
		courseService.updateByPrimaryKey(course);
		return "forward:list.do";
	}
	
}
