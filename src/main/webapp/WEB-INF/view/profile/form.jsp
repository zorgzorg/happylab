<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="profile" bundle="${content}"/></h2>
<h3><fmt:message key="hello" bundle="${content}"/>, ${user.name}</h3>
<div class="container">
    <form action="/profile/edit.html" method="post" role="form">
        <div class="form-group col-xs-5">
            <label for="name" class="control-label col-xs-5"><fmt:message key="name" bundle="${content}"/></label>
            <p>${data.name}</p>
            <label for="username" class="control-label col-xs-5"><fmt:message key="username" bundle="${content}"/></label>
            <p>${data.username}</p>
            <label for="email" class="control-label col-xs-5"><fmt:message key="email" bundle="${content}"/></label>
            <p>${data.email}</p>
            <br />
            <button class="btn btn-primary btn-md" type="submit" value="edit" name="action"><fmt:message key="edit" bundle="${content}"/></button>
            <input type="hidden" name="option" value ="profile">
            <input type="hidden" name="userId" value="${user.id}"/>
        </div>
    </form>
</div>
<t:footer />