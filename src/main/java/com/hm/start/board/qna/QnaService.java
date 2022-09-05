package com.hm.start.board.qna;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hm.start.board.impl.BoardDTO;
import com.hm.start.board.impl.BoardFileDTO;
import com.hm.start.board.impl.BoardService;
import com.hm.start.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		qnaDAO.setStepUpdate(parent);
		int result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
	}
	
	
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.getRowNum();
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		
		return qnaDAO.getList(pager);
	}
	
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		
		int result = qnaDAO.setAdd(boardDTO);
		
		//1. HDD에 파일 저장
		//1) 파일 저장 위치
		// /resources/upload/qna
		
		//2) 저장할 폴더 실제 경로 반환(어플리케이션)
		String realpath = servletContext.getRealPath("/resources/upload/qna");
		System.out.println("realPath : "+ realpath);
		
		//3) 저장할 폴더의 정보 가져오기
		
		for(MultipartFile mpf : files) {
			if(mpf.isEmpty()) {
				continue;
			}
			
			File file = new File(realpath);
			if(!file.exists()) {
				file.mkdirs();
			}
			
			//4) 중복되지않는 파일명 생성
			String filename = UUID.randomUUID().toString();
			filename = filename+"_"+mpf.getOriginalFilename();
			System.out.println("파일명:"+filename);
			
			//5)하드디스크에 파일 저장
			//어느 폴더에 어떤 이름을 저장할 파일 객체 생성
			file = new File(file, filename);
			//File dest = new File(file,filename);
			
			//a.MultipartFile 클래스의 transferTo 메서드
			mpf.transferTo(file);
			//mpf.transferTo(dest);
			
			//2. 저장된 파일 정보 DB 저장
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(filename);
			boardFileDTO.setOriName(mpf.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			qnaDAO.setAddFile(boardFileDTO);
			
		}//for 문 끝
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}
	
	
}
