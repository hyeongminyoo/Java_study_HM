package com.hm.start.notice;

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
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list.iu", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) throws Exception {
		System.out.println("게시판 목록");
		List<NoticeDTO> ar = noticeService.getList();
		mv.addObject("list", ar);
		mv.setViewName("notice/list");
		
		return mv;
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getDetail(HttpSession session,ModelAndView mv, NoticeDTO noticeDTO) throws Exception {
		System.out.println("상세페이지");
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		System.out.println(bankMembersDTO);
		if(bankMembersDTO == null) {
			noticeService.setUpdateHit(noticeDTO);
		}else {
			if(bankMembersDTO.getUserName().equals(noticeDTO.getWriter()) == false){
				noticeService.setUpdateHit(noticeDTO);
			}
		}
		noticeDTO = noticeService.getDetail(noticeDTO);
		mv.addObject("detail", noticeDTO);
		mv.setViewName("notice/detail");
		
		return mv;
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void setAdd() throws Exception {
		System.out.println("Add 페이지");
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO) throws Exception {
		System.out.println("Add 진행");
		int result = noticeService.setAdd(noticeDTO);
		System.out.println(result==1);
		
		return "redirect:./list.iu";
	}
	
	
	@RequestMapping(value="update.iu", method = RequestMethod.GET)
	public void setUpdate(Model model,NoticeDTO noticeDTO) throws Exception {
		System.out.println("업데이트 페이지");
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("update", noticeDTO);
	}
	
	@RequestMapping(value="update.iu", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception {
		System.out.println("업데이트 중");
		int result = noticeService.setUpdate(noticeDTO);
		System.out.println(result==1);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="delete.iu", method = RequestMethod.GET)
	public String setDelete(NoticeDTO noticeDTO) throws Exception {
		System.out.println("삭제");
		int result = noticeService.setDelete(noticeDTO);
		System.out.println(result==1);
		
		return "redirect:./list.iu";
	}
}
