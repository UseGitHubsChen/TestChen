package com.gxa.service;

import java.util.List;
import java.util.Map;

import com.gxa.model.Course;
import com.gxa.model.PageBean;

public interface CourseService {

	/**
	 * 查询所有课程
	 * @return
	 */
	public PageBean findAllCourse(int pageNum, int currentPage);
	
	
	/**
	 * 通过id查询课程
	 * @param course_id
	 * @return
	 */
	public Map<String, Object> findCourseById(int course_id);
	
	
	/**
	 * 修改课程信息
	 * @param course
	 * @return
	 */
	public int updateCourse(Course course);
	
	/**
	 * 删除课程
	 * @param course
	 * @return
	 */
	public int deleteCourse(int  course_id);
	
	/**
	 * 增加课程
	 * @param course
	 * @return
	 */
	public int addCourse(Map<String,Object> map);

	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int batchDel(String[] ids);
	
	
	/**
	 * 按照类型查询课程
	 * @param course_type
	 * @return
	 */
	public List<Course> findCourseByType(String course_type);

}