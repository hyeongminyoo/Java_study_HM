<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add.iu" method="POST">
		작성자 ID <input type="text" name="userName" readonly value="${sessionScope.member.userName}"><br>
		제목 <input type="text" name = "title"><br>
		<h5>내용</h5>
		<textarea rows="30" cols="100" name="contents"></textarea>
		<button type="submit">작성완료</button>
	</form>
</body>
</html>