package com.hm.start.bankBookComment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.start.MyAbstractTest;
import com.hm.start.bankBook.BankBookCommentDAO;
import com.hm.start.bankBook.BankBookCommentDTO;

public class BankBookCommentDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void test() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1661998795141L);
		bankBookCommentDTO.setWriter("writer1");
		bankBookCommentDTO.setContents("contents1");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		
		assertNotEquals(0, result);
	}

}
