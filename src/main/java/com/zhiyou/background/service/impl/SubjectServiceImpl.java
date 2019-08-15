package com.zhiyou.background.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.background.service.SubjectService;
import com.zhiyou.dao.SubjectMapper;
import com.zhiyou.model.Subject;
@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public void deleteByPrimaryKey(Integer subjectId) {
		subjectMapper.deleteByPrimaryKey2(subjectId);
	}

	@Override
	public void insert(Subject record) {
		subjectMapper.insert2(record);
	}

	@Override
	public Subject selectByPrimaryKey(Integer subjectId) {
		return subjectMapper.selectByPrimaryKey2(subjectId);
	}

	@Override
	public List<Subject> selectAll() {
		return subjectMapper.selectAll2();
	}

	@Override
	public void updateByPrimaryKey(Subject record) {
		subjectMapper.updateByPrimaryKey2(record);
	}

}
