package org.zerock.mapper.ex02;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;

public interface Ex02Mapper {
	// mapper에서 쿼리를 불러온다 
	// 다른곳에서도 할수있음 (22.05.11)
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerID = #{id} ")
	String selectNameById(int id);
	
	
	@Select("SELECT FirstName FROM Employees WHERE EmployeeID = #{id}")
	String selectNameByEmpId(int id);

	@Select("SELECT CustomerName AS Name, Address, City, Country "
			+ "FROM Customers WHERE CustomerId = #{id}")
	CustomerDto selectCustomerById(int id);
	// db에 있는 컬럼명과 CustomerDto에 있는 필드명이 같지 않을 수 있다 그때는 별칭을 활용해야함  

	@Select("SELECT FirstName, LastName, BirthDate FROM Employees WHERE EmployeeID = #{id}")
	EmployeeDto selectEmployeeById(int id);

	@Insert("INSERT INTO Customers (CustomerName, ContactName, City, Country, Address, PostalCode) "
			+ "VALUES (#{customerName}, #{contactName}, #{city}, #{country}, #{address}, #{postalCode} )")
	int insertCustomer(CustomerDto customer);

	@Insert("INSERT INTO Employees (LastName, FirstName, BirthDate, Photo, Notes) VALUES (#{lastName}, #{firstName}, #{birthDate}, #{photo}, #{notes} )")
	int insertEmployee(EmployeeDto employee);
}
