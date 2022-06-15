<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css"
	integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	referrerpolicy="no-referrer"></script>

<title>Insert title here</title>
</head>
<body>

	<h1>${board.id }번게시물 보기</h1>

	<%-- <c:url value="/ex15/board/modify" var="modifyLink"/> --%>

	<form action="${appRoot }/ex15/board/modify" method="post">
		<input type="hidden" name="id" value="${board.id }" />

		제목 :
		<input type="text" value="${board.title }" name="title" />
		<br />

		본문 :
		<textarea rows="10" cols="30" name="body">${board.body }</textarea>
		<br />

		작성일시 :
		<input type="datetime-local" value="${board.inserted }" readonly />
		<br />

		<button>수정</button>
	</form>

	<!-- 삭제 form -->
	<c:url value="/ex15/board/remove" var="removeLink" />
	<form action="${removeLink }" method="post">
		<input type="hidden" name="id" value="${board.id }" />
		<button>삭제</button>
	</form>


	<!-- 댓글 폼 -->
	<h1>댓글</h1>
	
	<c:url value="/ex16/reply/add" var="replyAddLink" />
	<form action="${replyAddLink }" method="post">
		<input type="hidden" name="boardId" value="${board.id }" />
		댓글 :
		<input type="text" name="content" size="50" />
		<button>쓰기</button>
	</form>

	<hr />

	<div>
		<!-- 댓글 보여주기 -->
		<c:forEach items="${replyList }" var="reply">
			<div style="border: 1px solid black; margin-bottom: 3px;">
				${reply.inserted } :

				<!-- 댓글 수정하기 -->
				<c:url value="/ex16/reply/modify" var="replyModifyLink"></c:url>
				<form action="${replyModifyLink }" method="post">
					<input type="hidden" name="id" value="${reply.id }" />
					<input type="hidden" name="boardId" value="${board.id }" />
					<input type="text" name="content" value="${reply.content }" />
					<button>수정</button>

				</form>

				<!-- 댓글 지우기 -->
				<c:url value="/ex16/reply/remove" var="replyRemoveLink" />
				<form action="${replyRemoveLink }" method="post">
					<input type="hidden" name="id" value="${reply.id }" />
					<input type="hidden" name="boardId" value="${board.id }" />
					<button>삭제</button>

				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>