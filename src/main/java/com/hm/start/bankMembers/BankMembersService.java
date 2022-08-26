package com.hm.start.bankMembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hm.start.bankAccount.BankAccountDAO;
import com.hm.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private ServletContext servletContext;
	
//	@Autowired
//	private BankAccountDAO banAccountDAO;
	
//	public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = banAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//		return map;
//	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	//bankMembers 회원가입 (Insert) (아이디, 패스워드, 이름, 이메일, 전화번호) (1이면성공, 0(Exception)이면 실패)
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo) throws Exception{
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println("join 실행:"+result);
		//1.HDD에 파일 저장
		// 파일 저장시에 경로는 Tomcat 기준이 아니라 OS의 기준으로 설정
		// 1) 파일 저장 위치
		//	/resources/upload/member
		
		// 2) 저장할 폴더의 실제경로를 반환(OS 기준)
		String realPath = servletContext.getRealPath("resources/upload/member");
		System.out.println("realPath: "+ realPath);
		
		// 3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realPath);
		System.out.println(file.exists());
		
		//***** File 첨부 안했을때
		
//		if(photo.getSize() != 0) {}
		if(!photo.isEmpty()) {
		
			if(!file.exists()) {
				file.mkdirs();
			}
			
			// 4)중복되지 않는 파일명 생성
			//		--- 시간, java api ...
			String filename = UUID.randomUUID().toString();
			System.out.println("파일명:"+filename);
			
			Calendar ca = Calendar.getInstance();
			Long time = ca.getTimeInMillis();
			System.out.println(time);
			
			filename = filename+"_"+photo.getOriginalFilename();
			System.out.println(filename);
			
			// 5)하드디스크에 파일 저장
			// 어느 폴더에 어떤 이름을 저장할 파일 객체 생성
			file = new File(file, filename); //(경로명, 정보)
	
			//	a. MultipartFile 클래스의 transferTo 메서드 사용
			
			photo.transferTo(file);
			
			
			//	b. FileCopyUtils 클래스의 copy 메서드 사용
			
			//2. 저장된 파일 정보를 DB에 저장
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setFileName(filename);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
			bankMembersDAO.setAddFile(bankMembersFileDTO);
			
			
		
		}//isEmpty 끝
		
		return result;

	}
	
	//검색어를 입력해서 ID를 찾기 (ex. abc가 포함된 id) abc 순으로
	public List<BankMembersDTO> getSearchByID(String search) throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}

}
