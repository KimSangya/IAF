<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:commonLayout>
	<jsp:body>
		<div>
			<span>글제목 : </span>
			${dto.title}
		</div>
		
		<div>
			<span>조회수 : </span>
			${dto.hit }
		</div>
		
		<div>
			<span>작성자 : </span>
			${dto.writerNickname }
		</div>
		<div>
			<span>닉네임 : </span>
			${dto.username }
		</div>
		<div>
			<span>시간 : </span>
			${dto.regdate }
		</div>
		<div>
			<span>작성자 이메일 : </span>
			${dto.email }
		</div>
		<div>
		<span>글 내용 : </span>
		<p>${dto.content }</p>
		</div>
		
		<c:if test = "${currentDto.no == dto.writerNo }">
		<div>
			<a href = "/IAFProject/board/modify?no=${dto.no }">글수정</a>
			<a href = "/IAFProject/board/delete?no=${dto.no }">글삭제</a>
		</div>
		</c:if>
	</jsp:body>
</t:commonLayout>