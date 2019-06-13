<%@tag description="Form Checkbox" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="id" required="true" type="java.lang.String" %>
<%@attribute name="group" required="false" type="java.lang.String" %>
<%@attribute name="checked" required="false" type="java.lang.Boolean" %>

<div class="form-group">
    <label class="checkbox-inline">
        <input class="form-check-input" id="${id}" name="${group.length() > 0 ? group : id}" type="checkbox" value="" ${checked? "checked" : ""}>
        <jsp:doBody/>
    </label>
</div>