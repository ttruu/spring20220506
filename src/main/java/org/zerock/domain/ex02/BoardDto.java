package org.zerock.domain.ex02;

import java.time.LocalDateTime;

import lombok.Data;

@Data // get,set 메소드 대신
public class BoardDto {
	private int id;
	private String title;
	private String body;
	private LocalDateTime inserted;
}
