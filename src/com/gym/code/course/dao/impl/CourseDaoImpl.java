package com.gym.code.course.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gym.code.course.dao.CourseDaoInter;
import com.gym.code.model.Course;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class CourseDaoImpl extends BaseDao implements CourseDaoInter{

	@Override
	public Course getCourseByIdDao(Course course) {
		Session session = this.getSession();
		Course CourseInstance = (Course) session.get(course.getClass(), course.getCourseId());
		return CourseInstance;
	}

	@Override
	public void insertCourseDao(Course course) {
		Session session = this.getSession();
		session.save(course);
	}

	@Override
	public int delCourseDao(Course course) {
		Session session = this.getSession();
		String hql = "delete from Course where CourseId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, course.getCourseId());
		return query.executeUpdate();
	}

	@Override
	public void updateCourseDao(Course course) {
		Session session = this.getSession();
		session.update(course);
	}

	@Override
	public void queryCourseDao(HttpServletRequest req, int currpage) {
		String sql = "select * from Course";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public List checkCoursenameDao(Course course) {
		Session session = this.getSession();
		String hql = "from Course where courseName=?";
		Query query = session.createQuery(hql);
		query.setString(0, course.getCourseName());
		return query.list();
	}

	@Override
	public void queryCourseByTypeDao(HttpServletRequest req, Course course, int currpage) {
		String sql = "select course.*,user.name,user.sex,user.age from Course,givelessons,user " + 
				" where course.course_type='"+course.getCourseType()+"'and " + 
				" givelessons.user_id=user.user_id and " + 
				" givelessons.course_id=course.course_id";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}
	
}
