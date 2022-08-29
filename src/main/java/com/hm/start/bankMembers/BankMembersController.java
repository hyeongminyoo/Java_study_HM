package com.hm.start.bankMembers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.hm.start.bankAccount.BankAccountDTO;
import com.hm.start.bankAccount.BankAccountService;
import com.hm.start.bankBook.BankBookDTO;
import com.hm.start.bankBook.BankBookService;

@Controller
@RequestMapping(value="/member/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;
	
//	@Autowired
//	private BankAccountService bankAccountService;
	
	
	@RequestMapping(value="join.iu", method=RequestMethod.GET)
	public String join() {
		System.out.println("join GET 실행");
		return "member/join";
	}
	
	@RequestMapping(value="join.iu", method=RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception{
		System.out.println("join POST 실행");
		System.out.println(photo);
		System.out.println("upload 파일명 : "+ photo.getOriginalFilename());
		System.out.println("upload 파라미터명 : "+ photo.getName());
		System.out.println("upload 파일 크기 : " + photo.getSize());
		
		int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());
		return "redirect:./login.iu";
	}

	
	@RequestMapping(value="logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		return "member/login";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public String login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("DB에 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		if(bankMembersDTO != null) {
		session.setAttribute("member", bankMembersDTO);
		return "redirect:../";
		}else {
			System.out.println("로그인 실패");
			return "member/login";
		}
	}
	
	@RequestMapping(value="search.iu", method=RequestMethod.GET)
	public void getSearchByID()throws Exception{
		
	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.POST)
	public String getSearchByID(String search, Model model)throws Exception{
		List<BankMembersDTO> ar= bankMembersService.getSearchByID(search);
		
		model.addAttribute("list", ar);
		return "member/list";
	}
	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public String getMyPage(HttpSession session, BankMembersDTO bankMembersDTO,Model model) throws Exception{
		bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
//		Map<String, Object> map = bankMembersService.getMyPage(bankMembersDTO);
//
//		
//		model.addAttribute("map", map);
//		List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getBankMembersFileDTO().getFileName());
		model.addAttribute("dto", bankMembersDTO);
//		model.addAttribute("list", ar);
		return "member/myPage";
	}
	
}
