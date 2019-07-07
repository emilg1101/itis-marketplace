<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="loggedIn" type="java.lang.Boolean" %>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="">Marketplace</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <t:navItem id="home" title="Home" link="/" selected="${id}"/>
                <c:if test="${!loggedIn}">
                    <t:navItem id="signin" title="Sign In" link="/login" selected="${id}"/>
                    <t:navItem id="signup" title="Sign Up" link="/register" selected="${id}"/>
                </c:if>
                <c:if test="${loggedIn}">
                    <t:navItem id="account" title="Account" link="/account" selected="${id}"/>
                    <t:navItem id="logout" title="Log Out" link="/logout" selected="${id}"/>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <jsp:doBody/>

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
</footer>
