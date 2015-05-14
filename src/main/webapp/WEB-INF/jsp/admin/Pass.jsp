<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="fck"%>
<html>
<head>
<admin:importstyles />
</head>

<body>
	<admin:wrapper>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					<spring:message code="admin.pass.management"></spring:message>
				</h1>
			</div>
		</div>
		<admin:processResult />
		<c:choose>
			<c:when test="${employeeCompanyForm.command eq 'search'}">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
<%-- 								<admin:form modelAttribute="employeeCompanyForm" method="get" --%>
<%-- 									action="add.html" id="addForm"> --%>
<!-- 									<button type="submit" class="btn btn-primary"> -->
<%-- 										<spring:message code="admin.account.create" /> --%>
<!-- 									</button> -->
<%-- 								</admin:form> --%>
							</div>
							<!-- /.panel-heading -->


<!--   <div class="panel-heading"> -->
<!--                 <h3 class="panel-title">Users</h3> -->
<!--                 <div class="pull-right"> -->
<!--                     <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span> Filter</button> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <table class="table"> -->
<!--                 <thead> -->
<!--                     <tr class="filters"> -->
<!--                         <th><input type="text" class="form-control" placeholder="#" disabled></th> -->
<!--                         <th><input type="text" class="form-control" placeholder="First Name" disabled></th> -->
<!--                         <th><input type="text" class="form-control" placeholder="Last Name" disabled></th> -->
<!--                         <th><input type="text" class="form-control" placeholder="Username" disabled></th> -->
<!--                     </tr> -->
<!--                 </thead> -->
<!--                 </table> -->
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="account-dataTable">
										<thead>
											<tr>
											
											<spring:message code="pass.employee.employeeName" var ="varemployeeName"/>
											<spring:message code="pass.employee.employeeNo" var ="varEmployeeNo"/>
											<spring:message code="pass.employee.employeePwd" var ="varEmployeePwd"/>
											<spring:message code="pass.employee.employeeStatus" var ="varEmployeeStatus"/>
											<spring:message code="pass.employee.mobilePhone" var ="varMobilePhone"/>
											<spring:message code="pass.employee.regDateEmp" var ="varRegDateEmp"/>
											<spring:message code="pass.employee.unregDateEmp" var ="varUnregDateEmp"/>
											
											<spring:message code="pass.company.companyName" var ="varCompanyName"/>
											<spring:message code="pass.company.companyMobile" var ="varCompanyMobile"/>
											<spring:message code="pass.company.companyPwd" var ="varCompanyPwd"/>
											<spring:message code="pass.company.companyStatus" var ="varCompanyStatus"/>
											<spring:message code="pass.company.regDateComp" var ="varRegDateComp"/>
											<spring:message code="pass.company.unregDateComp" var ="varUnregDateComp"/>


											<th><input type="text" class="form-control" placeholder="${varemployeeName}" ></th>
											<th><input type="text" class="form-control" placeholder="${varEmployeeNo}"></th>
											<th><input type="text" class="form-control" placeholder="${varEmployeePwd}"></th>
											<th><input type="text" class="form-control" placeholder="${varEmployeeStatus}"></th>
											<th><input type="text" class="form-control" placeholder="${varMobilePhone}"></th>
											<th><input type="text" class="form-control" placeholder="${varRegDateEmp}"></th>
											<th><input type="text" class="form-control" placeholder="${varUnregDateEmp}"></th>
											
											<th><input type="text" class="form-control" placeholder="${varCompanyName}"></th>
											<th><input type="text" class="form-control" placeholder="${varCompanyMobile}"></th>
											<th><input type="text" class="form-control" placeholder="${varCompanyPwd}"></th>
											<th><input type="text" class="form-control" placeholder="${varCompanyStatus}"></th>
											<th><input type="text" class="form-control" placeholder="${varRegDateComp}"></th>
											<th><input type="text" class="form-control" placeholder="${varUnregDateComp}"></th>
											<th>&nbsp</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listDto.items}" var="entity">
												<tr class="odd gradeX">
													<td>${entity.employeeId}</td>
													<td>${entity.employeeName }</td>
													<td>${entity.employeeNo}</td>
													<td>${entity.employeePwd}</td>
													<td>${entity.employeeStatus}</td>
													<td>${entity.mobilePhone}</td>
													<td>${entity.regDateEmp}</td>
													<td>${entity.unregDateEmp}</td>

													<td>${entity.companyName}</td>
													<td>${entity.companyMobile}</td>
													<td>${entity.companyPwd}</td>
													<td>${entity.companyStatus}</td>
													<td class="center">${entity.regDateComp}</td>
													<td class="center">${entity.unregDateComp}</td>
													<td><a href="edit-${entity.employeeId}.html"
														class="btn btn-outline btn-warning btn-sm"><spring:message
																code="admin.account.edit" /></a></td>
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
			<%--     <c:when test="${(accountForm.command eq 'add') || (accountForm.command eq 'edit')}"> --%>
			<%--     	<c:choose> --%>
			<%--     	<c:when test="${accountForm.command eq 'edit'}"> --%>
			<%--         	<c:set var="usernameDisable" value="true"/> --%>
			<%--         </c:when> --%>
			<%--         <c:otherwise> --%>
			<%--         	<c:set var="usernameDisable" value="false"/> --%>
			<%--         </c:otherwise> --%>
			<%--         </c:choose> --%>
			<!--         <div class="row"> -->
			<!--         <div class="col-lg-12"> -->
			<!--             <div class="panel panel-default"> -->
			<!--                 <div class="panel-heading"> -->
			<%--                     <spring:message code="admin.account.input"/> --%>
			<!--                 </div> -->
			<!--                 <div class="panel-body"> -->
			<!--                     <div class="row"> -->
			<!--                         <div class="col-lg-6"> -->

			<%--                         	<admin:form modelAttribute ="accountForm" method = "post" enctype="multipart/form-data" action="register.html" id="do-addForm"> --%>
			<%--                         		<form:errors path="*" cssClass="error" element="div"/> --%>
			<%--                         		<form:hidden path="id"/> --%>
			<%--                         		<form:hidden path="command"/> --%>
			<!--                         		<div class="form-group"> -->
			<%--                                     <label><spring:message code="admin.account.username" /></label> --%>
			<%--                                     <spring:message code="admin.account.username.input" var="intputUsername"/> --%>
			<%--                                     <c:choose> --%>
			<%-- 								    	<c:when test="${accountForm.command eq 'edit'}"> --%>
			<%-- 								        	<form:hidden path="username"/> --%>
			<%-- 								        	<input type="text" class="form-control"  value="${accountForm.username}" disabled="disabled"/> --%>
			<%-- 								        </c:when> --%>
			<%-- 								        <c:otherwise> --%>
			<%-- 								        	<form:input path = "username" class="form-control" placeholder="${intputUsername }"/>   --%>
			<%-- 								        </c:otherwise> --%>
			<%-- 							        </c:choose> --%>
			<!--                                 </div> -->
			<!--                                 <div class="form-group"> -->
			<%--                                     <label><spring:message code="admin.account.password" /></label> --%>
			<%--                                     <spring:message code="admin.account.password.input" var="intputPassword"/> --%>
			<%--                                     <form:input path = "password" class="form-control" placeholder="${intputPassword }"/> --%>
			<!--                                 </div> -->

			<!--                                  <div class="form-group"> -->
			<%--                                     <label><spring:message code="admin.account.role" /></label>           --%>
			<%--                                     <form:select path="role" class="form-control"> --%>
			<%-- <%-- 									   <form:option value="USER" label="User"/> --%> --%>
<%-- <%-- 									   <form:option value="ADMIN" label="Admin"/> --%> --%>
<%-- 									   <form:options items="${roleList}" /> --%>
			<%-- 									</form:select> --%>
			<!--                                 </div> -->
			<!-- 								<div class="form-group"> -->
			<%--                                 	<label><spring:message code="admin.account.enable" /><form:checkbox path = "active" class="form-control" /></label> --%>
			<!--                                 </div> -->
			<%--                                 <button type="submit" class="btn btn-default"><spring:message code="admin.account.save"/></button> --%>
			<%--                                 <a href="list.html" class="btn btn-default"><spring:message code="admin.account.list"/></a>                                 --%>
			<%--                         	</admin:form> --%>
			<!--                         </div> -->
			<!--                     </div> -->
			<!--                 </div> -->
			<!--            </div> -->
			<!--        	</div> -->
			<!--     	</div> -->
			<%--     </c:when> --%>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</admin:wrapper>
	<script>
		$(document).ready(function() {
			$('#account-dataTable').dataTable({
				stateSave : true
			});
		});
	</script>
</body>
</html>
