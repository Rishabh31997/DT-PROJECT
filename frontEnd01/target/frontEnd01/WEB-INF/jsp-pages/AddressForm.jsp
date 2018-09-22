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
 <form:form action="${contextRoot}/addToCart/addAddress" method="post" modelAttribute="addressObj">
 
 	<div class="panel panel-primary">
  	<div class="panel-heading" align="center"><h2>Address Form</h2></div>
 	 <div class="panel-body">
 	<div class="row">
	<div class="col-sm-4"><label for="HouseNumber" >House Number</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="HouseNumber" name="houseNumber"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="Locality" >Locality</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Locality" name="locality"></div>
	
	</div>
	
	
	<div class="row">
	<div class="col-sm-4"><label for="City">City</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="City" name="city"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="State">State</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Contact" name="state"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="Pincode">Pincode</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Pincode" name="pincode"></div>
	
	
	<button type="submit" value ="submit" class="btn btn-primary" align="center">Submit</button>
	</div>
	</div>
	</form:form>
	
	</div>
	
	
	