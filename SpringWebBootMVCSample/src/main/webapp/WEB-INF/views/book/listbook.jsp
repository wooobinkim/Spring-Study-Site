<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList,edu.ssafy.ws.dto.BookDTO"%>
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
	<h2>도서목록</h2>
	<table class="table table=active test-left" border="1">
		<tr class="table-info">
			<td>번호</td>
			<td>ISBN</td>
			<td>제목</td>
			<td>저자</td>
			<td>가격</td>
		</tr>

		<c:forEach items="${listbook }" var="book">
			<c:set var="i" value="${i+1}" />
			<tr>
				<td>${i }</td>
				<td>${book.ISBN }</td>
				<td>${book.title }</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
			</tr>
		</c:forEach>
	</table>


	<a href="${root }/book/regbookform.do">도서 등록</a>


</body>
</html>