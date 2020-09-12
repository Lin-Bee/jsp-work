<%@page import="com.cos.blog.model.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

<%
	Post post = (Post) request.getAttribute("post");
%>
<%=post.getId() %>
<%=post.getTitle() %>
<%=post.getContent() %>

	<section>
		
		<h2>Post > list.jsp</h2>
	
	</section>
<%@ include file="../layout/footer.jsp" %>