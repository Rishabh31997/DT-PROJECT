<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<body>
<jsp:include page="./shared/Navbar.jsp"></jsp:include>

	<h2>${msg}</h2>
	<div class="container">
 <form:form action="submitUser" method="post" modelAttribute="userForm">
 
 	<div class="panel panel-primary">
  	<div class="panel-heading" align="center"><h2>Sign In Form</h2></div>
 	 <div class="panel-body">
 	<div class="row">
	<div class="col-sm-4"><label for="FirstName" >First Name</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="FirstName" name="firstName"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="LastName" >Last Name</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="LastName" name="lastName"></div>
	
	</div>
	
	
	<div class="row">
	<div class="col-sm-4"><label for="Email">Email</label></div>
	<div class="col-sm-4"><input type="email" class="form-control" ID="Email" name="email"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="ContactNumber">Contact Number</label></div>
	<div class="col-sm-4"><input type="mobile" class="form-control" ID="Contact" name="contactNumber"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="Password">Password</label></div>
	<div class="col-sm-4"><input type="password" class="form-control" ID="Password" name="password"></div>
	
	</div>
	<div class="row">
	<div class="col-sm-4"><label for="ConfirmPassword" >Confirm Password</label></div>
	<div class="col-sm-4"><input type="password" class="form-control" ID="ConfirmPassword" name="confirmPassword"></div>
	
	</div>
	
	<button type="submit" value ="submit" class="btn btn-primary" align="center">Submit</button>
	</div>
	</div>
	</form:form>
	
	</div>
	
	
	