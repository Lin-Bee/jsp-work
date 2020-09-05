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
<title>데이터수정</title>
</head>
<body>
	<h1>데이터 입력 페이지</h1>
		<p>자바코드로 dbns로 접속해 값넣기</p>
		
		<hr/>
		
		<%
			if(request.getParameter("pw") == null || request.getParameter("name")== null || request.getParameter("id")== null){
				return;
			}
		
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			int id=Integer.parseInt(request.getParameter("id"));
			
			String query = "UPDATE person SET pw = ?, name = ? 	WHERE id=? ";
		
			Connection conn = DBConn.getInstance();
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 /*qeury에 값이 너무 길어지므로 변수 String query로 빼내기*/
			 pstmt.setString(1,pw);
			 pstmt.setString(2,name);
			 pstmt.setInt(3,id);
			 
			 int result = pstmt.executeUpdate(); // 수정된 행의 개수가 리터니됨
			 /*COMMIT이 담긴 Bufferd*/
		%>
		수정된 행의 갯수 : <%= result %>
</body>
</html>