package com.gxa.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.gxa.dao.JdbcBuild;
import com.gxa.dao.UserDao;
import com.gxa.model.Users;
import com.gxa.util.DBConnection;

public class UserDaoImpl extends JdbcBuild implements UserDao {

	@Override
	public Users findUserByname(String user_name) {
		Connection conn = null;
		Users user = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM users WHERE user_name = ? ";
			QueryRunner queryRunner = new QueryRunner();
			user = queryRunner.query(conn, sql, new BeanHandler<Users>(Users.class), user_name);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return user;
	}

	@Override
	public int addUser(Users user) {
		String sql = "INSERT INTO users(user_name,user_password,user_email,user_birthday,user_sex,user_mobile) VALUES(?,?,?,?,?,?)";
		Object[] params = {user.getUser_name(),user.getUser_password(),user.getUser_email(),Date.valueOf(user.getUser_birthday()),user.getUser_sex(),user.getUser_mobile()};
		int i  = 0;
		try {
			i = updateAll(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
