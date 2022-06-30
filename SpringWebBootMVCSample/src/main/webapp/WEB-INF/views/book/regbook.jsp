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
<script>
	function a(){
		let i = document.getElementById("isbn").value;
		let t = document.getElementById("title").value;
		let a = document.getElementById("author").value;
		let pr = document.getElementById("price").value;
		let pi = document.getElementById("picture").value;
		let d = document.getElementById("descr").value;
		let r = document.getElementById("reg");
		
		if(!i || !t || !a || !pr || !pi || !d){
			r.action = "${root }/book/emptyinput.do";
			r.submit();
		}else{
			r.action = "${root }/book/regbook.do";
			r.submit();
		}

	}
</script>
</head>
<body>
	
	<h2>도서등록</h2>
	<form method="post" id="reg">
		<div>도서번호<input type="text" name="ISBN" id="isbn"></div>
		<div>도서명<input type="text" name="title" id="title"></div>
		<div>저자<input type="text" name="author" id="author"></div>
		<div>가격<input type="text" name="price" id="price"></div>
		<div>이미지<input type="text" name="picture" id="picture"></div>
		<div>설명<textarea rows="5" cols="30" name="descr" id="descr"></textarea></div>
		<input type="reset" value="취소">
		<input type="button" value="등록" onclick="a()">
	</form>
	
	
	

</body>
</html>