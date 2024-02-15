package jdc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisManager;


public class MyBatisConneTest {
  SqlSessionFact sqlSessionFact = MyBatisManager.getSqlSessionFactory();
  SqlSession sqlSession = sqlSessionFact.openSession();

@Test
public void sqlSessionTest() {
  assertNotNuLL(sqlSession);
}
  
  
}