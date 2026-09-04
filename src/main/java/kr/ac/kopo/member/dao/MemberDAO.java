package kr.ac.kopo.member.dao;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;
/**
 * 멤버 CRUD를 위한 DAO 클래스
 */
public interface MemberDAO {

	/**
	 * 전체 멤버 조회 기능
	 */
	List<MemberVO> selectAll();
	
	/**
	 * 회원가입 기능
	 */
	public void insertMember(MemberVO member);
	
	/**
	 * 상세회원정보
	 */
	MemberVO selectById(String memberId);
	
	/**
	 * 로그인
	 */
	MemberVO login(MemberVO loginVO);
}
