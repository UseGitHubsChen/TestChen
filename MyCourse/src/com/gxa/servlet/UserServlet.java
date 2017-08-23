package com.gxa.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.gxa.model.Users;
import com.gxa.service.UserService;
import com.gxa.service.impl.UserServiceImpl;
import com.gxa.util.StrUtil;


@SuppressWarnings("serial")
@WebServlet("/login/User")
public class UserServlet extends HttpServlet {
	UserService userService = new UserServiceImpl();

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
		
		 if (v.endsWith("regist")) {
			 regist(request,response);
		}
		 
		

	}

	private void regist(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> map =  request.getParameterMap();
		 Users user = new Users();
			try {
				BeanUtils.populate(user, map);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				request.setAttribute("mess", "用户数据不正确");
			}
			// 提供一个方法，可以判断字符串是否为空
			String vars[] = {user.getUser_name(),
					user.getUser_password(),user.getUser_mobile()};
			if (!StrUtil.checkStr(vars)) {
				// 有空串 返回modify修改界面，提示用户补充信息
				request.setAttribute("mess", "用户数据不完整");	
				try {
					response.sendRedirect("regist.jsp");
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 前台提供的数据没有问题
			int i = userService.addUser(user);
			if (i != 1) { 
				request.setAttribute("mess", "添加失败");
				return;
			}
			try {
				response.sendRedirect("/MyCourse/login/login.jsp");
			} catch (IOException e1) {
					e1.printStackTrace();
			}
	}
}
