package com.gxa.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxa.model.Course;
import com.gxa.service.ShowCourseService;
import com.gxa.service.impl.ShowCourseServiceImpl;


@SuppressWarnings("serial")
@WebServlet("/front/showcourse")
public class ShowCourseServlet extends HttpServlet {
	ShowCourseService showCourseService = new ShowCourseServiceImpl();
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
			if (v==null) {
				
			}else if(v.endsWith("list")){
				list(request,response);
			}

	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		//request.setCharacterEncoding("utf-8");
		String course_type = request.getParameter("course_type");
		String s = new String(course_type.getBytes("ISO8859-1"),"utf-8"); 
		List<Course> list = showCourseService.findCourse(s);
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("showcourse.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
