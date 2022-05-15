package org.zerock.mapper.ex03;

import java.util.List;

import org.zerock.domain.ex02.ReplyDto;

public interface Ex04Mapper {

	int insertReply(ReplyDto reply);

	List<ReplyDto> selectReplyByBoardId(int boardId);

	int deleteReplyById(int id);

	int updateReply(ReplyDto reply);

	void deleteReplyByBoard(int boardId);

}
