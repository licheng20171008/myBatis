package com.yx.myBatis.bean;

import java.io.Serializable;

public class Infomation implements Serializable{

	// ID
	private int id;
	
	// 姓名
	private String name;
	
	// 密码
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Infomation [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
}
