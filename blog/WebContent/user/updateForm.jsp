<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>

	<section>
		<h2>user > update.jsp</h2>
		<br/>
		<div class="container">
	
			<form action="/user?cmd=updateProc" method="post">
				
				<input type="hidden" value="${sessionScope.principal.id}"  name="id" />
				
				<div class="form-group">
					<label for="username">username</label>
					 <input type="text" class="form-control" placeholder="Enter username" name="username" value="${sessionScope.principal.username}" required="required" readonly/>
				</div>
	
				<div class="form-group">
					<label for="password">Password:</label>
					 <input type="password" class="form-control" placeholder="Enter password" name="password" required="required"/>
				</div>
	
				<div class="form-group">
					<label for="email">Email address:</label>
					 <input type="email" class="form-control" placeholder="Enter email" name="email" value="${sessionScope.principal.email}" required="required"/>
				</div>
	
				<div class="form-group">
					<label for="address">address:</label> 
					<button type="button" class="btn btn-warning float-right">주소검색</button>
					<input type="text" class="form-control" placeholder="Enter address" name="address" value="${sessionScope.principal.address}" required="required"/>
				</div>
							
				<!-- form 안에 있으면 자동으로 submit됨 -->
				<button type="submit" class="btn btn-primary"  >회원정보수정</button>
			</form>
		</div>
		<div>
		</div>
	
	</section>

<%@ include file="../layout/footer.jsp" %>