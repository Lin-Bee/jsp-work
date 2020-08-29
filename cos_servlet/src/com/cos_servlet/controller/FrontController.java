package com.cos_servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class FrontController extends HttpServlet {
	
	// data줘(select) -> 어떤데이터? (쿼리스트링 : ?키 =값&키 = 값)
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String uri = req.getRequestURI();
			if(uri.equals("/main.do")){
					resp.sendRedirect("main.jsp");
					System.out.println("메인이다");
				}else if(uri.equals("join.do")){
					/*아디 비번 입력 하고 저장되어라*/
					String username = req.getParameter("username");
			    	String password = req.getParameter("password");
			    	String email = req.getParameter("email");
					
			   		resp.sendRedirect("main.jsp");
			   		
				}else if(uri.equals("/info.do")){
					resp.sendRedirect("info.jsp");
				
				}else if(uri.equals("/join.do")){
						resp.sendRedirect("join.jsp");
					
				}else if(uri.equals("/login.do")){
					//로그인 가능한 아이디와 패스워드
					resp.sendRedirect("login.jsp");
				
				}
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String uri = req.getRequestURI();
			if(uri.equals("/loginProc.do")){
				
			}
		}

		
	}
	
	

