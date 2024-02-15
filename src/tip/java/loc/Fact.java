package loc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.BoardMapper;
import dao.BoardMapperDAO;
import dao.UserMapper;
import dao.UserMapperDAO;
import myBatis.MyBatisManager;
import srv.UserService;
import srv.UserServiceImpl;

//enum은 조금 특별한 class 이다. 
//싱글톤 객체를 쉽게 생성하는데 활용하기도 한다.
public enum Fact {

  INSTANCE;

  // 마이바티즈 SqlSession 객체 생성
  private SqlSessionFact sqlSessionFact = MyBatisManager.getSqlSessionFact();
  private SqlSession sqlSession = sqlSessionFact.openSession(false);// Not Autocommit

  private UserMap userDao = new UserMapDAO(sqlSession);
  private BoardMap boardDao = new BoardMapDAO(sqlSession);

  // jsp나 컨트롤러에서 서비스객체가 필요할 경우 Factory의 get서비스() 이용
  private UserService userSr = new UserServiceImpl(userDao);

  public UserService getUserSrv() {
    return userSr;
  }
}