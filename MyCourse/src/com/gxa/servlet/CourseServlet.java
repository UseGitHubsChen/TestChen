package com.gxa.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.gxa.model.Course;
import com.gxa.model.PageBean;
import com.gxa.service.CourseService;
import com.gxa.service.impl.CourseServiceImpl;
import com.gxa.util.FileUploadUtils;
import com.gxa.util.StrUtil;

@WebServlet("/sys/Course")
public class CourseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	CourseService courseService = new CourseServiceImpl();

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
			if (v == null) {
			list(request, response);
			} else if (v.endsWith("list")) {
			list(request, response);
			} else if (v.endsWith("editCourse")) {
			editCourse(request, response);
			} else if (v.endsWith("update")) {
			update(request, response);
			}else if (v.endsWith("del")) {
				del(request, response);
			}else if (v.endsWith("add")) {
				add(request, response);
			}else if(v.endsWith("batchDel")){
				batchDel(request,response);
			}else if(v.endsWith("findByType")){
				findByType(request,response);
			}

	}
	
	/**
	 * 查询所有课程
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	private void findByType(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		int pageNum = 1;	//页码
		String _pageNum = request.getParameter("pageNum");
		if (_pageNum != null) {
			pageNum = Integer.parseInt(_pageNum);
		}
		
		int currentPage = 5;
		String course_type = request.getParameter("course_type");
		List<Course> list = courseService.findCourseByType(course_type);
		PageBean pb = new PageBean();
		pb.setList(list);
		pb.setPageNum(pageNum);
		pb.setCurrentPage(currentPage);
		request.setAttribute("pb", pb);
		try {
			request.getRequestDispatcher("course.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量删除
	 * @param request
	 * @param response
	 */
	private void batchDel(HttpServletRequest request,
			HttpServletResponse response) {
		String[] ids = request.getParameterValues("ck");
		if (ids!=null) {
			int i = courseService.batchDel(ids);
			if (i==1) {
				try {
					response.sendRedirect("/MyCourse/sys/Course?v=list");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("mess", "删除发生错误,请在重试！");
				try {
					request.getRequestDispatcher("/sys/Course?v=list").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
				}
			}else{
				request.setAttribute("mess", "没有选择要删除的人");
				try {
					request.getRequestDispatcher("/sys/Course?v=list").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
		}
	}
	/**
	 * 新增用户
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ServletException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException, ServletException {
		
	
		String savepath = "F:/xiangmu/MyCourse/WebContent/MyCourseData/"; //上传文件的保存路径
		File file = new File(savepath);

		if (!file.exists()) { //判断文件上传的路径是否不存在
			file.mkdirs();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 100, file); // 使用默认的.
		
		ServletFileUpload upload = new ServletFileUpload(factory);

		Map<String,Object> map = new HashMap<>();
			// 解决上传文件名称中文乱码
			upload.setHeaderEncoding("utf-8");

			// 设置上传文件大小
			// upload.setSizeMax(1024 * 1024 * 10);// 总大小为10m

			try {
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);// 解决request,得到所有的上传项FileItem

				// 3.得到所有上传项
				for (FileItem item : items) {
					if (item.isFormField()) {  //判断如果现在获取参数是来自于普通form参数，除<input type="file">以外
						String fieldName = item.getFieldName(); //参数名
						String value = item.getString("utf-8"); //获取用户填写参数值
						map.put(fieldName, value); //页面中获取参数放入到map集合
						
					} else {
					
						// 上传组件
						String name = item.getName(); // 上传文件名称
						// 得到上传文件真实名称
						String filename = FileUploadUtils.getRealName(name);
						
						// 得到随机名称
						String uuidname = FileUploadUtils.getUUIDFileName(filename);

						IOUtils.copy(item.getInputStream(),new FileOutputStream(new File(savepath+"/"+uuidname)));
						
						String fName = item.getFieldName(); 
						
						map.put(fName, "MyCourseData/"+uuidname);
						
						item.delete();
					}
				}
			} catch (FileUploadException e) {
				response.sendRedirect("/MyCourse/sys/Course?v=list");
				return;
			}
			String vars[] = { (String) map.get("course_name"),(String) map.get("course_price"),(String) map.get("course_type"),(String) map.get("course_img"),(String) map.get("course_video"),(String) map.get("course_time"),(String) map.get("course_status")};
			if (!StrUtil.checkStr(vars)) {
				request.setAttribute("message", "用户数据不完整,请重新添加");
				try {
					request.getRequestDispatcher("course_add.jsp").forward(request, response);
					return;
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			
			int i = courseService.addCourse(map);
			if (i != 1) { 
				request.setAttribute("message", "添加失败");
				request.setAttribute("message", "用户数据不完整,请重新添加");
				return;
			}
			// 结果返回界面
			try {
				response.sendRedirect("/MyCourse/sys/Course?v=list");
				return ; 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	
	
	
	/**
	 * 删除用户
	 * @param request
	 * @param response
	 */
	
	private void del(HttpServletRequest request, HttpServletResponse response) {
		int course_id = Integer.valueOf(request.getParameter("course_id"));
		courseService.deleteCourse(course_id);
		try {
			response.sendRedirect("/MyCourse/sys/Course?v=list");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 修改课程 
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> map = request.getParameterMap();
		Course course = new Course();
		try {
			BeanUtils.populate(course, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			request.setAttribute("mess", "用户数据不正确");
		}
		// 提供一个方法，可以判断字符串是否为空
		String vars[] = { course.getCourse_type(), course.getCourse_name(),
				course.getCourse_price(),course.getCourse_time()};
		if (!StrUtil.checkStr(vars)) {
			// 有空串 返回modify修改界面，提示用户补充信息
			request.setAttribute("mess", "用户数据不完整");
			request.setAttribute("course", course);
			try {
				request.getRequestDispatcher("course_update.jsp").forward(request, response);
				return;
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		// 前台提供的数据没有问题
		
		int i = courseService.updateCourse(course);
		if (i != 1) { 
			request.setAttribute("mess", "修改失败");
			return;
		}
		// 结果返回界面
		try {
			response.sendRedirect("/MyCourse/sys/Course?v=list");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查询到要编辑的用户 
	 * 
	 * @param request
	 * @param response
	 */
	private void editCourse(HttpServletRequest request,
			HttpServletResponse response) {
		int course_id = Integer.valueOf(request.getParameter("course_id"));
		Map<String, Object> course = courseService.findCourseById(course_id);
		request.setAttribute("course", course);
		try {
			request.getRequestDispatcher("course_update.jsp").forward(request,
					response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	

	 /**
	 * 分页展示
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNum = 1;	//页码
		String _pageNum = request.getParameter("pageNum");
		if (_pageNum != null) {
			pageNum = Integer.parseInt(_pageNum);
		}
		
		int currentPage = 5; //每页条数
		PageBean pb = courseService.findAllCourse(pageNum,currentPage);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/sys/course.jsp").forward(request,
				response);
	}
}
