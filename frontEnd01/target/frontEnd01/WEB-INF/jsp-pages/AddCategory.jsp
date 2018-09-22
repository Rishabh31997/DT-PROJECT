


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="./shared/Navbar.jsp"></jsp:include>



<div class="container">
	<h1>ADD CATEGORY</h1>
	<hr/>
	<form action="submitcategory" method="post">
	
	<div class="row">
	<div class="col-sm-4"><label for="Category Name" >Category Name</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Category Id" name="categoryName"></div>
	
	<button type="submit" value ="submitproduct" class="btn btn-primary">Submit</button>
	
	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	
	</form>
	
	
	<jsp:include page="./shared/Footer.jsp"></jsp:include>
	