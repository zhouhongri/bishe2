package com.gym.code.course.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.course.service.CourseServiceInter;
import com.gym.code.model.Course;

@Controller
@RequestMapping("courseCtrl")
public class CourseController {
	@Autowired
	public CourseServiceInter courseServiceInter;
	
	@RequestMapping("queryCourse")
	public String queryCourse(HttpServletRequest req,String currpage) {
		this.courseServiceInter.queryCourseService(req, currpage);
		return "tourist/courses";
	}
	
	@RequestMapping("queryCourseById")
	public String queryCourseByIdCtrl(HttpServletRequest req, Course course) {
		Course courseInstance = this.courseServiceInter.getCourseByIdService(course);
		req.setAttribute("Course", courseInstance);
		return "admin/courses_update";
	}
	
	@RequestMapping("updateCourse")
	@ResponseBody
	public boolean updateDemp(Course course) {
		this.courseServiceInter.updateCourseService(course);
		return true;
	}
	
	@RequestMapping("delCourseById")
	@ResponseBody
	public boolean delDempById(Course course) {
		boolean flag = this.courseServiceInter.delCourseService(course);
		return flag;
	}
	//管理员添加课程
	@RequestMapping("insertCourse")
	@ResponseBody
	public boolean insertCourse(Course course) {
		this.courseServiceInter.insertCourseService(course);
		return true;
	}
	
	@RequestMapping("checkCoursename")
	@ResponseBody
	public String checkCoursename(Course course) {
		String flag = this.courseServiceInter.checkCoursenameService(course);
		return flag;
	}
	
	@RequestMapping("queryCourseByType")
	public String queryCourseByType(HttpServletRequest req,Course course, String currpage) {
		this.courseServiceInter.queryCourseByTypeService(req, course, currpage);
		if("0".equals(course.getCourseType())) {
			return "tourist/recure_list";
		}else if("1".equals(course.getCourseType())) {
			return "tourist/function_list";
		}else if("2".equals(course.getCourseType())) {
			return "tourist/shape_list";
		}else {
			return "tourist/welcome";
		}
	}
	//管理员课程列表查询
	@RequestMapping("queryCourseAdmin")
	public String queryCourseAdmin(HttpServletRequest req,String currpage) {
		this.courseServiceInter.queryCourseService(req, currpage);
		return "admin/courses";
	}
	//管理员分配课程
	@RequestMapping("queryCourseGivelessons")
	public String queryCourseGivelessons(HttpServletRequest req, Course course) {
		Course courseInstance = this.courseServiceInter.getCourseByIdService(course);
		req.setAttribute("Course", courseInstance);
		return "admin/givelessons";
	}
	
}
