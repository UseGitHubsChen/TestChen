package com.gxa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxa.model.PageBean;
import com.gxa.service.OrdersService;
import com.gxa.service.impl.OrdersServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/sys/Order")
public class OrdersServlet extends HttpServlet {
	
	OrdersService ordersService = new OrdersServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String v = request.getParameter("v");
		if (v==null){
			list(request,response);
		}else if(v.endsWith("list"))
		{
			list(request,response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum = 1;	//页码
		String _pageNum = request.getParameter("pageNum");
		if (_pageNum != null) {
			pageNum = Integer.parseInt(_pageNum);
		}
		
		int currentPage = 5; //每页条数
		PageBean pb = ordersService.findAllOrder(pageNum,currentPage);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/sys/order.jsp").forward(request,response);
	}

}


