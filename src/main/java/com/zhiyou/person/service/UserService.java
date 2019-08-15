package com.zhiyou.person.service;

import java.util.List;

import com.zhiyou.model.User;

public interface UserService {

	void add(User user);
	void delete(int id);
	void update(User user);

	User SelectByAccounts(String accounts);
    User SelectById(int id);
	List<User> SelectAll();
}
