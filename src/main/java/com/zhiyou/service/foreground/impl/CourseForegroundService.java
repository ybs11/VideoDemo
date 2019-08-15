package com.zhiyou.service.foreground.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.extension.CourseExtensionMapper;
import com.zhiyou.foreground.service.CourseService;
import com.zhiyou.model.Course;
import com.zhiyou.model.extension.CourseExtension;

@Service
public class CourseForegroundService implements CourseService{

	@Autowired 
	private CourseExtensionMapper courseExtensionMapper;

	@Cacheable("SELECT_VIDEOANDSUBJECT")
	public List<CourseExtension> selectIncludeVideoAndSubjectBySubjectId(int subjectId){
		return	courseExtensionMapper.selectIncludeVideoAndSubjectBySubjectId(subjectId);
	}
}
