package com.zhiyou.background.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.zhiyou.background.service.CourseService;
import com.zhiyou.dao.CourseMapper;
import com.zhiyou.model.Course;
import com.zhiyou.utils.Page;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;

	@Caching(evict = {@CacheEvict(value = "SELECT_VIDEOANDSUBJECT" , allEntries=true),
			@CacheEvict(value = "SELCELT_VIDEO" , allEntries=true)})
	public void deleteByPrimaryKey(Integer id) {
		courseMapper.deleteByPrimaryKey2(id);
	}
	@Caching(evict = {@CacheEvict(value = "SELECT_VIDEOANDSUBJECT" , allEntries=true),
			@CacheEvict(value = "SELCELT_VIDEO" , allEntries=true)})
	public void deleteAll(Integer[] ids) {
		courseMapper.deleteAll2(ids);
	}
	@Caching(evict = {@CacheEvict(value = "SELECT_VIDEOANDSUBJECT" , allEntries=true),
			@CacheEvict(value = "SELCELT_VIDEO" , allEntries=true)})
	public void insert(Course record) {
		courseMapper.insert2(record);
	}

	public Course selectByPrimaryKey(Integer id) {
		return courseMapper.selectByPrimaryKey2(id);
	}

	public List<Course> selectAll() {
		return courseMapper.selectAll2();
	}
	
	public List<Course> selectBySubjectId(Integer subjectId) {
		return courseMapper.selectBySubjectId2(subjectId);
	}

	@Caching(evict = {@CacheEvict(value = "SELECT_VIDEOANDSUBJECT" , allEntries=true),
			@CacheEvict(value = "SELCELT_VIDEO" , allEntries=true)})
	public void updateByPrimaryKey(Course record) {
		courseMapper.updateByPrimaryKey2(record);
	}

	public Page<Course> selectByCourse(Course course) {
		//计算分页查询从那条记录开始
		course.setStart((course.getPage() - 1) * course.getRows());
		//查询总记录数
		Integer total = courseMapper.selectAcount2(course);
		//查询每页的数据列表
		List<Course> list = courseMapper.selectByCourse2(course);
		//包装分页数据
		Page<Course> page = new Page<Course>(total,course.getPage(),course.getRows(),list);
		
		return page;
	}

}
