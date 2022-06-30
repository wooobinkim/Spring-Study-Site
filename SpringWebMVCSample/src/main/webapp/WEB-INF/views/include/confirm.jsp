<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:if test="${!empty id}">
	<div class="m-3 text-right">
		<strong>${id.name}</strong> (${id.Id})님 안녕하세요.
		<a href="${root}/logout.do">로그아웃</a><br />
	</div>
	</c:if>
