<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%--@elvariable id="model" type="com.github.emilg1101.marketplace.model.AddressModel"--%>
<%--@elvariable id="action" type="java.lang.String"--%>
<%--@elvariable id="error" type="java.lang.String"--%>

<t:layout title="Shipping address" id="address">

    <t:mainLayout id="address" loggedIn="true">

        <div class="row justify-content-md-center">

            <div class="col-6 col-md-8 mb-4">

                <div class="card mt-4">

                    <c:if test="${action=='add'}">
                        <h5 class="card-header">Add Shipping address</h5>
                    </c:if>
                    <c:if test="${action=='edit'}">
                        <h5 class="card-header">Edit Shipping address</h5>
                    </c:if>

                    <div class="card-body">

                        <c:if test="${not empty error}">
                            <p>${error}</p>
                        </c:if>

                        <%--@elvariable id="addressForm" type="com.github.emilg1101.marketplace.model.form.AddressForm"--%>
                        <form:form method="POST" modelAttribute="addressForm">
                            <input type="hidden" name="id" value="${addressForm.id}">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="name">Contact name</label>
                                    <input type="text" class="form-control" name="name" id="name" placeholder="Ivanov Ivan Ivanovich" value="${addressForm.name}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="phone">Phone</label>
                                    <input type="text" class="form-control" name="phone" id="phone" placeholder="+7 XXX XXX XX XX" value="${addressForm.phone}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" name="address" id="address" placeholder="1234 Main St" value="${addressForm.address}">
                            </div>
                            <div class="form-group">
                                <label for="address2">Address 2</label>
                                <input type="text" class="form-control" name="address2" id="address2" placeholder="Apartment, studio, or floor" value="${addressForm.address2}">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="city">City</label>
                                    <input type="text" class="form-control" name="city" id="city" value="${addressForm.city}">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="state">State</label>
                                    <input type="text" class="form-control" name="state" id="state" value="${addressForm.state}">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="zip">Zip</label>
                                    <input type="text" class="form-control" name="zip" id="zip" value="${addressForm.zip}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="country">Country</label>
                                <input type="text" class="form-control" name="country" id="country" value="${addressForm.country}">
                            </div>
                            <c:if test="${action=='add'}">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </c:if>
                            <c:if test="${action=='edit'}">
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </c:if>

                        </form:form>

                    </div>

                </div>

            </div>

        </div>

    </t:mainLayout>

</t:layout>
