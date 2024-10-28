<%@page import="myhome.domain.MemberDto"%>
<%@page import="myhome.domain.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>


<t:commonLayout title = "mypage" tab = "mypage">
<jsp:body>
<c:choose>
	<c:when test="${not empty currentDto}"> <!-- = currentDto != null -->
	<div class = "d-flex justify-content-center">
	<a class = "btn btn-danger justify-content-center" href="/IAFProject/view/member/delete?no=${currentDto.no}">회원탈퇴</a>
	<a class = "btn btn-warning justify-content-center" href="/IAFProject/view/member/modify?no=${currentDto.no}">회원수정</a>
	</div>
	
	<!-- TODO 이쁘게 하기 -->
	<div>
		USERNAME : ${dto.username} <br/>
		NICKNAME : ${dto.nickname} <br/>
		${dto.type == 0 ? '관리자' : '일반회원'}<br/>
		REGDATE : ${dto.regdate} <br/>
		NO : ${dto.no } <br/>
	</div>

</c:when>
<c:otherwise>
<h2>로그인을 하셔야 합니다.</h2>
</c:otherwise>
</c:choose>
</jsp:body>
</t:commonLayout>
