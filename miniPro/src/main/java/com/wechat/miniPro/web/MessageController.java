package com.wechat.miniPro.web;

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

import com.wechat.miniPro.entity.Message;
import com.wechat.miniPro.service.MessageService;

@RestController
@RequestMapping("/superadmin")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
    @RequestMapping(value = "/getallmsg", method = RequestMethod.GET)
    private Map<String, Object> getAllMessage() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Message> list = new ArrayList<Message>();
        list = messageService.getAllMessage();
        modelMap.put("allMessageList", list);
        return modelMap;
    }
    
    @RequestMapping(value = "/getmymsg", method = RequestMethod.GET)
    private Map<String, Object> getMyMessage(@RequestParam int uid){
    	Map<String, Object> modelMap = new HashMap<String, Object>();
    	List<Message> list = new ArrayList<Message>();
    	list = messageService.getMyMessage(uid);
    	modelMap.put("myMessageList", list);
    	return modelMap;
    }
    
    @RequestMapping(value = "/addmsg", method = RequestMethod.POST)
    private Map<String, Object> addMessage(@RequestBody Message message){
    	Map<String, Object> modelMap = new HashMap<String, Object>();
    	modelMap.put("addMsgSuc", messageService.addMessage(message));
    	return modelMap;
    }
}
