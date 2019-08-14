package com.zhiyou.service.foreground;

import java.util.List;

import com.zhiyou.model.User;

public interface UserService {

	User SelectByAccounts(String accounts);
    User SelectById(int id);
	
}
