package org.zerock.controller.ex09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.domain.ex01.PageInfoDto;
import org.zerock.service.ex02.Ex04Service;


@Controller
@RequestMapping("ex14")
public class Ex14Controller {
	
	@Autowired
	private Ex04Service service;
	
	// /ex14/sub01?id=1
	@RequestMapping("sub01")
	public void method01(int id, Model model) {
		// request parameter 수집/가공
		// business logic 처리
		String name = service.getNameById(id);
		// model.addAttribute
		model.addAttribute("name", name);
		// foward / redirect
		// view(jsp)로 보내줘
	}
	
	
	// /ex14/sub02?id=3
	// view에서 firstName이 출력되도록
	// controller.method02 완성
	// service에도 메소드 추가
	// mapper에도 메소드 추가
	// jsp작성
		
	@RequestMapping("sub02")
	public void method02(int id, Model model) {
		String empName = service.getNameByEmpId(id);
		model.addAttribute("empName", empName);
		
	}
	
	
	// /ex14/sub03?id=3
	@RequestMapping("sub03")
	public void method03(int id, Model model) {
		// 자바빈즈 CustomerDto : 클래스들의 패키지(데이터를 담고있는 객체)
		CustomerDto dto = service.getCustomerInfoById(id);
		model.addAttribute("customer", dto);
	}
	
	
	// /ex14/sub04?id=7
	// 직원의 FirstName, LastName이 모두 jsp 출력되도록
	// controller 새 메소드 작성
	// service 새 메소드 작성
	// mapper에 새 메소드 작성
	// 새 jsp 파일 작성
	// EmployeeDto 새로 작성
	@RequestMapping("sub04")
	public void method04(int id, Model model) {
		EmployeeDto empDto = service.getEmployeeInfoById(id);
		model.addAttribute("employee", empDto);
	}
	
	
	
	
	
	@GetMapping("sub05")
	public void method05() {
		// form이 있는 jsp로 forward
	}
	
	@PostMapping("sub05")
	public String method06(CustomerDto customer, RedirectAttributes rttr) {
		
		boolean ok = service.addCustomer(customer);
		
		if(ok) {
			rttr.addFlashAttribute("message", "등록 완료");
		} else {
			rttr.addFlashAttribute("message", "등록 실패");
		}
		
		return "redirect:/ex14/sub05";
	}
	
	
	/* 직원 등록 */
	@GetMapping("sub06")
	public void method06() {
		
	}
	
	@PostMapping("sub06")
	public String method06(EmployeeDto employee, RedirectAttributes rttr) {
		
		boolean ok = service.addEmployee(employee);
		
		if(ok) {
			rttr.addFlashAttribute("message", "등록 완료");
		} else {
			rttr.addFlashAttribute("message", "등록 실패");
		}
		
		return "redirect:/ex14/sub06";
	}
	
	// 직원 목록 조회
	@GetMapping("sub07")
	public void method07(Model model) {
		List<EmployeeDto> list = service.listEmployee();
		model.addAttribute("employees", list);
	}
	
	
	// 고객 목록 조회
	@GetMapping("sub08")
	public void method08(Model model) {
		List<CustomerDto> list = service.listCustomer();
		model.addAttribute("customers", list);
	}
	
	
	// 페이지네이션
	@GetMapping("sub09")
	public String method09(@RequestParam(name = "page", defaultValue = "1")int page, Model model) {
		// @RequestParam(name = "page", defaultValue = "1") 페이지의 기본값을 1로 주는 것
		// 한 페이지에 몇개씩 보여줄건지 명시
		int rowPerPage = 5;
		List<CustomerDto> list = service.listCustomerPage(page, rowPerPage);
		
		// 총 갯수 구하기
		int totalRecords = service.countCustomers();
		
		// 마지막 페이지 구하기
		int end = (totalRecords - 1) / rowPerPage + 1;
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		model.addAttribute("customers", list);
		model.addAttribute("pageInfo", pageInfo);
		
		return "/ex14/sub09";
	}
	
	
	
}
