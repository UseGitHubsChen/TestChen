package com.gxa.service.impl;

import java.util.List;

import com.gxa.dao.CourseDao;
import com.gxa.dao.impl.CourseDaoImpl;
import com.gxa.model.Course;
import com.gxa.service.ShowCourseService;

public class ShowCourseServiceImpl implements ShowCourseService {
	CourseDao courseDao = new CourseDaoImpl();

	@Override
	public List<Course> findCourse(String course_type) {
		if ("course_type".equals(course_type)) {
			return courseDao.findCourse();
		} else {
			return courseDao.findCourse(course_type);
		}
	}
}
