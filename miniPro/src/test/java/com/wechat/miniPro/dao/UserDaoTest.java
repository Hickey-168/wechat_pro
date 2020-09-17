package com.wechat.miniPro.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wechat.miniPro.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoTest {
	@Autowired
	private UserDao userDao;
	@Test
	void testQueryUser() {
		List<User> userList = userDao.queryUser();
		assertEquals(2,userList.size());
	}

	@Test
	void testQueryUserByUid() {
		User user = userDao.queryUserByUid(1);
		assertEquals("one",user.getWname());
	}
	
	@Test
	void testQueryUserByWname() {
		User user = userDao.queryUserByWname("one");
		assertEquals(1,user.getUid());
	}
	
	@Test
	void testInsertUser() {
		User user = new User();
		user.setName("zhangsan");
		user.setUid(3);
		user.setWname("three");
		int eNum = userDao.insertUser(user);
		assertEquals(1,eNum);
	}
	
	@Test
	void testUpdateUser() {
		User user = new User();
		user.setName("youer");
		user.setUid(2);
		user.setWname("Two");
		int eNum = userDao.updateUser(user);
		assertEquals(1,eNum);
	}
	
	@Test
	void testDeleteUser() {
		int eNum = userDao.deleteUser(1);
		assertEquals(1,eNum);
	}
}
