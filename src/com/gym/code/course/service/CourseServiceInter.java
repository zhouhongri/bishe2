package com.gym.code.course.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Course;

public interface CourseServiceInter {
	public Course getCourseByIdService(Course course);
	public void insertCourseService(Course course);
	public boolean delCourseService(Course course);
	public void updateCourseService(Course course);
	public void queryCourseService(HttpServletRequest req,String currpage);
	public String checkCoursenameService(Course course);
	public void queryCourseByTypeService(HttpServletRequest req, Course course, String currpage);
}
