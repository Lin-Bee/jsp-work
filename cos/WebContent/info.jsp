<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="layout/header.jsp" %>
<%
	if(session.getAttribute("auth") == null){
	out.print("<script>alert('인증되지 않았습니다.');</script>");
	

	return;
}

boolean isLogin = (boolean)session.getAttribute("auth");
	if(isLogin){
		%>
		인증된사용자입니다
		<%
	}
		%>

	<h3>회원정보페이지</h3>
	
<%@ include file ="layout/footer.jsp" %>
