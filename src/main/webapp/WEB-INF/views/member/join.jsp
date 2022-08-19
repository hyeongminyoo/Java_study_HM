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

	<section class="container-fluid">
		<div class="row">
		<form action="join.iu" method="post">
		            <div class="col-md-6 mb-3">
		              <label for="name">이름</label>
		              <input type="text" class="form-control" id="name" name="name" placeholder="" value="" required>
		              <div class="invalid-feedback">
		                이름을 입력해주세요.
		              </div>
		            </div>
		            <div class="col-md-6 mb-3">
		              <label for="userName">ID</label>
		              <input type="text" class="form-control" id="userName "name="userName" placeholder="" value="" required>
		              <div class="invalid-feedback">
		                ID을 입력해주세요.
		              </div>
		            <div class="col-md-6 mb-3">
		              <label for="password">비밀번호</label>
		              <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
		              <div class="invalid-feedback">
		                Password를 입력해주세요.
		              </div>
		            </div>
		          </div>
		
		          <div class="mb-3">
		            <label for="email">이메일</label>
		            <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
		            <div class="invalid-feedback">
		              이메일을 입력해주세요.
		            </div>
		          </div>
		
		          <div class="mb-3">
		            <label for="phone">주소</label>
		            <input type="text" class="form-control" id="phone" name="phone" placeholder="010-1234-5678" required>
		            <div class="invalid-feedback">
		              주소를 입력해주세요.
		            </div>
		          </div>
		
		
		          <div class="row">
		            <div class="col-md-8 mb-3">
		              <label for="root">가입 경로</label>
		              <select class="custom-select d-block w-100" id="root">
		                <option value=""></option>
		                <option>검색</option>
		                <option>카페</option>
		              </select>
		              <div class="invalid-feedback">
		                가입 경로를 선택해주세요.
		              </div>
		            </div>
		            <div class="col-md-4 mb-3">
		              <label for="code">추천인 코드</label>
		              <input type="text" class="form-control" id="code" placeholder="" required>
		              <div class="invalid-feedback">
		                추천인 코드를 입력해주세요.
		              </div>
		            </div>
		          </div>
		          <hr class="mb-4">
		          <div class="custom-control custom-checkbox">
		            <input type="checkbox" class="custom-control-input" id="aggrement" required>
		            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
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