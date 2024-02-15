package did;

import java.util.List;

import mod.BoardVO;

public interface BoardMap {

  List<BoardVO> findAll();

  int save(BoardVO vo);
}