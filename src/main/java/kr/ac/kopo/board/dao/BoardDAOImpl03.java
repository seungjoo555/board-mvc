package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.kopo.board.vo.BoardVO;

/**
 * MyBatis(mapper xml 활용) 게시판 CRUD
 */

//@Repository
public class BoardDAOImpl03 implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List<BoardVO> selectAll() {
		System.out.println("boardDAO03.....selectAll");
		List<BoardVO> boardList = sqlSessionTemplate.selectList("board.dao.BoardDAO.selectAll");
		return boardList;
	}

	@Override
	public void insert(BoardVO board) {
		sqlSessionTemplate.insert("board.dao.BoardDAO.insert", board);

	}

	@Override
	public BoardVO selectByNo(int BoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
