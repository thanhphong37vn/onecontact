<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="fck"%>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<admin:importstyles />
<style type="text/css">
table {
	table-layout: auto;
	width: 100px;
}

.filterable {
	margin-top: 15px;
}

.filterable .panel-heading .pull-right {
	margin-top: -20px;
}

/* .filterable .filters input[disabled] { */
/* 	background-color: transparent; */
/* 	border: none; */
/* 	cursor: auto; */
/* 	box-shadow: none; */
/* 	padding: 0; */
/* 	height: auto; */
/* } */
.filterable .filters input[disabled]::-webkit-input-placeholder {
	color: #333;
}

.filterable .filters input[disabled]::-moz-placeholder {
	color: #333;
}

.filterable .filters input[disabled]:-ms-input-placeholder {
	color: #333;
}
</style>

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

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="container">
						<!-- /.panel-heading -->
						<div class="row">
							<div class="panel-body">
								<div class="panel panel-primary filterable">
									<div class="panel-heading">
										<h3 class="panel-title">Users</h3>
										<br />
										<!-- 										<div class="pull-left"> -->
										<button class="btn btn-default btn-xs btn-filter">
											<span class="glyphicon glyphicon-filter">Filter</span>
										</button>
										<!-- 										</div> -->
									</div>
									<table class="table">
										<thead>
											<tr class="filters">
												<spring:message code="pass.employee.employeeName"
													var="varemployeeName" />
												<spring:message code="pass.employee.employeeNo"
													var="varEmployeeNo" />
												<spring:message code="pass.employee.employeePwd"
													var="varEmployeePwd" />
												<spring:message code="pass.employee.employeeStatus"
													var="varEmployeeStatus" />
												<spring:message code="pass.employee.mobilePhone"
													var="varMobilePhone" />
												<spring:message code="pass.employee.regDateEmp"
													var="varRegDateEmp" />
												<spring:message code="pass.employee.unregDateEmp"
													var="varUnregDateEmp" />

												<spring:message code="pass.company.companyName"
													var="varCompanyName" />
												<spring:message code="pass.company.companyMobile"
													var="varCompanyMobile" />
												<spring:message code="pass.company.companyPwd"
													var="varCompanyPwd" />
												<spring:message code="pass.company.companyStatus"
													var="varCompanyStatus" />
												<spring:message code="pass.company.regDateComp"
													var="varRegDateComp" />
												<spring:message code="pass.company.unregDateComp"
													var="varUnregDateComp" />

												<th><input type="text" class="form-control"
													placeholder="#"></th>
												<th><input type="text" class="form-control"
													placeholder="${varemployeeName}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varMobilePhone}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varEmployeePwd}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varEmployeeNo}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varEmployeeStatus}"></th>

												<th><input type="text" class="form-control"
													placeholder="${varRegDateEmp}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varUnregDateEmp}"></th>

												<th><input type="text" class="form-control"
													placeholder="${varCompanyName}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varCompanyMobile}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varCompanyPwd}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varCompanyStatus}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varRegDateComp}"></th>
												<th><input type="text" class="form-control"
													placeholder="${varUnregDateComp}"></th>
												<!-- 											<th>&nbsp</th> -->
											</tr>
										</thead>
										<tbody>
											<%-- 								<c:out value="${listDto.size}"></c:out> --%>
											<c:if test="${not empty listDto}">
												<c:forEach items="${listDto}" var="entity" varStatus="index">
													<tr class="odd gradeX">
														<!-- 													<tr> -->
														<td><c:out value="${index.count}" /></td>
														<td><c:out value="${entity.employeeName }" /></td>
														<td><c:out value="${entity.mobilePhone}" /></td>
														<td><c:out value="${entity.employeePwd}" /></td>
														<td><c:out value="${entity.employeeNo}" /></td>
														<td><c:if test="${entity.employeeStatus==1}">
																<c:out value="On" />
															</c:if> <c:if test="${entity.employeeStatus!=1}">
																<c:out value="Off" />
															</c:if></td>



														<td><fmt:formatDate pattern="yyyy-MM-dd"
																value="${entity.regDateEmp}" /></td>
														<td><fmt:formatDate pattern="yyyy-MM-dd"
																value="${entity.unregDateEmp}" /></td>

														<td><c:out value="${entity.companyName}" /></td>
														<td><c:out value="${entity.companyMobile}" /></td>
														<td><c:out value="${entity.companyPwd}" /></td>
														<td><c:if test="${entity.companyStatus==1}">
																<c:out value="On" />
															</c:if> <c:if test="${entity.companyStatus!=1}">
																<c:out value="Off" />
															</c:if></td>
														<td class="center"><fmt:formatDate
																pattern="yyyy-MM-dd" value="${entity.regDateComp}" /></td>
														<td class="center"><fmt:formatDate
																pattern="yyyy-MM-dd" value="${entity.unregDateComp}" /></td>
														<!-- 														<td><a -->
														<%-- 															href="edit-<c:out value='${entity.employeeId}' />.html" --%>
														<!-- 															class="btn btn-outline btn-warning btn-sm"> -->
														<%-- 															<spring:message --%>
														<%-- 																	code="admin.account.edit" /></a></td> --%>
													</tr>
												</c:forEach>
											</c:if>
										</tbody>
									</table>

									<!-- /.table-responsive -->

								</div>
								<!-- /.panel-body -->
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</admin:wrapper>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							// 							$('#account-dataTable').dataTable({
							// 								stateSave : true
							// 							});
							$('.filterable .btn-filter')
									.click(
											function() {
												var $panel = $(this).parents(
														'.filterable'), $filters = $panel
														.find('.filters input'), $tbody = $panel
														.find('.table tbody');
												if ($filters.prop('disabled') == true) {
													$filters.prop('disabled',
															false);
													$filters.first().focus();
												} else {
													$filters.val('').prop(
															'disabled', true);
													$tbody.find('.no-result')
															.remove();
													$tbody.find('tr').show();
												}
											});

							$('.filterable .filters input')
									.keyup(
											function(e) {
												/* Ignore tab key */
												var code = e.keyCode || e.which;
												if (code == '9')
													return;
												/* Useful DOM data and selectors */
												var $input = $(this), inputContent = $input
														.val().toLowerCase(), $panel = $input
														.parents('.filterable'), column = $panel
														.find('.filters th')
														.index(
																$input
																		.parents('th')), $table = $panel
														.find('.table'), $rows = $table
														.find('tbody tr');
												/* Dirtiest filter function ever ;) */
												var $filteredRows = $rows
														.filter(function() {
															var value = $(this)
																	.find('td')
																	.eq(column)
																	.text()
																	.toLowerCase();
															return value
																	.indexOf(inputContent) === -1;
														});
												/* Clean previous no-result if exist */
												$table.find('tbody .no-result')
														.remove();
												/* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
												$rows.show();
												$filteredRows.hide();
												/* Prepend no-result row if all rows are filtered */
												if ($filteredRows.length === $rows.length) {
													$table
															.find('tbody')
															.prepend(
																	$('<tr class="no-result text-center"><td colspan="'
																			+ $table
																					.find('.filters th').length
																			+ '">No result found</td>
													</tr>'));
												}
											});
						});
	</script>
</body>
</html>
