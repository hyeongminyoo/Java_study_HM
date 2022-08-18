<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
    <h3>Add vscode </h3>
<h1>Index Page </h1>

<c:if test="${empty sessionScope.member}">
<a href="./member/login.iu">로그인</a>
<a href="./member/join.iu">가입</a>
</c:if>

<c:if test="${not empty sessionScope.member}">
<h3>${sessionScope.member.name}님 환영합니다.</h3>
<a href="./member/logout.iu">로그아웃</a>
<a href="#">마이 페이지</a>
</c:if>

<a href="./member/search.iu">찾기</a>
<a href="./bankbook/list.iu">book목록</a>

</body>
</html>
