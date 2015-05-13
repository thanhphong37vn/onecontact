<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin" %>
 <%@ taglib uri="http://java.fckeditor.net" prefix="fck"%>
<html>
<head>
<admin:importstyles/>
</head>

<body>
<admin:wrapper>
	<div class="row">
		<div class="col-lg-12">
		    <h1 class="page-header"><spring:message code="admin.${newsType }"></spring:message></h1>
		</div>
	</div>
	<admin:processResult/>

        <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <spring:message code="admin.${newsType }.input"/>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                        	
                        	<admin:form modelAttribute ="newsForm" method = "post" enctype="multipart/form-data" action="update-special.html" id="do-addForm">
                        		<form:errors path="*" cssClass="error" element="div"/>
                        		<form:hidden path="id"/>
                        		<form:hidden path="command"/>
                        		<form:hidden path="enable"/>
                        		<form:hidden path="category"/>
                        		<div class="form-group">
                                    <label><spring:message code="admin.news.title" /></label>
                                    <spring:message code="admin.news.title.input" var="intputTitle"/>
                                    <form:input path = "title" class="form-control" placeholder="${intputTitle }"/>                                                              
                                </div>
                                
                                <div class="form-group">
                                	
                                	<label><spring:message code="admin.news.content" /></label>
                                	<spring:message code="admin.news.content.input" var="intputContent"/>
                                	<script type="text/javascript" src="%=request.getContextPath()%>/common/script/ckeditor/ckeditor.js">
        							</script>
                                	<fck:editor instanceName="EditorDefault"
 									inputName="content" width="650" height="450"> 
 									<jsp:attribute name="value">${newsForm.content}</jsp:attribute> 
 									</fck:editor>
<%--                                     <form:errors path="content" cssClass="error" />    --%>
                                </div>                                
                                 
								
                                <button type="submit" class="btn btn-default"><spring:message code="admin.news.save"/></button>
                                <a href="list.html" class="btn btn-default"><spring:message code="admin.news.list"/></a>                                
                        	</admin:form>
                        </div>
                    </div>
                </div>
           </div>
       	</div>
    	</div>
   
</admin:wrapper>
<script>
    $(document).ready(function() {
    	var values = $("select").val();        			  
		   $("#tags").val(values);	
		   $("#ob").html(values);
        $('#news-dataTable').dataTable({
        	stateSave: true
        });
        $("#selecttags").multiselect({        	   
        		   header: false,        		   
        		   close: function(){
        			   var values = $("select").val();        			  
        			   $("#tags").val(values);	
        			   $("#ob").text(values);
        		   }
        	});
    });
    </script>
</body>
</html>
