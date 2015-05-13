<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin" %>
 
<html>
<head>
<admin:importstyles/>
</head>

<body>
<admin:wrapper>	
    <% if (request.getAttribute("exception") instanceof Exception) { %>
    <div class="panel panel-red">
        <div class="panel-heading">
            Error
        </div>
        <div class="panel-body">
            <p>${exception.localizedMessage}</p>
        </div>
        <div class="panel-footer">
            <button onclick="history.back();">Back</button>
        </div>
    </div>    
	<% }%>

</admin:wrapper>

</body>
</html>
