package org.zerock.myapp.persistence;


import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;

import java.util.List;

public interface BoardDAO {

    // 전체 게시물 조회
    public abstract List<BoardDTO> selectAllBoard();

    // 특정 게시물 상세 조회
    public abstract BoardVO selectBoard(BoardDTO dto);

} // end interface
