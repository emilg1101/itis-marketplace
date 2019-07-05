<%@tag description="Review item for account page" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="model" required="true" type="com.github.emilg1101.marketplace.model.account.ReviewItemModel" %>

<tbody class="review-item-wrapper">
    <tr class="review-head">
        <td class="review-info" colspan="4">
            <p>
                <span>Review time: </span>
                <span>${model.reviewTime}</span>
            </p>
        </td>
    </tr>
    <tr class="review-body">
        <td class="product-sets">
            <div class="product-left">
                <img src="${model.productImageURL}" alt="">
            </div>
            <div class="product-right">
                <a href="<c:url value="/product?id=${model.productId}"/>">
                    <p>${model.productTitle}</p>
                </a>
            </div>
        </td>
        <td colspan="2">
            <p>${model.text}</p>
        </td>
        <td class="review-action">
            <a href="<c:url value="/review/delete?id=${model.id}"/>">
                <button class="btn btn-danger">Delete</button>
            </a>
        </td>
    </tr>
</tbody>
