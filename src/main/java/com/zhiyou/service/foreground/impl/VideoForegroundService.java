package com.zhiyou.service.foreground.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.CourseMapper;
import com.zhiyou.dao.UserMapper;
import com.zhiyou.dao.VideoMapper;
import com.zhiyou.dao.extension.VideoExtensionMapper;
import com.zhiyou.foreground.service.VideoService;
import com.zhiyou.model.Course;
import com.zhiyou.model.Video;
import com.zhiyou.model.VideoExample;
import com.zhiyou.model.extension.VideoExtension;
import com.zhiyou.utils.VideoResult;

@Service
public class VideoForegroundService implements VideoService{

	@Autowired
	private VideoMapper videoMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private VideoExtensionMapper videoExtensionMapper;
	
	public VideoExtension selectById(Integer videoId) {
		VideoExtension video = videoExtensionMapper.selectById(videoId);

		return video;
	}
	
	public void update(Video video) {
		videoMapper.updateByPrimaryKeySelective(video);
	}
}
