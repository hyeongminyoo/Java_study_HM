
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h3>Add page</h3>
	<form action="add.iu" method="POST">
		BookName <input type="text" name="bookName"><br>
		BookRate <input type="text" name="bookRate"><br>
		BookContents <textarea rows="10" cols="30" name="bookContents"></textarea>
		
		<div class="mb-3">
  		<label for="files" class="form-label">파일첨부</label>
  		<input type="file" class="form-control" id="files" name="files">
		</div>
		
		<button type="submit">Add</button>
		<input type="reset" value="초기화">	
	</form>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>

</body>
</html>