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
		    <h1 class="page-header"><spring:message code="admin.tag.management"></spring:message></h1>
		</div>
	</div>
	<admin:processResult/>
	<c:choose>
    <c:when test="${tagForm.command eq 'list'}">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<admin:form modelAttribute ="tagForm" method = "get" action="add.html" id="addForm">
							<button type="submit" class="btn btn-primary"><spring:message code="admin.tag.create" /></button>
						</admin:form>
					</div>
					<!-- /.panel-heading -->
					
	                 <div class="panel-body">
	                     <div class="table-responsive">
	                         <table class="table table-striped table-bordered table-hover" id="tag-dataTable">
	                             <thead>
	                                 <tr>
	                                 <th><spring:message code="admin.tag.enable" /></th>
	                                     <th><spring:message code="admin.tag.id" /></th>
	                                     <th><spring:message code="admin.tag.name" /></th>
	                                     <th><spring:message code="admin.tag.lastUpdate" /></th>
	                                     <th> </th>    
	                             </thead>
	                             <tbody>
	                             	<c:forEach items="${listDto.items}" var="entity">
		                                 <tr class="odd gradeX">
		                                 	<td>${entity.enable }</td>
		                                     <td>${entity.id }</td>
		                                     <td>${entity.name}</td>
		                                     <td class="center">${entity.lastUpdate}</td>
		                                     <td>
		                                     	<a href="edit-${entity.id}.html" class="btn btn-outline btn-warning btn-sm"><spring:message code="admin.tag.edit" /></a>
		                                     	<a href="delete-${entity.id}.html" class="btn btn-outline btn-danger btn-sm"><spring:message code="admin.tag.delete" /></a>		                                     	
		                                     </td>
		                                     
		                                     
		                                 </tr>
	                                 </c:forEach>   
	                             </tbody>
	                         </table>
	                     </div>
	                     <!-- /.table-responsive -->
	                    
	                 </div>
	                 <!-- /.panel-body -->
				</div>
			</div>
		</div>
	</c:when>
    <c:when test="${tagForm.command eq 'register'}">
        <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <spring:message code="admin.tag.input"/>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                        	
                        	<admin:form modelAttribute ="tagForm" method = "post" action="register.html" id="do-addForm">
                        		<form:errors path="*" cssClass="error" element="div"/>
                        		<form:hidden path="id"/>
                        		<form:hidden path="command"/>
                        		<div class="form-group">
                                    <label><spring:message code="admin.tag.name" /></label>
                                    <spring:message code="admin.tag.name.input" var="intputName"/>
                                    <form:input path = "name" class="form-control" placeholder="${intputName }"/>                                                                  
                                </div>                                
                                
								<div class="form-group">
                                	<label><spring:message code="admin.tag.enable" /><form:checkbox path = "active" class="form-control" /></label>
                                </div>
								
                                <button type="submit" class="btn btn-default"><spring:message code="admin.tag.save"/></button>
                                <a href="list.html" class="btn btn-default"><spring:message code="admin.tag.list"/></a>                                
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
        $('#tag-dataTable').dataTable({
        	stateSave: true
        });
    });
    </script>
</body>
</html>
