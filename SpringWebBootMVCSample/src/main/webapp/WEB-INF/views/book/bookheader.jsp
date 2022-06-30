<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img style="width: 150px;" alt="ssafy" src="${root}/resources/img/ssafy_logo.png">
<div><a href="${root }/mem/initpage.do">초기화면</a></div>
	<h1>도서관리</h1>
	<c:choose>
		<c:when test="${not empty sessionScope.id }">
			<div>${sessionScope.id }님 반갑습니다. <a href="${root }/mem/logout.do">로그아웃</a></div>
		</c:when>
		<c:when test="${empty sessionScope.id }">
			<div><a href="${root }/mem/loginform.do">로그인</a>해주세요</div>
		</c:when>
	</c:choose>
</body>
</html>