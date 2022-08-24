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
	<h1 class="align-center">${requestScope.board} 작성</h1>
		<div class="row">
		<form action="join.iu" method="post">
		            <div class="col-md-6 mb-3">
		              <label for="writer">작성자</label>
		              <input type="text" class="form-control" id="writer" name="writer" placeholder="" value="" required>
		              <div class="invalid-feedback">
		                작성자를 입력해주세요.
		              </div>
		            </div>
		            <div class="col-md-6 mb-3">
		              <label for="title">제목</label>
		              <input type="text" class="form-control" id="title "name="title" placeholder="" value="" required>
		              <div class="invalid-feedback">
		                제목을 입력해주세요.
		              </div>
		            <div class="col-md-6 mb-3">
		              <label for="contents">내용</label>
		              <input type="text" class="form-control" id="contents" name="contents" placeholder="" value="" required>
		              <div class="invalid-feedback">
		                내용를 입력해주세요.
		              </div>
		            </div>
		          </div>
		
		          <div class="mb-4"></div>
		          <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
          </form>
		</div>
	</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<c:import url="../template/footer.jsp"></c:import>
</body>
</html>