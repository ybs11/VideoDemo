package com.zhiyou.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserMapper;
import com.zhiyou.model.User;
import com.zhiyou.model.UserExample;
import com.zhiyou.person.service.YUserService;


@Service
public class YUserServiceImpl implements YUserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public void add(User user) {
		userMapper.insert(user);
		
	}

	@Override
	public void delete(int id) {
		userMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public List<User> SelectAll(UserExample example) {
		List<User> selectByExample = userMapper.selectByExample(example);
		return selectByExample;
	}
	

}
