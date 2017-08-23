package com.gxa.dao.impl; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.gxa.dao.AdminDao;
import com.gxa.dao.JdbcBuild;
import com.gxa.model.Admin;
import com.gxa.util.DBConnection;

public class AdminDaoImpl extends JdbcBuild implements AdminDao {


	@Override
	public Admin findAdminByname(String name) {
		Connection conn = null;
		Admin admin = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM admin WHERE admin_name = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {
				int admin_id = resultSet.getInt("admin_id");
				String admin_name = resultSet.getString("admin_name");
				String admin_password = resultSet.getString("admin_password");
				admin = new Admin(admin_id, admin_name, admin_password);
			} else {
				return null;
			}
		} catch (SQLException e) {

		} finally {
			try {
				DBConnection.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin;
	}

}

