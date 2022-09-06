package com.hm.start.bankBook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.start.util.CommentPager;
import com.hm.start.util.Pager;

@Service
public class BankBookService {
	
	//--------------------Comment-------------------------
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception{
		commentPager.getRowNum();
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	//----------------------------------------------------
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setDelete(bankBookDTO);
	}
	
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	//BANKBOOK 테이블에 인서트 
	//BOOKNUM은 현재 시간을 밀리세컨즈로 변환하여 입력
	//BOOKSALE은 처음엔 무조건 1로 입력
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception{
		Calendar ca = Calendar.getInstance();
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		return bankBookDAO.setBankBook(bankBookDTO);
	}
	
	//BankBook 모든 데이터를 조회
	//최신 순으로(
	public List<BankBookDTO> getList(Pager pager) throws Exception{
		
		pager.getRowNum();
		Long totalCount = bankBookDAO.getCount(pager);
		pager.getNum(totalCount);
		
		return bankBookDAO.getList(pager);
	}
	
	//BOOKSALE의 값을 수정
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	
	//BookNum의 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	
}
