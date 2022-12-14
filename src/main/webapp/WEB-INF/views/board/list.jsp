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
<section class="container-fluid col-lg-5 mt-5">
<h1 class="align-center">${requestScope.board}</h1>
	<div class="row">
		<form action="./list.iu?" class="row row-cols-lg-auto g-3 align-items-center">
		
		  <div class="col-12">
		    <label class="visually-hidden" for="kind">Preference</label>
		    <select name="kind" class="form-select" id="kind">
		      <option class="kinds" value="contents">내용</option>
		      <option class="kinds" value="title">제목</option>
		      <option class="kinds" value="writer">작성자</option>
		    </select>
		  </div>
		
		  <div class="col-12">
		    <label class="visually-hidden" for="search">검색어 입력</label>
		    <div class="input-group">
		      <input type="text" name="search" value="${param.search}" class="form-control" id="search" placeholder="검색어 입력">
		    </div>
		  </div>
	
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">Submit</button>
		  </div>
		</form>
	</div>

	<div class="row">
	<table class="table">
		<thead>
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>작성일자</th><th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${pageScope.dto.num}</td>
				<td>
				<%-- for(int i = begin; i<= end; i++ --%>
				<c:catch>
				<c:forEach begin="1" end="${dto.depth}">&ensp;</c:forEach>
				</c:catch>
				<a href="./detail.iu?num=${pageScope.dto.num}">${pageScope.dto.title}</a>
				</td>
				<td>${pageScope.dto.writer}</td>
				<td>${pageScope.dto.regDate}</td>
				<td>${pageScope.dto.hit}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="mb-3">
		<a href="./add.iu" class="btn btn-primary">Add</a>
	</div>
	
	<nav aria-label="Page navigation example">
  		<ul class="pagination">
    	<c:if test="${pager.pre}">
    	<li class="page-item">
      		<a class="page-link" href="./list.iu?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
        		<span aria-hidden="true">&laquo;</span>
      		</a>
    	</li>
    	</c:if>
   		 <c:forEach	begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    		<li class="page-item"><a class="page-link" href="./list.iu?page=${i}">${i}</a></li>
    	</c:forEach>
    	
<%--     	<c:choose>
    		<c:when test="${pager.next}">
    			<li class="page-item">
    		</c:when>
    		<c:otherwise>
    			<li class="page-item disabled">
    		</c:otherwise>
    	</c:choose> --%>
    	<li class="page-item ${pager.next?'':'disabled'}">
     		 <a class="page-link" href="./list.iu?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
       			 <span aria-hidden="true">&raquo;</span>
      		</a>
    	</li>
  		</ul>
	</nav>
	</div>
</section>	
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/board.js"></script>
<script>
const kinds = document.getElementsByClassName("kinds");	
let k = '${param.kind}'; //title, contents, writer

	for(let i = 0; i<kinds.length ; i++){
		if(kinds[i].value == k){
			kinds[i].selected = true;
			break;
		}
	}

</script>
</body>
</html>