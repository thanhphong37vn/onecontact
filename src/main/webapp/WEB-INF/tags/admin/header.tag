<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="oa" tagdir="/WEB-INF/tags/admin" %>

<nav style="margin-bottom: 0" role="navigation" class="navbar navbar-default navbar-static-top">
    <div class="navbar-header">
        <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
            <span class="sr-only">Toggle navigation</span>
        </button>
        <a href="index.html" class="navbar-brand">OneContact Management</a>
    </div>
    <!-- /.navbar-header -->

	<oa:userinfo />
	<!-- /.navbar-top-links -->

	<oa:sidebar />			
	<!-- /.navbar-static-side -->

</nav>
