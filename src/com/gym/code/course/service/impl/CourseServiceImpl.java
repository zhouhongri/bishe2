package com.gym.code.course.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.course.dao.CourseDaoInter;
import com.gym.code.course.service.CourseServiceInter;
import com.gym.code.model.Course;

@Service
public class CourseServiceImpl implements CourseServiceInter{
	
	@Autowired
	public CourseDaoInter courseDaoInter;
	
	@Override
	public Course getCourseByIdService(Course course) {
		Course CourseInstance = this.courseDaoInter.getCourseByIdDao(course);
		return CourseInstance;
	}

	@Override
	public void insertCourseService(Course course) {
		this.courseDaoInter.insertCourseDao(course);
	}

	@Override
	public boolean delCourseService(Course course) {
		int num = this.courseDaoInter.delCourseDao(course);
		if(num == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void updateCourseService(Course course) {
		this.courseDaoInter.updateCourseDao(course);
	}

	@Override
	public void queryCourseService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.courseDaoInter.queryCourseDao(req, intcurrpage);
	}

	@Override
	public String checkCoursenameService(Course course) {
		List list = this.courseDaoInter.checkCoursenameDao(course);
		if(list.size()>0) {
			return "exist";
		}else {
			return "noexist";
		}
	}

	@Override
	public void queryCourseByTypeService(HttpServletRequest req, Course course, String currpage) {
		this.courseDaoInter.queryCourseByTypeDao(req, course, Integer.parseInt(currpage));
	}
	
}
