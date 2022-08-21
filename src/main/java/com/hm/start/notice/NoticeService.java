package com.hm.start.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getList() throws Exception {
		
		return noticeDAO.getList();
		
	}
	
	//작성하기
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		
		return noticeDAO.setAdd(noticeDTO);
		
	}
	
	
	
	//글 상세보기
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.getDetail(noticeDTO);
	}
	
	//업데이트
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		
		
		return noticeDAO.setUpdate(noticeDTO);
		
	}
	//삭제하기
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
	
		return noticeDAO.setDelete(noticeDTO);
	}
	
	//조회수 증가
	public int setUpdateHit(NoticeDTO noticeDTO) throws Exception {
		
		
		return noticeDAO.setUpdateHit(noticeDTO);
	}
}
