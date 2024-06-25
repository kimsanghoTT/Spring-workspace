package com.khmall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;
import com.khmall.mapper.PigMapper;

@Service
public class PigService {

	@Autowired
	private PigMapper pigMapper;
	
	/*
	@Autowired 
	
	==
	
	public PigService(PigMapper pigMapper){
		this.pigMapper = pigMapper;
	}
	
	서비스에서 추가적으로 수정된 데이터가 매퍼를 통해 db에 들어가고, db에서 가져온 sql에
	추가적으로 수정을 서비스 단계에서 진행한 다음 컨트롤러에 전달하거나 전달 받기
	*/
	
	public List<Pig> getAllPig(){
		return pigMapper.getAllPig();
	}
	
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	}

	// public void uploadPig(Pig pig)
	//-> 돼지정보를 저장할 때 경로나 이름 등 변경할게 없을 때 사용
	public void uploadPig(String pig_name, int pig_age, MultipartFile file) {
		
		// 파일 이름을 저장하길 원할 때 이미지 업로드 시 임시저장되어있는 이미지 파일이름 가져옴
		String fileName = file.getOriginalFilename();
		
		// 바탕화면에 pigImg라는 폴더가 없으면 생성하도록 작성
		String 저장폴더 = "C:/Users/user1/Desktop/pigImg/";
		File 폴더경로확인 = new File(저장폴더);
		
		// 만약 저장하고자 하는 이미지 폴더가 없을 경우 경로를 생성
		//exist -> File 자료형에서만 생성이 됨
		if(!폴더경로확인.exists()) {
			폴더경로확인.mkdirs(); //mkdir : 폴더 1개, mkdirs : 폴더 여러개
			//혹시 모를 문제를 최소화하기 위해 mkdirs를 사용
		}
		
		//폴더 생성을 확인하고 지정된 폴더에 사진 올리기
		File 사진파일올리기 = new File(저장폴더 + fileName);
		String DB에파일경로및파일명전달 = 저장폴더 + fileName;
		
		try {
			file.transferTo(사진파일올리기);
			
			// 이미지 정보를 db에 전달
			Pig pig = new Pig();
			pig.setPig_name(pig_name);
			pig.setPig_age(pig_age);
			pig.setPig_image_path(DB에파일경로및파일명전달);
			// String 값이므로 File 자료형이 올 수 없음
			
			pigMapper.uploadPig(pig);
			System.out.println("Mapper에 Service로 pig insert 전달 성공"); // 나중에 log로 변경할 것
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
