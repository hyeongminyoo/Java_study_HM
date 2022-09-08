package com.hm.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hm.start.bankMembers.BankMembersDTO;
import com.hm.start.board.impl.BoardDTO;
import com.hm.start.board.qna.QnaDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		if(method.equals("POST")) {
			return;
		}
		
		//로그인 사용자의 ID와 DTO의 작성자가 일치하는가?
		//로그인 사용자 정보
		HttpSession session = request.getSession();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		Map<String, Object> map = modelAndView.getModel();
		
		BoardDTO boardDTO = (BoardDTO)map.get("boardDTO");
		
		if(!bankMembersDTO.getUserName().equals(boardDTO.getWriter())) {
			modelAndView.setViewName("common/result");
			modelAndView.addObject("message", "작성자만 수정이 가능합니다.");
			modelAndView.addObject("url", "./list.iu");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
