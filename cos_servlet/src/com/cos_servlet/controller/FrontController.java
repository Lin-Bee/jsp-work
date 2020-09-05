package com.cos_servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class FrontController extends HttpServlet {

	// data줘(select) -> 어떤데이터? (쿼리스트링 : ?키 =값&키 = 값)
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String uri = req.getRequestURI();
			HttpSession session = req.getSession();
			
			resp.setContentType("text/html; charset=utf-8");			
			
			if(uri.equals("/main.do")){
					resp.sendRedirect("main.jsp");
					System.out.println("메인이다");
				}else if(uri.equals("/join.do")){	
					
			   		resp.sendRedirect("join.jsp");
				}else if(uri.equals("/logout.do")){
					session.invalidate();
					resp.sendRedirect("main.jsp");					
				}else if(uri.equals("/login.do")){
					
					//로그인 가능한 아이디와 패스워드
					resp.sendRedirect("login.jsp");				
				}else if(uri.equals("/info.do")){
					if(session.getAttribute("auth") == null){
						PrintWriter out = resp.getWriter();
						out.print("<script>alert('로그인하세요.');</script>");
						return;
					}
					else{
						resp.sendRedirect("info.jsp");
					}
				}
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html; charset=utf-8");			
		
		if (uri.equals("/loginProc.do")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			if (username.equals("test") && password.equals("1234")) {
				session.setAttribute("auth", true);
				PrintWriter out = resp.getWriter();
				resp.sendRedirect("main.jsp");
			}else {
				PrintWriter out = resp.getWriter();
				out.print("<script>alert('로그인 실패');</script>");
				out.print("history.back();");
			}
		}

		else if (uri.equals("/joinProc.do")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");

			session.setAttribute("auth", true);
			resp.sendRedirect("main.jsp");
		}
	}

}
