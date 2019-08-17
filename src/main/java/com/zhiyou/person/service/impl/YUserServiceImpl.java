package com.zhiyou.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
	@CacheEvict(value = "USERACCOUNTS" , allEntries=true)
	public void add(User user) {
		userMapper.insertSelective(user);
		
	}

	@Override
	@CacheEvict(value = "USERACCOUNTS" , allEntries=true)
	public void delete(int id) {
		userMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	@CacheEvict(value = "USERACCOUNTS" , allEntries=true)
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
		
	}

	@Override
	public List<User> SelectAll() {
		UserExample userExample = new UserExample();
		List<User> selectByExample = userMapper.selectByExample(userExample);
		return selectByExample;
	}
	

}
