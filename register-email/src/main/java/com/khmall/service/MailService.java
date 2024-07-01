package com.khmall.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //@Autowired와 비슷. 외부에서 전체적으로 설정 -> lombok에서 만듦
//@Autowired = 클래스 내 변수마다 하나씩 지정 -> SpringBoot에서 만듦
public class MailService {
	
	//java에서 제공하는 이메일 보내기 기능 틀 -> 회사마다 규격이 다르기 때문
	private final JavaMailSender JavaMailSender;
	
	//이메일을 보낼 이메일 주소값
	private static final String senderEmail = "qwert850528@gmail.com"; //이메일을 보낼 담당자 이메일 작성
	//application.properties에서 가져온 이메일을 그대로 사용
	
	private static int number; //인증번호를 보낼 숫자 공간
	
	//랜덤으로 인증번호 생성하는 메서드 기능 설정
	public static void makingNumber() {
		//임의의 6자리 숫자를 생성
		number = (int)(Math.random() * (90000)) + 100000;
		// Math.random() * (90000) : 0.0 ~ 89999.999999....
		// + 100000 -> 100000 ~ 189999 사이의 숫자 6자리 생성
	}
	
	//메일 양식 기능 작성
	public MimeMessage createMail(String mail) {
		// MimeMessage : 이메일 본문 담당. 첨부파일, 헤더 같이 보낼 수 있음
		//java에서 제공하는 기능
		
		//인증번호 생성
		makingNumber();
		
		//생성된 인증번호를 담는 변수
		//메세지 보낼 공간 생성
		MimeMessage message = JavaMailSender.createMimeMessage();
		
		try {
			message.setFrom(senderEmail); //인증번호를 보내는 주최자의	 이메일 주소
			message.setRecipients(MimeMessage.RecipientType.TO, mail);// -> String 타입
//			message.setRecipient(MimeMessage.RecipientType.TO, mail); -> address 타입
			//태그로 img src 이미지 같이 보낼 수 있음
			//첨부파일 참조하는 태그들 이용해서 같이 보낼 수 있음
			message.setSubject("이메일 인증"); //보내는 제목
			String 이메일본문 = "";
			이메일본문 += "<h3>" + "요청하신 인증번호입니다." + "<h3>";
			이메일본문 += "<h1>" + number + "<h1>";
			message.setText(이메일본문, "utf-8", "html");
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return message; // message.으로 작성한 모든 내용 담아서 전달
	}
	
	public int sendMail(String mail) {
		MimeMessage message = createMail(mail);
		JavaMailSender.send(message);
		return number;
		
	}
}
