<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%--@elvariable id="model" type="com.github.emilg1101.marketplace.model.OrderModel"--%>
<%--@elvariable id="error" type="java.lang.String"--%>

<t:layout title="Order" id="order">

    <t:mainLayout id="order" loggedIn="true">

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                sumTotalPrice(${model.productPrice});
            }, false);
        </script>

        <div class="row justify-content-md-center">

            <div class="col-6 col-md-8 mb-4">

                <div class="card mt-4">

                    <h5 class="card-header">Order process</h5>

                    <div class="card-body">

                        <c:if test="${not empty error}">
                            <p>${error}</p>
                        </c:if>

                        <%--@elvariable id="orderForm" type="com.github.emilg1101.marketplace.model.form.OrderForm"--%>
                        <form:form method="POST" modelAttribute="orderForm">

                            <input type="hidden" value="${model.productId}" name="productId">

                            <table class="table">
                                <thead>
                                    <tr>
                                        <th colspan="6">Product</th>
                                        <th colspan="2">Price</th>
                                        <th colspan="1">Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="order-body">
                                        <td class="product-sets" colspan="6">
                                            <div class="product-left">
                                                <img src="${model.productImageURL}" alt="">
                                            </div>
                                            <div class="product-right">
                                                <a href="<c:url value="/product?id=${model.productId}"/>">
                                                    <p>${model.productTitle}</p>
                                                </a>
                                            </div>
                                        </td>
                                        <td class="order-price" colspan="2">
                                            <p>${model.productPrice} $</p>
                                        </td>
                                        <td class="order-quantity" colspan="1">
                                            <input type="number" name="quantity" min="1" max="10000" class="form-control mb-2 mr-sm-2" id="input-quantity" value="1">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

                            <div class="form-group">
                                <label for="inputState">Shipping Address</label>
                                <select name="addressId" id="inputState" class="form-control">
                                    <option value="0" selected>Choose address</option>
                                    <c:forEach var="item" items="${model.addresses}">
                                        <option value="${item.id}">${item.contactName}, ${item.mobile}, ${item.zip}, ${item.country}, ${item.state}, ${item.city}, ${item.streetAddressOne}, ${item.streetAddressTwo}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="row">
                                <div class="col-6 col-md-12">
                                    <p class="float-right">Total: <b><span id="total">11.11</span>$</b></p>
                                </div>
                            </div>

                            <button class="btn btn-primary float-right">Order</button>

                        </form:form>

                    </div>
                </div>
            </div>
        </div>

    </t:mainLayout>

</t:layout>
