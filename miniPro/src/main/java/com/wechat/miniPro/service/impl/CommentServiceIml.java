package com.wechat.miniPro.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wechat.miniPro.dao.CommentDao;
import com.wechat.miniPro.entity.Comment;
import com.wechat.miniPro.service.CommentService;

@Service
public class CommentServiceIml implements CommentService{

	@Autowired
	CommentDao commentDao;
	@Override
	public List<Comment> getMsgComment(int mid) {
		// TODO Auto-generated method stub
		return commentDao.queryCommentByMid(mid);
	}

	@Override
	public List<Comment> getMyComment(int uid) {
		// TODO Auto-generated method stub
		return commentDao.queryCommentByUid(uid);
	}

	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		if (comment.getComment() != null && !"".equals(comment.getComment())) {
			// 设置默认值
			Timestamp nousedate = new Timestamp(System.currentTimeMillis());
			comment.setCtime(nousedate);
			try {
				int res = commentDao.insertComment(comment);
				if (res > 0) {
					return true;
				} else {
					throw new RuntimeException("添加评论失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加评论失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("评论信息不能为空！");
		}
	}

}
