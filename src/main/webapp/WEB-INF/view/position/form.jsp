<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="positions" bundle="${content}"/></h2>
<c:choose>
    <c:when test="${empty data.positions}">
        <t:createForm option="position"/>
    </c:when>
    <c:otherwise>
        <table id="advancedTable" class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                    <th><fmt:message key="#" bundle="${content}"/></th>
                    <th><fmt:message key="title" bundle="${content}"/></th>
                    <th><fmt:message key="remark" bundle="${content}"/></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="position" items="${data.positions}">
                <tr class="serial">
                    <td></td>
                    <td>${position.position}</td>
                    <td>${position.remark}</td>
                    <td width="30"><a href="/position/edit.html?option=position&action=edit&positionId=${position.id}"
                     title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                    <td width="30"><a href="/position/form.html?option=position&action=delete&positionId=${position.id}"
                     title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
            </c:forEach>
            </tbody>
            <tfooter>
                <tr>
                    <td></td>
                    <td colspan="3"></td>
                    <td><a href="/position/edit.html?option=position&action=add"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></i></a></td>
                </tr>
            <tfooter>
        </table>
    </c:otherwise>
</c:choose>
<t:footer />


