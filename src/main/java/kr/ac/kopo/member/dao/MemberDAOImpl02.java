package kr.ac.kopo.member.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.mapper.MemberMapper;
import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDAOImpl02 implements MemberDAO {

	private MemberMapper memberMapper;
	
	public MemberDAOImpl02(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("mybatis 전체 회원 조회...");
		return memberMapper.selectAll();
	}

	@Override
	public void insertMember(MemberVO member) {
		System.out.println("mybatis 회원 등록...");
		memberMapper.insertMember(member);
	}

	@Override
	public MemberVO selectById(String memberId) {
		return memberMapper.selectById(memberId);
	}

	@Override
	public MemberVO login(MemberVO loginVO) {
		return memberMapper.login(loginVO);
	}
}
