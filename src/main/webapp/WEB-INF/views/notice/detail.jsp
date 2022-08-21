<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">


</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	<table border = "2" class="table">
	
		<tr>
			<th>번호</th><td>${requestScope.detail.num}</td>
		</tr>
		<tr>
			<th>제목</th><td>${requestScope.detail.title}</td>
		</tr>
		<tr>
			<th>작성자</th><td>${requestScope.detail.writer}</td>
		</tr>
		<tr>
			<th>작성날짜</th><td>${requestScope.detail.regDate}</td>
		</tr>
		<tr>
			<th>조회 수</th><td>${requestScope.detail.hit}</td>
		</tr>
		<tr>
			<th>내용</th><td>${requestScope.detail.contents}</td>
		</tr>
	

	</table>
	<c:if test="${sessionScope.member.userName == requestScope.detail.writer}">
	<a href = "./update.iu?title=${requestScope.detail.title}">수정하기</a>
	<a href = "./delete.iu?num=${requestScope.detail.num}">삭제하기</a>
	</c:if>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>


</body>
</html>