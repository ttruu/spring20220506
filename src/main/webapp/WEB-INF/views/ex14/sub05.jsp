<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>

<title>Insert title here</title>
</head>
<body>
	<h1>${message }</h1>
	<h1>새 고객 입력</h1>
	<form action="${pageContext.request.contextPath }/ex14/sub05" method="post">
		고객명 : <input type="text" name="customerName" value="Son H.M." /> <br />
		계약명 : <input type="text" name="contactName" value="Striker" /> <br />
		주소 : <input type="text" name="address" value="seoul gangnam" /> <br /> 
		도시 : <input type="text" name="city" value="London" /> <br />
		나라 : <input type="text" name="country" value="UK" /> <br />
		우편번호 : <input type="text" name="postalCode" value="12345" /> <br />
		<button>등록</button>
	</form>
</body>
</html>