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

	<h2>도서등록결과</h2>

		<table class="table table=active test-left" border="1">
		<tr class="table-info">
			<td>항목</td>
			<td>내용</td>
		</tr>
		<tr>
			<td>도서번호</td>
			<td>${listbook.ISBN }</td>
		</tr>
		<tr>
			<td>도서명</td>
			<td>${listbook.title }</td>
		</tr>
		<tr>
			<td>저자</td>
			<td>${listbook.author }</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${listbook.price }</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td>${listbook.picture }</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>${listbook.descr }</td>
		</tr>
	</table>
	


	<a href="${root }/book/regbookform.do">추가 등록</a>
	<a href="${root }/book/listbook.do">목록 보기</a>
	

</body>
</html>