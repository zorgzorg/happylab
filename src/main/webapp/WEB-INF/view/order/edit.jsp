<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="order" bundle="${content}"/></h2>
<div class="container">
    <form action="/order/form.html" method="post" role="form" data-toggle="validator" id="editForm">
        <div class="form-group col-xs-5">
            <label for="number" class="control-label col-xs-5"><fmt:message key="order_number" bundle="${content}"/></label>
            <input type="number" name="number" id="number" class="form-control" value="${data.number}" min="1" required autofocus/>

            <label for="customer" class="control-label col-xs-5"><fmt:message key="customer" bundle="${content}"/></label>
            <select name="customerId" id="customerId" class="form-control" required>
                <option value="" selected>--<fmt:message key="choose_customer" bundle="${content}"/>--</option>
                <c:forEach var="customer" items="${data.customers}">
                    <c:choose>
                        <c:when test="${customer.id==data.customerId}">
                            <option value="${customer.id}" selected>${customer.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${customer.id}">${customer.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>

            <label for="date" class="control-label col-xs-5"><fmt:message key="date" bundle="${content}"/></label>
            <fmt:formatDate var="dateFmt" dateStyle = "short" value = "${data.date}"/>
            <input type="text" name="date" id="date" class="form-control" value="${dateFmt}" placeholder="<fmt:message key='date_placeholder' bundle='${content}'/>" required="true"/>

            <label for="remark" class="control-label col-xs-5"><fmt:message key="remark" bundle="${content}"/></label>
            <textarea name="remark" id="remark" cols="50" rows="5" class="form-control">${data.remark}</textarea>
            </br>
            <button class="btn btn-primary btn-md" type="submit" name="action" value="apply"><fmt:message key="apply" bundle="${content}"/></button>
            <button class="btn btn-primary btn-md" type="submit" name="action" value="save"><fmt:message key="save" bundle="${content}"/></button>
            <button class="btn btn-primary btn-md" type="reset"><fmt:message key="reset" bundle="${content}"/></button>
            <button class="btn btn-primary btn-md" type="cancel"><fmt:message key="cancel" bundle="${content}"/></button>
            <input type="hidden" name="option" value ="order">
            <input type="hidden" name="filter_customer" value ="${data.filter}">
            <input type="hidden" name="orderId" value="${data.id}"/>
        </div>
    </form>
</div>
<t:footer />