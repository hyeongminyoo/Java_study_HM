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
<%-- 	<h3>My page</h3>
	<table class="table">
		<thead class="table-light">
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>E-mail 주소</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.map.dto.userName}</td>
				<td>${requestScope.map.dto.name}</td>
				<td>${requestScope.map.dto.email}</td>
				<td>${requestScope.map.dto.phone}</td>
			</tr>
		</tbody>
	</table>
	<h3>가입 상품 목록</h3>
	<table class="table">
		<thead class="table-light">
			<tr>
				<th>번호</th><th>상품명</th><th>생성 일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.map.list}" var="dto">
			<tr>
				<td>${pageScope.dto.accountNum}</td>
				<td>${pageScope.dto.bankBookDTO.bookName}</td>
				<td>${pageScope.dto.accountDate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table> 
	--%>
		<h3>My page</h3>
	<table class="table">
		<thead class="table-light">
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>E-mail 주소</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.dto.userName}</td>
				<td>${requestScope.dto.name}</td>
				<td>${requestScope.dto.email}</td>
				<td>${requestScope.dto.phone}</td>
			</tr>
		</tbody>
	</table>
	<h3>가입 상품 목록</h3>
	<table class="table">
		<thead class="table-light">
			<tr>
				<th>번호</th><th>상품명</th><th>생성 일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.dto.bankAccountDTOs}" var="dto">
			<tr>
				<td>${pageScope.dto.accountNum}</td>
				<td>${pageScope.dto.bankBookDTO.bookName}</td>
				<td>${pageScope.dto.accountDate}</td>
			</tr>
			</c:forEach>
		</tbody> 
	</table>
	
	</div>
	</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>