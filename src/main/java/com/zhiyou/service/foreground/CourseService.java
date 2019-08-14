package com.zhiyou.service.foreground;

import java.util.List;

import com.zhiyou.model.extension.CourseExtension;

public interface CourseService {
	List<CourseExtension> selectIncludeVideoAndSubjectBySubjectId(int subjectId);
}
