package did;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mod.BoardVO;

public class BoardMapDAO implements BoardMap {

  // 필요한 객체를 Factory에서 주입(DI)
  private SqlSession sqlSession;

  public BoardMapDAO(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  private BoardMap mp() {
    return sqlSession.getMapper(BoardMap.class);
  }

  @Override
  public List<BoardVO> findAll() {
    return mp().findAll();
  }

  @Override
  public int save(BoardVO vo) {
    int result = 0;

    // 트랜잭션 예외처리
    try {
      result = mp().save(vo);
      sqlSession.commit();

    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }

    return result;
  }

  @Override
  public BoardVO getOne(int seq) {
    return mp().getOne(seq);
  }

  @Override
  public int increaseCnt(int seq) {

    int result = 0;

    try {
      result = mp().increaseCnt(seq);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }

    return result;
  }

  @Override
  public int update(BoardVO vo) {

    System.out.println(vo.toString());
    int result = 0;

    try {
      result = mp().update(vo);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }

    return result;

  }

}