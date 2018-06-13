package com.gym.code.login.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.login.dao.LoginDaoInter;
import com.gym.code.login.service.LoginServiceInter;
import com.gym.code.model.User;

@Service
public class LoginServiceImpl implements LoginServiceInter {
	
	@Autowired
	public LoginDaoInter loginDaoInter;
	@Override
	public Map<String, Object> login(
			HttpSession session, User user) {
		// TODO Auto-generated method stub
		Map<String,Object> result = new HashMap<String, Object>();
		List<User> list = this.loginDaoInter.getUserByName(user.getUsername());
		if(list.size()>0&&list!=null){
			if(user.getPassword().equals(list.get(0).getPassword())){
				result.put("result",true);
				result.put("mess", "登录成功");
				session.setAttribute("user", list.get(0));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String time = sdf.format(new Date());
				this.loginDaoInter.updateUserprelogintime(time, list.get(0));
				if("0".equals(list.get(0).getIdentity())){
					result.put("useridentity", "管理员");
				}else if("1".equals(list.get(0).getIdentity())){
					result.put("useridentity", "游客");
				}else if("2".equals(list.get(0).getIdentity())){
					result.put("useridentity", "会员");
				}else if("3".equals(list.get(0).getIdentity())){
					result.put("useridentity", "教练");
				}	
			}else{
				result.put("result", false);
				result.put("mess", "密码不正确");
			}	
		}
		else{
			result.put("result", false);
			result.put("mess", "用户名不存在");
		}
		return result;
	}

}
