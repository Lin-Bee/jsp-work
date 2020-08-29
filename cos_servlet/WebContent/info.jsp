<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="layout/header.jsp" %>
	<%
	if(session.getAttribute("auth") == null){
	out.print("<script>alert('비번틀렸다.');</script>");
	return;
}

boolean isLogin = (boolean)session.getAttribute("auth");
	if(isLogin){
		%>
		<p>로그인했음</p>
		<%
	}
		%>
<%@ include file ="layout/footer.jsp" %>