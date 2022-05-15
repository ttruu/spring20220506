package org.zerock.mapper.ex03;

import java.util.List;

import org.zerock.domain.ex02.BoardDto;

public interface Ex03Mapper {

	String selectCustomerNameById(int id);

	String selectEmployeeFirstNameById(int id);

	List<BoardDto> selectBoard();

	BoardDto getBoard(int id);

	int updateBoard(BoardDto board);

	int removeBoard(int id);

	int insertBoard(BoardDto board);
	// mapper가 받은 자바빈즈의 setId(id) 메소드를 사용해서 얻어온 id를 셋팅해줌
	// 근데 컨트롤러, 서비스, 매퍼의 객체가 다 같아서 컨트롤러에서 아이디를 받아오면 됨 
}
