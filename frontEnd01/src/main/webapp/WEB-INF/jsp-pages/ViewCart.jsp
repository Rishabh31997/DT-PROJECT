<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<body>
<jsp:include page="./shared/Navbar.jsp"></jsp:include>
 <spring:url var="images" value="/resources/images"/> 

 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<div class="container">

<br/>

<h1>${msg}</h1>

<h1 style="color:green">${msg}</h1>
<h1>Cart</h1>
<table class="table table-condensed">
    <thead>
      <tr>
        <th>Item Name</th>
        <th>Price</th>
       	<th>Quantity</th>
       	<th>Image</th>
       	<th>Delete</th>
       	<th>Increase quantity</th>
       	<th>Decrease quantity</th>
      </tr>
    </thead>
   <tbody>
 <c:forEach items="${itemsList}" var="itemObj">
 		
  		<tr>
  			<td>${itemObj.product.productName}</td>
  			<td>${itemObj.price}</td>
  			<td>${itemObj.quantity}</td>
  			<td><img src="${images}/${itemObj.product.imgName}" style="height:200px;width:200px"/></td>
  			<td><a href="${contextRoot}/addToCart/deleteItem/${itemObj.itemId}">Delete</a></td>
  			<td><a href="${contextRoot}/addToCart/increaseQuantity/${itemObj.itemId}">Increase</a></td>
  			<td><a href="${contextRoot}/addToCart/decreaseQuantity/${itemObj.itemId}">Decrease</a></td>
  		</tr>
  		
  </c:forEach>
  		<tr>
  			<td></td>
  			<td><a href="${contextRoot}/addToCart/makePayment" class="btn btn-primary">Make Payment</a></td>
  		</tr>
  </tbody>
</table>

<jsp:include page="./shared/Footer.jsp"></jsp:include>
