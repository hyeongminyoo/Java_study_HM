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
	<h3>BankBookUpdate Page</h3>
	<form action="update.iu" method = "POST">
	<div>
		<input type="text" name = "bookNum" readonly value="${requestScope.update.bookNum}">
	</div>
	<div>
		Name : <input type="text" name="bookName" value="${requestScope.update.bookName}" >
	</div>
	<div>
		Rate : <input type="text" name="bookRate" value="${requestScope.update.bookRate}">
	</div>
	<div>
		<input type="text" name="bookSale" readonly value="${requestScope.update.bookSale}" >
	</div>
	<div>
		<textarea rows="30" cols="30" name="bookContents">${requestScope.update.bookContents}</textarea>
	</div>
		<button type="submit">수정</button>
		<input type="submit" value="수정">
	</form>
	
</body>
</html>