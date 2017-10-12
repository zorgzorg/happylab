<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="employee" bundle="${content}"/></h2>
<div class="container">
<form action="/employee/form.html" method="post"  role="form" data-toggle="validator">
    <div class="form-group col-xs-5">
        <label for="lastname" class="control-label col-xs-5"><fmt:message key="lastname" bundle="${content}"/></label>
        <input type="text" name="lastname" id="lastname" class="form-control" value="<c:out value='${data.lastname}'/>" required autofocus/>

        <label for="name" class="control-label col-xs-5"><fmt:message key="name" bundle="${content}"/></label>
        <input type="text" name="name" id="name" class="form-control" value="<c:out value='${data.name}'/>" required/>

        <label for="surname" class="control-label col-xs-5"><fmt:message key="surname" bundle="${content}"/></label>
        <input type="text" name="surname" id="surname" class="form-control" value="<c:out value='${data.surname}'/>" required/>

        <label for="position" class="control-label col-xs-5"><fmt:message key="position" bundle="${content}"/></label>
        <select name="positionId" id="positionId" class="form-control">
            <option value="0" selected>--<fmt:message key="choose_position" bundle="${content}"/>--</option>
            <c:forEach var="position" items="${data.positions}">
            <c:choose>
                <c:when test="${position.id==data.positionId}">
                    <option value="${position.id}" selected>${position.position}</option>
                </c:when>
                <c:otherwise>
                    <option value="${position.id}">${position.position}</option>
                </c:otherwise>
            </c:choose>
            </c:forEach>
        </select>

        <label for="assistant" class="control-label col-xs-10"><fmt:message key="can_make_tests" bundle="${content}"/></label>
        <div class="col-lg-10">
            <div class="radio">
              <c:choose>
                  <c:when test="${data.assistant == 0}">
                      <label><input type="radio" name="assistant" value="${data.assistant}" checked><fmt:message key="yes" bundle="${content}"/></label>
                      <label><input type="radio" name="assistant" value="-1"><fmt:message key="no" bundle="${content}"/></label>
                  </c:when>
                  <c:otherwise>
                      <label><input type="radio" name="assistant" value="0"><fmt:message key="yes" bundle="${content}"/></label>
                      <label><input type="radio" name="assistant" value="${data.assistant}" checked><fmt:message key="no" bundle="${content}"/></label>
                  </c:otherwise>
              </c:choose>
            </div>
        </div>

        <label for="signature" class="control-label col-xs-10"><fmt:message key="signature_right" bundle="${content}"/></label>
        <div class="col-lg-10">
            <div class="radio">
              <c:choose>
                  <c:when test="${data.signature == -1}">
                      <label><input type="radio" name="signature" value="${data.signature}" checked><fmt:message key="yes" bundle="${content}"/></label>
                      <label><input type="radio" name="signature" value="0"><fmt:message key="no" bundle="${content}"/></label>
                  </c:when>
                  <c:otherwise>
                      <label><input type="radio" name="signature" value="-1"><fmt:message key="yes" bundle="${content}"/></label>
                      <label><input type="radio" name="signature" value="${data.signature}" checked><fmt:message key="no" bundle="${content}"/></label>
                  </c:otherwise>
              </c:choose>
            </div>
        </div>

        <label for="remark" class="control-label col-xs-5"><fmt:message key="remark" bundle="${content}"/></label>
        <textarea name="remark" id="remark" cols="50" rows="5" class="form-control">${data.remark}</textarea>
        </br>
        <button class="btn btn-primary btn-md" type="submit" value="apply" name="action"><fmt:message key="apply" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="submit" value="save" name="action"><fmt:message key="save" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="reset"><fmt:message key="reset" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="cancel"><fmt:message key="cancel" bundle="${content}"/></button>
        <input type="hidden" name="option" value ="employee">
        <input type="hidden" name="employeeId" value="${data.id}"/>
    </div>
</form>
</div>
<t:footer />
