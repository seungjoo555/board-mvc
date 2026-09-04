package kr.ac.kopo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberMapper {

	@Select("""
		    SELECT 
		        id,
		        name,
		        password,
		        email_id AS emailId,
		        email_domain AS emailDomain,
		        tel1 || '-' || tel2 || '-' || tel3 AS tel,
		        post,
		        basic_addr AS basicAddr,
		        detail_addr AS detailAddr,
		        type,
		        TO_CHAR(reg_date, 'YYYY-MM-DD HH24:MI:SS') AS regDate
		    FROM TBL_MEMBER
		    ORDER BY reg_date DESC
		""")
		List<MemberVO> selectAll();
	
	@Insert("""
		    INSERT INTO TBL_MEMBER (
		        id,
		        name,
		        password,
		        email_id,
		        email_domain,
		        tel1,
		        tel2,
		        tel3,
		        post,
		        basic_addr,
		        detail_addr
		    ) VALUES (
		        #{id},
		        #{name},
		        #{password},
		        #{emailId},
		        #{emailDomain},
		        SUBSTR(#{tel}, 1, INSTR(#{tel}, '-', 1, 1) - 1),
		        SUBSTR(#{tel}, INSTR(#{tel}, '-', 1, 1) + 1, INSTR(#{tel}, '-', 1, 2) - INSTR(#{tel}, '-', 1, 1) - 1),
		        SUBSTR(#{tel}, INSTR(#{tel}, '-', 1, 2) + 1),
		        #{post},
		        #{basicAddr},
		        #{detailAddr}
		    )
		""")
	void insertMember(MemberVO member);
	
	MemberVO selectById(String id);
	
	@Select("""
			SELECT
				id,
		        name,
		        password,
		        email_id AS emailId,
		        email_domain AS emailDomain,
		        tel1 || '-' || tel2 || '-' || tel3 AS tel,
		        post,
		        basic_addr AS basicAddr,
		        detail_addr AS detailAddr,
		        type,
		        TO_CHAR(reg_date, 'YYYY-MM-DD HH24:MI:SS') AS regDate
			  FROM tbl_member
			 WHERE id = #{id} and password = #{password}
			""")
	MemberVO login(MemberVO loginVO);
	
}
