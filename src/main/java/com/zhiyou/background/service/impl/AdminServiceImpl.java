package com.zhiyou.background.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.background.service.AdminService;
import com.zhiyou.dao.AdminMapper;
import com.zhiyou.model.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public void deleteByPrimaryKey(Integer id) {
		adminMapper.deleteByPrimaryKey2(id);
	}

	@Override
	public void deleteAll(Integer[] ids) {
		adminMapper.deleteAll2(ids);
	}

	@Override
	public void insert(Admin record) {
		adminMapper.insert2(record);
	}

	@Override
	public Admin selectByPrimaryKey(Integer id) {
		return adminMapper.selectByPrimaryKey2(id);
	}

	@Override
	public List<Admin> selectAll() {
		return adminMapper.selectAll2();
	}

	@Override
	public void updateByPrimaryKey(Admin record) {
		adminMapper.updateByPrimaryKey2(record);
	}

}
