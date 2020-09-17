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

import com.wechat.miniPro.entity.Comment;
import com.wechat.miniPro.entity.Message;
import com.wechat.miniPro.service.CommentService;

@RestController
@RequestMapping("/superadmin")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/getmsgcomment", method = RequestMethod.GET)
	private Map<String, Object> getMsgComment(@RequestParam Integer mid) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Comment> list = new ArrayList<Comment>();
		list = commentService.getMsgComment(mid);
		modelMap.put("msgCommentList", list);
		return modelMap;
	}
	
	@RequestMapping(value = "/getmycomment", method = RequestMethod.GET)
	private Map<String, Object> getMyComment(@RequestParam int uid) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Comment> list = new ArrayList<Comment>();
		list = commentService.getMsgComment(uid);
		modelMap.put("myCommentList", list);
		return modelMap;
	}
	
    @RequestMapping(value = "/addcomment", method = RequestMethod.POST)
    private Map<String, Object> addcomment(@RequestBody Comment comment){
    	Map<String, Object> modelMap = new HashMap<String, Object>();
    	modelMap.put("addCommentSuc", commentService.addComment(comment));
    	return modelMap;
    }
}
