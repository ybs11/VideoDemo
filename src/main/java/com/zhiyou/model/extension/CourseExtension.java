package com.zhiyou.model.extension;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;

import lombok.Data;
@Data
public class CourseExtension extends Course{
	
	private List<Video> videos =new ArrayList<Video>();
	private Subject subject;
}
