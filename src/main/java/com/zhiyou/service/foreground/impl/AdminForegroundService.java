package com.zhiyou.service.foreground.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.AdminMapper;
import com.zhiyou.model.Admin;
import com.zhiyou.model.AdminExample;
import com.zhiyou.model.AdminExample.Criteria;
import com.zhiyou.service.foreground.AdminService;
@Service
public class AdminForegroundService implements AdminService{

	@Autowired
	private AdminMapper adminMapper;

	public Admin SelectByAccounts(String accounts){
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(accounts);
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.size()>0) {
			Admin admin = list.get(0);
			return admin;
		}
		return null;
	};

	public Admin SelectByAdminId(int adminId){
		Admin admin = adminMapper.selectByPrimaryKey(adminId);
		return admin;

	};
}
