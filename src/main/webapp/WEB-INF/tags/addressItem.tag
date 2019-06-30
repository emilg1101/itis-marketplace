<%@tag description="Address item for account page" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="model" required="true" type="com.github.emilg1101.marketplace.model.AddressItemModel" %>

<div class="col-6 col-md-4 mb-4">
    <div class="address-item">
        <i class="fa fa-user"></i>${model.contactName}
        <div class="d-inline">
            <p><i class="fas fa-map-marker-alt"></i></p>
            <ul class="list-group list-group-flush">
                <li>${model.streetAddressOne}</li>
                <li>${model.streetAddressTwo}</li>
                <li>${model.city}, ${model.state}, ${model.zip}</li>
                <li>${model.country}</li>
            </ul>
        </div>
        <i class="fa fa-phone"></i>${model.mobile}
        <span><a href="<c:url value="/address/edit?id=${model.id}"/>">Edit</a> | <a href="/">Delete</a></span>
    </div>
</div>
