package com.hm.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hm.start.board.impl.BoardDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "QnA";
	}
	
	//글 목록
	@RequestMapping(value = "list.iu" , method = RequestMethod.GET)
	public String getList(Long page, Model model) throws Exception{
		List<BoardDTO> ar= qnaService.getList(page);
		model.addAttribute("list", ar);
		return "board/list";
	}
	
	//글 상세 
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getDetail(ModelAndView mv,BoardDTO boardDTO) throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO = (QnaDTO) qnaService.getDetail(boardDTO);
		
		mv.addObject("boardDTO", qnaDTO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	//글 작성
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd(Model model) throws Exception{
		model.addAttribute("board", "QnA");
		return "board/add";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(Model model,BoardDTO boardDTO) throws Exception{
		
		int result = qnaService.setAdd(boardDTO);
		
		
		model.addAttribute("boardDTO", boardDTO);
		
		return "redirect:./list.iu";
	}
	
	
	//글 수정
	@RequestMapping(value = "update.iu" ,method = RequestMethod.GET)
	public String setUpdate(Model model,BoardDTO boardDTO, QnaDTO qnaDTO) throws Exception{
		qnaDTO = (QnaDTO) qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", qnaDTO);
		return "board/update";
	}
	
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = qnaService.setUpdate(boardDTO);
		
		return "redirect:./detail.iu?num="+boardDTO.getNum();
	}
	
	
	//글 삭제
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = qnaService.setDelete(boardDTO);
		
		return "redirect:./list.iu";
	}
}
