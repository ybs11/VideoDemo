package com.zhiyou.service.foreground.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.extension.CourseExtensionMapper;
import com.zhiyou.model.Course;
import com.zhiyou.model.extension.CourseExtension;
import com.zhiyou.service.foreground.CourseService;

@Service
public class CourseForegroundService implements CourseService{

	@Autowired 
	private CourseExtensionMapper courseExtensionMapper;

	public List<CourseExtension> selectIncludeVideoAndSubjectBySubjectId(int subjectId){
		return	courseExtensionMapper.selectIncludeVideoAndSubjectBySubjectId(subjectId);
	}
}
