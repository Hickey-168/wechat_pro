package com.wechat.miniPro.service;

import java.util.List;

import com.wechat.miniPro.entity.User;

public interface UserService {
	//用户登录时信息登记
	boolean log(User user);
	//查询所有用户
	List<User> getAllUser();
}
