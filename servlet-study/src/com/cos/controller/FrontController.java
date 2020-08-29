package com.cos.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	// data줘(select) -> 어떤데이터? (쿼리스트링 : ?키 =값&키 = 값)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 요청");
		String uri = req.getRequestURI();
		System.out.println(uri);
		if(uri.equals("/user.do")) {
			System.out.println("/user 접근");
			resp.sendRedirect("user.jsp");
		}else if(uri.equals("/profile.do")) {
			System.out.println("/profile 접근");
			resp.sendRedirect("profile.jsp");
		}else if(uri.equals("/")) {
			System.out.println("/index 접근");
			resp.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("doPost()");
	}
}
