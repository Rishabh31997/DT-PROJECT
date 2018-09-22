<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


	<jsp:include page="./shared/Navbar.jsp"></jsp:include>
	<spring:url var="images" value="/resources/images"/>
	<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
	
	
	
	<div style="color:green">
	<h2>${msg}</h2>
	</div>
	
	<div class="container">
		
	  <%-- <h1 align="center">PRODUCTS LIST</h1>                                                                                      
	<div class="table-responsive">          
	  <table class="table">
	    <thead>
	      <tr>
        <th>ProductName</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Action</th>
        <th>Pictures</th>
      </tr>
    </thead>
    <tbody>
      
        <c:forEach items="${productList}" var="pObj">
        <tr>
		<td>${pObj.productName}</td>
		<td>${pObj.description}</td>
		<td>${pObj.quantity}</td>
		<td>${pObj.price}</td>
		<td><img src="${images}/${pObj.imgName}"class="img-responsive "style="width:100px; height:100px;"/></td>
	
		<td><a href="${contextRoot}/deleteproduct/${pObj.productId}">
          <span class="glyphicon glyphicon-trash"></span>
        </a></td>
		
		  </tr>
		</c:forEach>
    
	    </tbody>
	  </table> 
	  </div>
	 --%>
	
	<h1>Products List</h1>
	
	
	 <c:forEach items="${productList}" var="pObj"> 
        
        <div class="col-md-4">
      	<div class="thumbnail">
       <a href="${contextRoot}/detailsproduct/${pObj.productId}" target="_blank"> 
          <img src="${images}/${pObj.imgName}" alt="Lights" class="img-responsive "style="width:100px; height:150px;">
          <div class="caption">
            <p>Product Name:${pObj.productName}</p>
 			
 			<security:authorize access="hasAuthority('admin')">
            <a href="${contextRoot}/admin/deleteproduct/${pObj.productId}" ><span class="glyphicon glyphicon-trash"></span> </a>
 			</security:authorize>      
          </div>
        </a>
      </div>
    </div>
		</c:forEach>
   
	   
 
 
 
 
	</div>

	<jsp:include page="./shared/Footer.jsp"></jsp:include>