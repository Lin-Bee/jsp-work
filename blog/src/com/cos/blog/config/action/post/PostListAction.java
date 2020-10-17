package com.cos.blog.config.action.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostListAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int page = 0;
		
		if(request.getParameter("page")==null) {
			page=0;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PostDao postDao = PostDao.getIntance();
		List<Post> posts = postDao.글목록(page);
		
		//전체페이지 SELECT count(*)FROM post;
		int count = postDao.글개수();
		//int lastPage = 0;
		
		//request.setAttribute("lastpage", lastpage);
		request.setAttribute("posts", posts);
		//현재가 last라면 disabled가 붙도록 설정
		
		request.setAttribute("posts", posts);
		//자바 유틸.post
		RequestDispatcher dis = request.getRequestDispatcher("/post/list.jsp");
		dis.forward(request, response);
	}

}
