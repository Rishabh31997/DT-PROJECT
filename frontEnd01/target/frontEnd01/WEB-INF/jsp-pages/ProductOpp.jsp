
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<jsp:include page="./shared/Navbar.jsp"></jsp:include>

<div class="container" align="center">



<div class="container" align="center">
<h1>PRODUCT OPERATION</h1>

<a href="addupdateproduct" class="btn btn-primary">ADD PRODUCT</a>
<br>
<br>
<a href="${contextRoot}/viewAllProducts" class="btn btn-primary"> VIEW ALL PRODUCT</a>
<br>
<br>

</div>

<div class="footer" margin-top:100px;>

<jsp:include page="./shared/Footer.jsp"></jsp:include>

</div>

</div>

