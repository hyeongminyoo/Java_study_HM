package com.hm.start.board.notice;

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

import com.hm.start.bankMembers.BankMembersDAO;
import com.hm.start.bankMembers.BankMembersFileDTO;
import com.hm.start.board.impl.BoardDTO;
import com.hm.start.board.impl.BoardFileDTO;
import com.hm.start.board.impl.BoardService;
import com.hm.start.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.getRowNum();
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);

		
		// TODO Auto-generated method stub
//		System.out.println("Service Page:"+page);
//		Long perPage = 10L; // 한페이지에 출력할 목록의 개수
		//page			startRow		lastRow
		//1				1				15
		//2				16				30
		//3				31				45		
//		Long startRow = (page-1)*perPage+1;
//		Long lastRow = perPage*page;
//		
//		System.out.println("startRow:"+startRow);
//		System.out.println("lastRow:"+lastRow);
//		Map<String, Long> map = new HashMap<String, Long>();
		
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		/*************************
//		 * JSP에 페이지 번호 출력 1-?
//		 * 1. 글의 총 개수
//		 * 2. 글의 페이지 개수
//		 *************************/
//		Long totalCount = noticeDAO.getCount();
//		Long totalPage = totalCount/perPage;
//		
//		if(totalCount%perPage != 0) {
//			totalPage++;
//		}
//		
//		System.out.println(totalPage);
//		/*************************
//		 * JSP에 페이지 번호 출력 1-?
//		 * 3. 전체 블럭의 개수
//		 * Block 	:  
//		 * perBlock : 한페이지에 출력할 번호의 수
//		 *************************/
//		Long perBlock = 5L;
//		Long totalBlock = totalPage/perBlock;
//		
//		if(totalPage%perBlock !=0) {
//			totalBlock++;
//		}
//		
//		/*************************
//		 * JSP에 페이지 번호 출력 1-?
//		 * 4. page번호 로 현재 Block 번호 찾기
//		 * page		curBlock
//		 * 1		1  
//		 * 2		1
//		 * 3		1
//		 * 4		1
//		 * 5 		1 
//		 * 6		2
//		 * ...		2
//		 * 11		3		
//		 *************************/
//		Long curBlock = page/perBlock;
//		
//		if(page%perBlock != 0) {
//			curBlock++;
//		}
//		
//		/*************************
//		 * JSP에 페이지 번호 출력 1-?
//		 * 5. curBlock로 시작번호와 끝번호 알아오기
//		 * curBlock		startNum	lastNum
//		 * 1			1			5
//		 * 2			6			10			
//		 *************************/
//		
//		Long lastNum = curBlock*perBlock;
//		Long startNum = (curBlock-1)*perBlock+1;
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		int result = noticeDAO.setAdd(boardDTO);
		System.out.println("공지사항 번호:"+boardDTO.getNum());
		//1. HDD에 파일 저장
		//1) 파일 저장 위치
		// 	/resources/upload/notice
		
		// 2) 저장할 폴더 실제 경로 반환 (어플리케이션)
		String realPath = servletContext.getRealPath("resources/upload/notice");
		System.out.println("realPath : "+realPath);
		
		// 3) 저장할 폴더의 정보 가져오기
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//***** File 첨부 안했을때
		
		
		
		for(MultipartFile mpf : files) {
			if(mpf.isEmpty()) {
				continue;
			}else {
	
			//4) 중복되지 않는 파일명 생성
			String filename = UUID.randomUUID().toString();
			filename=filename+"_"+mpf.getOriginalFilename();
			System.out.println("파일명:"+filename);
			
			//5) 하드디스크에 파일 저장
			// 어느 폴더에 어떤 이름을 저장할 파일 객체 생성
			file = new File(file, filename); //(경로명, 파일이름)
			
			// a.MultipartFile 클래스의 transferTo 메서드 사용
			mpf.transferTo(file);
			
			//2. 저장된 파일 정보 DB 저장
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(filename);
			boardFileDTO.setOriName(mpf.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
			
			}//if문 끝
		}//for문 끝
		
	
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
	
	
}
