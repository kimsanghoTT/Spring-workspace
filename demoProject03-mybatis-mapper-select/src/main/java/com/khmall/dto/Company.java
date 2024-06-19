package com.khmall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {

	private int company_id;
	private String company_name;
	private String company_address;
	private String company_phone;
	//번호는 맨 앞자리가 0으로 시작하므로 String으로 할 것
	//int로 하면 0이 생략됨
}
