<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%--@elvariable id="model" type="com.github.emilg1101.marketplace.model.ProductModel"--%>

<t:layout title="${model.title}">

    <t:mainLayout loggedIn="${model.loggedIn}">

        <div class="row">

            <div class="col-lg-3">
                <h1 class="my-4">Shop Name</h1>
                <div class="list-group">
                    <a href="#" class="list-group-item active">Category 1</a>
                    <a href="#" class="list-group-item">Category 2</a>
                    <a href="#" class="list-group-item">Category 3</a>
                </div>
            </div>
            <!-- /.col-lg-3 -->

            <div class="col-lg-9">

                <div class="card mt-4">
                    <img class="card-img-top img-fluid" src="${model.imageURL}" alt="">
                    <div class="card-body">
                        <h3 class="card-title">${model.title}</h3>
                        <h4>$${model.price}</h4>
                        <p class="card-text">${model.description}</p>
                        <c:if test="${model.loggedIn}">
                            <a href="<c:url value="/order?product_id=${model.id}"/>">
                                <button class="btn"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</button>
                            </a>
                        </c:if>
                    </div>
                </div>
                <!-- /.card -->

                <div class="card card-outline-secondary my-4">
                    <div class="card-header">
                        Product Reviews
                    </div>
                    <div class="card-body">
                        <c:if test="${empty model.reviews}">
                            <p>No reviews!</p>
                        </c:if>
                        <c:if test="${!empty model.reviews}">

                            <c:forEach var="review" items="${model.reviews}">
                                <t:reviewProductItem model="${review}"/>
                            </c:forEach>

                        </c:if>

                        <c:if test="${model.loggedIn}">
                            <%--@elvariable id="reviewForm" type="com.github.emilg1101.marketplace.model.form.ReviewForm"--%>
                            <form:form method="post" modelAttribute="reviewForm" action="/review/add">

                                <div class="form-row">

                                    <input type="hidden" name="productId" value="${model.id}">
                                    <div class="col-7">
                                        <input type="text" class="form-control" id="text" name="text" placeholder="Review">
                                    </div>
                                    <div class="col">
                                        <button type="submit" class="btn btn-success">Leave a Review</button>
                                    </div>

                                </div>

                            </form:form>

                        </c:if>
                    </div>
                </div>
                <!-- /.card -->

            </div>
            <!-- /.col-lg-9 -->

        </div>

    </t:mainLayout>

</t:layout>
