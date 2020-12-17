package com.example.board.service;

import com.example.board.domain.BoardVO;
import com.example.board.repo.BoardDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional // Test가 끝나면 ROLLBACK를 해주므로 데이터가 전부 지워진다. , 주석처리하면 실제 DB에 올라감
class BoardServiceTest {

    @Autowired BoardService boardService;
    @Autowired BoardDAO boardDAO;

    @Test
    void 게시글_등록() throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setUserId("User");
        boardVO.setTitle("TestTitle");
        boardVO.setContent("TestContent");

        boardService.registerBoard(boardVO);
    }

    @Test
    void 모든_게시글() throws Exception {
        BoardVO boardVO1 = new BoardVO();
        boardVO1.setUserId("User1");
        boardVO1.setTitle("TestTitle1");
        boardVO1.setContent("TestContent1");
        boardService.registerBoard(boardVO1);

        BoardVO boardVO2 = new BoardVO();
        boardVO2.setUserId("User2");
        boardVO2.setTitle("TestTitle2");
        boardVO2.setContent("TestContent2");
        boardService.registerBoard(boardVO2);

        List<BoardVO> result = boardService.allBoard();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void 특정_게시글() throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setUserId("User3");
        boardVO.setTitle("TestTitle3");
        boardVO.setContent("TestContent3");
        boardService.registerBoard(boardVO);

        boardService.boardById("User3");
    }

    @Test
    void 게시글_업데이트() throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setUserId("User4");
        boardVO.setTitle("TestTitle4");
        boardVO.setContent("TestContent4");
        boardService.registerBoard(boardVO);

        boardVO.setUserId("User4");
        boardVO.setTitle("TestTitle5");
        boardVO.setContent("TestContent5");
        boardService.updateBoard(boardVO.getUserId());
    }

    @Test
    void 게시글_삭제() throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setUserId("User6");
        boardVO.setTitle("TestTitle6");
        boardVO.setContent("TestContent6");
        boardService.deleteBoard("User6");
    }
}
