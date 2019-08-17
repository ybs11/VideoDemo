package com.zhiyou.service.foreground.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserMapper;
import com.zhiyou.foreground.service.UserService;
import com.zhiyou.model.User;
import com.zhiyou.model.UserExample;
import com.zhiyou.model.UserExample.Criteria;
import com.zhiyou.utils.MailUtil;

@Service
public class UserForegroundService implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Cacheable("USERACCOUNTS")
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

	@Override
	public void add(User user) {
		int insertSelective = userMapper.insertSelective(user);
		
	}

	@Override
	public String sendEmail(String email) {
		
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder code=new StringBuilder(4);
		for(int i=0;i<4;i++)
		{
		     char ch=str.charAt(new Random().nextInt(str.length()));
		     code.append(ch);
		}
		String codeString = code.toString();
		MailUtil.setMain(email,codeString );
		return codeString;
	}

	@Override
	public void update(User user) {
		int updateByPrimaryKey = userMapper.updateByPrimaryKey(user);
	}

}
