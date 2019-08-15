package com.zhiyou.model.extension;

import java.io.Serializable;

import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;

import lombok.Data;
@Data
public class VideoExtension extends Video implements Serializable{

	private Speaker speaker;
	private CourseExtension course;
}
