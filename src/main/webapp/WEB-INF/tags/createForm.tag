<%@ tag body-content="empty"%>
<%@ attribute name="option" required="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<div class="container">
    <form action="/${option}/edit.html" method="POST" id="filterForm" name="filterForm" role="form">
        <div class="form-group col-xs-5">
            <input type="hidden" name="option" value ="${option}">
            <button type="submit" class="btn btn-primary  btn-md" name="action" value ="add"><fmt:message key="create" bundle="${content}"/></button>
        </div>
    </form>
</div>
<div class="alert alert-info">
    <fmt:message key="${option}_not_found" bundle="${content}"/>
</div>
