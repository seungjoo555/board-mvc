package kr.ac.kopo.member.service;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;


public interface MemberService {

	List<MemberVO> getMemberList() throws Exception;
	
	public void registerMember(MemberVO member) throws Exception;
	
	MemberVO getMemberByMemberId(String id) throws Exception;
	
	MemberVO checkMember(MemberVO member) throws Exception;
}
