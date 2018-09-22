<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:include page="./shared/Navbar.jsp"></jsp:include>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
    <div class="container">
    <br/>
    	<h2>${msg}</h2>
    <br/>
  <h1 align="center">CATEGORIES LIST</h1>                                                                                      
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
       <th>Category Id</th>
        <th>CategoryName</th>
        <!-- <th>Active</th> -->
       <th>Operations</th>
      </tr>
    </thead>
    <tbody>
      
        <c:forEach items="${catList}" var="catObj">
        <tr>
        <td>${catObj.categoryId}</td>
		<td>${catObj.categoryName}</td>
		<%-- <td>${catObj.category_isactive}</td> --%>
		
		<td><a href="${contextRoot}/admin/deletecategory/${catObj.categoryId}">
          <span class="glyphicon glyphicon-trash"></span>
        </a></td>
        
		</c:forEach>
    
    </tbody>
  </table>
  </div>
</div>
    
    
    <jsp:include page="./shared/Footer.jsp"></jsp:include>