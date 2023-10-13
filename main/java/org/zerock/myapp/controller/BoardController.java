package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.Board;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.service.BoardService;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@NoArgsConstructor

@RequestMapping("/board/*")
@Controller
public class BoardController {
    @Setter(onMethod_ = @Autowired)
    private BoardService boardService;

    @ResponseBody
    @GetMapping("/getBoardList")
    List<BoardDTO> getBoardList() {
        log.trace("getBoardList() invoked.");

        List<BoardDTO> list = this.boardService.findAllBoard();

        return list;
    } // getBoardList

    @ResponseBody
    @GetMapping("/findBoardList")
    BoardVO findBoardList(BoardDTO dto) {
        log.trace("findBoardList() invoked.");

        return this.boardService.findBoard(dto);
    } // findBoardList

} // end class
