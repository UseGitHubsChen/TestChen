package com.gxa.test;

import java.io.RandomAccessFile;

import org.junit.Test;

import com.gxa.dao.AdminDao;
import com.gxa.dao.UserDao;
import com.gxa.dao.impl.AdminDaoImpl;
import com.gxa.dao.impl.UserDaoImpl;
import com.gxa.model.Admin;

public class TestDao {

	@Test
	public void m01(){
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin =  adminDao.findAdminByname("a");
		System.out.println(admin);
		
		
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.findUserByname("aaaa"));
	}
	
	public static void main(String[] args) {
		RandomAccessFile file;
		try{
			file = new RandomAccessFile("test.txt", "rw");
			file.writeBoolean(true);
			file.writeInt(123456);
			file.write(7890);
			file.writeLong(1000000);
			file.writeInt(777);
			file.writeFloat(.0001f);
			file.seek(5);
			System.out.println(file.readInt());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
	
	}
}
