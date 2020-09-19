package com.cos.blog.config.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserLoginProcAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.회원가입 진행(insert)Model로 이동
				User user = new User(
					request.getParameter("username"),
					request.getParameter("password")
				);
				System.out.println(user);
				UserDao userDao = new UserDao();
				//2.세션에 저장
				User userEntity = userDao.로그인(user);
				if(userEntity != null) {
					HttpSession session = request.getSession();
					session.setAttribute("principal", userEntity);
					System.out.println("로그인 성공");
					response.sendRedirect("/index.jsp");
				}
				//3.index페이지로 이동 redirect
		
	}
		
}
