package com.gym.code.user.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gym.code.model.User;
import com.gym.code.user.dao.UserDaoInter;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class UserDaoImpl extends BaseDao implements UserDaoInter{

	@Override
	public User getUserByIdDao(User user) {
		Session session = this.getSession();
		User userInstance = (User) session.get(user.getClass(), user.getUserId());
		return userInstance;
	}

	@Override
	public void insertUserDao(User user) {
		Session session = this.getSession();
		session.save(user);
	}

	@Override
	public int delUserDao(User user) {
		Session session = this.getSession();
		String hql = "delete from User where userId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, user.getUserId());
		return query.executeUpdate();
	}

	@Override
	public void updateUserDao(User user) {
		Session session = this.getSession();
		session.update(user);
	}

	@Override
	public void queryUserDao(HttpServletRequest req, int currpage) {
		String sql = "select * from user";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public List checkUsernameDao(User user) {
		Session session = this.getSession();
		String hql = "from User where username=?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getUsername());
		return query.list();
	}

	@Override
	public int changePasswordDao(User user) {
		Session session = this.getSession();
		String hql = "update User set password='"+user.getPassword()+"' where userId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, user.getUserId());
		return query.executeUpdate();
	}
	
}
