package com.hm.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hm.start.board.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.hm.start.board.BoardDAO."; 
	
		public List<BoardDTO> getList() throws Exception {
			
			return sqlSession.selectList(NAMESPACE+"getList");
			
		}
		
		//작성하기
		public int setAdd(BoardDTO boardDTO) throws Exception{
			
			return sqlSession.update(NAMESPACE+"setAdd", boardDTO);
			
		}
		
		
		
		//글 상세보기
		public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
			
			return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
		}
		
		//업데이트
		public int setUpdate(BoardDTO boardDTO) throws Exception {
			
			
			return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
			
		}
		//삭제하기
		public int setDelete(BoardDTO boardDTO) throws Exception {
		
			return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
		}
		
		//조회수 증가
		public int setUpdateHit(BoardDTO boardDTO) throws Exception {
			
			
			return sqlSession.update(NAMESPACE+"setUpdateHit", boardDTO);
		}
}
