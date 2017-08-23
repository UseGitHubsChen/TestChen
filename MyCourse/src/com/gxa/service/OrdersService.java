package com.gxa.service;

import com.gxa.model.PageBean;

public interface OrdersService {
	
	/**
	 * 查询所有订单
	 * @return
	 */
	public PageBean findAllOrder(int pageNum, int currentPage);

}
