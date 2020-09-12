<%@page import="cos.cos3.model.Person"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
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
<title>데이터전체검색</title>
</head>
<body>
	<h1>데이터 입력 페이지</h1>
		<p>자바코드로 dbns로 접속해 값넣기</p>
		
		<hr/>
		
		<%

			// http://localhost:8080/cos3.selectAll.jsp
			String query = "SELECT id,pw,name FROM person";
		
			Connection conn = DBConn.getInstance();
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 /*qeury에 값이 너무 길어지므로 변수 String query로 빼내기*/

			 ResultSet rs= pstmt.executeQuery(); // 수정된 행의 개수가 리터니됨
			 
			 ArrayList<Person> persons = new ArrayList<>();
			 while(rs.next()){ // maybe 5건이므로 6번 돌거임
					 Person person = new Person(
							 rs.getInt("id"),
							 rs.getString("pw"),
							 rs.getString("name")
							 );
			 		persons.add(person);
			 }
			// 커서한칸내리기rs.next
			for(Person person:persons){
				System.out.println("아이디" + person.getId());
				System.out.println("비번" + person.getPw());
				System.out.println("이름" + person.getName());
				System.out.println("===============");
			}
		%>
		<table border=1>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
			</tr>
			<% for (Person person:persons){%>
			<tr>
				<td><%=person.getId()%></td>
				<td><%=person.getPw() %></td>
				<td><%=person.getName() %></td>
			</tr>
			 <%}%>
		</table>
</body>
</html>