package com.gxa.dao;

import com.gxa.model.Users;

public interface UserDao {
	/**
	 * 查找User
	 * @param user_name
	 * @return
	 */
	public Users findUserByname(String user_name);
	
	/**
	 * 添加操作
	 * @param map
	 * @return
	 */
	public int addUser(Users user);
}
