<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="css" type="java.lang.String" description="" %>
<%@ attribute name="js" type="java.lang.String" description="" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />

<!--[if IE]><link/><![endif]-->
<link rel="stylesheet" type="text/css" href="${contextPath}/globalcss/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/globalcss/plugins/metisMenu/metisMenu.min.css" />

<link rel="stylesheet" type="text/css" href="${contextPath}/globalcss/plugins/dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/globalcss/admin.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/font-awesome-4.1.0/css/font-awesome.min.css" />

<c:forTokens items="${css}" var="file" delims=",">
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/${fn:trim(file)}" />
</c:forTokens>

<script type="text/javascript" src="${contextPath}/globaljs/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${contextPath}/globaljs/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/globaljs/plugins/metisMenu/metisMenu.min.js"></script>
<script type="text/javascript" src="${contextPath}/globaljs/plugins/dataTables/jquery.dataTables.js"></script>
<script type="text/javascript" src="${contextPath}/globaljs/plugins/dataTables/dataTables.min.js"></script>
<script type="text/javascript" src="${contextPath}/globaljs/admin.js"></script>

<c:forTokens items="${js}" var="file" delims=",">
    <script type="text/javascript" src="${contextPath}/js/${fn:trim(file)}"></script>
</c:forTokens>
