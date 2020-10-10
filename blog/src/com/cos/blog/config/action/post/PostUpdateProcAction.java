package com.cos.blog.config.action.post;

import java.io.IOException;

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
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		String title = request.getParameter("title");
		title = title.replace("<","&lt;");
		title = title.replace(">","&rt;");
		String content = request.getParameter("content");
			
		//공백확인
		Post post = new Post(title, content, 0, userId);
			
		//값 검증	
		PostDao postDao = new PostDao();
		postDao.수정하기(post);
		
		//list로 돌아가기
		response.sendRedirect("/");
		
	}
	
}
