<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Jquery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<section class="container-fluid col-lg-5 mt-5">
	<h1 class="align-center">${requestScope.board} 작성</h1>
	<div class="row">
	<form action="add.iu" method="post" enctype="multipart/form-data">
		 
	<div class="mb-3">
  		<label for="writer" class="form-label">작성자</label>
  		<input type="text" class="form-control" id="writer" name="writer" placeholder="작성자 입력">
	</div>
	<div class="mb-3">
  		<label for="title" class="form-label">제목</label>
  		<input type="text" class="form-control" id="title" name="title" placeholder="제목 입력">
	</div>
	
	
	<div class="mb-3">
  		<label for="contents" class="form-label">내용</label>
  		<textarea class="form-control" id="contents" rows="3" name="contents" placeholder="내용 입력"></textarea>
	</div>
	

	<div id="addFiles">
		<button type="button" class="btn btn-danger" id="fileAdd">파일 추가</button>
	</div>

	
	
	<button class="btn btn-primary btn-lg btn-block" type="submit">Add</button>
	</form>
	</div>
	</section>         

<!-- BootStrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<c:import url="../template/footer.jsp"></c:import>
<script type="text/javascript">
	$("#contents1").summernote();
</script>
<script src="/resources/js/board_fileAdd.js"></script>
</body>
</html>