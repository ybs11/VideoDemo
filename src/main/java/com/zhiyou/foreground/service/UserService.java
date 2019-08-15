package com.zhiyou.foreground.service;

import java.util.List;

import com.zhiyou.model.User;

public interface UserService {

	User SelectByAccounts(String accounts);
    User SelectById(int id);
	void add(User user);
	String sendEmail(String email);
}
