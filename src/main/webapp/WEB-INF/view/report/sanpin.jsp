<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<c:set var = "probe" scope = "page" value = "${data.probe}"/>
<table class="table table-bordered">
            <tr>
                <td><fmt:message key="customer" bundle="${content}"/></td>
                <td>${probe.name}</td>
                <td><fmt:message key="order_number" bundle="${content}"/></td>
                <td colspan="2">${probe.number}</td>
            </tr>
            <tr>
                <td><fmt:message key="point_sampling" bundle="${content}"/></td>
                <td>${probe.pointSampling}</td>
                <td><fmt:message key="date_sampling" bundle="${content}"/></td>
                <td><fmt:formatDate dateStyle = "short" value = "${probe.dateSampling}" /></td>
            </tr>
            <tr>
                <td><fmt:message key="ND_testing_method" bundle="${analysis}"/></td>
                <td><fmt:message key="nd_testing_sanpin" bundle="${analysis}"/></td>
                <td><fmt:message key="probe_number_laboratory" bundle="${content}"/></td>
                <td>${probe.numberLab}</td>
            </tr>
</table>
<table id="advancedTable" class="table  table-bordered">
    <thead>
        <tr>
        <th><fmt:message key="#" bundle="${content}"/></th>
          <c:forEach items="${data.result[0]}" var="column">
          <c:choose>
            <c:when test="${column.key eq 'assistant'}"></c:when>
            <c:when test="${column.key eq 'limit'}"></c:when>
            <c:otherwise>
                <th><fmt:message key="${column.key}" bundle="${analysis}"/></th>
            </c:otherwise>
            </c:choose>
          </c:forEach>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${data.result}" var="columns">
          <tr class="serial">
            <td></td>
              <c:forEach items="${columns}" var="column">
                  <c:choose>
                    <c:when test="${column.key eq 'limit'}"></c:when>
                      <c:when test="${column.key == 'element'}">
                        <td><fmt:message key="${column.value}" bundle="${analysis}"/></td>
                      </c:when>
                      <c:when test="${column.key == 'assistant'}"><c:set var = "assistant" scope = "page" value = "${column.value}"/></c:when>
                      <c:otherwise>
                        <td>${column.value}</td>
                      </c:otherwise>
                  </c:choose>
              </c:forEach>
          </tr>
        </c:forEach>
    </tbody>
</table>
<p class="text-left"><fmt:message key="assistants" bundle="${analysis}"/>: ${assistant}</p>
