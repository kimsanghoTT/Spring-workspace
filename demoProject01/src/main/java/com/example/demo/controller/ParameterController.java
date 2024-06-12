package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.memberDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

//Bean : 스프링이 알아서 만들고 관리한다는 것
@Controller // 응답 / 요청 제어역할 명시 + Bean 등록
@RequestMapping("param") // 이 밑에 작성하는 모든 주소 앞에 param이 기본으로 붙음
@Slf4j //Simple logging facade 4(for) java -> System.out.println과 비슷
//System 출력에 비해 logging 사용하는게 메모리 부담이 적음. log를 이용한 메세지 출력시 자주 사용
public class ParameterController {
	
	//GETMAPPING main
	@GetMapping("main") //param/main 주소로 GET 방식 요청 생성
	public String paramMain() {
		return "param/param-main";
		//return할 때 폴더명/파일명 작성
		//param-main.html : templates 밑에 param이라는 폴더 밑에 존재
		//html 파일을 바라볼 때 기본으로 templates이라는 폴더를 먼저 보고
		// templates/param/param-main.html 파일을 바라본다는 의미
	}
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		
		String inputName = req.getParameter("inputName");
		//form의 input에서 name=inputName으로 존재하는 값 가져오기
		//<input type="text" name="inputName">
		
		String inputAddress = req.getParameter("inputAddress");
		//form의 input에서 name=inputAddress으로 존재하는 값 가져오기
		//<input type="text" name="inputAddress">
		
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		//form의 input에서 name=inputAge으로 존재하는 값 가져오기
		//<input type="number" name="inputAge">
		
		//가져온 값들이 제대로 작성됐는지 확인하기
		System.out.println("이름 확인 " + inputName);
		System.out.println("이름 확인 " + inputAddress);
		System.out.println("이름 확인 " + inputAge);
		
		// system 대신 log.debug를 활용해서 출력하는 것이 메모리 부담 적음
		// -> 코드 오류를 해결하기 위한 로그
		// -> 코드 오류가 없는데 정상적으로 수행이 안되거나 값이 잘못된 경우 값을 추적
		log.info("정보확인하기");
		log.debug("로그로 이름 확인 : " + inputName);
		log.debug("로그로 주소 확인 : "+ inputAddress);
		log.debug("로그로 나이 확인 : "+inputAge);
		
		/*
		spring에서 Redirect(재요청)하는 방법
		Controller 메서드 반환 값에 "redirect:요청주소" 작성
		-> 되돌아가짐
		*/
		return "redirect:/param/main";
	}
	
	/*
	@RequestParam - 낱개 파라미터 얻어오기
		- request 객체를 이용한 파라미터 전달 어노테이션
		- 매개변수 밑에 해당 어노테이션을 작성하면, 매개변수에 값이 작성됨
		- 작성되는 데이터는 매개변수(파라미터) 타입이 맞게 형변환(parse) 자동으로 수행
		
		속성 추가 작성법
		@RequestParam(value="name", required="false", defaultValue="1")
		
		value = 전달받은 input 태그의 name 속성값("value=" 생략 가능)
		required = 입력된 name 속성값 파라미터(매개변수) 필수 여부 지정 (기본값 true)
			-> required = true인 파라미터가 존재하지 않는다면 400 bad request 에러 발생
			-> required = ture인 파라미터가 null인 경우에도 400 bad request 에러 발생
			
		defaultValue = 파라미터 중 일치하는 name 속성 값이 없을 경우 대입할 값 지정
			-> required가 false일 경우 사용
			
		** 400 Bad Request(잘못된 요청) : 파라미터 불충분
	*/
	
	/*
	    책 제목 : <input type="text" name="title">
        작성자 : <input type="text" name="writer">
        가격 : <input type="number" name="price">
        출판사 : <input type="text" name="publisher">
	*/
	@PostMapping("test2")// /param/test2
	public String paramTest2(@RequestParam(/*value=*/"title"/*, required=true*/) String title,
							 @RequestParam("writer") String writer,
							 @RequestParam("price") int price,
	@RequestParam(value="publisher", defaultValue="교보문고", required = false) String publisher
	) {
		
		log.info("문제없이 insert 가능한지 확인");
		log.debug("title : " + title);
		log.debug("writer : " + writer);
		log.debug("price : " + price);
		log.debug("publisher : " + publisher);
		return "redirect:/param/main";
	}
	/*
	@RequestParam 여러개 파라미터
	 	** defaultValue 속성 사용 불가
	*/
	@PostMapping("test3")
	public String paramTest3(@RequestParam(value="color", required=false) String[] colorArr,
			@RequestParam(value="fruit", required=false) List<String> fruitList,
			@RequestParam Map<String, Object> paramMap
	) {
		log.info("colorArr : " + Arrays.toString(colorArr));
		log.info("fruitList : " + fruitList);
		log.info("paramMap" + paramMap);
		//key(name 속성 값)이 중복되면 값이 덮어쓰기가 됨
		//같은 name 속성 파라미터가 String[], List로 저장이 되는 것은 힘듦
		return "redirect:/param/main";
	}
	
	
	
	/*
	DTO와 VO
	
	DTO(Data Transfer Object)
		- 데이터 캡슐화를 통해 데이터를 전달하고 관리
		- 한 계층에서 다른 계층으로 데이터 전송을 위해 사용
			* 계층 : 예를 들면 html에서 db로 가는 것
	
	VO(Value Object)
		- 값 자체를 표현하는 객체
		- 한 번 값이 생성되면 그 값을 변경할 수 없음
		- 생성자를 통해 값을 생성하고 setter 메서드를 제공하지 않음 -> setter 사용안함
	*/
	/*
	@ModelAttribute
		- DTO(또는 VO)와 같이 사용하는 어노테이션
		- 전달받은 파라미터(매개변수)의 name 속성 값이 같이 사용되는 DTO의 필드명과 같다면
			자동으로 setter를 호출해서 필드에 값을 저장
			
		[주의사항]
		- DTO에 기본 생성자가 필수로 있어야함
		- DTO에 setter가 필수로 있어야함
		
		* 어노테이션은 생략 가능
		@ModelAttribute 를 이용해 값이 필드에 저장된 객체를 커맨드 객체라고 함
	*/
	
	
	@PostMapping("test4")
	public String paramTest4(/*@ModelAttribute - 기본값*/ memberDTO inputMember) {
		
		//lombok으로 만든 setter getter 값 가져오거나 설정하기
		memberDTO mem = new memberDTO();
		mem.getMemberAge(); // getter를 통해 나이 가져오기
		mem.setMemberAge(0); // setter를 통해 나이 넣기
		//getter,setter를 굳이 만들지 않아도 lombok @Getter @Setter를 만들어 가져오기 때문에 가능한것
		
		mem.getMemberId();
		mem.setMemberId("1");
		
		mem.getMemberName();
		mem.setMemberName("가나다");
		
		mem.getMemberPw();
		mem.setMemberPw("pass01");
		log.info("get 정보 가져오기 : " + mem.getMemberId());
		log.debug(mem.getMemberId());
		log.debug(mem.getMemberPw());
		log.debug(Integer.toString(mem.getMemberAge()));
		log.debug(mem.getMemberName());
		
		return "redirect/param/main";
	}
	/*
	 * org.thymeleaf.exceptions.TemplateInputException: 
	 * Error resolving template [], template might not exist or might 
	 * not be accessible by any of the configured Template Resolvers
		
	 * */
}
