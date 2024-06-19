package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Snacks;
import com.khmall.mapper.SnackMapper;

//Controller에서 가져오거나 db에서 가져온 값에 추가적인 기능을 작성
@Service
//@Service : db에서 가져온 sql 구문이나 html에서 db에 넣어줄 값에 추가적인 서비스를 적용한다는 의미
public class SnacksService {
	//Mapper에 작성한 리스트를 모두 활용 -> @Autowired
	//객체 안의 한 줄씩 참조할 때 작성
	@Autowired
	private SnackMapper snackMapper;
	
	public List<Snacks> getAllSnacks(){
		//상품목록을 보여줄 때 추가적으로 설정해서 넣고싶은 기능을 나중에 추가적으로 작성
		// 상품 이미지가 있는지 확인하고 없으면 x박스로 하거나 이외 여러가지 기능을 작성
		return snackMapper.getAllSnacks();
	}
}
