package org.zerock.controller.ex06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.ex03.Customer;

@Controller
@RequestMapping("ex10")

public class Ex10Controller {
	
	@RequestMapping("sub01")
	public String method01(RedirectAttributes rttr) {
		// redirect 할 때 model은 사용 안된다
		// 받는 경우엔 model 사용 가능
		System.out.println("ex10/sub01 경로에서 일함");
		rttr.addAttribute("address", "seoul");
		// request의 값이 쿼리스트링으로 전달된다
		return "redirect:/ex10/sub02";
	}
	
	@RequestMapping("sub02")
	public void method02() {
		System.out.println("ex10/sub02 경로에서 일함");
	}
	
	
	@RequestMapping("sub03")
	public String method03(RedirectAttributes rttr) {
		rttr.addAttribute("name", "sunja");
		rttr.addAttribute("age", 99);
		rttr.addAttribute("address", "newyork");
		
		return "redirect:/ex10/sub04";
		// 두번째 요청인 sub04로 요청을 보내고 RedirectAttributes의 attribute가 쿼리스트링으로 나옴
	}
	
	@RequestMapping("sub04")
	public void method04() {
		
	}
	
	@RequestMapping("sub05")
	public String method05(RedirectAttributes rttr) {
		Customer cus = new Customer();
		cus.setAge(88);
		cus.setAddress("london");
		cus.setName("captain");
		
		rttr.addFlashAttribute("customer", cus);
		// 객체를 넘기려면 addFlashAttribute를 써줘야 함 
		return "redirect:/ex10/sub06";
	}
	
	@RequestMapping("sub06")
	public void method06(Model model) {
		System.out.println(model.asMap().get("customer"));
	}
	

	
	
	
	
	
	
}

