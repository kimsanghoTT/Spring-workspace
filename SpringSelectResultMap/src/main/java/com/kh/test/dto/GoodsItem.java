package com.kh.test.dto;

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
public class GoodsItem {
	
	private int itemId;
	private String itemName;
	private String itemDes;
	//Count 결과를 받아서 저장할 변수명 추가
	private int itemCount;
}
