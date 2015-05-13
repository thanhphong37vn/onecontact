<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="id" type="java.lang.String" required="true" description="form ID" %>
<%@ attribute name="method" type="java.lang.String" description="form method" %>
<%@ attribute name="action" type="java.lang.String" required="true" description="form action URL" %>
<%@ attribute name="enctype" type="java.lang.String" description="form enctype" %>
<%@ attribute name="modelAttribute" type="java.lang.String" required="true" description="Class name of the Bean to be bound to the form" %>
<%@ attribute name="onsubmit" type="java.lang.String" description="javascript function, which is set to run on Submit" %>

<c:if test="${empty pageScope.method}">
    <c:set var="method" value="get" />
</c:if>

<form:form id="${id}" action="${action}" method="${method}" enctype="${pageScope.enctype}"
        modelAttribute="${modelAttribute}" onsubmit="${onsubmit}">
<%--     <form:hidden path="offset" id="macssd_list_${id}_offset" /> --%>
<%--     <form:hidden path="size" id="macssd_list_${id}_size" /> --%>
<%--     <form:hidden path="sortKey" id="macssd_list_${id}_sortKey" /> --%>
<%--     <form:hidden path="sortDir" id="macssd_list_${id}_sortDir" /> --%>
    <jsp:doBody />
</form:form>
