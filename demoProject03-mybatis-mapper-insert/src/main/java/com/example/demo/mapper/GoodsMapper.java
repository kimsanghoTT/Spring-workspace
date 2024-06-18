package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Goods;

/*기능을 상세하기 작성하는 공간이 아님*/
/*
Mapper.xml에 작성한 id 리스트를 작성하는 공간이기 때문에 interface로 작성
mapper.xml에 어떠한 파일이 존재하는지 리스트 작성란
@Mapper 어노테이션을 활용해서 SpringBoot가 Mapper를 찾을 수 있도록 설정
 */
@Mapper //sql 사용할 리스트 목록
public interface GoodsMapper {
	
	void insertGoods(Goods goods);
}
