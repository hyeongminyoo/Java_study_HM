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
	<table border = "2">
	
		<tr>
			<th>번호</th><td>${requestScope.detail.postNum}</td>
		</tr>
		<tr>
			<th>제목</th><td>${requestScope.detail.title}</td>
		</tr>
		<tr>
			<th>작성자</th><td>${requestScope.detail.userName}</td>
		</tr>
		<tr>
			<th>작성날짜</th><td>${requestScope.detail.postDate}</td>
		</tr>
		<tr>
			<th>조회 수</th><td>${requestScope.detail.hit}</td>
		</tr>
		<tr>
			<th>내용</th><td>${requestScope.detail.contents}</td>
		</tr>
	

	</table>
	<c:if test="${sessionScope.member.userName == requestScope.detail.userName}">
	<a href = "./update.iu?title=${requestScope.detail.title}">수정하기</a>
	<a href = "./delete.iu?postNum=${requestScope.detail.postNum}">삭제하기</a>
	</c:if>
</body>
</html>