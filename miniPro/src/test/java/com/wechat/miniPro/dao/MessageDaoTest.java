package com.wechat.miniPro.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDaoTest {
	@Autowired
	private MessageDao msgDao;
//	@Test
//	void testQueryMessage() {
//		List<Message> msgList = msgDao.queryMessage();
//		assertEquals(1,msgList.size());
//	}

//	@Test
//	void testQueryMessageByMid() {
//		Message msg = msgDao.queryMessageByMid(2);
//		assertEquals("world",msg.getMessage());
//	}
//
//	@Test
//	void testQueryMessageByUid() {
//		List<Message> msgList = msgDao.queryMessageByUid(2);
//		assertEquals(1,msgList.size());
//	}
//
//	@Test
//	void testInsertMessage() {
//		Message msg = new Message();
//		msg.setCnumber(3);
//		msg.setMid(3);
//		msg.setUid(2);
//		msg.setMessage("successinsert");
//		Date date = new Date(0, 0, 0);  
//		Timestamp timeStamp = new Timestamp(date.getTime()); 
//		msg.setMtime(timeStamp);
//		int res = msgDao.insertMessage(msg);
//		assertEquals(1,res);
//	}
//
//	@Test
//	void testUpdateMessage() {
//		Message msg = new Message();
//		msg.setCnumber(2);
//		msg.setMid(2);
//		msg.setUid(2);
//		msg.setMessage("successupdate");
//		int res = msgDao.updateMessage(msg);
//		assertEquals(1,res);
//	}
//
	@Test
	void testDeleteMessage() {
		int res = msgDao.deleteMessage(2);
		assertEquals(1,res);
	}

}
