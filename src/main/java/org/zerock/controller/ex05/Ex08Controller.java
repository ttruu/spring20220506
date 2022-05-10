package org.zerock.controller.ex05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex08")
public class Ex08Controller {
	
	@RequestMapping("sub01")
	public String method01(HttpServletRequest request) {
		
		request.setAttribute("address", "newyork");
		// prefix : /WEB-INF/views/
		// suffix : .jsp
				
		// full view name : /WEB-INF/views/ex08/sub01.jsp
		return "ex08/sub01";
	}
	
	@RequestMapping("sub02")
	public String method02(Model model) {
		model.addAttribute("address", "london");
		return "ex08/sub01";
	}
	
	@RequestMapping("sub03")
	public String method03(Model m) {
		m.addAttribute("MyName", "jimin");
		m.addAttribute("MyAge", 99);
		return "ex08/sub03";
	}
	
	// prefix : /WEB-INF/views/
	// suffix : .jsp
	// 요청경로 : /ex08/sub04
	// void return 타입일 경우엔 /ex08/sub04 <- view 이름
	// view name : /WEB-INF/views/ex08/sub04.jsp
	@RequestMapping("sub04")
	public void method04(Model model) {
		model.addAttribute("foods", new String[] {"apple", "milk", "coffee"});
	}
	
	@RequestMapping("sub05")
	public void method05(Model model) {
		model.addAttribute("heroList", new String[] {"doctor", "tor", "ironman"});
	}
	
	@RequestMapping("sub06")
	public void method06(Model model) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "jin");
		map.put("song", "butter");
		map.put("group", "bts");
		
		model.addAttribute("desc", map);
	}
	
	@RequestMapping("sub07")
	public void method07(Model model) {
		Customer cus = new Customer();
		cus.setAddress("seoul");
		cus.setName("donald");
		cus.setAge(30);
		
		model.addAttribute("customer", cus);
	}
	
	
	// jsp와 이 메소드를 완성해서 위에 셋팅한 email, name, salary 가 출력되도록 하세요
	@RequestMapping("sub08")
	public void method08(Model model) {
		Employee emp = new Employee();
		emp.setName("sunja");
		emp.setSalary(10000);
		emp.setEmail("se@gmial.com");
		
		model.addAttribute("employee", emp);
	}
	
	@RequestMapping("sub09")
	public String method09(Model model) {
		
		Employee emp = new Employee();
		emp.setEmail("korea@daum.net");
		emp.setName("jin");
		emp.setSalary(70000);
		
		// model.addAttribute("employee", emp); 와 동일
		model.addAttribute(emp); // attribute이름이 클래스의 이름으로 결정(단, lowerCamelCase 형식)
		return "ex08/sub08";
	}
	
	@RequestMapping("sub10")
	public String method10(Model model) {
		
		// model.Attribute(Object)를 사용해서
		// sub07.jsp에서 고객의 정보가 출력되도록 코드를 완성
		Customer cus = new Customer();
		cus.setName("suga");
		cus.setAddress("beriln");
		cus.setAge(80);
		
		model.addAttribute(cus);
		
		return "ex08/sub07";
	}
	
	
	@RequestMapping("sub11")
	public void method11(Model model) {
		List<String> list = new ArrayList<>();
		
		list.add("wanda");
		list.add("doctor");
		list.add("wong");
		
		model.addAttribute("arrayList", list);
	}
	
	@RequestMapping("sub12")
	public void method12() {
		
		// 1. request 파라미터 수집/가공
		// 2. business 로직 처리
		// 3. add attribute
		// 4. forward/redirect
	}	
	
	
}
