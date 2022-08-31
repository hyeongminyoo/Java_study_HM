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
		<form action="join.iu" method="post" enctype="multipart/form-data" id="membersJoinForm">
					
					<div class="col-md-6 mb-3">	       
					<label for="userNameInput">ID</label>
					<input type="text" class="form-control" id="userNameInput" name="userName" placeholder="" value="" >
					<div class="invalid-feedback">
					</div>
					</div>
						<div id="userNameInputResult">
						</div>
						
		            <div class="col-md-6 mb-3">
		              <label for="nameInput">이름</label>
		              <input type="text" class="form-control" id="nameInput" name="name" placeholder="" value="" >
		              <div class="invalid-feedback">
					</div>
		            </div>
		                <div id="nameInputResult">
						</div>
		            

		            <div class="col-md-6 mb-3">
		              <label for="passwordInput">비밀번호</label>
		              <input type="password" class="form-control" id="passwordInput" name="password" placeholder="" value="" >
		              <div class="invalid-feedback">
		              </div>
		              </div>
					  <div id="passwordInputResult">
					  </div>
		              <div class="col-md-6 mb-3">
		              <label for="passwordCheckInput">비밀번호 확인</label>
		              <input type="password" class="form-control" id="passwordCheckInput" name="password" placeholder="" value="" >
		              <div class="invalid-feedback"> 
		              </div>
					  </div>
					  <div id="passwordCheckInputResult">
					  </div>
		
		          <div class="mb-3">
		            <label for="emailInput">이메일</label>
		            <input type="email" class="form-control" id="emailInput" required name="email" placeholder="you@example.com" >
		            <div class="invalid-feedback">
		            </div>
		          </div>
				  <div id="emailInputResult">
				  </div>
		
		          <div class="mb-3">
		            <label for="phoneInput">Phone</label>
		            <input type="text" class="form-control" id="phoneInput" name="phone" placeholder="010-1234-5678" >
		            <div class="invalid-feedback">
		            </div>
		          </div>
				  <div id="phoneInputResult">
				  </div>
				
				 <div class="mb-3">
		            <label for="files">Photo</label>
		            <input type="file" class="form-control" id="files" name="photo" >
		            <div class="invalid-feedback">
		             
		            </div>
		          </div>
		
		       
		          <div class="mb-4"></div>
		          <button class="btn btn-primary btn-lg btn-block" id="membersJoinSubmit">가입</button>
          </form>
		</div>
	</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<c:import url="../template/footer.jsp"></c:import>
<script src="/resources/js/member.js"></script>
<script>
	joinCheck();
</script>
</body>
</html>