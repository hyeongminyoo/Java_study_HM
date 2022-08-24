<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<section class="container-fluid col-lg-5 mt-5">
<h1 class="align-center">${requestScope.board}</h1>
<div class="row">
	<table class="table">
		<thead>
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>작성일자</th><th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${pageScope.dto.num}</td>
				<td><a href="./detail.iu?num=${pageScope.dto.num}">${pageScope.dto.title}</a></td>
				<td>${pageScope.dto.writer}</td>
				<td>${pageScope.dto.regDate}</td>
				<td>${pageScope.dto.hit}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="mb-3">
		<a href="./add.iu" class="btn btn-primary">글 작성하기</a>
	</div>
</div>
</section>	
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>