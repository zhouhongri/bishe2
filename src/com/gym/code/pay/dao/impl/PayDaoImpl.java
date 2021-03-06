package com.gym.code.pay.dao.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gym.code.model.Pay;
import com.gym.code.model.User;
import com.gym.code.pay.dao.PayDaoInter;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class PayDaoImpl extends BaseDao implements PayDaoInter {

	@Override
	public void insertPayDao(Pay pay) {
		Session session = this.getSession();
		session.save(pay);
	}

	@Override
	public void queryPayDao(HttpServletRequest req, int currpage) {
		HttpSession session  = req.getSession();
		User user = (User) session.getAttribute("user");
		String sql = "select course.*,sum(course_num) coursetotal from Course,pay " + 
				" where pay.course_id=course.course_id and pay.user_id='"+user.getUserId()+"' " + 
				" GROUP BY course.course_id ";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

}
