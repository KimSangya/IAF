<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:commonLayout>
	<jsp:body>
     	<div>
     		<c:if test="${not empty originName1}">
     		<ul>
     			<li>원본 이름 : ${originName1}</li>
     			<li>새 이름 : ${realName1}</li>
     			<li>크기 : ${fileSize1 }byte</li>
     		</ul>
     		</c:if>
     		
     		<c:if test="${not empty originName2}">
     		<ul>
     			<li>원본 이름 : ${ originName2}</li>
     			<li>새 이름 : ${realName2 }</li>
     			<li>크기 : ${fileSize2 }byte</li>
     		</ul>
     		</c:if>
     	</div>
	</jsp:body>
</t:commonLayout>