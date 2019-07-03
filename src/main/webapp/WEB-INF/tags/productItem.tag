<%@tag description="Product item for homepage" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="product" required="true" type="com.github.emilg1101.marketplace.model.ProductItemModel" %>
<%@attribute name="loggedIn" required="true" type="java.lang.Boolean" %>

<div class="col-lg-4 col-md-6 mb-4">
    <div class="card h-100">
        <a href="<c:url value="/product?id=${product.id}"/>"><img class="card-img-top" src="${product.imageURL}" alt=""></a>
        <div class="card-body">
            <h4 class="card-title">
                <a href="<c:url value="/product?id=${product.id}"/>">${product.title}</a>
            </h4>
            <h5>$${product.price}</h5>
            <p class="card-text">${product.description}</p>
        </div>
        <c:if test="${loggedIn}">
            <div class="card-footer">
                <a href="<c:url value="/order?product_id=${product.id}"/>">
                    <button class="btn"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</button>
                </a>
            </div>
        </c:if>
    </div>
</div>
