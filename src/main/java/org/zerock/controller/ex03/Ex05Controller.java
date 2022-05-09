package org.zerock.controller.ex03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex05")
public class Ex05Controller {
	
	// /ex05/sub01?name=jin&age=11&address=seoul
	@RequestMapping("sub01")
	public void method01(HttpServletRequest request) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		Customer cus = new Customer();
		cus.setName(name);
		cus.setAge(age);
		cus.setAddress(address);
		
		System.out.println(cus);
		// 2. business 로직 처리
		// dao.insert();
		// 3. add attribute
		// 4. forward / redirect
	}
	
	
	//ex05/sub02?name=jin&age=11&address=seoul
	@RequestMapping("sub02")
	public void method02(Customer cus) {
		System.out.println(cus);
		// customer 하나만 붙여도 위에 코드랑 같은 값이 나옴
	}
	
	
	//ex05/sub02?name=jin&age=11&address=seoul
	@RequestMapping("sub03") 
	public void method03(@ModelAttribute Customer cus) {
		System.out.println(cus);
		// 위 코드값에 @어떤 어노테이션이 생략되어 있는지 
	}
	
	
	// ex05/sub04?cpu=intel&hdd=1024&model=apple
	@RequestMapping("sub04")
	public void method04(Computer com) {
		System.out.println(com); // Computer(cpu=intel, hdd=1024, model=apple)
	}
	
	
	// ex05/sub05?name=donald&salary=1000&email=emp@gmail.com
	@RequestMapping("sub05")
	public void method05(Employee emp) {
		System.out.println(emp); // Employee(name=donald, salary=1000, email=emp@gmail.com)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
