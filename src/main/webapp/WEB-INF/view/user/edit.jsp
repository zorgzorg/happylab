<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="user" bundle="${content}"/></h2>
<div class="container">
<form action="/user/form.html" method="post"  role="form" data-toggle="validator">
    <div class="form-group col-xs-5">
        <label for="name" class="control-label col-xs-5"><fmt:message key="name" bundle="${content}"/></label>
        <input type="text" name="name" id="name" class="form-control" value="<c:out value='${data.name}'/>" required autofocus/>

        <label for="username" class="control-label col-xs-5"><fmt:message key="username" bundle="${content}"/></label>
        <input type="text" name="username" id="username" class="form-control" value="<c:out value='${data.username}'/>" required/>

        <label for="password" class="control-label col-xs-5"><fmt:message key="password" bundle="${content}"/></label>
        <input type="password" name="password" id="password" class="form-control" oninput="checkPasscode();" required/>

        <label for="password_confirm" class="control-label col-xs-5"><fmt:message key="confirm_password" bundle="${content}"/></label>
        <input type="password" name="password_confirm" id="password_confirm" class="form-control" oninput="checkPasscode();" required/>

        <label for="email" class="control-label col-xs-5"><fmt:message key="email" bundle="${content}"/></label>
        <input type="email" name="email" id="email" class="form-control" value="<c:out value='${data.email}'/>" required/>

        <label for="usertype" class="control-label col-xs-5"><fmt:message key="usertype" bundle="${content}"/></label>
        <select name="usertype" id="usertype" class="form-control" required>
            <option value="" selected>--<fmt:message key="choose_usertype" bundle="${content}"/>--</option>
             <c:forEach var="usertype" items="${data.usertypes}">
                <c:choose>
                    <c:when test="${usertype.usertype==data.usertype}">
                        <option value="${usertype.usertype}" selected><fmt:message key="${usertype.usertype}" bundle="${content}"/></option>
                    </c:when>
                    <c:otherwise>
                        <option value="${usertype.usertype}"><fmt:message key="${usertype.usertype}" bundle="${content}"/></option>
                    </c:otherwise>
                </c:choose>
              </c:forEach>
        </select>

        <label for="dateRegistration" class="control-label col-xs-5"><fmt:message key="date_registration" bundle="${content}"/></label>
        <fmt:formatDate var="dateFmt" dateStyle = "short" value = "${data.dateRegistration}"/>
        <input type="text" name="dateRegistration" id="dateRegistration" class="form-control" value="${dateFmt}"
        placeholder="<fmt:message key='date_placeholder' bundle='${content}'/>" required/>

        <c:if test="${data.usertype != 'administrator'}">
            <label for="block" class="control-label col-xs-10"><fmt:message key="blocked" bundle="${content}"/></label>
            <div class="col-lg-10">
                <div class="radio">
                  <c:choose>
                      <c:when test="${data.block == -1}">
                          <label><input type="radio" name="block" value="${data.block}" checked><fmt:message key="yes" bundle="${content}"/></label>
                          <label><input type="radio" name="block" value="-1"><fmt:message key="no" bundle="${content}"/></label>
                      </c:when>
                      <c:otherwise>
                          <label><input type="radio" name="block" value="0"><fmt:message key="yes" bundle="${content}"/></label>
                          <label><input type="radio" name="block" value="${data.block}" checked><fmt:message key="no" bundle="${content}"/></label>
                      </c:otherwise>
                  </c:choose>
                </div>
            </div>
        </c:if>

        <label for="remark" class="control-label col-xs-5"><fmt:message key="remark" bundle="${content}"/></label>
        <textarea name="remark" id="remark" cols="50" rows="5" class="form-control">${data.remark}</textarea>
        </br>
        <button class="btn btn-primary btn-md" type="submit" value="apply" name="action"><fmt:message key="apply" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="submit" value="save" name="action"><fmt:message key="save" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="reset"><fmt:message key="reset" bundle="${content}"/></button>
        <button class="btn btn-primary btn-md" type="cancel"><fmt:message key="cancel" bundle="${content}"/></button>
        <input type="hidden" name="option" value ="user">
        <input type="hidden" name="userId" value="${data.id}"/>
    </div>
</form>
</div>
<script>
function checkPasscode() {
    var password = document.getElementById('password');
    var password_confirm = document.getElementById('password_confirm');

    var checkPasswordValidity = function() {
        if (password.value != password_confirm.value) {
            password.setCustomValidity('<fmt:message key="passwords_must_be_equal" bundle="${content}"/>.');
        } else {
            password.setCustomValidity('');
        }
    };

    password.addEventListener('change', checkPasswordValidity, false);
    password_confirm.addEventListener('change', checkPasswordValidity, false);
}</script>
<t:footer />
