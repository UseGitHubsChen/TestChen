package com.gxa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.gxa.dao.JdbcBuild;
import com.gxa.dao.OrdersDao;
import com.gxa.model.Orders;

public class OrdersDaoImpl extends JdbcBuild implements OrdersDao {

	@Override
	public List<Orders> findAllOrder(int pageNum, int currentPage) {
		String sql = "SELECT * FROM orders limit ?,?";
		List<Orders> list = null;
			try {
				list = getOrders(sql, (pageNum-1)*currentPage,currentPage);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	}

	@Override
	public int findAllCount() {
		String sql = "select count(*) from orders";
		int count = 0;
		try {
		 count =  findAllCount(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
