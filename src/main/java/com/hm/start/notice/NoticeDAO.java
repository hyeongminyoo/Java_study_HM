package com.hm.start.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.hm.start.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList");
		
	}
	
	//작성하기
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"setAdd", noticeDTO);
		
	}
	
	
	
	//글 상세보기
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}
	
	//업데이트
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		
		
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
		
	}
	//삭제하기
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
	
		return sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
	}
	
	//조회수 증가
	public int setUpdateHit(NoticeDTO noticeDTO) throws Exception {
		
		
		return sqlSession.update(NAMESPACE+"setUpdateHit", noticeDTO);
	}
}
