<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:include page="./shared/Navbar.jsp"></jsp:include>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
    <div class="container">
    <br/>
    	<h2>${msg}</h2>
    <br/>
  <h1 align="center">SUPPLIERS LIST</h1>                                                                                      
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
       <th>Supplier Id</th>
        <th>Supplier Name</th>
        <th>Address</th>
        <th colspan="2">Operations</th> 
      </tr>
    </thead>
    <tbody>
      
        <c:forEach items="${suppList}" var="suppObj">
        <tr>
        <td>${suppObj.supplierId}</td>
		<td>${suppObj.supplierName}</td>
		<td>${suppObj.supplierAddress}</td>
		
		
		<td><a href="${contextRoot}/deletesupplier/${suppObj.supplierId}">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
        <a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </td>
		
		<%-- <td><a href="deletecategory/${catObj.categoryId}">Delete<i class="fa fa-trash"></i></a></td> --%>
		<!-- <td><a href="deleteproduct"><i class="fa fa-edit"></i></a></td> -->
		  </tr>
		</c:forEach>
    
    </tbody>
  </table>
  </div>
</div>
    
    
    <jsp:include page="./shared/Footer.jsp"></jsp:include>