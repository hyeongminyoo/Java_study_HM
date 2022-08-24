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
	<section class="container-fluid col-lg-5 mt-5">
	<div class="row">
	<h1 class="align-center">${requestScope.board} 상세</h1>
	<table border="1" class="table">
	
	<thead>
		<tr>
			<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.boardDTO.num}</td>
			<td>${requestScope.boardDTO.title}</td>
			<td>${requestScope.boardDTO.writer}</td>
			<td>${requestScope.boardDTO.hit}</td>
			
		</tr>
	</tbody>
	
	</table>
	<section class="container-fluid col-lg-5 mt-5">
	<div class="card" style="width: 18rem;">
  	<div class="card-body">
    <h5 class="card-title">Contents</h5>
    <h6 class="card-subtitle mb-2">내용</h6>
    <p class="card-text">${requestScope.boardDTO.contents}</p>
  	</div>
	</div>
	</section>
	
	<div class="mb-3">
	<a href="./update.iu?num=${requestScope.boardDTO.num}" class="btn btn-primary">수정</a>
	</div>
	<div class="mb-3">
	<a href="./delete.iu?num=${requestScope.boardDTO.num}" class="btn btn-primary">삭제</a>
	</div>
	</div>
	</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>