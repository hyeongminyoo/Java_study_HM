package com.hm.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.hm.start.file.FileDTO;



@Component
public class FileManager {
	
//	@Autowired
//	private ServletContext servletContext;
	
	//delete
	public boolean deleteFile(ServletContext servletContext, String path, FileDTO fileDTO) throws Exception{
		//1. 실제경로
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		//2. 
		File file = new File(realPath, fileDTO.getFileName());
		
		return file.delete();
	}
	
	
	//saver
	//public void saveFile(ServletContext servletContext) throws Exception
	public String saveFile(ServletContext servletContext ,String path, MultipartFile multipartFile) throws Exception{
		
		String realpath = servletContext.getRealPath(path);
		System.out.println(realpath);
		
		//2. 폴더(directory) 체크
		File file = new File(realpath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3. 저장할 파일명을 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + multipartFile.getOriginalFilename();
		
		file = new File(file,fileName);
		multipartFile.transferTo(file);
		
		return fileName;
		
	}
	


	
	
	
}
