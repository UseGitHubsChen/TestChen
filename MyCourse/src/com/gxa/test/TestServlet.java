package com.gxa.test;

import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.gxa.model.Orders;
import com.gxa.model.PageBean;
import com.gxa.service.OrdersService;
import com.gxa.service.impl.OrdersServiceImpl;

public class TestServlet {

	@Test
	public void m01(){
		OrdersService ordersService = new OrdersServiceImpl();
		int pageNum = 1;	//页码
		int currentPage = 5; //每页条数
		PageBean pb = ordersService.findAllOrder(pageNum,currentPage);
		List<Orders> list = pb.getListorder();
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}
	
	public static void main(String[] args) {
		String regex = "-";
		String ss = "dsdsd-dsdsd";
		ss.replaceAll("d", "s");
		System.out.println(ss);
		for (int i = 0; i < 10; i++) {
			  String s = UUID.randomUUID().toString();
			  s.replaceAll(regex, "");
			  System.out.println(s);
		}
		

		
	}
}
