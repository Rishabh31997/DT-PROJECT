<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD PRODUCT</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%-- <%@include file="Navbar.jsp" %> --%>
	<div class="container">
	<h1>Delete Product</h1>
	<hr/>
	<form action="submitdelete" method="get">
	
	<div class="row">
	<div class="col-sm-4"><label for="Product ID" >Product ID</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Product ID" name="productId"></div>
	
	<button type="submit" value ="submitproduct" class="btn btn-primary">Submit</button>
	
	</form>


</body>
</html>