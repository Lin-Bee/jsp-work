<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="layout/header.jsp" %>

	<form action="loginProc.do" method="POST">
		<p>로그인</p>
		<table>
			<tr>
				<th>아이디</th> <td><input type="text"/></td>
			</tr>
			<tr>
				<th>비밀번호</th> <td><input type="text"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" title="회원가입"/></td>
			</tr>
		</table>
	</form>

<%@ include file ="layout/footer.jsp" %>