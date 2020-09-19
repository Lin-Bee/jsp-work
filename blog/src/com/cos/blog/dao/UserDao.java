package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.User;

public class UserDao {
	
	public User 로그인(User user) {
		//패스워드 세션에 저장하면 불법임 패스워드는 저장하지 않는다
		String sql="SELECT id,username,email,address FROM users WHERE username = ? AND password=?";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				User userEntity = new User(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("email"),
					rs.getString("address")
				);
				return userEntity;
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int 회원가입(User user) {
		String sql="INSERT INTO users(username, password, email, address, createDate) VALUES(?,?,?,?,now())";
		Connection conn= DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}