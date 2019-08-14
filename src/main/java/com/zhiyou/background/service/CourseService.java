package com.zhiyou.background.service;

import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.utils.Page;

public interface CourseService {
	/**
	 * 删除数据
	 * @param id
	 */
	void deleteByPrimaryKey(Integer id);
	
	/**
     * 批量删除
     * @param ids
     */
    void deleteAll(Integer[] ids);

	/**
	 * 添加数据
	 * @param record
	 */
	void insert(Course record);

    Course selectByPrimaryKey(Integer id);

    List<Course> selectAll();
    
    List<Course> selectBySubjectId(Integer subjectId);

    void updateByPrimaryKey(Course record);
    
    /**
     * 根据查询条件，分页查询用户列表
     * @return
     */
    Page<Course> selectByCourse(Course course);
}
