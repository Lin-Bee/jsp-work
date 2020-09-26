package com.cos.blog.config.action.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class PostDetailAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) return;
			
		//공백확인
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title"+title);
		System.out.println("content"+content);
		//값 검증	
		response.sendRedirect("/post/list.jsp");
		
	}
	
}
