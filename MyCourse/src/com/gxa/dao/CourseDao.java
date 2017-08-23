package com.gxa.dao;

import java.util.List;
import java.util.Map;

import com.gxa.model.Course;

public interface CourseDao {
	/**
	 * 
	 * @param pageNum  页码
	 * @param currentPage	每页条数	
	 * @return
	 */
	public List<Course> findAllCourse(int pageNum, int currentPage);
	
	/**
	 * 通过id查询课程
	 * @param course_id 课程id
	 * @return
	 */
	public Map<String, Object> findCourseById(int course_id);
	
	/**
	 * 
	 * @param course 课程对象
	 * @return
	 */
	public int updateCourse(Course course);
	
	/**
	 * 删除课程
	 * @param course 课程对象
	 * @return
	 */
	public int deleteCourse(int course_id);
	
	/**
	 * 增加课程
	 * @param course 课程对象
	 * @return
	 */
	
	public int addCourse(Map<String,Object> map);

	
	/**
	 * 批量删除
	 * @param ids 需要删除的课程的id
	 * @return
	 */
	public int batchDel(String[] ids);

	
	/**
	 * 统计课程表的的数据条数
	 * @return
	 */
	public int findAllCount();

	
	/**
	 * 通过类型查询课程 只查询starus为1的
	 * @param course_type
	 * @return
	 */
	public List<Course> findCourse(String course_type);
	
	
	/**
	 * 查询所有课程
	 * @return
	 */
	public List<Course> findCourse();
	
	
	
	/**
	 * 通过类型查询课程
	 * @param course_type
	 * @return
	 */
	public List<Course> findByTpe(String course_type);
	

}
