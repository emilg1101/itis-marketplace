<%@tag description="Product item for homepage" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="product" required="true" type="com.github.emilg1101.marketplace.model.ProductItemModel" %>

<div class="col-lg-4 col-md-6 mb-4">
    <div class="card h-100">
        <a href="<c:url value="/product?id=${product.id}"/>"><img class="card-img-top" src="${product.imageURL}" alt=""></a>
        <div class="card-body">
            <h4 class="card-title">
                <a href="#">${product.title}</a>
            </h4>
            <h5>$${product.price}</h5>
            <p class="card-text">${product.description}</p>
        </div>
        <div class="card-footer">
            <%--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>--%>
                <button class="btn"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</button>
        </div>
    </div>
</div>
