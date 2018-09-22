


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="./shared/Navbar.jsp"></jsp:include>



<div class="container">
	<h1>ADD SUPPLIER</h1>
	<hr/>
	<form action="submitsupplier" method="post">
	
	<div class="row">
	<div class="col-sm-4"><label for="Supplier Name" >Supplier Name</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Category Id" name="supplierName"></div>
	</div>
	
	
	<div class="row">
	<div class="col-sm-4"><label for="Supplier Address" >Supplier Address</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Category Id" name="supplierAddress"></div>
	</div>
	
	
	<button type="submit" value ="submitproduct" class="btn btn-primary">Submit</button>
	
	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	
	</form>
	
	
	<jsp:include page="./shared/Footer.jsp"></jsp:include>
	