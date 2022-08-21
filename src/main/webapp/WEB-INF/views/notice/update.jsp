<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Update Page</h3>
	<form action="update.iu" method="POST">
		번호 : <input type="text" name="num" readonly value="${requestScope.update.num}"><br>
		작성자 : <input type="text" name="writer" readonly value="${requestScope.update.writer}"><br>
		작성날짜 : <input type="text" name="regDate" readonly value="${requestScope.update.regDate}"><br>
		제목 : <input type="text" name="title" value="${requestScope.update.title}"><br>
		<h5>내용</h5>
		<textarea rows="30" cols="100" name="contents">${requestScope.update.contents}</textarea>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>