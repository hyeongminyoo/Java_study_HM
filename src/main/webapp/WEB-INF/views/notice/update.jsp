<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
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
	
	<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

	
</body>
</html>