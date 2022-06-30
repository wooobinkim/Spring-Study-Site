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
	<ul>
		<li><a href="${root }/book/regbookform.do">도서 등록</a></li>
		<li><a href="${root }/book/listbook.do">도서 목록</a></li>
	</ul>
	
	
	

</body>
</html>