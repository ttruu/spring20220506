package org.zerock.controller.ex10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ex02.BoardDto;
import org.zerock.service.ex03.Ex05Service;

@Controller
@RequestMapping("ex15")
public class Ex15Controller {
	
	@Autowired
	private Ex05Service service;
	
	@RequestMapping("sub01")
	public String method01(int id, Model model) {
		String name = service.getCustomerNameById(id);
		
		model.addAttribute("name", name);
		
		
		return "/ex14/sub01";
	}
	
	@RequestMapping("sub02")
	public String method02(int id, Model model) {
		String name = service.getEmployeeFirstNameById(id);
		model.addAttribute("employeeName", name);
		
		return "/ex14/sub02";
	}
	
	// 게시물 목록 불러오기
	// 요청 경로 : ex15/board/list
	@GetMapping("board/list")
	public void listBoard(Model model) {
		List<BoardDto> list = service.listBoard();
		
		model.addAttribute("boardList", list);
	}
	
	@GetMapping("board/{id}") // 책366쪽
	// {id} :  path variable(경로변수)라고 함
	public String getBoard(@PathVariable("id") int id, Model model) {
		// 서비스일 시켜서 id에 해당하는 게시물 select
		BoardDto dto = service.getBoard(id);
		// 모델에 넣고
		model.addAttribute("board", dto);
		// /WEB-INF/views/ex15/board/get.jsp로 포워드
		return "/ex15/board/get";
	}
	
	@PostMapping("/board/modify")
	public String modifyBoard(BoardDto board) {
		boolean success = service.updateBoard(board);
		if(success) {
			
		} else {
			
		}
		return "redirect:/ex15/board/" + board.getId();
	}
	
}
