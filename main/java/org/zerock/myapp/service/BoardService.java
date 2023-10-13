package org.zerock.myapp.service;

import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;

import java.util.List;

public interface BoardService {
    // 전체 게시물 조회
    List<BoardDTO> findAllBoard();

    // 특정 게시물 상세 조회
    BoardVO findBoard(BoardDTO dto);

} // end interface
