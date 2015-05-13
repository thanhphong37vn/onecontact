<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${not empty oni_result['SUCCESS']}">
    <div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default success">
				<c:forEach items="${oni_result['SUCCESS']}" var="msg">
            	<div><c:out value="${msg}" /></div>
        		</c:forEach>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${not empty oni_result['INFO']}">
    <div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default info">
				<c:forEach items="${oni_result['INFO']}" var="msg">
            	<div><c:out value="${msg}" /></div>
        		</c:forEach>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${not empty oni_result['WARNING']}">
    <div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default warning">
				<c:forEach items="${oni_result['WARNING']}" var="msg">
            	<div><c:out value="${msg}" /></div>
        		</c:forEach>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${not empty oni_result['ERROR']}">
    <div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default error">
				<c:forEach items="${oni_result['ERROR']}" var="msg">
            	<div><c:out value="${msg}" /></div>
        		</c:forEach>
			</div>
		</div>
	</div>
</c:if>

<% session.removeAttribute("oni_result"); %>
