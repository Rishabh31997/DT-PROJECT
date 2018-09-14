<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC</title>
</head>
<body>
<div align="center">
	<h1>Student Form : </h1>
	<hr/>
	<form:form action="submitproduct" method="post" modelAttribute="proForm">
		<table>
			<tr>
				<td>Product Name : </td>
				<td><form:input path="productName"/></td>
			</tr>
			<tr>
				<td>Price : </td>
				<td><form:input path="price"/></td>
			</tr>
			<tr>
				<td>Description : </td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td>Quantity : </td>
				<td><form:input path="quantity"/></td>
			</tr>
			<tr>	
				<td></td>
				<td>
					<form:button>Submit</form:button>
				</td>
			</tr>
		</table>
		
	</form:form>
</div>
</body>
</html>