package com.zhiyou.service.foreground.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserMapper;
import com.zhiyou.foreground.service.UserService;
import com.zhiyou.model.User;
import com.zhiyou.model.UserExample;
import com.zhiyou.model.UserExample.Criteria;

@Service
public class UserForegroundService implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public User SelectByAccounts(String accounts) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(accounts);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0) {
			User user = list.get(0);
			return user;
		}
		return null;
	}

	public User SelectById(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

}
