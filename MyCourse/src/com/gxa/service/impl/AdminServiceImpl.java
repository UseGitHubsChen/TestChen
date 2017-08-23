package com.gxa.service.impl;

import com.gxa.dao.AdminDao;
import com.gxa.dao.impl.AdminDaoImpl;
import com.gxa.model.Admin;
import com.gxa.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao = new AdminDaoImpl();

	@Override
	public int login(String name,String password) {
		Admin admin = adminDao.findAdminByname(name);
		int flag = 0;
		if (admin != null) {
			if (admin.getadmin_password().equals(password)) {
				flag = 1;
			} 
		} 
			return flag;
	}
}
