package com.wechat.miniPro.service;

import java.util.List;

import com.wechat.miniPro.entity.Message;

public interface MessageService {
	//查询所有的留言
	List<Message> getAllMessage();
	//获取一个用户的所有留言
	List<Message> getMyMessage(int uid);
	//新增message
	boolean addMessage(Message message);
	//更新留言内容
	//boolean updateMessage();
	//添加点赞数
	//删除留言
}
