package com.gym.code.login.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gym.code.login.dao.LoginDaoInter;
import com.gym.code.model.User;

import framework.base.BaseDao;

@Repository
public class LoginDaoImpl extends BaseDao implements LoginDaoInter{
	
	public List<User> getUserByName(String username) {
		Session session = this.getSession();
		String hql="from User where username=?";
		Query query = session.createQuery(hql);
		query.setString(0,username);
		List<User> userList = query.list();
		return userList;
	}

	@Override
	public void updateUserprelogintime(String time, User user) {
		Session session = this.getSession();
		String hql="update User set prelogintime='"+time+"' where userId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, user.getUserId());
		query.executeUpdate();
	}

}
