<!DOCTYPE html>
<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fe" tagdir="/WEB-INF/tags/frontend" %>

<html>
<head>
	<title>	${menu_select}</title>			
	<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />
	
	<!-- Import all css, java-script -->			
	<fe:importheader></fe:importheader>		
</head>
<body>
    <div class="boxed" >    
    <div id="ctl07_ContentPane" style="width: 100%"><div></div></div>
	    
	    <!-- Add header -->			
		<fe:Header></fe:Header>	
	
		<!-- to add content -->
		<jsp:doBody />
	    
	    <!-- Add bottom --> 
	    <fe:Bottom></fe:Bottom>		
    </div>

	<!-- More script-->
   	<fe:ScriptPlus></fe:ScriptPlus>
</body>
</html>
