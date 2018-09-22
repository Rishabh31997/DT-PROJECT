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



<h1 style="color:green">${msg}</h1>
<h1>Address List</h1>
<table class="table table-condensed">
    <thead>
      <tr>
        <th>House Number</th>
        <th>Locality</th>
       	<th>City</th>
       	<th>State</th>
       	<th>Pincode</th>
       	
      </tr>
    </thead>
   <tbody>
 <c:forEach items="${addressList}" var="addressObj">
 		
  		<tr>
  			<td>${addressObj.houseNumber}</td>
  			<td>${addressObj.locality}</td>
  			<td>${addressObj.city}</td>
  			<td>${addressObj.state}</td>
  			<td>${addressObj.pincode}</td>
  			
  		</tr>
  		
  </c:forEach>
  		<tr>
  			<td></td>
  			<td><a href="${contextRoot}/addToCart/placeOrder" class="btn btn-primary">Place Order</a></td>
  		</tr>
  </tbody>
</table>


<jsp:include page="./shared/Footer.jsp"></jsp:include>