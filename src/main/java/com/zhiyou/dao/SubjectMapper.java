package com.zhiyou.dao;

import com.zhiyou.model.Subject;
import com.zhiyou.model.SubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectMapper {
    long countByExample(SubjectExample example);

    int deleteByExample(SubjectExample example);

    int deleteByPrimaryKey(Integer subjectId);

    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample(SubjectExample example);

    Subject selectByPrimaryKey(Integer subjectId);

    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
    
    //后台
    void deleteByPrimaryKey2(Integer subjectId);

    void insert2(Subject record);

    Subject selectByPrimaryKey2(Integer subjectId);

    List<Subject> selectAll2();

    void updateByPrimaryKey2(Subject record);
}