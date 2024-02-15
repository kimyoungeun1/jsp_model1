package did;

import java.util.Map;

import mod.UserVO;

public interface UserMap {

  // 매퍼xml의 id값이 추상메소드 이름
  // resultType 값을 리턴타입으로 지정
  UserVO getOne(Map<String, String> loginInfo);

}