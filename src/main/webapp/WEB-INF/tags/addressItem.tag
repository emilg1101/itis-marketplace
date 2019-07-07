<%@tag description="Address item for account page" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="model" required="true" type="com.github.emilg1101.marketplace.model.AddressItemModel" %>

<div class="col-6 col-md-4 mb-4">
    <div class="address-item">
        <span><i class="fa fa-user"></i>&nbsp${model.contactName}</span><br>
        <div class="d-inline">
            <div class="float-left w-auto">
                <i class="fas fa-map-marker-alt"></i>&nbsp
            </div>
            <div class="float-left w-75">
                <ul class="list-unstyled">
                    <li>${model.streetAddressOne}</li>
                    <li>${model.streetAddressTwo}</li>
                    <li>${model.city}, ${model.state}, ${model.zip}</li>
                    <li>${model.country}</li>
                </ul>
            </div>
        </div>
        <div class="float-left w-100">
            <span><i class="fa fa-phone"></i>&nbsp${model.mobile}</span>
        </div>
        <br>
        <div class="float-left">
            <span><a href="<c:url value="/address/edit?id=${model.id}"/>">Edit</a> | <a href="<c:url value="/address/delete?id=${model.id}"/>">Delete</a></span>
        </div>
    </div>
</div>
