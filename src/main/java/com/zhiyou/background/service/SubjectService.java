package com.zhiyou.background.service;

import java.util.List;

import com.zhiyou.model.Subject;

public interface SubjectService {
	void deleteByPrimaryKey(Integer subjectId);

    void insert(Subject record);

    Subject selectByPrimaryKey(Integer subjectId);

    List<Subject> selectAll();

    void updateByPrimaryKey(Subject record);
}
