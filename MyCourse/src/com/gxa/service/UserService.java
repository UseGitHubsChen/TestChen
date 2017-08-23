package com.gxa.service;

import com.gxa.model.Users;

public interface UserService {
	/**
	 * 登录操作
	 * @param user_name
	 * @param user_password
	 * @return
	 */
	public int login(String user_name,String user_password);
	
	
	/**
	 * 注册操作
	 * @param user
	 * @return
	 */
	public int addUser(Users user);
}
