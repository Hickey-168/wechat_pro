package com.wechat.miniPro.entity;

import java.sql.Timestamp;

public class Message {
	//留言序列号
	private Integer mid;
	//发布者id
	private Integer uid;
	//留言内容
	private String message;
	//发言时间
	private Timestamp mtime;
	//点赞数
	private Integer likeNum;
	//评论数
	private Integer cnumber;
	
	public Integer getCnumber() {
		return cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getMtime() {
		return mtime;
	}
	public void setMtime(Timestamp mtime) {
		this.mtime = mtime;
	}
	public Integer getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}
}
