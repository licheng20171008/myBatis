package com.yx.myBatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yx.myBatis.bean.Infomation;

public class InfomationDaoImpl implements InfomationDao {
	
	// 注入工厂
	private SqlSessionFactory sqlSessionFactory;
	public InfomationDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Infomation findInfoById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Infomation info = sqlSession.selectOne("test.findInfoById", id);
		sqlSession.close();
		return info;
	}

	@Override
	public void insetInfo(Infomation info) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertInfo", info);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteInfo(int id) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteInfoById", 8);
		sqlSession.commit();
		sqlSession.close();
	}

}
