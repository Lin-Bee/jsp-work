<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="layout/header.jsp" %>
	<p>로그인</p>
	<form action="loginProc.jsp" method="post">
		<input type="text" name="username" placeholder="Username"/></br>
		<input type="password" name="password" placeholder="Password"/></br>
		<button>로그인</button>
	</form>
<%@ include file ="layout/footer.jsp" %>