package com.hm.start.bankBookComment;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.start.MyAbstractTest;
import com.hm.start.bankBook.BankBookCommentDAO;
import com.hm.start.bankBook.BankBookCommentDTO;
import com.hm.start.util.CommentPager;

public class BankBookCommentDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
//	@Test
	public void test() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1661998795141L);
		bankBookCommentDTO.setWriter("writer2");
		bankBookCommentDTO.setContents("contents2");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		
		assertNotEquals(0, result);
	}
	
	
//	@Test
	public void getCommentListTest() throws Exception{
		CommentPager commentPager = new CommentPager();
		commentPager.getRowNum();
		commentPager.setBookNum(1660799230216L);
		
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager);
		
		assertEquals(5, ar.size());
	}
	
	@Test
	public void getCommentListTotalCount() throws Exception{
		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(1661998816684L);
		Long countTotal = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		System.out.println(countTotal);
	}

}
