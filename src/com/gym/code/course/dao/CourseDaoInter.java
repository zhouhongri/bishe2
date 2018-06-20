package com.gym.code.course.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Course;

public interface CourseDaoInter {
	public Course getCourseByIdDao(Course course);
	public void insertCourseDao(Course course);
	public int delCourseDao(Course course);
	public void updateCourseDao(Course course);
	public void queryCourseDao(HttpServletRequest req,int currpage);
	public List checkCoursenameDao(Course course);
	public void queryCourseByTypeDao(HttpServletRequest req, Course course, int currpage);
}
