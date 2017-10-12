<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<c:set var = "probe" scope = "page" value = "${data.probe}"/>
<table class="table">
        <tr>
            <td><fmt:message key="customer" bundle="${content}"/></td>
            <td colspan="2">${probe.name}</td>
        </tr>
        <tr>
            <td><fmt:message key="order_number" bundle="${content}"/></td>
            <td colspan="2">${probe.number}</td>
        </tr>
        <tr>
            <td><fmt:message key="date_receiving" bundle="${content}"/></td>
            <td colspan="2"><fmt:formatDate dateStyle = "short" value = "${probe.dateReceiving}" /></td>
        </tr>
        <tr>
            <td><fmt:message key="ND_sampling" bundle="${analysis}"/></td>
            <td colspan="2"><fmt:message key="nd_sampling_aes" bundle="${analysis}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="ND_testing_method" bundle="${analysis}"/></td>
            <td colspan="2"><fmt:message key="nd_testing_aes" bundle="${analysis}"/></td>
        </tr>
</table>
<table class="table table-bordered">
        <tr>
            <td><fmt:message key="#" bundle="${content}"/></td>
            <td><fmt:message key="probe_number_laboratory" bundle="${content}"/></td>
            <td>${probe.numberLab}</td>
        </tr>
        <tr>
            <td></td>
            <td><fmt:message key="probe_number_customer" bundle="${content}"/></td>
            <td>${probe.numberCustomer}</td>
        </tr>
        <tr>
            <td></td>
            <td><fmt:message key="point_sampling" bundle="${content}"/></td>
            <td>${probe.pointSampling}</td>
        </tr>
        <tr>
            <td></td>
            <td><fmt:message key="date_sampling" bundle="${content}"/></td>
            <td><fmt:formatDate dateStyle = "short" value = "${probe.dateSampling}" /></td>
        </tr>
        <tr>
            <td></td>
            <td><strong><fmt:message key="elements" bundle="${analysis}"/></strong></td>
            <td><strong><fmt:message key="mg_dm" bundle="${analysis}"/></strong></strong></td>
        </tr>
        <c:forEach items="${data.result}" var="columns">
              <c:forEach items="${columns}" var="column">
              <tr class="serial">
                  <c:choose>
                      <c:when test="${column.key == 'assistant'}"><c:set var = "assistant" scope = "page" value = "${column.value}"/></c:when>
                      <c:otherwise>
                        <td></td>
                        <td><fmt:message key="${column.key}" bundle="${analysis}"/></td>
                        <td>${column.value}</td>
                      </c:otherwise>
                  </c:choose>
              </tr>
              </c:forEach>
        </c:forEach>
</table>
<p class="text-left"><fmt:message key="assistants" bundle="${analysis}"/>: ${assistant}</p>
