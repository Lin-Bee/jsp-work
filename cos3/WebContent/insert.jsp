<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.sun.corba.se.impl.orb.PrefixParserAction"%>
<%@page import="com.cos3.config.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터입력</title>
</head>
<body>
	<h1>데이터 입력 페이지</h1>
		<p>자바코드로 dbns로 접속해 값넣기</p>
		
		<hr/>
		
		<%
			if(request.getParameter("password") == null || request.getParameter("name")== null){
				return;
			}
		
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			
			String query = "INSERT INTO person(pw,name) VALUES(?,?)";
		
			Connection conn = DBConn.getInstance();
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 /*qeury에 값이 너무 길어지므로 변수 String query로 빼내기*/
			 pstmt.setString(1,password);
			 pstmt.setString(2,name);
			 int result = pstmt.executeUpdate(); // 수정된 행의 개수가 리터니됨
			 /*COMMIT이 담긴 Bufferd*/
		%>
		수정된 행의 갯수 : <%= result %>
</body>
</html>