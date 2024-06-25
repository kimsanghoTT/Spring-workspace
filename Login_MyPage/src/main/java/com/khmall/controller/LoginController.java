package com.khmall.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.khmall.dto.Member;
import com.khmall.service.MemberService;
import jakarta.servlet.http.HttpSession;
@Controller
// @RestController -> 추후, 리액트에서 사용할 예정
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("m", new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
			     @RequestParam("member_name") String Member_name,
			     @RequestParam("member_phone") String Member_phone,
			     HttpSession session) {
		
		Member member = memberService.getLogin(Member_name, Member_phone);
		
		// 만약, 사용자의 입력 값과 DB 에 저장된 정보가 일치한다면, null 이 아님
		if(member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
			
		} else { // 하지만, 일치하지 않는다면, null 임
			model.addAttribute("e", "일치하는 회원 정보가 없습니다.");
			model.addAttribute("m", new Member());
			return "login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session /* SessionStatus status -> 시간이 지나면 자동으로 로그아웃되게 설정할 때 사용*/) {
		session.invalidate(); // 로그인 풀리게 만들기
		return "redirect:/";
	}
	
	@GetMapping("/myPage")
	public String showMyPage(HttpSession session, Model model) {
		// 현재 로그인 상태인 세션의 정보를 가져와, 멤버 정보를 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		
		// 만약, 모델에 정보가 담겨있다면, 보여줄 멤버 객체
		model.addAttribute("member", member);
		return "myPage";
	}
	
	//마이페이지 불러오고 수정하는 get post
	@GetMapping("/modifyProfile")//html 파일 이름
	public String modifyMypage(HttpSession session, Model model) {
		// 현재 로그인 상태인 세션의 정보를 가져와, 멤버 정보를 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		
		// 만약, 모델에 정보가 담겨있다면, 보여줄 멤버 객체
		model.addAttribute("member", member);
		return "modifyProfile";
	}
	
	@PostMapping("/modifyProfile")//form action에 적은 주소값
	public String updateMember(HttpSession session, Member updateMember) {
		// 현재 로그인 상태인 세션의 정보를 가져와, 멤버 정보를 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		
		updateMember.setMember_id(member.getMember_id());
		memberService.updateMember(member);
		session.setAttribute("loginSession", updateMember);
		return "redirect:/myPage";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(HttpSession session) {
		Member member = (Member) session.getAttribute("loginSession");
		
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		
		//세션에 저장된 member_id 불러오기
		memberService.deleteMember(member.getMember_id());
		
		session.invalidate(); //삭제 후 로그인 무효화
		return "redirect:/";
	}
}
