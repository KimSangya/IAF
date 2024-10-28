<%@page import="myhome.domain.MemberDao"%>
<%@page import="myhome.domain.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<t:commonLayout title = "delete" tab = "mypage">
	<jsp:body>
		
		<c:choose>
			<c:when test="${result}">
				<h2 class="display-5">회원 삭제를 완료하였습니다.</h2>
				<a class = "btn btn-outline-light" 
				href="${pageContext.request.contextPath }/view/member/join.jsp">회원가입으로</a>
			</c:when>
			
			<c:otherwise>
				<h2 class="display-5">회원 삭제를 실패하였습니다.</h2>
				<a class = "btn btn-outline-light"
				href="${pageContext.request.contextPath }/view/member/login.jsp">회원가입으로</a>
			</c:otherwise>
		</c:choose>
		
		
	</jsp:body>
</t:commonLayout>

