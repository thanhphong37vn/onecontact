<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin" %>
 <%@ taglib uri="http://java.fckeditor.net" prefix="fck"%>
<html>
<head>
<admin:importstyles js="jquery-ui.min.js,jquery.multiselect.js" css="jquery-ui.css,jquery.multiselect.css"/>
</head>

<body>
<admin:wrapper>
	<div class="row">
		<div class="col-lg-12">
		    <h1 class="page-header"><spring:message code="admin.news.management"></spring:message></h1>
		</div>
	</div>
	<admin:processResult/>
	<c:choose>
    <c:when test="${newsForm.command eq 'list'}">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<admin:form modelAttribute ="newsForm" method = "get" action="add.html" id="addForm">
							<button type="submit" class="btn btn-primary"><spring:message code="admin.news.create" /></button>
						</admin:form>
					</div>
					<!-- /.panel-heading -->
					
	                 <div class="panel-body">
	                     <div class="table-responsive">
	                         <table class="table table-striped table-bordered table-hover" id="news-dataTable">
	                             <thead>
	                                 <tr>
	                                 	<th><spring:message code="admin.news.enable" /></th>
	                                     <th><spring:message code="admin.news.id" /></th>
	                                     <th><spring:message code="admin.news.title" /></th>
	                                     <th><spring:message code="admin.news.thumbnail" /></th>
	                                     <th> </th>    
	                                 </tr>
	                             </thead>
	                             <tbody>
	                             	<c:forEach items="${listDto.items}" var="entity">
		                                 <tr class="odd gradeX">
		                                 	<td>${entity.enable }</td>
		                                     <td>${entity.id }</td>
		                                     <td>${entity.title}</td>
		                                     <td><img width="80px" src=" ${contextPath}/Images_Upload/${entity.thumbnail}" />
		                                     </td>
		                                     <td>
		                                     	<a href="edit-${entity.id}.html" class="btn btn-outline btn-warning btn-sm"><spring:message code="admin.news.edit" /></a>
		                                     	<a href="delete-${entity.id}.html" class="btn btn-outline btn-danger btn-sm"><spring:message code="admin.news.delete" /></a>		                                     	
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
    <c:when test="${newsForm.command eq 'register'}">
        <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <spring:message code="admin.news.input"/>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                        	
                        	<admin:form modelAttribute ="newsForm" method = "post" enctype="multipart/form-data" action="register.html" id="do-addForm">
                        		<form:errors path="*" cssClass="error" element="div"/>
                        		<form:hidden path="id"/>
                        		<form:hidden path="command"/>
                        		<form:hidden path="thumbnail"/>
                        		<form:hidden path="tags"/>
                        		<div class="form-group">
                                    <label><spring:message code="admin.news.title" /></label>
                                    <spring:message code="admin.news.title.input" var="intputTitle"/>
                                    <form:input path = "title" class="form-control" placeholder="${intputTitle }"/>
<%--                                     <form:errors path="title" cssClass="error" />                                                                      --%>
                                </div>
                                <div class="form-group">
                                	<label><spring:message code="admin.news.intro" /></label>
                                	<spring:message code="admin.news.intro.input" var="intputIntro"/>
                                    <form:input path = "intro" class="form-control" placeholder="${intputIntro }" />
<%--                                     <form:errors path="intro" cssClass="error" />    --%>
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
                                
                                
                                <div class="form-group">
                                	<label><spring:message code="admin.news.tags" /></label>
                                	
									<select id="selecttags" multiple="multiple">
										<c:forEach items="${tagsList}" var="tag">
											<c:choose>
												<c:when test="${tag.selected }">
													<option value="${tag.name }" selected>${tag.name }</option>
												</c:when>
												<c:otherwise>
													<option value="${tag.name }">${tag.name }</option>
												</c:otherwise>
											</c:choose>
											
											
										</c:forEach>										
									</select>
<%-- 									<form:input disabled="true" path = "tags" class="form-control" /> --%>
									<br><label id="ob" ></label>
<!-- 									<label id="callback2" >empty2</label> -->
                                </div>
                                 <div class="form-group">
                                	<label><spring:message code="admin.news.thumbnailFile" /></label>
<%--                                 	<spring:message code="admin.news.thumbnailFile.input" var="intputThumbnailFile"/>                                    --%>
									<input type="file" size="35"
										name="thumbnailFile" id="thumbnailFile" /> 
								
<%--                                     <form:errors path="thumbnailFile" cssClass="error" />    --%>
                                </div>
                                
								<div class="form-group">
                                	<label><spring:message code="admin.news.enable" /><form:checkbox path = "active" class="form-control" /></label>
<%--                                 	<spring:message code="admin.news.enable.input" var="intputEnable"/> --%>
                                    
<%--                                     <form:errors path="enable" cssClass="error" />    --%>
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
    </c:when>
    <c:otherwise>        
    </c:otherwise>
	</c:choose>
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
