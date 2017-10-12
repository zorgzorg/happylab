<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<t:header />
<h2><fmt:message key="atomic_emission_spectrometry" bundle="${analysis}"/></h2>
<div class="container">
    <form action="/aes/form.html" method="post" role="form" data-toggle="validator" class="form-horizontal">
        <c:forEach items="${data.journal}" var="columns">
            <c:forEach items="${columns}" var="column">
                <c:choose>
                     <c:when test="${column.key == 'numberLab'}"></c:when>
                     <c:when test="${column.key == 'assistant'}"></c:when>
                     <c:when test="${column.key == 'id'}">
                     <c:if test="${not empty column.value}" ><input type="hidden" name="recordId" value="${column.value}"/></c:if></c:when>
                     <c:when test="${column.key == 'probeId'}">
                         <div class="form-group">
                            <label for="${column.key}" class="col-sm-2 control-label"><fmt:message key="${column.key}" bundle="${analysis}"/></label>
                            <div class="col-sm-2">
                                <select name="probeId" id="probeId" class="form-control" required>
                                    <option value="">--<fmt:message key="choose_probe" bundle="${analysis}"/>--</option>
                                    <c:forEach var="probe" items="${data.probes}">
                                        <c:choose>
                                          <c:when test="${probe.id==column.value}">
                                              <option value="${probe.id}" selected>${probe.numberLab}</option>
                                          </c:when>
                                          <c:otherwise>
                                              <option value="${probe.id}">${probe.numberLab}</option>
                                          </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                         </div>
                    </c:when>
                    <c:when test="${column.key == 'date'}">
                        <div class="form-group">
                            <label for="${column.key}" class="col-sm-2 control-label"><fmt:message key="${column.key}" bundle="${analysis}"/></label>
                            <div class="col-sm-2">
                              <fmt:formatDate var="dateFmt" dateStyle = "short" value = "${column.value}"/>
                              <input type="text" name="${column.key}" id="${column.key}" class="form-control" value="${dateFmt}"
                              placeholder="<fmt:message key='date_placeholder' bundle='${content}'/>" required/>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${column.key == 'employeeId'}">
                        <div class="form-group">
                            <label for="${column.key}" class="col-sm-2 control-label"><fmt:message key="${column.key}" bundle="${analysis}"/></label>
                            <div class="col-sm-2">
                                <select name="employeeId" id="employeeId" class="form-control" required>
                                  <option value="">--<fmt:message key="choose_assistant" bundle="${analysis}"/>--</option>
                                  <c:forEach var="employee" items="${data.employees}">
                                  <c:choose>
                                      <c:when test="${employee.id==column.value}">
                                          <option value="${employee.id}" selected>${employee.lastname}</option>
                                      </c:when>
                                      <c:otherwise>
                                          <option value="${employee.id}">${employee.lastname}</option>
                                      </c:otherwise>
                                  </c:choose>
                                  </c:forEach>
                              </select>
                              </div>
                          </div>
                    </c:when>
                    <c:when test="${column.key == 'deleted'}"></c:when>
                    <c:otherwise>
                        <div class="form-group">
                           <label for="${column.key}" class="col-sm-2 control-label">${column.key}</label>
                           <div class="col-sm-2">
                               <input type="number" name="${column.key}" id="${column.key}" class="form-control" min="0" value="${column.value}"/>
                           </div>
                       </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:forEach>
        <button class="btn btn-primary btn-md" type="submit" name="action" value="apply"><fmt:message key="apply" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="submit" name="action" value="save"><fmt:message key="save" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="reset"><fmt:message key="reset" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="cancel"><fmt:message key="cancel" bundle="${content}"/></button>
        <input type="hidden" name="option" value ="aes">

    </form>
</div>
<t:footer />