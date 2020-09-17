package com.wechat.miniPro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.miniPro.dao.UserDao;
import com.wechat.miniPro.entity.User;
import com.wechat.miniPro.service.UserService;

@Service
public class UserServiceIml implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean log(User user) {
		// TODO Auto-generated method stub
		if(user.getWname() != null && !"".equals(user.getWname())) {
			User tuser = userDao.queryUserByWname(user.getWname());
			if(tuser != null) {
				//设置默认值
				//
				try {
					int res = userDao.insertUser(user);
					if(res > 0) {
						return true;
					}
					else {
						throw new RuntimeException("添加用户信息失败!");
					}
				}
				catch(Exception e) {
					throw new RuntimeException("添加用户信息失败:" + e.toString());
				}
			}
			else {
				throw new RuntimeException("用户已经存在");
			}
		}
		else {
			throw new RuntimeException("微信名信息不能为空！");
		}
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.queryUser();
	}

}
