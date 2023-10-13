package org.zerock.myapp.persistence;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@NoArgsConstructor

@Repository
public class BoardDAOImpl implements BoardDAO{


    // 1. 전체 게시물 조회
    @Override
    public List<BoardDTO> selectAllBoard() {
        log.trace("selectAllBoard() invoked.");

        List<BoardDTO> list = new ArrayList<>();

        for(int i=1; i<=3; i++) {
            BoardDTO dto = new BoardDTO();
            dto.setTitle("TITLE_"+ i);
            dto.setWriter("WRITER_" + i);
            dto.setContent("CONTENT_" + i);

            list.add(dto);
        } // for

        list.forEach(log::info);

        return null;
    } // selectAllBoard

    // 게시물 상세 조회
    @Override
    public BoardVO selectBoard(BoardDTO dto) {
        log.trace("selectBoard({}) invoked.", dto);

        BoardVO vo = new BoardVO(
                dto.getSeq(),
                "TITLE_" +dto.getSeq(),
                "WRITER_" + dto.getSeq(),
                "CONTENT_" + dto.getSeq() );



        return null;
    } // selectBoard


} // end class
