package kr.ac.kopo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.kopo.member.vo.MemberVO;

/**
 * Oracle DB에서 게시판테이블(tbl_member)에서 CRUD 기능클래스
 */

//@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private DataSource ds;

	@Override
	public List<MemberVO> selectAll() {
		
		List<MemberVO> memberList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type, to_char(reg_date, 'yyyy-mm-dd') as regDate ";
		   sql += " from tbl_member ";
		
	   try {
			// Connection 객체 얻어오기(dbcp에서)
			conn = ds.getConnection();
			// sql를 sql실행객체에 넣어주기
			pstmt = conn.prepareStatement(sql);
			// sql실행 후 결과를 얻어오기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String emailId = rs.getString("email_id");
				String emailDomain = rs.getString("email_domain");
				String tel1 = rs.getString("tel1");
				String tel2 = rs.getString("tel2");
				String tel3 = rs.getString("tel3");
				String post = rs.getString("post");	
				String basicAddr = rs.getString("basic_addr");
				String detailAddr = rs.getString("detail_addr");
				String type = rs.getString("type");
				String regDate = rs.getString("regDate");
				
				MemberVO member = new MemberVO();
				member.setId(id);
				member.setName(name);
				member.setPassword(password);
				member.setEmailId(emailId);
				member.setEmailDomain(emailDomain);
				member.setTel(tel1+"-"+tel2+"-"+tel3);
				member.setPost(post);
				member.setBasicAddr(basicAddr);
				member.setDetailAddr(detailAddr);
				member.setType(type);
				member.setRegDate(regDate);
				
				memberList.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return memberList;
	}

	@Override
	public void insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO selectById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
