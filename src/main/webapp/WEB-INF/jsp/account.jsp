<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%--@elvariable id="model" type="com.github.emilg1101.marketplace.model.AccountModel"--%>

<t:layout title="Account" id="account">

    <t:mainLayout id="account" loggedIn="true">

        <div class="row">

            <div class="col-6 col-md-3 mb-4">
                <div class="card mt-4">
                    <img class="card-img-top" src="http://placehold.it/700x400" alt="Card image cap">
                    <div class="card-body">
                    </div>
                </div>
            </div>

            <div class="col-12 col-md-9 mb-4">
                <div class="card mt-4">
                    <div class="card-header">
                        <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#orders" role="tab" aria-controls="orders" aria-selected="true">Orders</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#reviews" role="tab" aria-controls="reviews" aria-selected="false">Reviews</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="contact-tab" data-toggle="tab" href="#address" role="tab" aria-controls="address" aria-selected="false">Address</a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="orders" role="tabpanel" aria-labelledby="nav-home-tab">

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
                            <div class="tab-pane fade" id="reviews" role="tabpanel" aria-labelledby="nav-profile-tab">
                                Nulla est ullamco ut irure incididunt nulla Lorem Lorem minim irure officia enim
                                reprehenderit. Magna duis labore cillum sint adipisicing exercitation ipsum. Nostrud ut
                                anim
                                non exercitation velit laboris fugiat cupidatat. Commodo esse dolore fugiat sint velit
                                ullamco magna consequat voluptate minim amet aliquip ipsum aute laboris nisi. Labore
                                labore
                                veniam irure irure ipsum pariatur mollit magna in cupidatat dolore magna irure esse
                                tempor
                                ad mollit. Dolore commodo nulla minim amet ipsum officia consectetur amet ullamco
                                voluptate
                                nisi commodo ea sit eu.
                            </div>
                            <div class="tab-pane fade" id="address" role="tabpanel" aria-labelledby="nav-contact-tab">
                                Sint sit mollit irure quis est nostrud cillum consequat Lorem esse do quis dolor esse
                                fugiat
                                sunt do. Eu ex commodo veniam Lorem aliquip laborum occaecat qui Lorem esse mollit
                                dolore
                                anim cupidatat. Deserunt officia id Lorem nostrud aute id commodo elit eiusmod enim
                                irure
                                amet eiusmod qui reprehenderit nostrud tempor. Fugiat ipsum excepteur in aliqua non et
                                quis
                                aliquip ad irure in labore cillum elit enim. Consequat aliquip incididunt ipsum et minim
                                laborum laborum laborum et cillum labore. Deserunt adipisicing cillum id nulla minim
                                nostrud
                                labore eiusmod et amet. Laboris consequat consequat commodo non ut non aliquip
                                reprehenderit
                                nulla anim occaecat. Sunt sit ullamco reprehenderit irure ea ullamco Lorem aute nostrud
                                magna.
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </t:mainLayout>

</t:layout>
