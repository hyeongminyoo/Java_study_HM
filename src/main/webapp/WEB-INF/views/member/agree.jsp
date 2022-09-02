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
	<h1>약관동의 페이지</h1>
<form action="./join.iu" method="get" id="frm2">
<div class="row">
    <h5>전체동의</h5>
    <input type="checkbox" name="" id="all">
    동의1(필수)<input type="checkbox" name="" id="" class="req cb">
    동의2(필수)<input type="checkbox" name="" id="" class="req cb">
    동의3(선택)<input type="checkbox" name="" id="" class="cb">
    동의4(선택)<input type="checkbox" name="" id="" class="cb">
</div>

<button class="btn btn-primary btn-lg btn-block" id="btn2" type="button">가입</button>
</form>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<c:import url="../template/footer.jsp"></c:import>
<script src="/resources/js/member.js"></script>
<script>
    agreeCheck();
</script>

</body>
</html>