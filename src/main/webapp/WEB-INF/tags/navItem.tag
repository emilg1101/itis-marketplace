<%@tag description="Navifgation item" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="id" required="true" type="java.lang.String" %>
<%@attribute name="title" required="true" type="java.lang.String" %>
<%@attribute name="link" required="true" type="java.lang.String" %>
<%@attribute name="selected" required="true" type="java.lang.String" %>

<li class="nav-item<c:if test="${id == selected}"> active</c:if>">
    <a class="nav-link" href="<c:url value="${link}"/>">${title}
        <span class="sr-only">(current)</span>
    </a>
</li>