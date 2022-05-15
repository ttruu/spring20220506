package org.zerock.controller.ex10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ex02.ReplyDto;
import org.zerock.service.ex03.Ex06Service;

@Controller
@RequestMapping("ex16")
public class Ex16Controller {
	
	@Autowired
	private Ex06Service service;
	
	/* 댓글 추가(쓰기) */
	@RequestMapping("reply/add") 
	public String addReply(ReplyDto reply) {
		boolean success = service.addReply(reply);
		
		return "redirect:/ex15/board/" + reply.getBoardId();
	}
	
	/* 댓글 삭제 */
	@PostMapping("reply/remove")
	public String removeReply(ReplyDto reply) {
		
		boolean success = service.removeReplyById(reply.getId());
		
		return "redirect:/ex15/board/" + reply.getBoardId();
		
	}
	
	/* 댓글 수정 */
	@PostMapping("reply/modify")
	public String modifyReply(ReplyDto reply) {
		boolean success = service.modifyReply(reply);
		return "redirect:/ex15/board/" + reply.getBoardId();
	}
	
}
