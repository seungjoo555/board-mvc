package kr.ac.kopo.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.mapper.BoardMapper;

/**
 * MyBatis (Mapper클래스 활용) 게시판 CRUD
 */

@Repository
public class BoardDAOImpl02 implements BoardDAO {

	private BoardMapper boardMapper;
	
	public BoardDAOImpl02(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardVO> selectAll() {
		System.out.println("mybatis 전체 게시글조회...");
		return boardMapper.selectAll();
	}

	@Override
	public void insert(BoardVO board) {
		boardMapper.insert(board);
	}

	@Override
	public BoardVO selectByNo(int boardNo) {
		// TODO Auto-generated method stub
		return boardMapper.selectByNo(boardNo);
	}

}
