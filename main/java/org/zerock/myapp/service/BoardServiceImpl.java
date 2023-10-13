package org.zerock.myapp.service;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.persistence.BoardDAO;

import java.util.List;

@Log4j2
@NoArgsConstructor

@Service
public class BoardServiceImpl implements BoardService{
    @Setter(onMethod_ = @Autowired)
    private BoardDAO boardDAO;

    @Override
    public List<BoardDTO> findAllBoard() {
        log.trace("findAllBoard() invoked.");

        return this.boardDAO.selectAllBoard();

    } // findAllBoard

    @Override
    public BoardVO findBoard(BoardDTO dto) {
        log.trace("findBoard() invoked.");

        return this.boardDAO.selectBoard(dto);
    } // findBoard

} // end class
