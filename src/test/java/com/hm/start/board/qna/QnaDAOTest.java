package com.hm.start.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.start.MyAbstractTest;
import com.hm.start.board.impl.BoardDTO;

public class QnaDAOTest extends MyAbstractTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void test() throws Exception {
//		List<BoardDTO> ar = qnaDAO.getList();
//		
//		assertNotEquals(0, ar.size());
//		
//		QnaDTO qnaDTO = new QnaDTO();
//		qnaDTO.setNum(21L);
//		qnaDTO.setTitle("aasdgasdf");
//		qnaDTO.setWriter("asdgasdg");
//		qnaDTO.setContents("adgasdgasdg");
//		
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(21L);
//		
//		qnaDTO = (QnaDTO) qnaDAO.getDetail(qnaDTO);
//		
//		System.out.println(qnaDTO.getTitle());
		
	}
	
	@Test
	public void test2() throws Exception{
		
//		QnaDTO qnaDTO = new QnaDTO();
//		qnaDTO.setTitle("aasdgasdfadg");
//		qnaDTO.setWriter("asdgasdgadsgasdg");
//		qnaDTO.setContents("adgasdgasdasdgasdgg");
//		int result = qnaDAO.setAdd(qnaDTO);
//		
//		assertNotEquals(0, result);
//		
	}
	
	
	@Test
	public void test3() throws Exception{
		
//		QnaDTO qnaDTO = new QnaDTO();
//		qnaDTO.setNum(41L);
//		qnaDTO.setContents("UPDATE1");
//		qnaDTO.setTitle("UPDATE1");
//		int result = qnaDAO.setUpdate(qnaDTO);
//		
//		assertNotEquals(0, result);
	}
	
	@Test
	public void test4() throws Exception{
		
		for(int i=0; i<100 ; i++) {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("Test"+i);
		qnaDTO.setWriter("Writer"+i);
		qnaDTO.setContents("Contents"+i);
		
		int result = qnaDAO.setAdd(qnaDTO);
		
		if(i%10==0) {
			Thread.sleep(500);
		}
	}
		
	}
	
	
}
