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
import com.hm.start.util.FileManager;
import com.hm.start.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	
	
	@Override
	public int setFileDelete(BoardFileDTO boardFileDTO, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		boardFileDTO = noticeDAO.getFileDetail(boardFileDTO);
		int result = noticeDAO.setFileDelete(boardFileDTO);
		String path = "resources/upload/notice";
		
		if(result > 0) {
			fileManager.deleteFile(servletContext, path, boardFileDTO);
		}
		
		return result;
	}
	
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
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		int result = noticeDAO.setAdd(boardDTO);
		System.out.println("공지사항 번호:"+boardDTO.getNum());
		String path = "resources/upload/notice";
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
		
		
	
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		
		String path = "resources/upload/notice";
		int result = noticeDAO.setUpdate(boardDTO);
		
		if(result < 1) {
			return result;
		}
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
		
		
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
	
	
}
