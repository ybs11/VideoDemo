package com.zhiyou.dao.extension;

import java.util.List;



import com.zhiyou.model.extension.CourseExtension;

public interface CourseExtensionMapper {
	  List<CourseExtension> selectIncludeVideoAndSubjectBySubjectId(int subjectId);
}
