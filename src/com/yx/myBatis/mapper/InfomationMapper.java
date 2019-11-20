package com.yx.myBatis.mapper;

import java.util.List;
import java.util.Map;

import com.yx.myBatis.bean.Infomation;
import com.yx.myBatis.vo.InfomationExtend;
import com.yx.myBatis.vo.InfomationVO;

public interface InfomationMapper {

	// 综合查询
	public List<InfomationExtend> findInfoByVO(InfomationVO infovo) throws Exception;
	
	// map
	public List<Infomation> findInfoMapByVO(InfomationVO infovo) throws Exception;
	
	// 查询
	public Infomation findInfoById(int id) throws Exception;
	
	// 添加
	public void insetInfo(Infomation info) throws Exception;
	
	// 删除
	public void deleteInfo(int id) throws Exception;
	
	public int updateInfoById(Infomation info) throws Exception;
}
