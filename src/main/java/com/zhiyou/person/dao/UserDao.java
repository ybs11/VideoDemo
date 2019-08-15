package com.zhiyou.person.dao;

import java.util.List;


import com.zhiyou.model.User;

public interface UserDao {

	void add(User user);
	void delete(int id);
	void update(User user);

	List<User> SelectByAccounts(String accounts);
	List<User> SelectById(int id);
	List<User> SelectAll();
}
