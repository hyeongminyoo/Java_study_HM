package com.hm.start.util;

import java.util.List;
import java.util.Map;

public class Pager {
	
	//멤버변수
	/**
	 * 파라미터를 담을 변수
	 * jsp 에서 꺼내서 사용할 변수
	 * mapper 에서 꺼내서 사용할 변수
	 * perPage : 한 페이지에 출력할 글의 갯수
	 * perBlcok : 한 페이지에 출력할 번호의 개수
	 **/
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	
	public Pager() {
		this.perPage=10L;
		this.perBlock=5L;
	}
	
	
	//1. mapper에서 사용할 값
	public void getRowNum() throws Exception{
		
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	//2. JSP에서 사용할 값을 계산
	public void getNum(Long totalCount) throws Exception{
		//totalCount로 totalPage 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount/this.getPerPage() != 0) {
			totalPage++;
		}
		
		//totalPage로 totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage/this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//page 번호로 현재 Block 번호 찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		// curBlock 으로 시작번호와 끝 번호 알아오기
		
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		
	}
	
	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	
	
	
}
