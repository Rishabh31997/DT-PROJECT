	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<jsp:include page="./shared/Navbar.jsp"></jsp:include>
	
	
	<div class="container">
	<h1>LOGIN</h1>
	<hr/>
	<h3>${message}</h3>
	<h3>${msg}</h3>
	 <form   method="post" >
	
	<div class="row">
	<div class="col-sm-4"><label for="Email" >User Name</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Email" name="username"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="Password">Password</label></div>
	<div class="col-sm-4"><input type="password" class="form-control" ID="Password" name="password"></div>
	
	</div>
		<button type="submit" class="btn btn-primary">Submit</button>
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	
	
</form>
</div>

<jsp:include page="./shared/Footer.jsp"></jsp:include>

