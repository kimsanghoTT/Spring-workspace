package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.BlogDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("blog")
public class BlogController {

	/*
	<input type="text" name="commentName">
	<input type="text" name="commentOpinion">
	*/
	@PostMapping("comment")
	public String blogComment(/*@RequestParam("commentName") String commentName, 
							@RequestParam("commentOpinion") String commentOpinion*/
			/*@ModelAttribute*/BlogDTO BlogComment
	) {	
		
		//lombok으로 만든 setter getter 값 가져오거나 설정하기
		BlogDTO comment = new BlogDTO();
		comment.getCommentName(); // getter를 통해 나이 가져오기
		comment.setCommentName("가나다"); // setter를 통해 나이 넣기
		//getter,setter를 굳이 만들지 않아도 lombok @Getter @Setter를 만들어 가져오기 때문에 가능한것
		
		comment.getCommentOpinion();
		comment.setCommentOpinion("잘 봤어요");
		
		log.info("comment에 작성한 내용 보기 : " + comment.toString());
		/*log.info("블로그 댓글 작성 공간");
		log.debug("commentName : " + commentName);
		log.debug("commentOpinion : " + commentOpinion);
		log.info("블로그 댓글 작성하고 다시 블로그 메인 페이지로 돌아가기");*/
		
		
		return "redirect:/blog/blog-index";
	}
	
}
