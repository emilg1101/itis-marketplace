<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<t:layout title="Sign In" id="signin">

    <t:authLayout>

        <div class="login-form">

            <%--@elvariable id="signinForm" type="com.github.emilg1101.marketplace.model.form.SigninForm"--%>
            <form:form method="POST" modelAttribute="signinForm">

                <h2>Log in</h2>
                <hr>

                <c:if test="${not empty error}">
                    <p>${error}</p>
                </c:if>

                <t:input id="email" type="text" placeholder="E-mail" val="${signinForm.email}"/>
                <t:input id="password" type="password" placeholder="Password" val="${signinForm.password}"/>
                <div class="clearfix">
                    <label class="pull-left checkbox-inline">
                        <input type="checkbox" name="remember" id="remember">Remember me
                    </label>
                </div>
                <t:button id="submit" text="Sign In" submit="true"/>

            </form:form>

            <p class="text-center">
                <a href="<c:url value="/register"/>">Create an Account</a>
            </p>

        </div>

    </t:authLayout>

</t:layout>
