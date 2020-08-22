<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="layout/header.jsp" %>
	<!--  form태그는 데이터를 전송하기 위한 박스  --> 
	<p>회원가입</p>
	<form action="joinProc.jsp"  method="POST">
		<input type="text" name="username" placeholder="username"/></br>
		<input type="password" name="password" placeholder="password"/></br>
		<input type="email" name="email" placeholder="email"/></br>
		<button>전송</button>
	</form>
<%@ include file ="layout/footer.jsp" %>





