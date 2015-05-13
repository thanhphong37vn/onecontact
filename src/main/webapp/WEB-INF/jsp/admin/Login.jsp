<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<html>
<head>
<admin:importstyles/>
</head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="${contextPath}/globalcss/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${contextPath}/globalcss/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/globalcss/admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${contextPath}/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div class="container">
        <div class="row">
        	
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                    	<c:if test="${not empty error}">	
                    	<div class="error">
                    		<c:out value="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}" />
                    	</div>	       
					            		        
					    </c:if>
                        <form id="form" action="<c:url value='${contextPath}/j_spring_security_check'/>" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="<spring:message code="user.loginId" />" id="loginIdField" name="j_username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="<spring:message code="user.password" />" id="passwordField" name="j_password" maxlength="12" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button class="btn btn-lg btn-success btn-block" type = "submit">Login</button>
<!--                                 <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a> -->
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery Version 1.11.0 -->
    <script src="${contextPath}/globaljs/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${contextPath}/globaljs/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${contextPath}/globaljs/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${contextPath}/globaljs/admin.js"></script>

</body>

</html>
