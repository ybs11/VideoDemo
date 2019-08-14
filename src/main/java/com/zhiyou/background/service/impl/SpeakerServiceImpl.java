package com.zhiyou.background.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.SpeakerMapper;
import com.zhiyou.model.Speaker;
import com.zhiyou.background.service.SpeakerService;

@Service
public class SpeakerServiceImpl implements SpeakerService {
	
	@Autowired
	private SpeakerMapper speakerMapper;
	
	public void deleteByPrimaryKey(Integer id) {
		speakerMapper.deleteByPrimaryKey2(id);
	}
	
	public void deleteAll(Integer[] ids) {
		speakerMapper.deleteAll2(ids);
	}
	
	public void insert(Speaker record) {
		speakerMapper.insert2(record);
	}

	public Speaker selectByPrimaryKey(Integer id) {
		return speakerMapper.selectByPrimaryKey2(id);
	}

	public List<Speaker> selectAll() {
		return speakerMapper.selectAll2();
	}

	public void updateByPrimaryKey(Speaker record) {
		speakerMapper.updateByPrimaryKey2(record);
	}

	

}
