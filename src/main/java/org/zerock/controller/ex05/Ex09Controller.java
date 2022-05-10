package org.zerock.controller.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex09")
public class Ex09Controller {
	
	@RequestMapping("sub01")
	public void method01(String name, Model model) {
		// 1. request 파라미터 수집/가공
		System.out.println(name);
		// 2. business 5.11 배움
		// 3. model에 attribute 추가
		model.addAttribute("name", name);
		
		// 4. view forward : ex09/sub01
	}
	
	// /ex09/sub02?name=trump
	@RequestMapping("sub02")
	public String method02(@ModelAttribute("name") String name) {
		// @ModelAttribute("name") String name 랑 
		// model.addAttribute("name", name); 랑 같은 일
		
		return "ex09/sub01";
	}
	
	// /ex09/sub03?address=seoul&email=seoul@gmail.com
	@RequestMapping("sub03")
	public void method03(@ModelAttribute("address") String address, 
			             @ModelAttribute("email") String email) {
			
		}
	
	// /ex09/sub04?name=trump&age=40&address=newyork
	@RequestMapping("sub04")
	public void method04(@ModelAttribute("customer") Customer cus) {
		// @ModelAttribute() ... 원리
		// requestParam으로 넘어온 데이터가 자동으로 Customer객체로 set 되는 것 
	}
	
	// /ex09/sub04?name=trump&age=40&address=newyork
	@RequestMapping("sub05")
	public String method05(@ModelAttribute Customer cus) {
		// @ModelAttribute("customer") 에서 () 생략 가능 
		return "ex09/sub04";
	}
	
	// /ex09/sub04?name=trump&age=40&address=newyork
	@RequestMapping("sub06")
	public String method06(Customer cus) {
		// @ModelAttribute도 생략 가능
		return "ex09/sub04";
	}
	
	// 문제
	// 요청경로 : /ex09/sub07
	// 쿼리스트링 : ?name=sunja&salary=50000&email=sunja@gmail.com
	// 쿼리스트링으로 넘어온 파라미터 값들을 세팅해서
	// model에 "employee"라는 이름의 attribute로 추가되고
	// ex09/sub07 뷰로 포워드 되도록
	/*
	@RequestMapping("sub07")
	public void method07(HttpServletRequest request) {
		String name = request.getParameter("name");
		String salaryStr = request.getParameter("salary");
		String email = request.getParameter("email");
		
		int salary = Integer.parseInt(salaryStr);
		
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setName(name);
		emp.setSalary(salary);
		
		request.setAttribute("employee", emp);
		
		request.getRequestDispatcher("/WEB-INF/views/ex09/sub07.jsp");
		
	}
	위의 꺼가 다 생략되는 거 !!!
	*/
	
	@RequestMapping("sub07")
	public void method07(Employee emp) {
		// 다 생략해서 이렇게만 해줘도 가능하다 햐 ... 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
