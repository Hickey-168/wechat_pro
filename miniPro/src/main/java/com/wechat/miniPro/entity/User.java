package com.wechat.miniPro.entity;

public class User {
	//用户序列号
	private Integer uid;
	//用户微信名
	private String wname;
	//用户昵称
	private String name;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
