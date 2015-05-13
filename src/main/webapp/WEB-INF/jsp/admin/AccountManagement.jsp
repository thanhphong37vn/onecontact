<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin" %>
 <%@ taglib uri="http://java.fckeditor.net" prefix="fck"%>
<html>
<head>
<admin:importstyles />
</head>

<body>
<admin:wrapper>
	<div class="row">
		<div class="col-lg-12">
		    <h1 class="page-header"><spring:message code="admin.account.management"></spring:message></h1>
		</div>
	</div>
	<admin:processResult/>
	<c:choose>
    <c:when test="${accountForm.command eq 'list'}">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<admin:form modelAttribute ="accountForm" method = "get" action="add.html" id="addForm">
							<button type="submit" class="btn btn-primary"><spring:message code="admin.account.create" /></button>
						</admin:form>
					</div>
					<!-- /.panel-heading -->
					
	                 <div class="panel-body">
	                     <div class="table-responsive">
	                         <table class="table table-striped table-bordered table-hover" id="account-dataTable">
	                             <thead>
	                                 <tr>
	                                 	<th><spring:message code="admin.account.enable" /></th>
	                                     <th><spring:message code="admin.account.id" /></th>
	                                     <th><spring:message code="admin.account.username" /></th>
	                                     <th><spring:message code="admin.account.role" /></th>
	                                     <th><spring:message code="admin.account.createDate" /></th>
	                                     <th>&nbsp</th>  
	                                 </tr>
	                             </thead>
	                             <tbody>
	                             	<c:forEach items="${listDto.items}" var="entity">
		                                 <tr class="odd gradeX">
		                                 	<td>${entity.enable }</td>
		                                     <td>${entity.id }</td>
		                                     <td>${entity.username}</td>
		                                     <td>${entity.role}</td>
		                                     <td class="center">${entity.dateCreate}</td>
		                                     <td>
		                                     	<a href="edit-${entity.id}.html" class="btn btn-outline btn-warning btn-sm"><spring:message code="admin.account.edit" /></a>
		                                     </td>
		                                 </tr>
	                                 </c:forEach>   
	                             </tbody>
	                         </table>
	                   
	                     <!-- /.table-responsive -->
	                    
	                 </div>
	                 <!-- /.panel-body -->
				</div>
			</div>
		</div>
		</div>
	</c:when>
    <c:when test="${(accountForm.command eq 'add') || (accountForm.command eq 'edit')}">
    	<c:choose>
    	<c:when test="${accountForm.command eq 'edit'}">
        	<c:set var="usernameDisable" value="true"/>
        </c:when>
        <c:otherwise>
        	<c:set var="usernameDisable" value="false"/>
        </c:otherwise>
        </c:choose>
        <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <spring:message code="admin.account.input"/>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                        	
                        	<admin:form modelAttribute ="accountForm" method = "post" enctype="multipart/form-data" action="register.html" id="do-addForm">
                        		<form:errors path="*" cssClass="error" element="div"/>
                        		<form:hidden path="id"/>
                        		<form:hidden path="command"/>
                        		<div class="form-group">
                                    <label><spring:message code="admin.account.username" /></label>
                                    <spring:message code="admin.account.username.input" var="intputUsername"/>
                                    <c:choose>
								    	<c:when test="${accountForm.command eq 'edit'}">
								        	<form:hidden path="username"/>
								        	<input type="text" class="form-control"  value="${accountForm.username}" disabled="disabled"/>
								        </c:when>
								        <c:otherwise>
								        	<form:input path = "username" class="form-control" placeholder="${intputUsername }"/>  
								        </c:otherwise>
							        </c:choose>
                                </div>
                                <div class="form-group">
                                    <label><spring:message code="admin.account.password" /></label>
                                    <spring:message code="admin.account.password.input" var="intputPassword"/>
                                    <form:input path = "password" class="form-control" placeholder="${intputPassword }"/>
                                </div>
                                
                                 <div class="form-group">
                                    <label><spring:message code="admin.account.role" /></label>          
                                    <form:select path="role" class="form-control">
<%-- 									   <form:option value="USER" label="User"/> --%>
<%-- 									   <form:option value="ADMIN" label="Admin"/> --%>
									   <form:options items="${roleList}" />
									</form:select>
                                </div>
								<div class="form-group">
                                	<label><spring:message code="admin.account.enable" /><form:checkbox path = "active" class="form-control" /></label>
                                </div>
                                <button type="submit" class="btn btn-default"><spring:message code="admin.account.save"/></button>
                                <a href="list.html" class="btn btn-default"><spring:message code="admin.account.list"/></a>                                
                        	</admin:form>
                        </div>
                    </div>
                </div>
           </div>
       	</div>
    	</div>
    </c:when>
    <c:otherwise>        
    </c:otherwise>
	</c:choose>
</admin:wrapper>
<script>
    $(document).ready(function() {
        $('#account-dataTable').dataTable({
        	stateSave: true
        });
    });
    </script>
</body>
</html>
