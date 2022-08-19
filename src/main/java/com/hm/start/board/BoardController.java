package com.hm.start.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hm.start.bankMembers.BankMembersDTO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="list.iu", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) throws Exception {
		System.out.println("게시판 목록");
		List<BoardDTO> ar = boardService.getList();
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getDetail(HttpSession session,ModelAndView mv, BoardDTO boardDTO) throws Exception {
		System.out.println("상세페이지");
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		System.out.println(bankMembersDTO);
		if(bankMembersDTO == null) {
			boardService.setUpdateHit(boardDTO);
		}
//		else {
//			if(bankMembersDTO.getUserName().equals(boardDTO.getUserName()) == false){
//				boardService.setUpdateHit(boardDTO);
//			}
//		}
		boardDTO = boardService.getDetail(boardDTO);
		mv.addObject("detail", boardDTO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void setAdd() throws Exception {
		System.out.println("Add 페이지");
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO) throws Exception {
		System.out.println("Add 진행");
		int result = boardService.setAdd(boardDTO);
		System.out.println(result==1);
		
		return "redirect:./list.iu";
	}
	
	
	@RequestMapping(value="update.iu", method = RequestMethod.GET)
	public void setUpdate(Model model,BoardDTO boardDTO) throws Exception {
		System.out.println("업데이트 페이지");
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("update", boardDTO);
	}
	
	@RequestMapping(value="update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		System.out.println("업데이트 중");
		int result = boardService.setUpdate(boardDTO);
		System.out.println(result==1);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="delete.iu", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception {
		System.out.println("삭제");
		int result = boardService.setDelete(boardDTO);
		System.out.println(result==1);
		
		return "redirect:./list.iu";
	}
	
	
}
