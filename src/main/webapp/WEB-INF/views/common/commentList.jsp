<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-dark table-hover">
  <c:forEach items="${ar}" var="commentDTO">
  	<tr>
  		<td>${commentDTO.writer}</td>
  		<td>${commentDTO.contents}</td>
  		<td>${commentDTO.regDate}</td>
  	</tr>
  </c:forEach>
</table>

