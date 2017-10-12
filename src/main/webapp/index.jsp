<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language  ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<c:if test="${not empty user}">
    <jsp:forward page="/profile/form.html?option=profile"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv = "content-type" content = "text/html; charset = UTF-8">
    <title><fmt:message key="appname" bundle="${content}"/></title>
    <base href="/">

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/custom.css">

    <script type="text/javascript" src="../js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../js/jquery-1.12.4.js" ></script>
    <script type="text/javascript" src="../js/login.js" ></script>
</head>
<body>
    <div class="container">
    <div class="text-center">
            <a href="/index.html"><img src="../../images/logo.jpg"/></a>
            <form action="/index.html">
                <button class="btn btn-link" type="submit" value="ru_RU" name="language"><image src="../../images/ru.png" alt="RU" title="RU" /></button>
                <button class="btn btn-link" type="submit" value="en_US" name="language"><image src="../../images/gb.png" alt="EN" title="EN" /></button>
                <button class="btn btn-link" type="submit" value="nl_NL" name="language"><image src="../../images/nl.png" alt="NL" title="NL" /></button>
            </form>
        </div>

    <div class="container">
    <div class="card card-container">
    <img id="profile-img" class="profile-img-card" src="images/avatar.png" />
    <c:if test="${not empty message}">
        <div class="alert alert-danger"><fmt:message key='${message}' bundle='${content}'/></div>
    </c:if>
    <form class="form-signin" action="/controller" method="post" role="form">
        <input type="text" name="username" id="username" class="form-control" placeholder="<fmt:message key='username' bundle='${content}'/>" required autofocus />
        <input type="password" name="password" id="password" class="form-control" placeholder="<fmt:message key='password' bundle='${content}'/>" required autofocus/>
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value="login" name="action"><fmt:message key="sign_in" bundle="${content}"/></button>
        <p class="forgot-password"><fmt:message key='forgot_password' bundle='${content}'/></p>
        <input type="hidden" name="option" value ="profile">
    </form>
</div>
<t:footer />