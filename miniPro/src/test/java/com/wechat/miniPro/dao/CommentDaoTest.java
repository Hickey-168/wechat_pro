package com.wechat.miniPro.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wechat.miniPro.entity.Comment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {
	@Autowired
	private CommentDao commentDao;
	
//	@Test
//	public void testQueryComment() {
//		List<Comment> commentList = commentDao.queryComment();
//		assertEquals(1,commentList.size());
//	}

//	@Test
//	public void testQueryCommentByCid() {
//		Comment comment = commentDao.queryCommentByCid(1);
//		assertEquals(3,comment.getMid());
//	}
//
//	@Test
//	public void testQueryCommentByUid() {
//		Comment comment = commentDao.queryCommentByCid(2);
//		assertEquals(3,comment.getMid());
//	}
//
	@Test
	public void testQueryCommentByMid() {
		List<Comment> comment = commentDao.queryCommentByMid(3);
		assertEquals(3,comment.size());
	}
//
//	@Test
//	public void testInsertComment() {
//		Comment comment = new Comment();
//		comment.setCid(3);
//		comment.setComment("insertSuc");
//		comment.setMid(3);
//		comment.setUid(2);
//		Date date = new Date(0, 0, 0);
//		Timestamp timeStamp = new Timestamp(date.getTime()); 
//		comment.setCtime(timeStamp);
//		int res = commentDao.insertComment(comment);
//		assertEquals(1,res);
//		}
//
//	@Test
//	public void testUpdateComment() {
//		Comment comment = new Comment();
//		comment.setCid(2);
//		comment.setComment("updateSuc");
//		comment.setMid(3);
//		comment.setUid(2);
//		int res = commentDao.updateComment(comment);
//		assertEquals(1,res);
//	}

//	@Test
//	public void testDeleteComment() {
//		int res = commentDao.deleteComment(1);
//		assertEquals(1,res);
//	}

}
