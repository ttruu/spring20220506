package org.zerock.controller.ex07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ex11")
public class Ex11Controller {
//	받는 방식(get, post)에 따라 메소드 분리
	
	
//	@RequestMapping(value="login", method=RequestMethod.GET)을 
	@GetMapping("login") //으로 사용
	public void loginForm() {
		System.out.println("로그인 화면으로 포워드");
		
	}
	
	
//	@RequestMapping(value="login", method=RequestMethod.POST)
	@PostMapping("login")
	public String loginProcess(String id, String password, RedirectAttributes rttr) {
		System.out.println("로그인 처리!");
		
		boolean ok = false;
		if(id != null && id.equals(password)) {
			ok = true;
		}
		
		if(ok) {
			rttr.addFlashAttribute("message", "로그인 성공");
			
			return "redirect:/ex11/main";
		} else {
			rttr.addFlashAttribute("message", "아이디나 패스워드 불일치");
			
			return "redirect:/ex11/login";
		}
	}
	
	@GetMapping("main")
	public void main() {
		
	}
}
