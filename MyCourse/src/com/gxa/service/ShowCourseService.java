package com.gxa.service;

import java.util.List;

import com.gxa.model.Course;

public interface ShowCourseService {
	
	/**
	 * 按照类型查询课程
	 * @param course_type
	 * @return
	 */
	public List<Course> findCourse(String course_type);
}
