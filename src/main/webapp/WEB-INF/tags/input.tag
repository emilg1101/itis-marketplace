<%@tag description="Form Input" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="id" required="true" type="java.lang.String" %>
<%@attribute name="placeholder" required="false" type="java.lang.String" %>
<%@attribute name="type" required="false" type="java.lang.String" %>
<%@attribute name="val" required="false" type="java.lang.String" %>
<%@attribute name="label" required="false" type="java.lang.String" %>

<div class="input-group">
    <c:if test="${label.length() > 0}">
        <label>${label}</label>
    </c:if>
    <c:if test="${type == 'textarea'}">
        <textarea value="${val.length() > 0 ? val : ''}" class="form-control" placeholder="${placeholder}" name="${id}" id="${id}"></textarea>
    </c:if>
    <c:if test="${type != 'textarea'}">
        <input type="${type.length() > 0 ? type : 'text'}" value="${val.length() > 0 ? val : ''}" class="form-control" placeholder="${placeholder}" name="${id}" id="${id}">
    </c:if>
</div>