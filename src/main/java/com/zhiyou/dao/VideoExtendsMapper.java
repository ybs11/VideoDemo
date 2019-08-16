package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.VideoExtends;

public interface VideoExtendsMapper {
	//后台
    void deleteByPrimaryKey2(Integer videoId);
    
    /**
     * 批量删除
     * @param ids
     */
    void deleteAll2(Integer[] ids);

    void insert2(VideoExtends record);

    VideoExtends selectByPrimaryKey2(Integer videoId);

    List<VideoExtends> selectAll2();
    
    List<VideoExtends> selectByCourseId2(Integer[] ids);
    
    List<VideoExtends> selectBySpeakerId2(Integer speakerId);

    void updateByPrimaryKey2(VideoExtends record);
    
    /**
     * 根据查询条件,查询总数
     * @param video
     * @return
     */
    Integer selectCount2(VideoExtends video);
    
    /**
     * 根据查询条件,分页查询视频列表
     * @param video
     * @return
     */
    List<VideoExtends> selectByVideo2(VideoExtends video);
}
