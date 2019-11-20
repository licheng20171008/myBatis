package com.yx.myBatis.bean;

public class Family {

	private int id;
	private int info_id;
	private int code;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Family [id=" + id + ", info_id=" + info_id + ", code=" + code + ", name=" + name + "]";
	}
}
