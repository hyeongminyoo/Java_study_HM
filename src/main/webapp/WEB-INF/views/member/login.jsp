<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<form action="login.iu" method="post" id="frm">
				<div class="mb-3">
 					 <label for="exampleFormControlInput1" class="form-label">ID</label>
 					 <input type="text" class="form-control" name="userName" placeholder="ID입력" id="id1">
				</div>
				<div>
					<h5 id="val_id"></h5>
				</div>
				  <div class="mb-3">
    				<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
      				<input type="password" class="form-control" name="password" placeholder="PW입력" id="pw1">
  				</div>
				<div>
					<h5 id="val_pw"></h5>
				</div>
  				<div>
  					<button type="submit" class="btn btn-primary" id="btn">로그인</button>
  				</div>
			
			</form>
		</div>
	</section>	
	
	<c:import url="../template/footer.jsp"></c:import>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/member.js">
	</script>
	<script>
		// loginCheck();
	</script>
</body>
</html>