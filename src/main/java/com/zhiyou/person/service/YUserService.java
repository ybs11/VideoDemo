package com.zhiyou.person.service;

import java.util.List;

import com.zhiyou.model.User;
import com.zhiyou.model.UserExample;

public interface YUserService {

	void add(User user);
	void delete(int id);
	void update(User user);

	List<User> SelectAll();
}
