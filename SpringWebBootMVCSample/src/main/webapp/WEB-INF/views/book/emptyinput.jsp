<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <c:set var="root" value="${pageContext.request.contextPath }"></c:set>
     <%@ include file="bookheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책관리</title>
</head>
<body>
	
	<h2>파라미터가 잘 전달되었는지 확인하세요</h2>
	<a href="${root }/book/regbookform.do">도서 등록</a>
	<a href="${root }/book/listbook.do">도서 목록</a>
	

</body>
</html>