package org.zerock.controller.ex02;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex04")
public class Ex04Controller {
	
	@RequestMapping("sub01")
	public void method1(HttpServletRequest request) {
		System.out.println("/ex04/sub01 요청");
		//1. request parameter 수집/가공
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		// 
	}
	
	// @RequestParam
	@RequestMapping("sub02")
	public void method02(@RequestParam("name") String n ) {
		System.out.println(n);
	}
	
	@RequestMapping("sub03")
	public void method03(@RequestParam("name") String n, @RequestParam("age") String age) {
		System.out.println(n);
		System.out.println(age);
		//int a = Integer.parseInt(age);
		//위의 일을 리퀘스트가 해주고 있다 형변환
	}
	
	@RequestMapping("sub04")
	public void method04(@RequestParam("age") int age) {
		System.out.println(age);
	}
	
	@RequestMapping("sub05")
	public void method05(HttpServletRequest request) {
		// 1. request parameter 수집/가공
		String name = request.getParameter("name");
		String agrStr = request.getParameter("age");
		
		int age = Integer.parseInt(agrStr);
		
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("sub06")
	public void method06(@RequestParam String name, @RequestParam int age) {
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("sub07")
	public void method07(String name, int age) {
		System.out.println(name);
		System.out.println(age);
		// @requestparam이 생략되어 있는 것
	}
	
	
	@RequestMapping("sub08")
	public void method08(String address, int number) {
		System.out.println(address); // seoul
		System.out.println(number); // 300
	}
	
	@RequestMapping("sub09")
	public void method09(@RequestParam("password") String pw, @RequestParam("number") int num) {
		System.out.println(pw); // 1q2w3e 
		System.out.println(num); // 10000
	}
	
	// /ex04/sub10?name=trump
	@RequestMapping("sub10")
	public void method10(@RequestParam(value="name", required = false) String name) {
		System.out.println(name);
		// required 를 false로 넣어주면 값이 없어도 메소드가 실행하지 않는것이 아닌 null이 나온다
	}
	
	// 배열값
	// /ex04/sub11?food=apple&food=banana&food=milk
	@RequestMapping("sub11")
	public void method11(HttpServletRequest request) {
		String[] foods = request.getParameterValues("food");
		System.out.println(Arrays.toString(foods));
	}
	
	//ex04/sub12?food=apple&food=banana&food=milk
	@RequestMapping("sub12")
	public void method12(@RequestParam("food") String[] foods) {
		System.out.println(Arrays.toString(foods));
	}
	
	//ex04/sub13?food=apple&food=banana&food=milk
	@RequestMapping("sub13")
	public void method13(String[] food) {
		System.out.println(Arrays.toString(food));
	}
	
	//ex04/sub14?food=apple&food=banana&food=milk
	@RequestMapping("sub14") 
	public void method14(@RequestParam("food") ArrayList<String> food) {
		System.out.println(food);
		// arraylist는 생략 어려움
	}
	
	
	
	
	
	
	
	
	
}


















