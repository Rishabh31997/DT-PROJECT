<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<jsp:include page="./shared/Navbar.jsp"></jsp:include>

<div class="container" align="center">
<h2>Choose Operation</h2>

<a href="${contextRoot}/admin/productpage" class="btn btn-primary">PRODUCT</a>
<br>
<br>
 <a href="${contextRoot}/admin/categoryopp" class="btn btn-primary"> CATEGORY</a>
<br>
<br>
<a href="${contextRoot}/admin/supplieropp" class="btn btn-primary">SUPPLIER</a>
<br>
<br>
 


<div class="footer" margin-top:500px;>

<jsp:include page="./shared/Footer.jsp"></jsp:include>

</div>

</div>