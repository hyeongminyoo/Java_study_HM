package com.hm.start.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.hm.start.file.FileDTO;

public class FileUtils {
	
	@Autowired
	private ServletContext servletContext;
	
	public void fileAdd(MultipartFile [] files, String path) throws Exception {
		
		String realpath = servletContext.getRealPath(path);
		for(MultipartFile mpf : files) {
			if(mpf.isEmpty()) {
				continue;
			}
			File file = new File(realpath);
			if(!file.exists()) {
				file.mkdirs();
			}
			
			String filename = UUID.randomUUID().toString();
			filename= filename+"_"+mpf.getOriginalFilename();
			
			file = new File(file, filename);
			
			mpf.transferTo(file);
			
			
			
		}
		 
	}


	
	
	
}
