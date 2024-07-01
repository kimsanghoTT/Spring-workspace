package com.khmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

//파일 업로드를 위해서 설정
public class FileUploadUtil {

	public static void saveFile(String uploadDir, String fileName, MultipartFile mpFile) throws IOException {
		
		//폴더에 파일을 업로드하기 위해 경로 설정
		//바탕화면에 imgFolder 생성하고 이미지 3개 선택해서 폴더에 저장
		Path uploadPath = Paths.get("C:\\" + uploadDir); //내가 지금 실행하고 있는 자바파일 위치의 주소 가져오기
		
		//만약 이미지를 저장할 폴더가 없다면 폴더 생성
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		/*
		try{
		InputStream inputStream = mpFile.getInputStream()
		}
		-> 전통적인 try구문. 메모리 사용이 아래보다 높음
		
		try(InputStream inputStream = mpFile.getInputStream()){			
		}
		-> 자바 7버전 이후부터 사용하는 try구문. 메모리 사용이 위보다 절감됨
		
		stream -> buffer. 이미지들을 사용자 눈에 바로 보일 수 있게 모아놓는공간. 메모리 사용이 큼
		Stream의 경우 다른 코드 줄보다 메모리 사용이 높으므로 처리하고 전달해주는 것이 가장 좋음	
		*/
	
		//1. InputStream을 사용해서 파일을 실제로 저장할 때 사용하기 위해 작성한 객체
		//파일 데이터를 가지고 옴
		try(InputStream inputStream = mpFile.getInputStream()){
			
			//2.uploadPath : 파일을 저장할 폴더 위치를 나타내는 것
			//resolve = 해결하다 -> 풀거나 결합, 절단. Path계의 +를 의미. 경로와 파일명을 붙여서 한 번에 작성할 수 있게 해줌
			Path filePath = uploadPath.resolve(fileName);
			System.out.println(filePath); //파일경로 + 파일명;
			
			//3. Files.copy : 파일을 복사
			// inputStream의 내용을 filePath에 복사
			
			//3-1. StandardCopyOption.REPLACE_EXISTING
			//만약 동일한 이름의 파일이 존재할 경우 덮어쓰기. 필수요소는 아님
			//추후에 파일을 업로드할 때 동일한 파일명 때문에 에러가 발생할 때를 대비해서 작성
			//선택1) 덮어쓰기 해서 에러가 안나도록 설정
			//선택2) 이미 동일명의 파일이 존재하면 업로드 못하게 하기
			//선택3) 동일한 파일명이 존재하면 숫자나 업로드날짜를 추가로 작성
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
