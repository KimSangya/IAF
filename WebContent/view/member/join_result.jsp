<%@page import="myhome.domain.MemberDao"%>
<%@page import="myhome.domain.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<t:commonLayout>
<jsp:body>
<c:choose>
	<c:when test="${result}">
	<h1>회원가입에 감사드립니다.</h1>
	<a class = "btn btn-outline-light" 
				href="${pageContext.request.contextPath }/view/member/login.jsp">로그인으로</a>
	</c:when>
	<c:otherwise>
	<h1>회원가입에 실패하였습니다.</h1>
	<a class = "btn btn-outline-light" 
				href="${pageContext.request.contextPath }/view/member/join.jsp">회원가입 하러가기</a>
	</c:otherwise>
</c:choose>
</jsp:body>
</t:commonLayout>
