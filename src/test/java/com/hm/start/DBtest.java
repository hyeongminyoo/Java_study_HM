package com.hm.start;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBtest extends MyAbstractTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		System.out.println(sqlSession);
		fail("Not yet implemented");
	}

}
