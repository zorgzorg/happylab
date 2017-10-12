<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<t:header />
<h2><fmt:message key="profile" bundle="${content}"/></h2>
<h3><fmt:message key="hello" bundle="${content}"/>, ${user.name}</h3>
<div class="container">
    <form action="/profile/form.html" method="post" role="form" id="registration-form">
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
            <input type="email" name="email" id="email" class="form-control" value="<c:out value='${data.email}'/>"
            placeholder="email" oninvalid="this.setCustomValidity('<fmt:message key='enter_valid_email' bundle='${content}'/>')"
            oninput="setCustomValidity('')" required/>
            <br />
            <button class="btn btn-primary btn-md" type="submit" value="apply" name="action"><fmt:message key="apply" bundle="${content}"/></button>
            <button class="btn btn-primary btn-md" type="submit" value="save" name="action"><fmt:message key="save" bundle="${content}"/></button>
            <button class="btn btn-primary btn-md" type="reset"><fmt:message key="reset" bundle="${content}"/></button>
            <button class="btn btn-primary btn-md" type="cancel"><fmt:message key="cancel" bundle="${content}"/></button>
            <input type="hidden" name="option" value ="profile">
            <input type="hidden" name="userId" value="${user.id}"/>
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