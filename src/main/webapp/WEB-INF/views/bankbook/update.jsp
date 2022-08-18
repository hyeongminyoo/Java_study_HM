<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<button type="submit">수정</button>
		<input type="submit" value="수정">
	</form>
	
</body>
</html>