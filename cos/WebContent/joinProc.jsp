<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//3개의 값을 입력해줬는데 name을
    	//Parameter에서 불러와줌
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String email = request.getParameter("email");
    	
    	System.out.println("컨텍스트 패스 :"+request.getContextPath());
    	System.out.println("컨텐트타입 :"+request.getHeader("Content-Type"));
    	System.out.println("캐릭터 인코딩 :"+request.getCharacterEncoding());
    	System.out.println("로컬포트 :"+request.getLocalPort());
    	System.out.println("요청메서드 :"+request.getMethod());
    	System.out.println("원격주소 :"+request.getRemoteAddr());
    	System.out.println("프로토콜 :"+request.getProtocol());
    	System.out.println("쿼리스트링 :"+request.getQueryString());
    	System.out.println("로컬주소 :"+request.getLocalAddr());
   		//잘받아지면 DB에 입력받아주면됨
   		
   		session.setAttribute("auth", true);
   		response.sendRedirect("main.jsp");
    %>