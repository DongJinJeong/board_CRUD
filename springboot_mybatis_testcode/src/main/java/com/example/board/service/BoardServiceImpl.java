package com.example.board.service;

import com.example.board.domain.BoardVO;
import com.example.board.repo.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    private BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public Long registerBoard(BoardVO boardVO) throws Exception {
        boardDAO.registerBoard(boardVO);
        return null;
    }

    @Override
    public List<BoardVO> allBoard() throws Exception {
        return boardDAO.allBoard();
    }

    @Override
    public List<BoardVO> boardById(String userId) throws Exception {
        return boardDAO.boardById(userId);
    }

    @Override
    public void updateBoard(String userId) throws Exception {
        boardDAO.updateBoard(userId);
    }

    @Override
    public void deleteBoard(String userId) throws Exception {
        boardDAO.deleteBoard(userId);
    }
}
