<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:commonLayout>
	<jsp:body>
		<form 
		action="${pageContext.request.contextPath }/board/write" 
		method="post">
		
		<div>
		글 제목 : <input type = "text" name = "title">
		</div>
		
		<div>
		닉네임 : <input type = "text" name = "username">
		</div>
		
		<div>
		이메일 : <input type = "text" name = "email">
		</div>
		
		<div>
		<textarea name="content" cols="40" rows="10"></textarea>
		</div>
		
		<input type = "submit">
		</form>
	</jsp:body>
</t:commonLayout>




