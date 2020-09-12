<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
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
<title>데이터검색</title>
</head>
<body>
	<h1>데이터 입력 페이지</h1>
		<p>자바코드로 dbns로 접속해 값넣기</p>
		
		<hr/>
		
		<%
			if(request.getParameter("id") == null){
				return;
			}
		
			int id = Integer.parseInt(request.getParameter("id"));
			
			String query = "SELECT id,pw,name FROM person WHERE id=?";
		
			Connection conn = DBConn.getInstance();
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 /*qeury에 값이 너무 길어지므로 변수 String query로 빼내기*/
			 pstmt.setInt(1,id);
			 ResultSet rs= pstmt.executeQuery(); // 수정된 행의 개수가 리터니됨
			 /*COMMIT이 담긴 Bufferd*/
			 rs.next(); // 커서한칸내리기
		%>
		<table>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
			</tr>
			<tr>
				<td><%=rs.getInt("id") %></td>
				<td><%=rs.getString("pw") %></td>
				<td><%=rs.getString("name") %></td>
			</tr>
		</table>
</body>
</html>