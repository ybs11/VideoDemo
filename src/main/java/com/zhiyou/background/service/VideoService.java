package com.zhiyou.background.service;

import java.util.List;

import com.zhiyou.model.VideoExtends;
import com.zhiyou.utils.Page;

public interface VideoService {
	
	/**
	 * 删除数据
	 * @param id
	 */
	void deleteByPrimaryKey(Integer videoId);
	
	 /**
     * 批量删除
     * @param ids
     */
    void deleteAll(Integer[] ids);
	
	/**
	 * 添加数据
	 * @param record
	 */
    void insert(VideoExtends record);

    VideoExtends selectByPrimaryKey(Integer videoId);

    List<VideoExtends> selectByCourseId(Integer[] ids);
    
    List<VideoExtends> selectBySpeakerId(Integer speakerId);
    
    List<VideoExtends> selectAll();

    void updateByPrimaryKey(VideoExtends record);
    
    
    
    /**
     * 根据查询条件,分页查询视频列表
     * @param video
     * @return
     */
    Page<VideoExtends> selectByVideo(VideoExtends video);
}
