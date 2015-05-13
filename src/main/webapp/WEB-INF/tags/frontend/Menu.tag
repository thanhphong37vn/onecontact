<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		<span class="sr-only">Toggle navigation</span>
		<i class="fa fa-bars"></i>
	</button>
	<a href="#" class="navbar-brand hidden-lg hidden-md hidden-sm active" style="width:300px"></a>
</div> <!-- navbar-header -->
<!-- Collect the nav links, forms, and other content for toggling -->
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul id="ctl07_ctl04_root" class="nav navbar-nav">		
		
		<c:choose>		
			<c:when test="${active eq 'id_li_1'}">
				<li id = "id_li_1" class="active"><a href="http://1contact.vn/meg/index.jsp">Trang chủ</a></li>	 
			</c:when>
			<c:otherwise>   
			     <li id = "id_li_1" class=""><a href="http://1contact.vn/meg/index.jsp">Trang chủ</a></li>
	   		</c:otherwise>
		</c:choose>
		
		<c:choose>		
			<c:when test="${active eq 'id_li_2'}">
				<li id = "id_li_2" class="active"><a href="${contextPath}/intro.html">Giới thiệu</a></li>
			</c:when>
			<c:otherwise>   
			     <li id = "id_li_2" class=""><a href="${contextPath}/intro.html">Giới thiệu</a></li>
	   		</c:otherwise>
		</c:choose>
		
		<c:choose>		
			<c:when test="${active eq 'id_li_3'}">
			 	<li id = "id_li_3" class="active"><a href="${contextPath}/promos-1-0.html">Khuyến mại v&#224; tin tức</a></li>
			</c:when>
			<c:otherwise>   
			    <li id = "id_li_3" class=""><a href="${contextPath}/promos-1-0.html">Khuyến mại v&#224; tin tức</a></li>
	   		</c:otherwise>
		</c:choose>
		
		<c:choose>		
			<c:when test="${active eq 'id_li_4'}">
				<li id = "id_li_4" class="active"><a href="${contextPath}/guide.html">Hướng dẫn sử dụng</a></li> 
			</c:when>
			<c:otherwise>   
			     <li id = "id_li_4" class=""><a href="${contextPath}/guide.html">Hướng dẫn sử dụng</a></li>
	   		</c:otherwise>
		</c:choose>	   
		
		
		<c:choose>		
			<c:when test="${active eq 'id_li_5'}">
				<li id = "id_li_5" class="active"><a href="${contextPath}/contact.html">Li&#234;n hệ</a></li> 
			</c:when>
			<c:otherwise>   
			     <li id = "id_li_5" class=""><a href="${contextPath}/contact.html">Li&#234;n hệ</a></li>
	   		</c:otherwise>
		</c:choose>
	</ul>
</div>