package com.hm.start.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hm.start.bankMembers.BankMembersDTO;
import com.hm.start.bankMembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1. 로그인한 사용자에서 roleDTOs를 꺼냄 반복문 admin을 찾음
		HttpSession session = request.getSession();
		
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		List<RoleDTO> ar = bankMembersDTO.getRoleDTOs();
		
		boolean check = false;
		
		for(RoleDTO rd : ar) {
			if(rd.getRoleName().equals("admin")) {
				check = true;
				break;
			}
		}
		
		//2. admin이 아닐 때
		if(!check) {
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("url", "../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp"); //jsp의 경로
			view.forward(request, response);
			
		}
		
		
		return check; 
	}
}
