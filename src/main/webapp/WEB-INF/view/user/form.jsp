<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="users" bundle="${content}"/></h2>
<c:choose>
    <c:when test="${empty data.users}">
        <t:createForm option="customer"/>
    </c:when>
    <c:otherwise>
        <table id="advancedTable" class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                    <th><fmt:message key="#" bundle="${content}"/></th>
                    <th><fmt:message key="name" bundle="${content}"/></th>
                    <th><fmt:message key="username" bundle="${content}"/></th>
                    <th><fmt:message key="email" bundle="${content}"/></th>
                    <th><fmt:message key="usertype" bundle="${content}"/></th>
                    <th><fmt:message key="date_registration" bundle="${content}"/></th>
                    <th><fmt:message key="blocked" bundle="${content}"/></th>
                    <th><fmt:message key="remark" bundle="${content}"/></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${data.users}">
                <tr class="serial">
                    <td></td>
                    <td>${user.name}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td><c:if test="${user.usertype != '0'}"><fmt:message key="${user.usertype}" bundle="${content}"/></c:if></td>
                    <td>${user.dateRegistration}</td>
                    <td>
                        <c:if test="${user.usertype != 'administrator'}">
                            <c:choose>
                                <c:when test="${user.block == -1}">
                                    <a href="/user/edit.html?option=user&action=block&userId=${user.id}&block=0"><span class="fa fa-check"/></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/user/edit.html?option=user&action=block&userId=${user.id}&block=-1"><span class="fa fa-times"/></a>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </td>
                    <td>${user.remark}</td>
                    <td width="30"><a href="/user/edit.html?option=user&action=edit&userId=${user.id}"
                    title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                    <td width="30"><a href="/user/form.html?option=user&action=delete&userId=${user.id}"
                    title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
            </c:forEach>
            </tbody>
            <tfooter>
                <tr>
                    <td></td>
                    <td colspan="8"></td>
                    <td><a href="/user/edit.html?option=user&action=add"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></i></a></td>
                </tr>
            <tfooter>
        </table>
    </c:otherwise>
</c:choose>
<t:footer />


