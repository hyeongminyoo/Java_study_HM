package com.hm.start.bankAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hm.start.MyAbstractTest;
import com.hm.start.bankMembers.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstractTest {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	
	@Test
	public void getListTest() throws Exception {
		
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("id7");
		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
		
		for(int i=0; i<ar.size(); i++) {
		System.out.println(ar.get(i).getBankBookDTO().getBookName());
			
		}
		
		assertNotEquals(0, ar.size());
	}
}
