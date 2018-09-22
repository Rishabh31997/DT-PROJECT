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
 
<!-- Product Details -->
<div class="container content">

	<form:form modelAttribute="prod" action="${contextRoot}/addToCart/${prod.productId}" method="GET">

		<div style="height: 10%"></div>
		<div class="row well table-responsive">
			<div class="col-md-3">
				<div id="${prod.productId}"></div>
				<div>
					<img src="${images}/${prod.imgName}" height="400" width="300">
				</div>
			</div>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="row">
					<p>
					<h1 style="color: blue; font-weight: bold">${prod.productName}</h1>
					</p>
				</div><br/>
				<div class="row">
					<p>
					<h4>
						<b>Category : </b>${prod.category.categoryName}</h4>
					</p>
				</div><br/>
				
				<div class="row">
					<p>
					<h4>
						<b>Description : </b>${prod.description}</h4>
					</p>
				</div><br/>
				<div class="row">
					<p>
						<b></b>
					<h4 style="color: red">${prod.price}</h4>
					</b>
					</p>
				</div><br/>
				<div class="row">
					<p>
						<b></b>
					<h4 style="color: orange">${prod.quantity} pieces left
						.</h4>
					</b>
					</p>
				</div><br/>
				<%-- <div class="row">
					<select name="quantity" id="quantity">
						<c:forEach var="i" begin="1" end="${prod.quantity}">
							<option value="${i}">${i}</option>
						</c:forEach>
					</select> 

				</div>--%><br/>
				<div class="row">
					<p>
						<button style="text-size: 30px" class="btn btn-danger btn-md">
							<span class="glyphicon glyphicon-shopping-cart"
								style="text-size: 30px"></span> Add to Cart
						</button>
					</p>

				</div>
			</div>

		</div>
	</form:form>
</div>
