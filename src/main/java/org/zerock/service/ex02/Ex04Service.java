package org.zerock.service.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.mapper.ex02.Ex02Mapper;

@Service
public class Ex04Service {
	@Autowired
	private Ex02Mapper mapper;
	
	public String getNameById(int id) {
		String name = mapper.selectNameById(id);
		return name;
	}
	
	
	public String getNameByEmpId(int id) {
		String empName = mapper.selectNameByEmpId(id);
		return empName;
	}

	
	public CustomerDto getCustomerInfoById(int id) {
		return mapper.selectCustomerById(id);
	}

	
	public EmployeeDto getEmployeeInfoById(int id) {
		return mapper.selectEmployeeById(id);
	}

	
	public boolean addCustomer(CustomerDto customer) {
		int count = mapper.insertCustomer(customer);
		return count == 1;
		// executeupdate는 type이 int
		// int executeUpdate() 는 DML의 줄(row)을 반환하는 것
		// 이 코드에서 원하는건 한줄만 반환하는것을 원했기 때문에 count == 1 일때 등록되도록 했다 
	}
	

	public boolean addEmployee(EmployeeDto employee) {
		int count = mapper.insertEmployee(employee);
		return count == 1;
	}
}
