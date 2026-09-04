package kr.ac.kopo.member.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.ac.kopo.config.DBConfig;
import kr.ac.kopo.member.vo.MemberVO;

@SpringJUnitConfig(classes = {DBConfig.class})
public class MemberDBTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private MemberDAO memberDao;
	
	@Disabled
	@Test
	public void DB접속Test() throws Exception{
		
		//assertNotNull(ds);
		Connection conn = ds.getConnection();
		assertNotNull(conn);
	}
	
	@Disabled
	@Test
	public void 전체멤버조회() throws Exception {
		List<MemberVO> list = memberDao.selectAll();
		for (MemberVO m : list) {
			System.out.println(m);
		}
	}
	
	@Disabled
	@Test
	public void 상세회원조회() throws Exception {
		System.out.println(memberDao.selectById("seungjoo"));
	}
	
	@Test
	public void 로그인확인() throws Exception {
		MemberVO loginVO = new MemberVO();
		loginVO.setId("seungjoo");
		loginVO.setPassword("1234");
		System.out.println(memberDao.login(loginVO));
	}
	
}
