package com.gxa.test;

import org.junit.Test;

import com.gxa.dao.AdminDao;
import com.gxa.dao.impl.AdminDaoImpl;
import com.gxa.model.Admin;



public class TestFinaAdmin {
	AdminDao adminDao = new AdminDaoImpl();
	
	@Test
	public void login() {
		String name = "a";
		String password = "a";
		Admin admin = adminDao.findAdminByname(name);
		
		int flag = 0;
		if (admin != null) {
			if (admin.getadmin_password().equals(password)) {
				flag = 1;
			} 
		} 
		System.out.println(flag);
	}
}
