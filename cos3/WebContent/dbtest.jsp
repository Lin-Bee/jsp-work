<%@page import="java.sql.Connection"%>
<%@page import="com.cos3.config.DBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP 연습</title>
</head>
<body>
	<h1>테스트페이지 입니다.</h1>
	<HR/>
	<%
		Connection conn = DBConn.getInstance();
	%>
</body>
</html>