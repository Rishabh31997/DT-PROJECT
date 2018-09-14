
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<jsp:include page="./shared/Navbar.jsp"></jsp:include>
	<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
	
	<div class="container">
	<h1>Add Product</h1>
	<hr/>
	<%--  <form:form action="submitproduct" method="post" modelAttribute="proForm"> --%>
	 <form action="admin/submitproduct" method="post" enctype="multipart/form-data">
	
	<div class="row">
	<div class="col-sm-4"><label for="Product Name" >Product Name</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Product Name" name="productName"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="Product Price">Product Price</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Product Price" name="price"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="Description">Product Description</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Description" name="description"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="Quantity">Product Quantity</label></div>
	<div class="col-sm-4"><input type="text" class="form-control" ID="Quantity" name="quantity"></div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-4">
	<label for="Category">Category -</label>
	</div>
	<div class="col-sm-4">
	<select name="category" class="form-control">
	<option value="none">----------Select Category-------------</option>
	<c:forEach items="${categoryList}" var="categoryObj">
	<option value="${categoryObj.categoryId}">${categoryObj.categoryName}</option>
	</c:forEach>
    </select>
	</div>
	</div>
	
	<div class="row">
	<div class="col-sm-4">
	<label for="Supplier">Supplier -</label>
	</div>
	<div class="col-sm-4">
	<select name="supplier" class="form-control">
	<option value="none">----------Select Supplier-------------</option>
	<c:forEach items="${supplierList}" var="supplierObj">
	<option value="${supplierObj.supplierId}">${supplierObj.supplierName}</option>
	</c:forEach>
    </select>
	</div>
	</div>
	
	<div class="row">
	<div class="col-sm-4"><label for="pimage">Upload Image:</label></div>
	<div class="col-sm-4"><input type="file" class="form-control" id="file" placeholder="Upload Product Image" name="file"></div>
	
	</div>
	
	

	<button type="submit" value ="addproduct" class="btn btn-primary">Submit</button>
	
	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	
	
	</form>
	</div> 
 	
	
	
	
	<jsp:include page="./shared/Footer.jsp"></jsp:include>
	
	<%-- </form:form> --%>
