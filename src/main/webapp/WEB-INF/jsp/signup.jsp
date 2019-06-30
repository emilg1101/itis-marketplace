<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<t:layout title="Sign Up" id="signup">

    <t:authLayout>

        <div class="signup-form">

            <%--@elvariable id="registrationForm" type="com.github.emilg1101.marketplace.model.form.RegistrationForm"--%>
            <form:form method="POST" modelAttribute="registrationForm">

                <h2>Sign Up</h2>
                <p>Please fill in this form to create an account!</p>
                <hr>

                <c:if test="${not empty error}">
                    <p>${error}</p>
                </c:if>

                <t:input id="email" type="text" placeholder="E-mail" val="${registrationForm.email}"/>
                <t:input id="name" type="text" placeholder="Name" val="${registrationForm.name}"/>
                <t:input id="password" type="password" placeholder="Password"/>
                <t:input id="confirmPassword" type="password" placeholder="Confirm Password"/>
                <t:button id="submit" text="Sign Up" submit="true"/>

            </form:form>

            <div class="text-center">Already have an account? <a href="<c:url value="/login"/>">Login here</a></div>

        </div>

    </t:authLayout>

</t:layout>
