package com.zhiyou.dao;

import com.zhiyou.model.Admin;
import com.zhiyou.model.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    //后台
    void deleteByPrimaryKey2(Integer id);
    
    /**
     * 批量删除
     * @param ids
     */
    void deleteAll2(Integer[] ids);

    void insert2(Admin record);

    Admin selectByPrimaryKey2(Integer id);

    List<Admin> selectAll2();

    void updateByPrimaryKey2(Admin record);
    
}