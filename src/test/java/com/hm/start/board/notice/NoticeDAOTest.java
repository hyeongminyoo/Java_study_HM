package com.hm.start.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.start.MyAbstractTest;
import com.hm.start.board.impl.BoardDAO;
import com.hm.start.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void noticeTest() throws Exception {
		
		
//		for(int i=0; i<100 ; i++) {
//			NoticeDTO noticeDTO = new NoticeDTO();
//			noticeDTO.setTitle("Test"+i);
//			noticeDTO.setWriter("Writer"+i);
//			noticeDTO.setContents("Contents"+i);
//			
//			int result = noticeDAO.setAdd(noticeDTO);
//			
//			if(i%10==0) {
//				Thread.sleep(500);
//			}
//		}
		
		
		
		Long count = noticeDAO.getCount();
		
		System.out.println(count);
//		List<BoardDTO> ar = noticeDAO.getList();
//		
//		assertNotEquals(0, ar.size());
		
//		NoticeDTO noticeDTO = new NoticeDTO();
//		
//		noticeDTO.setNum(1L);
//		
//		noticeDTO = (NoticeDTO) noticeDAO.getDetail(noticeDTO);
//		
//		assertNotNull(noticeDTO);
		
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("ASDFASDF");
//		boardDTO.setContents("adsgasd");
//		boardDTO.setWriter("adsgasdg");
//		
//		System.out.println(boardDTO.getTitle());
//		
//		int result = noticeDAO.setAdd(boardDTO);
//		System.out.println(result);
//		assertEquals(0, result);
		
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(61L);
		
//		NoticeDTO noticeDTO = new NoticeDTO();
		
//		noticeDTO.setNum(81L);
//		int result = noticeDAO.setUpdate(boardDTO);
//		
//		assertNotEquals(0, result);
		
//		int result = noticeDAO.setDelete(noticeDTO);
//		
//		assertNotEquals(0, result);
		
	}
	
}
