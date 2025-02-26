<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:commonLayout>
	<jsp:body>
		<div class="display-5">
			<c:choose>
				<c:when test="${ status eq 'write'}">
					글쓰기에 ${result ? '성공' : '실패' }했습니다.
				</c:when>
				<c:when test="${ status eq 'modify'}">
					글수정에 ${result ? '성공' : '실패' }했습니다.
				</c:when>
				<c:when test="${ status eq 'delete'}">
					글삭제에 ${result ? '성공' : '실패' }했습니다.
				</c:when>
			</c:choose>
		 	
		</div>
		<a class = "btn btn-outline-light"
		 	href="${pageContext.request.contextPath }/board/list">목록으로</a>
	</jsp:body>
</t:commonLayout>





