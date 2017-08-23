package com.gxa.service.impl;

import java.util.List;
import java.util.Map;

import com.gxa.dao.CourseDao;
import com.gxa.dao.impl.CourseDaoImpl;
import com.gxa.model.Course;
import com.gxa.model.PageBean;
import com.gxa.service.CourseService;

public class CourseServiceImpl implements CourseService {

	CourseDao courseDao = new CourseDaoImpl();

	/**
	 * 查询所有用户
	 */
	@Override
	public PageBean findAllCourse(int pageNum, int currentPage) {
		PageBean pb = new PageBean();
		List<Course> course = courseDao.findAllCourse(pageNum,currentPage);
		int totalCount = courseDao.findAllCount();
		int totalPage = (int) Math.ceil(totalCount*1.0/currentPage);
		pb.setTotalPage(totalPage);	//封装总页数
		pb.setTotalCount(totalCount); //封装条数
		pb.setList(course);	//封装当前也数据
		pb.setPageNum(pageNum);	//封装当前页码
		pb.setCurrentPage(currentPage); //封装每页条数
		return pb ;
	}

	/**
	 * 通过id查询用户
	 */
	@Override
	public Map<String, Object> findCourseById(int course_id) {
		return courseDao.findCourseById(course_id);
	}

	/**
	 * 修改课程信息
	 */
	@Override
	public int updateCourse(Course course) {
		return courseDao.updateCourse(course);
	}

	/**
	 * 删除课程
	 */
	@Override
	public int deleteCourse(int course_id) {
		return courseDao.deleteCourse(course_id);
	}

	/**
	 * 增加课程
	 */

	@Override
	public int addCourse(Map<String,Object> map) {
		return courseDao.addCourse(map);
	}

	
	/**
	 * 批量删除
	 */
	@Override
	public int batchDel(String[] ids) {
		return courseDao.batchDel(ids);
	}

	/**
	 * 通过类型查询课程
	 */
	@Override
	public List<Course> findCourseByType(String course_type) {
		if ("course_type".equals(course_type)) {
			return courseDao.findCourse();
		} else {
			return courseDao.findCourse(course_type);
		}
	}
}
