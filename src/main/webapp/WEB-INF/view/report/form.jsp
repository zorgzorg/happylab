<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<my:header />
<h2 class="text-center"><fmt:message key="test_report" bundle="${analysis}"/></h2>
<c:if test="${not empty data.analysis}" >
    <c:set var="analysis_title" value="${data.analysis}" />
    <h4 class="text-center"><fmt:message key="${analysis_title}_report_title" bundle="${analysis}"/></h4>
</c:if>
<c:choose>
    <c:when test="${not empty data.result}">
        <c:choose>
            <c:when test="${data.analysis eq 'sanpin'}">
                <jsp:include page="/WEB-INF/view/report/sanpin.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="/WEB-INF/view/report/aes.jsp"/>
            </c:otherwise>
        </c:choose>
        <p class="text-right"><fmt:message key="head_laboratory" bundle="${analysis}"/>____________________${data.headLaboratory}<p>
        <p class="text-center"><fmt:message key="test_result_annotation" bundle="${analysis}"/></p>
    </c:when>
    <c:otherwise>
        <br><br>
        <div class="alert alert-info">
            <fmt:message key="record_not_found" bundle="${analysis}"/>
        </div>
    </c:otherwise>
</c:choose>
<my:footer />