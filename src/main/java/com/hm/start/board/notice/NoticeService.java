package com.hm.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.start.board.impl.BoardDTO;
import com.hm.start.board.impl.BoardService;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service Page:"+page);
		Long perPage = 10L; // 한페이지에 출력할 목록의 개수
		//page			startRow		lastRow
		//1				1				15
		//2				16				30
		//3				31				45		
		Long startRow = (page-1)*perPage+1;
		Long lastRow = perPage*page;
		
		System.out.println("startRow:"+startRow);
		System.out.println("lastRow:"+lastRow);
		Map<String, Long> map = new HashMap<String, Long>();
		
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		/*************************
		 * 
		 * 글의 갯수가 총 80개
		 * 1 - 10
		 * 2 - 10
		 * 
		 * 
		 * 
		 * 
		 * */
		
		Long count = noticeDAO.getCount();
		
		System.out.println(count);
		
		return noticeDAO.getList(map);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setAdd(boardDTO);
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
