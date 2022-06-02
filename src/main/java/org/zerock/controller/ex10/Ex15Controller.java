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
import org.zerock.domain.ex02.ReplyDto;
import org.zerock.service.ex03.Ex05Service;
import org.zerock.service.ex03.Ex06Service;

@Controller
@RequestMapping("ex15")
public class Ex15Controller {
	
	@Autowired
	private Ex05Service service;
	
	@Autowired
	private Ex06Service replyService;
	
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
		/* 댓글 갯수 보이기 */
		
		model.addAttribute("boardList", list);
	}
	
	
	/* 게시물 보기 */
	@GetMapping("board/{id}") // 책366쪽
	// {id} : 여기에 어떤 값이 들어오면 /board/{id}로 매핑이 됨
	// {id}가 int의 id에 들어가야 함 이러한 것을
	// path variable(경로변수)라고 함
	public String getBoard(@PathVariable("id") int id, Model model) {
		
		// 서비스일 시켜서 id에 해당하는 게시물 select
		BoardDto dto = service.getBoard(id);
		
		/* 댓글 보이기 */ 
		List<ReplyDto> replyList = replyService.listReplyByBoardId(id);
		
		// 모델에 넣고
		model.addAttribute("board", dto);
		
		/* 댓글 보이기 */ 
		model.addAttribute("replyList", replyList);
		
		// /WEB-INF/views/ex15/board/get.jsp로 포워드
		return "/ex15/board/get";
	}
	
	
	/*게시물 수정*/
	@PostMapping("board/modify")
	public String modifyBoard(BoardDto board) {
		boolean success = service.updateBoard(board);
		if(success) {
			
		} else {
			
		}
		return "redirect:/ex15/board/" + board.getId();
	}
	
	
	/* 게시물 삭제 */
	@PostMapping("board/remove")
	public String removeBoard(int id) {
		boolean success = service.removeBoardById(id);
		if(success) {
			
		} else {
			
		}
		/* 댓글 있는 게시물 삭제하기 */
		/* 댓글을 먼저 지워야 함--> 서비스에서 해줌 */
		
		return "redirect:/ex15/board/list";
	}
	
	
	/* 글 쓰기 */
	@GetMapping("board/write")
	public void writeBoard() {
		
	}
	
	@PostMapping("board/write") 
	public String writeBoardProcess(BoardDto board) {
		boolean success = service.writeBoard(board);
		
		if(success) {
			
		} else {
			
		}
		
		int id = 1;
		
		// mapper가 받은 자바빈즈의 setId(id) 메소드를 사용해서 얻어온 id를 셋팅해줌
		// 근데 컨트롤러, 서비스, 매퍼의 객체가 다 같아서 컨트롤러에서 아이디를 받아오면 됨
		return "redirect:/ex15/board/" + board.getId();
	}
	
	
	
	
}
