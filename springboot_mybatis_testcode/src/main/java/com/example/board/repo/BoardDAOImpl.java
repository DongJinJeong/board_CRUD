package com.example.board.repo;

import com.example.board.domain.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO {

    private String NS = "BoardMapper.";

    private SqlSession sqlSession;

    @Autowired
    public BoardDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void registerBoard(BoardVO boardVO) throws Exception {
        sqlSession.insert(NS+"registerBoard", boardVO);
    }

    @Override
    public List<BoardVO> allBoard() throws Exception {
        return sqlSession.selectList(NS+"allBoard");
    }

    @Override
    public List<BoardVO> boardById(String userId) throws Exception {
        return sqlSession.selectList(NS+"boardById", userId);
    }

    @Override
    public void updateBoard(String userId) throws Exception {
        sqlSession.update(NS+"updateBoard", userId);
    }

    @Override
    public void deleteBoard(String userId) throws Exception {
        sqlSession.delete(NS+"deleteBoard", userId);
    }

}
