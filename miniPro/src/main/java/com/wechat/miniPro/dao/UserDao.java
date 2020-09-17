package com.wechat.miniPro.dao;

import java.util.List;

import com.wechat.miniPro.entity.User;

public interface UserDao {
	//列出所有用户列表
    List<User> queryUser();

    //根据主键UID搜索出用户列表
    User queryUserByUid(int uid);
    
    //根据wname即微信名搜索出用户列表
    User queryUserByWname(String wname);

    // 插入新用户
    int insertUser(User user);

    // 更新用户信息
    int updateUser(User user);

    // 根据主键UID删除用户信息
    int deleteUser(int UID);
}
