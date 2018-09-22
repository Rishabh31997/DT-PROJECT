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
 <form:form action="${contextRoot}/addToCart/processOrder" method="post" modelAttribute="orderObj">
 
 	<div class="panel panel-primary">
  	<div class="panel-heading" align="center"><h2>Payment Form</h2></div>
 	 <div class="panel-body">
 	<div class="row">
	<div class="col-sm-4"><label for="CardNumber" >Card Number</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="CardNumber" name="cardNumber"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="NameOnCard" >Name On Card</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="NameOnCard" name="nameOnCard"></div>
	
	</div>
	
	
	<div class="row">
	<div class="col-sm-4"><label for="CVV">CVV</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="CVV" name="cvv"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="Expiry Date">Expiry Date</label></div>
	<div class="col-sm-4"><input type="text" class="form-control input-sm" ID="Contact" name="month"></div>
	<div class="col-sm-4"><input type="text" class="form-control input-sm" ID="Contact" name="year"></div>
	</div>
	
	
	<button type="submit" value ="submit" class="btn btn-primary" align="center">Submit</button>
	</div>
	</div>
	</form:form>
	
	</div>
	
	
	