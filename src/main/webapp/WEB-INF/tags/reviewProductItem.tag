<%@tag description="Review item for account page" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="model" required="true" type="com.github.emilg1101.marketplace.model.ReviewItemModel" %>

<p>${model.text}</p>
<small class="text-muted">Posted by ${model.author} on ${model.reviewTime}</small>
<hr>
