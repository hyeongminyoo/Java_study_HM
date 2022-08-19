package com.hm.start.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> getList() throws Exception {
		
		return boardDAO.getList();
		
	}
	
	//작성하기
	public int setAdd(BoardDTO boardDTO) throws Exception{
		
		return boardDAO.setAdd(boardDTO);
		
	}
	
	
	
	//글 상세보기
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return boardDAO.getDetail(boardDTO);
	}
	
	//업데이트
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		
		return boardDAO.setUpdateHit(boardDTO);
		
	}
	//삭제하기
	public int setDelete(BoardDTO boardDTO) throws Exception {
	
		return boardDAO.setDelete(boardDTO);
	}
	
	//조회수 증가
	public int setUpdateHit(BoardDTO boardDTO) throws Exception {
		
		
		return boardDAO.setUpdateHit(boardDTO);
	}
	
}
