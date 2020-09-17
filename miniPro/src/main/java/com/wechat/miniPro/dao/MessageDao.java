package com.wechat.miniPro.dao;

import java.util.List;

import com.wechat.miniPro.entity.Message;

public interface MessageDao {
	//查询所有留言
    List<Message> queryMessage();

    //根据主键mid查询留言
    Message queryMessageByMid(int mid);
    
    //根据UID列出留言列表
    List<Message> queryMessageByUid(int uid);

    // 插入新的留言
    int insertMessage(Message message);

    // 更新留言信息
    int updateMessage(Message message);

    // 根据留言mid删除区域信息
    int deleteMessage(int mid);
}
