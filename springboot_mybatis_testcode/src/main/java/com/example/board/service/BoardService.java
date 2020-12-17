package com.example.board.service;

import com.example.board.domain.BoardVO;

import java.util.List;

public interface BoardService {
    Long registerBoard(BoardVO boardVO) throws Exception;
    List<BoardVO> allBoard() throws Exception;
    List<BoardVO> boardById(String userId) throws Exception;
    void updateBoard(String userId) throws Exception;
    void deleteBoard(String userId) throws Exception;
}
