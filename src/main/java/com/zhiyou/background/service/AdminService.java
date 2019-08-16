package com.zhiyou.background.service;

import java.util.List;

import com.zhiyou.model.Admin;

public interface AdminService {
	
	void deleteByPrimaryKey(Integer id);
	
	/**
     * 批量删除
     * @param ids
     */
    void deleteAll(Integer[] ids);
	
    void insert(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAll();

    void updateByPrimaryKey(Admin record);
	
}
