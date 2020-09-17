package com.wechat.miniPro.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.miniPro.dao.MessageDao;
import com.wechat.miniPro.entity.Message;
import com.wechat.miniPro.service.MessageService;

@Service
public class MessageServiceIml implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		if (message.getMessage() != null && !"".equals(message.getMessage())) {
			// 设置默认值
			Timestamp nousedate = new Timestamp(System.currentTimeMillis());
			message.setMtime(nousedate);
			try {
				int res = messageDao.insertMessage(message);
				if (res > 0) {
					return true;
				} else {
					throw new RuntimeException("添加留言失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加留言失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("留言信息不能为空！");
		}
	}

	@Override
	public List<Message> getAllMessage() {
		// TODO Auto-generated method stub
		return messageDao.queryMessage();
	}

	@Override
	public List<Message> getMyMessage(int uid) {
		// TODO Auto-generated method stub
		return messageDao.queryMessageByUid(uid);
	}

}
