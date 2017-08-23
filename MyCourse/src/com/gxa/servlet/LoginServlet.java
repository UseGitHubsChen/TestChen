package com.gxa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxa.dao.AdminDao;
import com.gxa.dao.UserDao;
import com.gxa.dao.impl.AdminDaoImpl;
import com.gxa.dao.impl.UserDaoImpl;
import com.gxa.service.AdminService;
import com.gxa.service.UserService;
import com.gxa.service.impl.AdminServiceImpl;
import com.gxa.service.impl.UserServiceImpl;



@WebServlet("/login/Login.do")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminServiceImpl();
	UserService userService = new UserServiceImpl();
    UserDao userDao = new UserDaoImpl();
    AdminDao adminDao = new AdminDaoImpl();
    
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utg-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		String code1 = (String) request.getSession().getAttribute("code");
		String code2 = request.getParameter("code").trim();
		
		if (username != null && !"".equals(username) && password != null && !"".equals(password)){
		if (!"".equals(code2)&&code2!=null) {
			{
				if (userService.login(username, password) == 1 && code1.trim().equalsIgnoreCase(code2.trim())){
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					response.sendRedirect("/MyCourse/login/refresh2.html");
				}else if (adminService.login(username, password) == 1 && code1.trim().equalsIgnoreCase(code2.trim())) {
					HttpSession session = request.getSession();
					session.setAttribute("adminname", username);
					response.sendRedirect("/MyCourse/login/refresh.html");
				}else {
					request.setAttribute("msg", "用户名密码错误！！！");
					request.getRequestDispatcher("/login/login.jsp").forward(request, response);
				}
				
					
			}
		}else{
			request.setAttribute("yzmsg", "验证错误！");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			}
		} 
		else {
			request.setAttribute("msg", "用户名密码错误！");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		
	}
}
