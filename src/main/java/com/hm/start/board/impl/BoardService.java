package com.hm.start.board.impl;

import java.util.List;

import com.hm.start.util.Pager;

public interface BoardService {
	
	//글 목록
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//글 상세
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글 쓰기
	public int setAdd(BoardDTO boardDTO) throws Exception;
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	
}
