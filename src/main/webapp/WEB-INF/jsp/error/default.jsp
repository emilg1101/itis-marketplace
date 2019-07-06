<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%--@elvariable id="url" type="java.lang.String"--%>
<%--@elvariable id="exception" type="java.lang.Exception"--%>

<t:layout title="Error" id="error">

    <div class="row justify-content-md-center">

        <div class="col-6 col-md-8 mb-4">
            <h1>Exception</h1>
            <h2>Failed URL: ${url}</h2>
            <h3>Exception: ${exception.message}</h3>
            <c:forEach items="${exception.stackTrace}" var="ste">
                ${ste}<br>
            </c:forEach>
        </div>

    </div>

</t:layout>
