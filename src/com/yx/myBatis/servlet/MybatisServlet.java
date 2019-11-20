package com.yx.myBatis.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yx.myBatis.bean.Infomation;
import com.yx.myBatis.mapper.InfomationMapper;
import com.yx.myBatis.vo.InfomationExtend;
import com.yx.myBatis.vo.InfomationVO;

public class MybatisServlet {

	private SqlSessionFactory ssf;

	public MybatisServlet() {

		InputStream is = null;
		try {
			// 获取路径
			String resource = "com/yx/myBatis/servlet/sqlMapConfig.xml";

			// 获取信息流
			is = Resources.getResourceAsStream(resource);

			// 创建会话工厂
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void excute() {

		// 获取sqlsession
		 SqlSession ss = ssf.openSession();

		Infomation ifm = ss.selectOne("test.findInfoById", 1);
		System.out.println(ifm);
		ss.close();
	};

	private void excute1() {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();

		List<Infomation> ifm = ss.selectList("test.findInfoByName", "%李成%");
		ss.close();
		System.out.println(ifm);
	};

	private void excute2() {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();
		Infomation ifm = new Infomation();
		ifm.setName("李成3");
		ifm.setPassword("122222");
		ss.insert("test.insertInfo", ifm);
		System.out.println(ifm.getId());
		// 提交事务
		ss.commit();
		ss.close();
	};

	private void excute3() {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();
		ss.delete("test.deleteInfoById", 9);
		ss.commit();
		ss.close();
	};

	private void excute4() {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();
		Infomation ifm = new Infomation();
		ifm.setId(1);
		ifm.setName("李成5");
		ifm.setPassword("122222");
		ss.update("test.updateInfoById", ifm);
		ss.commit();
		ss.close();
	};

	private void excute5() throws Exception {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();
		InfomationMapper infom = ss.getMapper(InfomationMapper.class);
		Infomation ifm = infom.findInfoById(1);
		System.out.println(ifm);
		ss.close();
	};

	private void excute6() throws Exception {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();
		InfomationMapper infom = ss.getMapper(InfomationMapper.class);
		InfomationVO infoVO = new InfomationVO();
		InfomationExtend infoex = new InfomationExtend();
		infoex.setName("%李成%");
		infoVO.setInfomationExtend(infoex);
		List<InfomationExtend> ifmexList = infom.findInfoByVO(infoVO);
		System.out.println(ifmexList);
		ss.close();
	};
	
	private void excute7() throws Exception {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();
		InfomationMapper infom = ss.getMapper(InfomationMapper.class);
		InfomationVO infoVO = new InfomationVO();
		InfomationExtend infoex = new InfomationExtend();
		infoex.setName("%李成%");
		infoVO.setInfomationExtend(infoex);
		List<Infomation> ifmexList = infom.findInfoMapByVO(infoVO);
		System.out.println(ifmexList);
		ss.close();
	};
	
	private void excute8() throws Exception {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();
		InfomationMapper infom = ss.getMapper(InfomationMapper.class);
		Infomation ifm1 = infom.findInfoById(1);
		System.out.println(ifm1);
		ifm1.setName("李四");
		ifm1.setPassword("666666");
		infom.updateInfoById(ifm1);
		ss.commit();
		Infomation ifm2 = infom.findInfoById(1);
		System.out.println(ifm2);
		ss.close();
	};
	
	private void excute9() throws Exception {

		// 获取sqlsession
		SqlSession ss1 = ssf.openSession();
		SqlSession ss2 = ssf.openSession();
		SqlSession ss3 = ssf.openSession();
		InfomationMapper infom1 = ss1.getMapper(InfomationMapper.class);
		InfomationMapper infom2 = ss2.getMapper(InfomationMapper.class);
		InfomationMapper infom3 = ss3.getMapper(InfomationMapper.class);
		Infomation ifm1 = infom1.findInfoById(1);
		System.out.println(ifm1);
		ss1.close();
		ifm1.setName("李四1");
		ifm1.setPassword("888888");
		infom3.updateInfoById(ifm1);
		ss3.commit();
		ss3.close();
		Infomation ifm2 = infom2.findInfoById(1);
		System.out.println(ifm2);
		ss2.close();
	};
	
	private void excute10() throws Exception {

		// 获取sqlsession
		SqlSession ss = ssf.openSession();
		InfomationMapper infom1 = ss.getMapper(InfomationMapper.class);
		Infomation ifm = new Infomation();
		ifm.setId(1);
		ifm.setName("李成5");
		ifm.setPassword("122222");
		int i = infom1.updateInfoById(ifm);
		ss.commit();
		ss.close();
		System.out.println("返回值：" + i);
	};
	
	public static void main(String[] args) throws Exception {
		MybatisServlet ms = new MybatisServlet();
		ms.excute10();
	}
}
