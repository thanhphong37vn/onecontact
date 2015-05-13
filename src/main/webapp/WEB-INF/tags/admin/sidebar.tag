<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authentication property="principal.administrator"
	var="administrator" />
<div role="navigation" class="navbar-default sidebar">
	<div class="sidebar-nav navbar-collapse">
		<ul id="side-menu" class="nav">
			<li><a href="${contextPath}/intro.html"><i
					class="fa fa-dashboard fa-fw"></i> Home One Contact</a></li>
			<li>
				<ul class="nav nav-second-level collapse">
					<li>&nbsp</li>
				</ul>
			</li>
			<li>
				<ul class="nav nav-second-level collapse">
					<li>&nbsp</li>
				</ul>
			</li>
			<c:choose>
				<c:when test="${administrator}">
					<li><a href="${contextPath}/admin/account/list.html"><i
							class="fa fa-dashboard fa-fw"></i> Account</a></li>
					<li>
						<ul class="nav nav-second-level collapse">
							<li>&nbsp</li>
						</ul>
					</li>
				</c:when>
			</c:choose>
			<li><a href="${contextPath}/admin/news/list.html"><i
					class="fa fa-edit fa-fw"></i> <spring:message code="admin.news" />
			</a></li>
			<li>
				<ul class="nav nav-second-level collapse">
					<li>&nbsp</li>
				</ul>
			</li>
			<li>
				<ul class="nav nav-second-level collapse">
					<li>&nbsp</li>
				</ul>
			</li>
			<li>
				<ul class="nav nav-second-level collapse">
					<li>&nbsp</li>
				</ul>
			</li>
			<li><a href="${contextPath}/admin/news/intro.html"><i
					class="fa fa-edit fa-fw"></i> <spring:message code="admin.intro" /></a>
			</li>
			<li><a href="${contextPath}/admin/news/guide.html"><i
					class="fa fa-edit fa-fw"></i> <spring:message code="admin.guide" /></a>
			</li>
			<li><a href="${contextPath}/admin/news/contact.html"><i
					class="fa fa-edit fa-fw"></i> <spring:message code="admin.contact" /></a>
			</li>
			<li>
				<ul class="nav nav-second-level collapse">
					<li>&nbsp</li>
				</ul>
			</li>
			<li>
				<ul class="nav nav-second-level collapse">
					<li>&nbsp</li>
				</ul>
			</li>
			<li><a href="${contextPath}/admin/tag/list.html"><i
					class="fa fa-edit fa-fw"></i> <spring:message code="admin.tag" /></a>
			</li>
		</ul>
	</div>
</div>
