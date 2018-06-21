package com.gym.code.givelessons.dao.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.gym.code.givelessons.dao.GivelessonsDaoInter;
import com.gym.code.model.User;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class GivelessonsDaoImpl extends BaseDao implements GivelessonsDaoInter {

	@Override
	public void queryGivelessonsDao(HttpServletRequest req, int currpage) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		String sql = "select course.* from givelessons,course "
				+ "where givelessons.course_id=course.course_id and givelessons.user_id="+user.getUserId();
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

}
