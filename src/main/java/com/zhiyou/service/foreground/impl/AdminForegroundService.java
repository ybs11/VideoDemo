package com.zhiyou.service.foreground.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.AdminMapper;
import com.zhiyou.foreground.service.AdminService;
import com.zhiyou.model.Admin;
import com.zhiyou.model.AdminExample;
import com.zhiyou.model.AdminExample.Criteria;
@Service
public class AdminForegroundService implements AdminService{

	@Autowired
	private AdminMapper adminMapper;

	@Cacheable("SELECT_ACCOUNTS_ADMIN")
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
    @Cacheable("SELECT_ADMINID")
	public Admin SelectByAdminId(int adminId){
		Admin admin = adminMapper.selectByPrimaryKey(adminId);
		return admin;

	};
}
