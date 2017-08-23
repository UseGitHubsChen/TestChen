package com.gxa.service.impl;

import com.gxa.dao.UserDao;
import com.gxa.dao.impl.UserDaoImpl;
import com.gxa.model.Users;
import com.gxa.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public int login(String user_name, String user_password) {
		Users user = userDao.findUserByname(user_name);
		int flag = 0;
		if (user != null) {
			if (user.getUser_password().equals(user_password)) {
				flag = 1 ;
			} 
		} 
			return flag;
	}

	@Override
	public int addUser(Users user) {
		return userDao.addUser(user);
	}
}


