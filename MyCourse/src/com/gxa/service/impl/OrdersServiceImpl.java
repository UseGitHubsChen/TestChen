package com.gxa.service.impl;

import java.util.List;

import com.gxa.dao.OrdersDao;
import com.gxa.dao.impl.OrdersDaoImpl;
import com.gxa.model.Orders;
import com.gxa.model.PageBean;
import com.gxa.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {
	OrdersDao ordersDao = new OrdersDaoImpl();
	@Override
	public PageBean findAllOrder(int pageNum, int currentPage) {
	
			PageBean pb = new PageBean();
			List<Orders> orders = ordersDao.findAllOrder(pageNum, currentPage);
			int totalCount = ordersDao.findAllCount();
			int totalPage = (int) Math.ceil(totalCount*1.0/currentPage);
			pb.setTotalPage(totalPage);	//封装总页数
			pb.setTotalCount(totalCount); //封装条数
			pb.setListorder(orders);	//封装当前也数据
			pb.setPageNum(pageNum);	//封装当前页码
			pb.setCurrentPage(currentPage); //封装每页条数
			return pb ;
	

	}

}
