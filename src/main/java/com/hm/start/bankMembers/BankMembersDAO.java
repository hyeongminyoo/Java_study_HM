package com.hm.start.bankMembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hm.start.bankMembers.BankMembersDTO;

@Repository
public class BankMembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.hm.start.bankMembers.BankMembersDAO.";
	
	public int setAddFile(BankMembersFileDTO bankMembersFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddFile", bankMembersFileDTO);
	}
	
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
	}
	
	//bankMembers 회원가입 (Insert) (아이디, 패스워드, 이름, 이메일, 전화번호) (1이면성공, 0(Exception)이면 실패)
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}
	
	//검색어를 입력해서 ID를 찾기 (ex. abc가 포함된 id) abc 순으로
	public List<BankMembersDTO> getSearchByID(String search) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMyPage", bankMembersDTO);
	}
	
}
