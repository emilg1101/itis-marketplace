<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="title" required="false" %>
<%@attribute name="id" required="false" type="java.lang.String" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <c:if test="${not empty title}">${title} - </c:if>Marketplace
        </title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/css/style.css" />" rel="stylesheet">
        <link href="<c:url value="/css/${id}.css" />" rel="stylesheet">
    </head>
    <body>

        <jsp:doBody/>

        <script type="text/javascript" src="<c:url value="/js/jquery-3.4.1.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/bootstrap.bundle.min.js" />"></script>

    </body>
</html>