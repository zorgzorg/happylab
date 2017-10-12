<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>
<fmt:setBundle basename="sanpin" var="sanpin"/>

<t:header />
<h2><fmt:message key="SANPIN" bundle="${analysis}"/></h2>
<c:choose>
    <c:when test="${empty data.journal}">
        <t:createForm option="sanpin" />
    </c:when>
    <c:otherwise>
    <c:set var = "code" scope = "page" value = "sanpin"/>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-condensed">
            <thead>
                <tr>
                <th><fmt:message key="#" bundle="${content}"/></th>
                  <c:forEach items="${data.journal[0]}" var="column">
                    <c:choose>
                        <c:when test="${column.key == 'id'}"></c:when>
                        <c:when test="${column.key == 'probeId'}"></c:when>
                        <c:when test="${column.key == 'employeeId'}"></c:when>
                        <c:when test="${column.key == 'deleted'}"></c:when>
                        <c:when test="${column.key == 'numberLab'}"><th><fmt:message key="${column.key}" bundle="${analysis}"/></th></c:when>
                        <c:when test="${column.key == 'assistant'}"><th><fmt:message key="${column.key}" bundle="${analysis}"/></th></c:when>
                        <c:when test="${column.key == 'date'}"><th><fmt:message key="${column.key}" bundle="${analysis}"/></th></c:when>
                        <c:otherwise>
                            <th><fmt:message key="${column.key}" bundle="${sanpin}"/></th>
                        </c:otherwise>
                    </c:choose>
                  </c:forEach>
                  <th></th>
                  <th></th>
                  <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${data.journal}" var="columns">
                  <tr class="serial">
                    <td></td>
                      <c:forEach items="${columns}" var="column">
                          <c:choose>
                              <c:when test="${column.key == 'id'}"><c:set var = "recordId" scope = "page" value = "${column.value}"/></c:when>
                              <c:when test="${column.key == 'probeId'}"><c:set var = "probeId" scope = "page" value = "${column.value}"/></c:when>
                              <c:when test="${column.key == 'employeeId'}"></c:when>
                              <c:when test="${column.key == 'deleted'}"></c:when>
                              <c:when test="${column.key == 'date'}">
                                <td><fmt:formatDate dateStyle = "short" value = "${column.value}"/></td>
                              </c:when>
                              <c:otherwise>
                                <td>${column.value}</td>
                              </c:otherwise>
                          </c:choose>
                      </c:forEach>
                    <td width="30"><a href="/sanpin/edit.html?option=sanpin&action=edit&recordId=${recordId}"
                    title="<fmt:message key='edit' bundle='${content}'/>"><span class="fa fa-pencil"/></a></td>
                    <td width="30"><a href="/report/form.html?option=report&analysis=${code}&recordId=${recordId}&probeId=${probeId}"
                    title="<fmt:message key='make_report' bundle='${content}'/>"><span class="fa fa-print"/></a></td>
                    <td width="30"><a href="/sanpin/form.html?option=sanpin&action=delete&recordId=${recordId}"
                    title="<fmt:message key='delete' bundle='${content}'/>"><span class="fa fa-trash-o"/></a></td>
                  </tr>
                </c:forEach>
            </tbody>
            <tfooter>
                <tr>
                    <td></td>
                    <td colspan="65"></td>
                    <td><a href="/sanpin/edit.html?option=sanpin&action=add"><i class="fa fa-plus" title="<fmt:message key='create' bundle='${content}'/>"></i></a></td>
                </tr>
            <tfooter>
        </table></div>
    </c:otherwise>
</c:choose>
<t:footer />