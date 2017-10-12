<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="customers" bundle="${content}"/></h2>
<c:choose>
    <c:when test="${empty data.customers}">
        <t:createForm option="customer"/>
    </c:when>
    <c:otherwise>
        <table id="advancedTable" class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                    <th><fmt:message key="#" bundle="${content}"/></th>
                    <th><fmt:message key="title" bundle="${content}"/></th>
                    <th><fmt:message key="city" bundle="${content}"/></th>
                    <th><fmt:message key="remark" bundle="${content}"/></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${data.customers}">
                <tr class="serial" data-id="1" style="cursor: pointer;">
                    <td></td>
                    <td>${customer.name}</td>
                    <td>${customer.city}</td>
                    <td>${customer.remark}</td>
                    <td width="30"><a href="/customer/edit.html?option=customer&action=edit&customerId=${customer.id}" title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                    <td width="30"><a href="/customer/form.html?option=customer&action=delete&customerId=${customer.id}" title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
            </c:forEach>
            </tbody>
            <tfooter>
                <tr>
                    <td></td>
                    <td colspan="4"></td>
                    <td><a href="/customer/edit.html?option=customer&action=add"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></td>
                </tr>
            <tfooter>
        </table>
    </c:otherwise>
</c:choose>
<t:footer />


