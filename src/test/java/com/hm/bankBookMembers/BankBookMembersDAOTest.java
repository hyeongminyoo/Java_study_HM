package com.hm.bankBookMembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.start.MyAbstractTest;
import com.hm.start.banbookMembers.BankbookMembersDAO;


public class BankBookMembersDAOTest extends MyAbstractTest {
	
	@Autowired
	private BankbookMembersDAO bankbookMembersDAO;
	
	@Test
	public void setJoinTest() throws Exception {
		int result = bankbookMembersDAO.setJoin("abc");
		throw new Exception();
		//assertEquals(1, result);
	}
	@Test
	public void getLoginTest() throws Exception{
		
		Object object = bankbookMembersDAO.getLogin("ABCD");
		assertNull(object);
	}
	
	@Test
	public void getSearchByIDTest() throws Exception{
		
		List<Object> ar = bankbookMembersDAO.getSearchByID("a");
		assertNotEquals(0, ar.size());
	}
	
}
