<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<section>
	<h2>회원가입</h2>
	<br />
	<div class="container">

		<form action="/user?cmd=joinProc" method="post">
			<div class="form-group">
				<label for="username">username</label>
				 <input type="text" class="form-control" placeholder="Enter username" name="username"/>
			</div>

			<div class="form-group">
				<label for="password">Password:</label>
				 <input type="password" class="form-control" placeholder="Enter password" name="password"/>
			</div>

			<div class="form-group">
				<label for="email">Email address:</label>
				 <input type="email" class="form-control" placeholder="Enter email" name="email"/>
			</div>

			<div class="form-group">
				<label for="address">address:</label> 
				<input type="text" class="form-control" placeholder="Enter address" name="address"/>
			</div>
			
			<!-- form 안에 있으면 자동으로 submit됨 -->
			<button type="submit" class="btn btn-primary"  >회원가입</button>
		</form>
	</div>
	<br />
</section>

<%@ include file="../layout/footer.jsp"%>