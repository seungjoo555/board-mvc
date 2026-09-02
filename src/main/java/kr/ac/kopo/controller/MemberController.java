package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

/**
 * 멤버 관련 요청 처리 컨트롤러
 */
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/members")
	public String listMember(Model model) throws Exception {
		List<MemberVO> memberList = memberService.getMemberList();
		model.addAttribute("memberList", memberList);
		
		return "member/list";
	}
	
	@GetMapping("/member/register")
	public void registerForm(Model model) {
		
		model.addAttribute("memberVO", new MemberVO());
		
	}
	
	@PostMapping("/member/register")
	public String register(@Valid MemberVO member, BindingResult result) throws Exception{
		
		if(result.hasErrors()) {
			return "member/register";
		}
		
		memberService.registerMember(member);
		return "redirect:/members";
	}
	
	@GetMapping("/member/{id}")
	public String detail(@PathVariable("id") String id, Model model) throws Exception {
		
//		System.out.println("memberid : " + id);
		MemberVO member = memberService.getMemberByMemberId(id);
		model.addAttribute("member", member);
		
		return "member/detail";
	}
}
