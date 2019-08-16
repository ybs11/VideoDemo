package com.zhiyou.background.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.background.service.VideoService;
import com.zhiyou.dao.VideoExtendsMapper;
import com.zhiyou.model.VideoExtends;
import com.zhiyou.utils.Page;
@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoExtendsMapper videoMapper;
	
	public void deleteByPrimaryKey(Integer videoId) {
		videoMapper.deleteByPrimaryKey2(videoId);
	}
	
	public void deleteAll(Integer[] ids) {
		videoMapper.deleteAll2(ids);
	}

	public void insert(VideoExtends record) {
		videoMapper.insert2(record);
	}

	public VideoExtends selectByPrimaryKey(Integer videoId) {
		return videoMapper.selectByPrimaryKey2(videoId);
	}
	
	public List<VideoExtends> selectByCourseId(Integer[] ids) {
		return videoMapper.selectByCourseId2(ids);
	}
	
	public List<VideoExtends> selectBySpeakerId(Integer speakerId) {
		return videoMapper.selectBySpeakerId2(speakerId);
	}
	
	public List<VideoExtends> selectAll() {
		return videoMapper.selectAll2();
	}

	public void updateByPrimaryKey(VideoExtends record) {
		videoMapper.updateByPrimaryKey2(record);
	}

	public Page<VideoExtends> selectByVideo(VideoExtends video) {
		//计算分页查询从那条记录开始
		video.setStart((video.getPage() - 1) * video.getRows());
		//查询总记录数
		Integer total = videoMapper.selectCount2(video);
		//查询每页的数据列表
		List<VideoExtends> list = videoMapper.selectByVideo2(video);
		//包装分页数据
		Page<VideoExtends> page = new Page<VideoExtends>(total,video.getPage(),video.getRows(),list);
		
		return page;
	}

}
