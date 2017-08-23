package com.gxa.dao;

import java.util.List;

import com.gxa.model.Orders;

public interface OrdersDao {
	/**
	 * 
	 * @param pageNum  页码
	 * @param currentPage	每页条数	
	 * @return
	 */
	public List<Orders> findAllOrder(int pageNum, int currentPage);
	
	
	/**
	 * 统计订单的的数据条数
	 * @return
	 */
	public int findAllCount();
}
