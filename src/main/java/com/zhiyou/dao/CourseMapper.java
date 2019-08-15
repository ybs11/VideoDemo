package com.zhiyou.dao;

import com.zhiyou.model.Course;
import com.zhiyou.model.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
    //后台
    /**
	 * 删除数据
	 * @param id
	 */
    void deleteByPrimaryKey2(Integer id);
    
    /**
     * 批量删除
     * @param ids
     */
    void deleteAll2(Integer[] ids);

    /**
     * 添加数据
     * @param record
     */
    void insert2(Course record);

    Course selectByPrimaryKey2(Integer id);

    List<Course> selectAll2();
    
    List<Course> selectBySubjectId2(Integer subjectId);

    void updateByPrimaryKey2(Course record);
    
    /**
     * 根据查询条件,查询总数
     * @return
     */
    Integer selectAcount2(Course course);
    
    /**
     * 根据查询条件,分页查询课程列表
     * @return
     */
    List<Course> selectByCourse2(Course course);
}