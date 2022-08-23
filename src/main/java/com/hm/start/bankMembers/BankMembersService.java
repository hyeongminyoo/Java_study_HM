package com.hm.start.bankMembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.start.bankAccount.BankAccountDAO;
import com.hm.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
//	@Autowired
//	private BankAccountDAO banAccountDAO;
	
//	public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = banAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//		return map;
//	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	//bankMembers 회원가입 (Insert) (아이디, 패스워드, 이름, 이메일, 전화번호) (1이면성공, 0(Exception)이면 실패)
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}
	
	//검색어를 입력해서 ID를 찾기 (ex. abc가 포함된 id) abc 순으로
	public List<BankMembersDTO> getSearchByID(String search) throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}

}