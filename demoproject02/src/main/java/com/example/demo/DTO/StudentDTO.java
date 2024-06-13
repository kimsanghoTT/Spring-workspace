package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
	Spring은 getter가 필수로 있어야함
	-> ${StudentDTO.getName()} == ${StudentDTO.name}
	
	-> getter 대신 필드명 호출하는 형식(${StudentDTO.name})
	-> getter를 자동으로 호출하기 때문
*/


@Getter
@Setter	//getter, setter 메서드 자동 추가
@NoArgsConstructor // 기본 생성자 자동 추가
@AllArgsConstructor // 필수 생성자 자동 추가
@ToString // toString 메서드 자동 오버라이딩 추가
public class StudentDTO {
	
	private String studentNo;
	private String name;
	private int age;
}
