package com.cos.blog.config.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.UserException;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserLoginProcAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		//1.회원가입 진행(insert)Model로 이동
				User user = User.builder()
					.username(request.getParameter("username"))
					.password(request.getParameter("password"))
					.build();
					
				System.out.println(user);
				UserDao userDao = UserDao.getIntance();
				//2.세션에 저장
				User userEntity = userDao.로그인(user);
				if(userEntity != null) {
				
					if(request.getParameter("remember") != null) {
						//Cookie cookie = new Cookie("remember"+userEntity.getUsername());
						//response.addCookie(cookie);
						response.setHeader("Set-Cookie", "remember="+userEntity.getUsername());
						
					}else {
						Cookie cookie = new Cookie("remember","");
						cookie.setMaxAge(0); //0초 동안만 쿠키를 가지고있는다.
						response.addCookie(cookie);
					}
					
					HttpSession session = request.getSession();
					session.setAttribute("principal", userEntity);
					System.out.println("로그인 성공");
					response.sendRedirect("/index.jsp");
				}else {
					System.out.println("로그인 실패");
					response.sendRedirect("/index.jsp");
				}
				//3.index페이지로 이동 redirect
		
	}
		
}
