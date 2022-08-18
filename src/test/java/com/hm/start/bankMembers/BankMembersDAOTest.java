package com.hm.start.bankMembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.start.MyAbstractTest;

public class BankMembersDAOTest extends MyAbstractTest {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	
	@Test
	public void getLoginTest() throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("id7");
		bankMembersDTO.setPassword("pw7");
		bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
		
		assertNotNull(bankMembersDTO);
	}
	
//	@Test
//	public void setJoinTest() throws Exception{
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUserName("id78");
//		bankMembersDTO.setPassword("pw78");
//		bankMembersDTO.setName("name78");
//		bankMembersDTO.setEmail("email78@naver.com");
//		bankMembersDTO.setPhone("01025233466");
//		
//		int result = bankMembersDAO.setJoin(bankMembersDTO);
//		assertEquals(1, result);
//	}
	
	@Test
	public void getSearchID() throws Exception{
		String search = "abc";
		List<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
		assertEquals(1, ar.size());
	}

}
