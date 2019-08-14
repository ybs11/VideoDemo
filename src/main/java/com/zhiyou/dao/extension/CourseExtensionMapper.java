package com.zhiyou.dao.extension;

import java.util.List;


import com.zhiyou.model.Course;

public interface CourseExtensionMapper {
	  List<Course> selectIncludeVideoAndSubjectBySubjectId(int subjectId);
}
