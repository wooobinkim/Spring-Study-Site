<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY SpringWebMVCSample</title>
</head>
<body>
	<a href="${root}/mem/initpage.do"><img alt="ssafy_logo" src="${root}/resources/img/ssafy_logo.png" style = "width : 150px"></a>
	로그인 정보 : <span>
		<c:choose>
			<c:when test="${not empty id }">
				${id }
			</c:when>
			<c:otherwise>
				로그인이 되지 않았습니다!	
			</c:otherwise>
		</c:choose>
	</span>
</body>
</html>