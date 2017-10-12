<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="employees" bundle="${content}"/></h2>
<c:choose>
    <c:when test="${empty data.employees}">
        <t:createForm option="employee" />
    </c:when>
    <c:otherwise>
        <table id="advancedTable" class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                    <th><fmt:message key="#" bundle="${content}"/></th>
                    <th><fmt:message key="lastname" bundle="${content}"/></th>
                    <th><fmt:message key="name" bundle="${content}"/></th>
                    <th><fmt:message key="surname" bundle="${content}"/></th>
                    <th><fmt:message key="position" bundle="${content}"/></th>
                    <th><fmt:message key="can_make_tests" bundle="${content}"/></th>
                    <th><fmt:message key="signature_right" bundle="${content}"/></th>
                    <th><fmt:message key="remark" bundle="${content}"/></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${data.employees}">
                <tr class="serial">
                    <td></td>
                    <td>${employee.lastname}</td>
                    <td>${employee.name}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.position}</td>
                    <td>
                        <c:choose>
                            <c:when test="${employee.assistant == -1}">
                                <a href="/employee/edit.html?option=employee&action=saveAssistant&employeeId=${employee.id}&assistant=0"><span class="fa fa-check"/></a>
                            </c:when>
                            <c:otherwise>
                                <a href="/employee/edit.html?option=employee&action=saveAssistant&employeeId=${employee.id}&assistant=-1"><span class="fa fa-times"/></a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${employee.signature == -1}">
                                <a href="/employee/edit.html?option=employee&action=saveSignature&employeeId=${employee.id}&signature=0"><span class="fa fa-check"/></a>
                            </c:when>
                            <c:otherwise>
                                <a href="/employee/edit.html?option=employee&action=saveSignature&employeeId=${employee.id}&signature=-1"><span class="fa fa-times"/></a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${employee.remark}</td>
                    <td width="30"><a href="/employee/edit.html?option=employee&action=edit&employeeId=${employee.id}" title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                    <td width="30"><a href="/employee/form.html?option=employee&action=delete&employeeId=${employee.id}" title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
            </c:forEach>
            </tbody>
            <tfooter>
                <tr>
                    <td></td>
                    <td colspan="8"></td>
                    <td><a href="/employee/edit.html?option=employee&action=add"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></i></a></td>
                </tr>
            <tfooter>
        </table>
    </c:otherwise>
</c:choose>
<t:footer />


