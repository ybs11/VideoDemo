package com.zhiyou.background.service;

import java.util.List;

import com.zhiyou.model.Speaker;

public interface SpeakerService {
	void deleteByPrimaryKey(Integer id);
	
	/**
     * 批量删除
     * @param ids
     */
    void deleteAll(Integer[] ids);
	
    void insert(Speaker record);

    Speaker selectByPrimaryKey(Integer id);

    List<Speaker> selectAll();

    void updateByPrimaryKey(Speaker record);
}
