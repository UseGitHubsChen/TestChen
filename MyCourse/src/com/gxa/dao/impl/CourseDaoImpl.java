package com.gxa.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.gxa.dao.CourseDao;
import com.gxa.dao.JdbcBuild;
import com.gxa.model.Course;


public class CourseDaoImpl extends JdbcBuild implements CourseDao {

	
	/**
	 * 查询所有课程
	 */
	@Override
	public List<Course> findAllCourse( int pageNum, int currentPage) {
		String sql = "SELECT * FROM course ORDER BY course_id DESC LIMIT ?,?";
		List<Course> list = null;
			try {
				list = getCourse(sql,(pageNum-1)*currentPage,currentPage);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return list;
	}

	
	/**
	 * 通过id查询课程
	 */
	@Override
	public Map<String, Object> findCourseById(int course_id) {
		String sql = "select * from course where course_id = ?";
		Map<String, Object> course = null;
		try {
			course = getForMap(sql, course_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;	
	}

	/**
	 * 修改课程信息
	 */
	@Override
	public int updateCourse(Course course) {
		String sql = "UPDATE course SET course_name = ?,course_price = ?,course_type = ?,course_desc = ?,course_time = ? ,course_status = ? WHERE course_id = ?";
		Object[] params = {course.getCourse_name(),course.getCourse_price(),course.getCourse_type(),course.getCourse_img(),course.getCourse_time(),course.getCourse_status(),course.getCourse_id()};
		int i = 0;
		try {
			i = updateAll(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 删除课程
	 */
	@Override
	public int deleteCourse(int course_id) {
		String sql = "delete from course where course_id = ?";
		int i = 0;
		try {
			i = updateAll(sql, course_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return i;
	}

	/**
	 * 增加课程
	 */
	@Override
	public int addCourse(Map<String,Object> map) {
		String sql = "INSERT INTO course(course_name,course_price,course_type,course_img,course_video,course_desc,course_time,course_status) VALUES(?,?,?,?,?,?,?,?)";
/*		Object[] params = {course.getCourse_name(),course.getCourse_price(),course.getCourse_type(),course.getCourse_img(),course.getCourse_video(),course.getCourse_desc(),course.getCourse_time(),course.getCourse_status()};*/
		Object[] params = {map.get("course_name"),map.get("course_price"),map.get("course_type"),map.get("course_img"),map.get("course_video"),map.get("course_desc"),map.get("course_time"),map.get("course_status")};

		int i = 0;
		try {
			i = updateAll(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return i ;
	}


	/**
	 * 批量删除
	 */
	@Override
	public int batchDel(String[] ids) {
		int j = 0;
		for (int i = 0; i < ids.length; i++) {
			j = deleteCourse(Integer.valueOf(ids[i]));
		}
		return j;
	}


	/**
	 * 统计课程的数目
	 */
	@Override
	public int findAllCount() {
			String sql = "select count(*) from course";
			int count = 0;
			try {
			 count =  findAllCount(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
	}

	
	/**
	 * 通过类型查询课程 只查询starus为1的
	 * @param course_type
	 * @return
	 */
	@Override
	public List<Course> findCourse(String course_type) {
		String sql = "SELECT * FROM course where course_type = ? and course_status = '1' ";
		List<Course> list = null;
			try {
				list = getCourse(sql,course_type);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return list;
	}

	
	/**
	 * 查询所有课程
	 * @return
	 */
	@Override
	public List<Course> findCourse() {
		String sql = "SELECT * FROM course  WHERE course_status = '1' ORDER BY course_id DESC";
		List<Course> list = null;
			try {
				list = getCourse(sql,null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 	return list;
	}


	
	/**
	 * 通过类型查询课程
	 * @param course_type
	 * @return
	 */
	@Override
	public List<Course> findByTpe(String course_type) {
		String sql = "SELECT * FROM course where course_type = ? ";
		List<Course> list = null;
			try {
				list = getCourse(sql,course_type);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return list;
	}
	
}
