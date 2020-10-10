package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.User;

@Controller
public class HomeController {
	//http://localhost:8080/home
	@GetMapping("/home")
	public String home(String name,String addr) {
		//파일의 경로를 정어주면됨 template 안에 home 인데 기본적으로 template 내부를 찾아가고
		//엔진을 mustache를 사용하고 가능 
		System.out.println(name);
		System.out.println(addr);
		return "home";
	}
	
	//[GET] http://localhost:8080/post
	@GetMapping("/post")
	public String post() {
		//파일의 경로를 정어주면됨 template 안에 home 인데 기본적으로 template 내부를 찾아가고
		//엔진을 mustache를 사용하고 가능 
		return "post";
	}
	
	//[get]http://localhost:880/user
	@GetMapping("/user")
	public String user(User user, Model model) {
		//파일의 경로를 정어주면됨 template 안에 home 인데 기본적으로 template 내부를 찾아가고
		//엔진을 mustache를 사용하고 가능 
		System.out.println(user.getName());
		System.out.println(user.getAddr());
		model.addAttribute("user", user);
		// 이게 request attribute와 같음!
		return "user";
	}
	
}
