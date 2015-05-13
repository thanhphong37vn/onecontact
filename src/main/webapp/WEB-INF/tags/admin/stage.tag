<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="oa" tagdir="/WEB-INF/tags/admin" %>

<%@ attribute name="titleKey" type="java.lang.String" required="true" description="" %>
<%@ attribute name="tooltipKey" type="java.lang.String" description="" %>

<div id="stage">
    <oa:header />
    <oa:title titleKey="${titleKey}" tooltipKey="${tooltipKey}" />
    <jsp:doBody />
    <oa:footer />
</div>


<div id="blanket"></div>
