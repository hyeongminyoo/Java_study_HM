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
	
	//이전 블럭의 유무
	private boolean pre;
	//다음 블럭의 유무
	private boolean next;
	
	//검색 컬럼의 종류
	private String kind;
	//검색어
	private String search;
	
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
		//1.totalCount로 totalPage 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
	
		//1.1 totalPage보다 page가 더 클 경우
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		
		
		//2.totalPage로 totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//3.page 번호로 현재 Block 번호 찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		
		//4. curBlock 으로 시작번호와 끝 번호 알아오기
		
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		//5. curBlock 이 totalBlock 과 같을 때
		if(curBlock == totalBlock) {
			this.lastNum=totalPage;
		}
		
		//6. 이전, 다음 블럭의 유무
		if(curBlock>1) {
			pre = true;
		}
		
		if(curBlock<totalBlock) {
			next = true;
		}

	}
	
	public Long getPage() {
		if(this.page==null || this.page <= 0) {
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


	public boolean isPre() {
		return pre;
	}


	public void setPre(boolean pre) {
		this.pre = pre;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}
	
	
	
}
