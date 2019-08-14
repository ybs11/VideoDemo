package com.zhiyou.foreground.service;

import java.util.List;

import com.zhiyou.model.extension.CourseExtension;

public interface CourseService {
	List<CourseExtension> selectIncludeVideoAndSubjectBySubjectId(int subjectId);
}
