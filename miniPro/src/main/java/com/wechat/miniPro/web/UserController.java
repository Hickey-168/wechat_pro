package com.wechat.miniPro.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wechat.miniPro.entity.User;
import com.wechat.miniPro.service.UserService;

@RestController
@RequestMapping("/superadmin")//根路由名指定
public class UserController {
	@Autowired
	private UserService userService;//调用服务
	
	//查询所有用户
	@RequestMapping(value = "/getalluser", method = RequestMethod.GET)
	private Map<String, Object> getAllUser(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<User> list = new ArrayList<User>();
		list = userService.getAllUser();
		modelMap.put("userList", list);
		return modelMap;
	}
	
	//登录操作
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	private Map<String, Object> log(@RequestParam User user)//前端传入json信息
			 throws JsonParseException, JsonMappingException, IOException{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("logSuc", userService.log(user));
		return modelMap;
	}
}
