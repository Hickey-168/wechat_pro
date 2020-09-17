package com.wechat.miniPro.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wechat.miniPro.entity.Message;
import com.wechat.miniPro.service.MessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImlTest {
	@Autowired
	private MessageService messageService;
	@Test
	public void testAddMessage() {
		Message message = new Message();
		message.setMessage("你好");
		message.setUid(2);
		boolean res = messageService.addMessage(message);
		assertEquals(true,res);
	}

}
