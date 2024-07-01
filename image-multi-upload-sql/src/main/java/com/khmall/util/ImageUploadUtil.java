package com.khmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

/*
	html 파일과 db가 주고받을 때는 Service라는 이름으로 코드를 작성
	
	백엔드에서 단독적으로 진행하는 값이나 공통으로 설정할 때는 util이라는 이름을 사용해서 코드를 작성
	
	util -> postMan을 사용해서 파일 업로드가 잘 되고 있는지 테스트 진행
*/
//DB랑 아무 관련이 없고 파일이 내 컴퓨터에 무사히 저장되는지만 확인 -> Service가 아니라 Util
public class ImageUploadUtil {
	
	public static void insertImageUpload(String uploadDir, String fileName,
			MultipartFile multipartFile) throws IOException{
		
		//컨트롤러에서는 MultipartFile이 배열 -> 서비스에서 하나씩 올린 파일을 모두 전송
		//서비스에서는 배열이 아님 -> 파일을 하나씩 올리는 작업
		
		Path uploadPath = Paths.get("C:/"+uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try(InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
