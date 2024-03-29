package com.zhiyou.dao;

import com.zhiyou.model.Speaker;
import com.zhiyou.model.SpeakerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpeakerMapper {
    long countByExample(SpeakerExample example);

    int deleteByExample(SpeakerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Speaker record);

    int insertSelective(Speaker record);

    List<Speaker> selectByExample(SpeakerExample example);

    Speaker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByExample(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByPrimaryKeySelective(Speaker record);

    int updateByPrimaryKey(Speaker record);
    
//    后台
    void deleteByPrimaryKey2(Integer id);
    
    /**
     * 批量删除
     * @param ids
     */
    void deleteAll2(Integer[] ids);

    void insert2(Speaker record);

    Speaker selectByPrimaryKey2(Integer id);

    List<Speaker> selectAll2();

    void updateByPrimaryKey2(Speaker record);
    
    
}