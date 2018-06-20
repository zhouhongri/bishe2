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
		return "tourist/course_update";
	}
	
	@RequestMapping("updateCourse")
	public String updateDemp(Course course) {
		this.courseServiceInter.updateCourseService(course);
		return "redirect:/courseCtrl/queryCourse?currpage=1";
	}
	
	@RequestMapping("delCourseById")
	@ResponseBody
	public String delDempById(Course course) {
		String flag = this.courseServiceInter.delCourseService(course);
		return flag;
	}
	
	@RequestMapping("insertCourse")
	public String insertCourse(Course course) {
		this.courseServiceInter.insertCourseService(course);
		return "redirect:/courseCtrl/queryCourse?currpage=1";
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
}
