<%@tag description="Order item for homepage" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="order" required="true" type="com.github.emilg1101.marketplace.model.account.OrderItemModel" %>

<tbody class="order-item-wrapper">
    <tr class="order-head">
        <td class="order-info" colspan="3">
            <p>
                <span>Order №: </span>
                <span>${order.id}</span>
            </p>
            <p>
                <span>Order time: </span>
                <span>${order.orderTime}</span>
            </p>
        </td>
        <td class="order-amount" colspan="1">
            <p>
                <span>Amount: </span>
                <span>${order.amount}$</span>
            </p>
        </td>
    </tr>
    <tr class="order-body">
        <td class="product-sets" colspan="2">
            <div class="product-left">
                <img src="${order.productImageURL}" alt="">
            </div>
            <div class="product-right">
                <a href="<c:url value="/product?id=${order.productId}"/>">
                    <p>${order.productTitle}</p>
                </a>
                <p>${order.productPrice}$ x ${order.productQuantity}</p>
            </div>
        </td>
        <td class="order-status">
            <p>${order.status}</p>
        </td>
        <td class="order-action">
            <c:if test="${order.status != 'canceled'}">
                <a href="<c:url value="/order/cancel?id=${order.id}"/>">
                    <button class="btn btn-danger">Cancel</button>
                </a>
            </c:if>
        </td>
    </tr>
</tbody>