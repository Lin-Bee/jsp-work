package com.cos.blog.config.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;

public class PostUpdateProcAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) return;
			
		//공백확인
	
		//값 검증	
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		title = title.replace("<","&lt;");
		title = title.replace(">","&rt;");
		String content = request.getParameter("content");
				
		Post post =Post.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();		
			
		PostDao postDao = PostDao.getIntance();
		postDao.수정하기(post);
		
		System.out.println("수정온료");
		
		response.sendRedirect("index.jsp");
		
		
	}
	
}
