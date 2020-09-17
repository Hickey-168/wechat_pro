package com.wechat.miniPro.dao;

import java.util.List;

import com.wechat.miniPro.entity.Comment;

public interface CommentDao {
	//查询所有评论
    List<Comment> queryComment();

    //根据主键CID查询评论
    Comment queryCommentByCid(int cid);
    
    //根据uid查询评论列表
    List<Comment> queryCommentByUid(int uid);

    //根据mid查询评论列表
    List<Comment> queryCommentByMid(int mid);

    // 插入新的留言
    int insertComment(Comment comment);

    // 更新留言信息
    int updateComment(Comment comment);

    // 根据评论的CID删除区域信息
    int deleteComment(int CID);
}
