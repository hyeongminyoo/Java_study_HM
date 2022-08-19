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
	<h3>Board List</h3>
	<table class="table" border = "1">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
				<th>작성 날짜</th>
				<th>조회 수</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${requestScope.list}" var="dto">
			<tr>
					<td>${pageScope.dto.postNum}</td>
					<td><a href = "./detail.iu?title=${pageScope.dto.title}&userName=${pageScope.dto.userName}&postNum=${pageScope.dto.postNum}">${pageScope.dto.title}</a></td>
					<td>${pageScope.dto.userName}</td>
					<td>${pageScope.dto.postDate}</td>
					<td>${pageScope.dto.hit}</td>
			</tr>
				</c:forEach>
		</tbody>
	
	</table>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="./add.iu?username=${sessionScope.member.userName}">글 작성하기</a>
	</c:if>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>