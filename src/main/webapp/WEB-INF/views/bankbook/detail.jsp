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
			<h1>Detail Page</h1>
			<table border="1" class="table">
	
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
		
			<div class="form-floating">
				<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 200px"></textarea>
				<label for="floatingTextarea2">${detail.bookContents}</label>
			</div>
	

			<!-- 절대경로 -->

			<a href="./list.iu">리스트보기</a>
			<a href="./update.iu?bookNum=${requestScope.detail.bookNum}">수정</a>
			<a href="./delete.iu?bookNum=${requestScope.detail.bookNum}">삭제</a>
			
			<c:if test="${not empty sessionScope.member}">
			<a href="../bankAccount/add.iu?bookNum=${requestScope.detail.bookNum}">상품 가입하기</a>
			</c:if>
	
			<!--------COMMENT---------->
			<div class="row">
				<div class="mb-3">
					<label for="writer" class="form-label">Username</label>
					<input type="text" class="form-control" id="writer">
				  </div>
				  <div class="mb-3">
					<label for="contents" class="form-label">Contents</label>
					<textarea class="form-control" id="contents" rows="3"></textarea>
				  </div>
				  <div class="mb-3">
					<button type="button" id="commentAdd" data-bookNum="${detail.bookNum}">댓글 작성</button>

				  </div>
			</div>
			<div id="commentList">
				
			</div>
			<!--------COMMENT---------->

		</div>
	</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>

<script src="/resources/js/bankbookComment.js"></script>
</body>
</html>