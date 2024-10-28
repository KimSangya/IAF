<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:commonLayout>
	<jsp:body>
		<form id = "modify-form">
		<input type = "hidden" name = "no" value="${dto.no }">
		<div>
			<input type = "text" value="${dto.title }" name="title">
		</div>
		
		<div>
			<textarea name="content">${dto.content}</textarea>
		</div>
				
		<div>
			<button type = "button" id = "#submit-btn" >수정</button>
		</div>
		
		</form>
		
		<script>
			// TODO load()
			$(document).ready(function(){
				$("#submit-btn").click(function(){
					$.post("${pageContext.request.contextPath}/member/modify", 
							$("#modify-form").serialize(), // 서버에게 보낼 데이터(문자열, json)
							function (data){ // response 날아오면 할 일 (data 매개변수 : 서버로부터 받은 데이터)
															
								if(data['result']){
									alert("수정 완료!");
									} else {
									alert("수정 실패..");
								}
							},
							"json" // 서버에게 받은 데이터의 content 타입 (나는 json 받을거야!)
						);
					});
			});
			
			
		</script>
	</jsp:body>
</t:commonLayout>