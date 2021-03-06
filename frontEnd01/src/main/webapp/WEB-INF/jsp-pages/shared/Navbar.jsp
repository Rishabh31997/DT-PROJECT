<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<spring:url var="images" value="/resources/images"/>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
  		<div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>  
      </button>
      <a class="navbar-brand" href="${contextRoot}/home"><img src="${images}/if_flipkart_1220366.png" width="35" height="27"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
       
        <%-- <li><a href="${contextRoot}/viewAllProducts">Shop</a></li> --%>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Shop By Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${contextRoot}/getProduct/Mens">Mens</a></li>
          <li><a href="${contextRoot}/getProduct/Womens">Womens</a></li>
          <li><a href="${contextRoot}/getProduct/kids">Kids</a></li>
          <li class="divider"></li>
          <li><a href="${contextRoot}/viewAllProducts">SHOP</a></li>
      </ul> 
        </li>
        <li><a href="#">Contact</a></li>
      
        </ul>
	  
	      <form class="navbar-form navbar-left" action="">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search.." size="40" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
	  
      <ul class="nav navbar-nav navbar-right">
      
      	<security:authorize access="isAnonymous()">
      		<li><a href="${contextRoot}/login"><span class="glyphicon glyphicon-user" style="color:grey"></span></a></li>
		 	<li><a href="${contextRoot}/signIn">Sign In</a></li>
      	</security:authorize>
      
       
		<security:authorize access="isAuthenticated()">
		
		<div class="dropdown">
   			
   			 <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
   			 Welcome:<c:out value="${sessionScope.username}"/>
    			<span class="caret"></span></button>
   				 <ul class="dropdown-menu">
     	 <li><a href="${contextRoot}/logout"><span class="glyphicon glyphicon-log-out" style="font-size:18px;color:grey">LogOut</span></a></li>
     	 <li><a href="#"><span class="glyphicon glyphicon-shopping-cart" style="font-size:18px;color:grey"/>Cart</a></li>
        </ul>
        
  		</div>

		
		
  		</security:authorize>
		</div>
		
		
</ul>
		 </nav>
		 
		 
		 
		 
