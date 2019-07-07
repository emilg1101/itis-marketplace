<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%--@elvariable id="model" type="com.github.emilg1101.marketplace.model.account.AccountModel"--%>
<%--@elvariable id="tab" type="java.lang.String"--%>

<t:layout title="Account" id="account">

    <t:mainLayout id="account" loggedIn="true">

        <div class="row">

            <div class="col-6 col-md-3 mb-4">
                <div class="card mt-4">
                    <img class="card-img-top" src="/img/profile.png" alt="Card image cap">
                    <div class="card-body">
                        <ul class="list-unstyled">
                            <li><b>Name:</b></li>
                            <li>${model.username}</li>
                            <li><b>E-mail:</b></li>
                            <li>${model.email}</li>
                            <li><b>Orders:</b></li>
                            <li>${model.orders.size()}</li>
                            <li><b>Reviews:</b></li>
                            <li>${model.reviews.size()}</li>
                            <li><b>Registered at:</b></li>
                            <li>${model.registeredAt}</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-12 col-md-9 mb-4">
                <div class="card mt-4">
                    <div class="card-header">
                        <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link <c:if test="${tab == 'orders'}">active</c:if>" id="home-tab" data-toggle="tab" href="#orders" role="tab" aria-controls="orders" aria-selected="true">Orders</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link <c:if test="${tab == 'reviews'}">active</c:if>" id="profile-tab" data-toggle="tab" href="#reviews" role="tab" aria-controls="reviews" aria-selected="false">Reviews</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link <c:if test="${tab == 'address'}">active</c:if>" id="contact-tab" data-toggle="tab" href="#address" role="tab" aria-controls="address" aria-selected="false">Address</a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade <c:if test="${tab == 'orders'}">show active</c:if>" id="orders" role="tabpanel" aria-labelledby="nav-home-tab">

                                <c:if test="${empty model.orders}">
                                    <p>No orders!</p>
                                </c:if>
                                <c:if test="${!empty model.orders}">
                                    <table class="table table-striped order-table">

                                        <thead>
                                            <tr class="product-table-title">
                                                <th colspan="2">Product</th>
                                                <th>Order status</th>
                                                <th>Order action</th>
                                            </tr>
                                        </thead>

                                        <c:forEach var="order" items="${model.orders}">
                                            <t:orderItem order="${order}"/>
                                        </c:forEach>

                                    </table>
                                </c:if>

                            </div>
                            <div class="tab-pane fade <c:if test="${tab == 'reviews'}">show active</c:if>" id="reviews" role="tabpanel" aria-labelledby="nav-profile-tab">

                                <c:if test="${empty model.reviews}">
                                    <p>No reviews!</p>
                                </c:if>
                                <c:if test="${!empty model.reviews}">
                                    <table class="table table-striped review-table">

                                        <thead>
                                            <tr class="product-table-title">
                                                <th>Product</th>
                                                <th colspan="2">Review</th>
                                                <th>Review action</th>
                                            </tr>
                                        </thead>

                                        <c:forEach var="review" items="${model.reviews}">
                                            <t:reviewItem model="${review}"/>
                                        </c:forEach>

                                    </table>
                                </c:if>

                            </div>
                            <div class="tab-pane fade <c:if test="${tab == 'address'}">show active</c:if>" id="address" role="tabpanel" aria-labelledby="nav-contact-tab">

                                <div class="row">

                                    <div class="col-6 col-md-12 mb-4">
                                        <a href="/address/add"><button class="btn btn-primary">Add address</button></a>
                                    </div>

                                    <c:if test="${empty model.addresses}">
                                        <div class="col-6 col-md-12 mb-4">
                                            <p>Empty!</p>
                                        </div>
                                    </c:if>
                                    <c:if test="${!empty model.addresses}">
                                        <c:forEach var="address" items="${model.addresses}">
                                            <t:addressItem model="${address}"/>
                                        </c:forEach>
                                    </c:if>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </t:mainLayout>

</t:layout>
