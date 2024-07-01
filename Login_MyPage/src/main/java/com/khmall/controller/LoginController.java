package com.khmall.controller;
import java.util.List;

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
	
	/*
	 	Member updateMember와 Member member
	 	Member updateMember는 소비자(클라이언트)가 새롭게 작성하고 DB에 덮어쓸 내용이 저장
	 	Member member는 소비자가 기존에 DB에 저장했던 값
	 	
	 	Member member = (Member) session.getAttribute("loginSession);
	 		- session에서 loginSession이라는 변수명에 저장된 로그인 정보 가져오기
	 		가져와서 member의 기존의 저장된 값 가져오기
	 	   
	 	updateMember.setMember_id(member.getMember_id()); -> 덮어쓰기
	 		- DB에 저장된 값 중 id는 개발자가 회원가입의 순번을 소비자에게 부여한 순서값으로, 
	 		소비자가 가입한 순서를 스스로 변경할 수 없기 때문에, id 값으로 소비자가 
	 		input에 수정해서 작성한 값을 가져와서 임시저장
	 		
	 	member.getMember_id : 기존의 DB에 저장된 정보
	 	
	 	setMember_id : 새롭게 DB에 저장할 정보
	 					id(회원가입순서)는 동일하지만 밑 내용은 다름
	 		
		memberService.updateMember(member);
			- 덮어쓰기한 내용을 DB에 저장하기
			
		session.setAttribute("loginSession", updateMember);
			- 새롭게 DB에 저장된 내용을 loginSession이라는 변수명에 다시 저장
	*/
	
	
	@PostMapping("/modifyProfile")//form action에 적은 주소값
	public String updateMember(HttpSession session, Member updateMember) {//새롭게 저장할 내용을 담을 공간명
		// 현재 로그인 상태인 세션의 정보를 가져와, 멤버 정보를 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");//기존 db에 있던 내용 가져오기
		
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		
		updateMember.setMember_id(member.getMember_id()); //input에 사용자가 작성한 값을 모두 가져오기
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
	
	@GetMapping("/search")
	public String showSearchForm(Model model) {
		
		return "search";
	}
	/*
		@RequestParam("keyword") String keyword
		<input type="text" name="keyword" placeholder="이름 또는 번호 입력" required>
		
		- @RequestParam("input이나 태그에 작성한 name 또는 th로 작성된 변수명")
			input에서 name="keyword"이기 때문에 @RequestParam("keyword")
			input에서 name, th:field로 작성한 변수명과 반드시 일치할 것.
			
			String keyword는 input에서 바라보는 keyword 값을 가져와서 자바에서 가져온 값을 담을 공간
	 */
	@PostMapping("/search")
	public String searchMembers(Model model, @RequestParam("keyword") String keyword) {
		
		List<Member> member = memberService.searchMembers(keyword);
		model.addAttribute("results", member);
		return "search";
	}
}
