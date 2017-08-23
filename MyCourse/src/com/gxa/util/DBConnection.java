package com.gxa.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnection {
	private static DBConnection db = null;
	private static DataSource ds = null;
	
	

	private DBConnection() {
		if (ds == null) {
			ds = new ComboPooledDataSource();
		}
		
		System.out.println(ds);
	}


	private DataSource getDataSource() {
		return ds;
	}

	
	private static DBConnection getInstance() {
		if (db == null) {
			db = new DBConnection();
		}
		return db;
	}

	public synchronized static Connection getConnection() throws SQLException {
		return getInstance().getDataSource().getConnection();
	}

	public synchronized static void closeConnection(Connection conn)
			throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.isClosed();
			conn = null;
		}
	}
	
}
