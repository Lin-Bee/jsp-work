package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.Post;

public class PostDao {
	
	public int 삭제하기(int id) {
		String sql="DELETE FROM post WHERE id=?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 조회수증가(int id) {
		String sql="UPDATE post Set readCount = readCount+1 WHERE id=?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
public List<Post> 글목록() {
		List<Post> posts = new ArrayList<>();
			
		String sql = "SELECT *FROM post ORDER BY id DESC";
		//DESC 역순으로 불러온다 ASC 작성순으로 불러온다
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			ResultSet rs=pstmt.executeQuery();
			

			while (rs.next()) {
				Post post = new Post(
						rs.getInt("id"), 
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("readCount"),
						rs.getTimestamp("createDate"),
						rs.getInt("id")
				);			
				posts.add(post);
			}
		return posts;
		} catch (Exception e) {
			e.printStackTrace();//빨간 오류가 터짐 !!! 젠장!!!확인할 것
		}
		return null;
	}

	public int 글쓰기(Post post) {
		String sql="INSERT INTO post(title, content, readCount,userId, createDate) VALUES(?,?,?,?,now())";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3, post.getReadCount());
			pstmt.setInt(4, post.getUserId());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 수정하기(Post post) {
		String sql="UPDATE FROM post(title, content, readCount,userId, createDate)WHERE id=?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3, post.getReadCount());
			pstmt.setInt(4, post.getUserId());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Post 글내용(int id) {
		String sql = "SELECT * FROM post WHERE id=? ";
		
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if (rs.next()) {
				Post post = new Post(
						rs.getInt("id"), 
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("readCount"),
						rs.getTimestamp("createDate"),
						rs.getInt("userId")
				);			
				return post;
			}					
		} catch (Exception e) {
			e.printStackTrace();
			}
		return null;
	}
	
	
}
