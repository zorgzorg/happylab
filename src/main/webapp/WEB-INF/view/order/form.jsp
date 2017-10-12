<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="orders" bundle="${content}"/></h2>
<div class="container">
    <form action="/order/form.html" method="POST" id="filterForm" name="filterForm" role="form">
        <div class="form-group col-xs-5">
            <select name="filter_customer" onchange="document.filterForm.submit();" class="form-control">
                <option value="0" selected>--<fmt:message key="choose_customer" bundle="${content}"/>--</option>
                <c:forEach var="customer" items="${data.customers}">
                    <c:choose>
                        <c:when test="${customer.id==data.filter}">
                            <option value="${customer.id}" selected>${customer.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${customer.id}">${customer.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <br />
            <c:if test="${empty data.orders}">
                <button type="submit" class="btn btn-primary  btn-md" name="action" value ="add"><fmt:message key="create" bundle="${content}"/></button>
            </c:if>
            <input type="hidden" name="option" value ="order">
            <input type="hidden" name="filter_customer" value ="${data.filter}">
        </div>
    </form>
</div>
<c:choose>
    <c:when test="${empty data.orders}" >
        <div class="alert alert-info">
            <fmt:message key="order_not_found" bundle="${content}"/>
        </div>
    </c:when>
    <c:otherwise>
        <table id="advancedTable" class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                    <th><fmt:message key="#" bundle="${content}"/></th>
                    <th><fmt:message key="order_number" bundle="${content}"/></th>
                    <th><fmt:message key="customer" bundle="${content}"/></th>
                    <th><fmt:message key="date" bundle="${content}"/></th>
                    <th><fmt:message key="quantity_probes" bundle="${content}"/></th>
                    <th><fmt:message key="remark" bundle="${content}"/></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${data.orders}">
                <tr class="serial">
                    <td></td>
                    <td>${order.number}</td>
                    <td>${order.name}</td>
                    <td><fmt:formatDate dateStyle = "short" value = "${order.date}"/></td>
                    <td><c:if test="${order.probesQuantity != 0}">${order.probesQuantity}</c:if></td>
                    <td>${order.remark}</td>
                    <td width="30"><a href="/order/edit.html?option=order&action=edit&orderId=${order.id}&filter_customer=${data.filter}"
                     title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                    <td width="30"><a href="/order/form.html?option=order&action=delete&orderId=${order.id}&filter_customer=${data.filter}"
                     title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfooter>
                <tr>
                    <td></td>
                    <td colspan="6"></td>
                    <td><a href="/order/edit.html?option=order&action=add"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></td>
                </tr>
            <tfooter>
        </table>
    </c:otherwise>
</c:choose>
<t:footer />
