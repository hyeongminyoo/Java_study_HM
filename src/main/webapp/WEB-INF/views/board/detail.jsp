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
	<h1 class="align-center">${requestScope.board} 상세</h1>

	<table class="table">
	
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
	
	<div class="row">
		<c:forEach items="${requestScope.boardDTO.boardFileDTOs}" var="fileDTO">
			<p>
			<a href="../resources/upload/${requestScope.board}/${fileDTO.fileName}">${fileDTO.oriName}</a>
			</p>
		</c:forEach>
	</div>
	
			<div class="form-floating">
  			<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 200px"></textarea>
  			<label for="floatingTextarea2">${boardDTO.contents}</label>
			</div>
	

	<a href="./reply.iu?num=${boardDTO.num}" class="btn btn-danger">reply</a>


	<a href="./update.iu?num=${requestScope.boardDTO.num}" class="btn btn-primary">수정</a>


	<a href="./delete.iu?num=${requestScope.boardDTO.num}" class="btn btn-primary">삭제</a>

	</section>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>