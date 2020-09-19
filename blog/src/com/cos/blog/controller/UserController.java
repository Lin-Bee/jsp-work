package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.config.action.UserJoinProcAction;
import com.cos.blog.config.action.UserLoginFormAction;
import com.cos.blog.config.action.UserLoginProcAction;
import com.cos.blog.config.action.UserLogoutProcAction;

//http://localhost:8080/blog/            .do
//모든 .do요청은 FrontController를 탄다
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();

	}

	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/user요청됨");
		String cmd = request.getParameter("cmd");
		System.out.println("cmd :" + cmd);
		
		Action action=route(cmd);
		if(action !=null) action.excute(request, response);
	}

	private Action route(String cmd) {
		if (cmd.equals("joinForm")) {
			// 회원가입이면 회원가입페이지 redirect
			//response.sendRedirect("/user/joinForm.jsp");

		} else if (cmd.equals("loginForm")) {
			// 로그인페이지도 redirect
			
			return new UserLoginFormAction();

		} else if (cmd.equals("updateForm")) {
			// 회원수정페이지 model > Dispatcher

		} else if (cmd.equals("joinProc")) {
			return new UserJoinProcAction();

		} else if (cmd.equals("loginProc")) {
			return new UserLoginProcAction();

		} else if (cmd.equals("updateProc")) {
			// 1.로그인 진행(select)Model로 이동
			// 2.index페이지로 이동 redirect

		} else if (cmd.equals("logout")) {
			return new UserLogoutProcAction();

		} else if (cmd.equals("detail")) {
			// 로그인페이지도 dispatcher
		}
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

}
