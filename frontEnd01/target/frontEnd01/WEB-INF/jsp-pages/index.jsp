
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

<h1>${msg}</h1>
	
<security:authorize access="hasAuthority('admin')">
	<c:out value="${contextRoot}/admin/operations"/>
	<jsp:forward page="/admin/operations"/>
</security:authorize>		
 
<div class="container-fluid" align="center">

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${images}/20160205_003933_730x300_20160128-160324-730x300-image-730-300-honor5x.jpg" style="width:80%;">
      </div>

      <div class="item">
        <img src="${images}/Flipkart-Fashion-Sale-Minimum-50-Off.jpg" style="width:80%;">
      </div>
    
      <div class="item">
        <img src="${images}/20151112_011839_730x300_image-730-300-711.jpg" style="width:80%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
      </a>
  </div>
</div>
<br>
<br>
    <div class="container">
    <div class="rows">
    <div class="col-md-12">
    
	<div class="col-sm-4">
	<div class="thumbnail" align="center">
	
	<img src=${images}/3660174-asus-x552ea-sx009d-laptop-apu-dual-core-2gb-500gb-dos-black-picture-big.jpg>
	<p>Laptop i5 core</p>
	<p>8th Generation</p>
	<p>Now 55000</p>
	
	</div>
	</div>
	
		<div class="col-sm-4">
	<div class="thumbnail" align="center">
	
	<img src=${images}/3660174-asus-x552ea-sx009d-laptop-apu-dual-core-2gb-500gb-dos-black-picture-big.jpg>
	<p>Laptop i5 core</p>
	<p>8th Generation</p>
	<p>Now 55000</p>
	
	</div>
	</div>
		<div class="col-sm-4">
	<div class="thumbnail" align="center">
	
	<img src=${images}/3660174-asus-x552ea-sx009d-laptop-apu-dual-core-2gb-500gb-dos-black-picture-big.jpg>
	<p>Laptop i5 core</p>
	<p>8th Generation</p>
	<p>Now 55000</p>
	
	</div>
	</div>
		<div class="col-sm-4">
	<div class="thumbnail" align="center">
	
	<img src=${images}/3660174-asus-x552ea-sx009d-laptop-apu-dual-core-2gb-500gb-dos-black-picture-big.jpg>
	<p>Laptop i5 core</p>
	<p>8th Generation</p>
	<p>Now 55000</p>
	
	</div>
	</div>
	
	<div class="col-sm-4">
	<div class="thumbnail" align="center">
	
	<img src=${images}/3660174-asus-x552ea-sx009d-laptop-apu-dual-core-2gb-500gb-dos-black-picture-big.jpg>
	<p>Laptop i5 core</p>
	<p>8th Generation</p>
	<p>Now 55000</p>
	
	</div>
	</div>
	
	<div class="col-sm-4">
	<div class="thumbnail" align="center">
	
	<img src=${images}/3660174-asus-x552ea-sx009d-laptop-apu-dual-core-2gb-500gb-dos-black-picture-big.jpg>
	<p>Laptop i5 core</p>
	<p>8th Generation</p>
	<p>Now 55000</p>
	
	</div>
	</div>
	</div>
	</div>
	</div>


<jsp:include page="./shared/Footer.jsp"></jsp:include>

</body>
</html>

