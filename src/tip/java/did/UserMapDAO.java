package did;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mod.UserVO;

public class UserMapDAO implements UserMap {

  // SqlSession 객체(팩토리에서 주입)
  SqlSession sqlSession;

  // 생성자를 통한 DI 준비
  public UserMapDAO(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  // 매퍼xml에 접근할 수 있는 객체를 리턴하는 함수
  public UserMapper mp() {
    return sqlSession.getMapper(UserMapper.class);
  }

  @Override
  public UserVO getOne(Map<String, String> loginInfo) {
    return mp().getOne(loginInfo);
  }

}