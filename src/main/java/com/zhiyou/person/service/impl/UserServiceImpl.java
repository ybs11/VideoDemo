package com.zhiyou.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.model.User;
import com.zhiyou.person.dao.UserDao;
import com.zhiyou.person.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public void add(User user) {
		userDao.add(user);
		
	}

	public void delete(int id) {
		userDao.delete(id);
		
	}

	public void update(User user) {
		userDao.update(user);
		
	}

	public User SelectByAccounts(String accounts) {
       List<User> selectByAccounts = userDao.SelectByAccounts(accounts);
       if(selectByAccounts.size()>0) {
			return selectByAccounts.get(0);
		}
       return null;
		
	}

	public User SelectById(int id) {
		List<User> selectById = userDao.SelectById(id);
		if(selectById.size()>0) {
			return selectById.get(0);
		}
		return null;
	}

	public List<User> SelectAll() {
		List<User> selectAll = userDao.SelectAll();
		return selectAll;
	}

}
