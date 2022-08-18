<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	<table border="1">
	
	<thead>
		<tr>
			<th>Number</th><th>Name</th><th>Rate</th><th>Sale</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.detail.bookNum}</td>
			<td>${requestScope.detail.bookName}</td>
			<td>${requestScope.detail.bookRate}</td>
			<td>${requestScope.detail.bookSale}</td>
		</tr>
	</tbody>
	
	</table>
	
	
	<!-- 상대경로 -->
	<a href="../member/login.iu">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join.iu">Join</a>
	<a href="./list.iu">리스트보기</a>
	<a href="./update.iu?bookNum=${requestScope.detail.bookNum}">수정</a>
	<a href="./delete.iu?bookNum=${requestScope.detail.bookNum}">삭제</a>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="../bankAccount/add.iu?bookNum=${requestScope.detail.bookNum}">상품 가입하기</a>
	</c:if>
</body>
</html>