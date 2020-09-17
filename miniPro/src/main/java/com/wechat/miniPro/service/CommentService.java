package com.wechat.miniPro.service;

import java.util.List;

import com.wechat.miniPro.entity.Comment;

public interface CommentService {
	//列出一条留言的所有评论
	List<Comment> getMsgComment(int mid);
	//查找某个用户的所有评论
	List<Comment> getMyComment(int uid);
	//添加评论
	boolean addComment(Comment comment);
	//删除评论
}
