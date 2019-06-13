<%@tag description="Form Button" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="id" required="true" type="java.lang.String" %>
<%@attribute name="style" required="false" type="java.lang.String" %>
<%@attribute name="text" required="false" type="java.lang.String" %>
<%@attribute name="submit" required="false" type="java.lang.Boolean" %>

<button class="btn btn-${style.length() > 0 ? style : 'primary'}" id="${id}" <c:if test="${submit}">type="submit"</c:if>>${text}</button>