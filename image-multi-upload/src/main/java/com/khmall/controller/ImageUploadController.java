package com.khmall.controller;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.util.FileUploadUtil;

/*
	1. SQL -> 백엔드 -> css

	@Controller
		주로 html(view)을 반환하기 위해 사용
		
	@RestController
		- @Controller와 @Responsebody가 합쳐진 형태
		- json 형태의 객체 데이터를 반환
		- 백엔드 개발자가 보이는 화면(view, html)이 없을 때 데이터가 무사히 들어오고 나가는지 확인하기위해 사용
		- React에서 프론트엔드를 작성할 때 사용하기도 함
*/		

@RequestMapping("api/v1/img") //ImageUploadController 밑에 작성하는 모든 주소 앞에 api/v1/img 붙음
@RestController
public class ImageUploadController {
	
	//api : /로 된 Mpping 개수
	
	@GetMapping("/upload") //get api 1개 생성 = api/v2/img/upload
	public String get() {
		return "html 파일이름";
	}
	

	@PostMapping("/upload") //  api/v1/image/upload
	public void saveImage(@RequestParam("files")MultipartFile[] files) {
		
		String 업로드할폴더위치 = "imgFolder"; //static 밑에 imaFolder 만들 예정
		
		//배열로 이미지를 담아서 한 번에 전달
		Arrays.asList(files).stream().forEach(file->{
			
			//파일이름에서 경로를 깔끔하게 정리
			//StringUtils에서 cleanPath 기능 : 파일 이름에 포함될 수 있는 잠재적인 악의적인 값 제거
			//getOriginalFilename : file에서 가져오기(=get) 원본(=Original) 파일이름(=Filename)
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			System.out.println(fileName);
			
			try {
				//파일 올리기 -> 업로드할 파일 위치에 내가 원하는 파일이름으로 파일을 올리겠다
				FileUploadUtil.saveFile(업로드할폴더위치, fileName, file);
			}
			catch(Exception e){
				
			}
		});
	}
}
