package com.yx.myBatis.dao;

import com.yx.myBatis.bean.Infomation;

public interface InfomationDao {

	// 查询
	public Infomation findInfoById(int id) throws Exception;
	
	// 添加
	public void insetInfo(Infomation info) throws Exception;
	
	// 删除
	public void deleteInfo(int id) throws Exception;
}
