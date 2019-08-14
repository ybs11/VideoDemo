package com.zhiyou.service.foreground;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.extension.CourseExtensionMapper;
import com.zhiyou.model.Course;
import com.zhiyou.model.extension.CourseExtension;

@Service
public class CourseForegroundService {

	@Autowired 
	private CourseExtensionMapper courseExtensionMapper;

	public List<CourseExtension> selectIncludeVideoAndSubjectBySubjectId(int subjectId){
		return	courseExtensionMapper.selectIncludeVideoAndSubjectBySubjectId(subjectId);
	}
}
