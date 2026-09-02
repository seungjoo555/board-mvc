package kr.ac.kopo.member.vo;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;

public class MemberVO {
	
	@NotEmpty(message = "필수항목입니다")
	private String id;
	@NotEmpty(message = "필수항목입니다")
	private String name;
	@NotEmpty(message = "필수항목입니다")
	private String password;
	@NotEmpty(message = "필수항목입니다")
	private String emailId;
	@NotEmpty(message = "필수항목입니다")
	private String emailDomain;
	@NotEmpty(message = "필수항목입니다")
	private String tel;
	@Length(min = 5, max = 5, message = "5자리 입력하세요")
	@NotEmpty(message = "필수항목입니다")
	private String post;
	@NotEmpty(message = "필수항목입니다")
	private String basicAddr;
	@NotEmpty(message = "필수항목입니다")
	private String detailAddr;
	private String type;
	private String regDate;
	
	public MemberVO() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getBasicAddr() {
		return basicAddr;
	}
	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", emailId=" + emailId
				+ ", emailDomain=" + emailDomain + ", tel=" + tel + ", post="
				+ post + ", basicAddr=" + basicAddr + ", detailAddr=" + detailAddr + ", type=" + type + ", regDate="
				+ regDate + "]";
	}
	
	
}
