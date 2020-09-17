package com.wechat.miniPro.entity;

import java.sql.Timestamp;

public class Comment {
	//评论序列号
	private Integer cid;
	//留言id
	private  Integer mid;
	//评论者id
	private Integer uid;
	//评论时间
	private Timestamp ctime;
	//评论内容
	private String  comment;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getCtime() {
		return ctime;
	}
	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}
}
