<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language  ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv = "content-type" content = "text/html; charset = UTF-8">
    <title><fmt:message key="appname" bundle="${content}"/></title>
    <base href="/">

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/custom.css">
    <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css" >

    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
    <div class="container">
        <div class="text-center">
            <a href="/index.html"><img src="../../images/logo.jpg" alt="HappyLab" title="HappyLab"/></a>
            <form action="/index.html">
                <button class="btn btn-link" type="submit" value="ru_RU" name="language"><image src="../../images/ru.png" alt="RU" title="RU" /></button>
                <button class="btn btn-link" type="submit" value="en_US" name="language"><image src="../../images/gb.png" alt="EN" title="EN" /></button>
                <button class="btn btn-link" type="submit" value="nl_NL" name="language"><image src="../../images/nl.png" alt="NL" title="NL" /></button>
                <input type="hidden" name="option" value ="profile">
            </form>
        </div>
        <div class="jumbotron">
            <div class="text-center"><i class="fa fa-5x fa-frown-o" style="color:#d9534f;"></i></div>
            <div class="text-center">
                    <h1><fmt:message key="not_found_error" bundle="${content}"/></h1>
                    <p><fmt:message key="everything_broke" bundle="${content}"/></p>
                    <div class="error-desc"><fmt:message key="page_not_found" bundle="${content}"/><div>
                    <p><fmt:message key="try_pressing" bundle="${content}"/></p>
                    <p><a class="btn btn-primary" href="/index.html"><i class="fa fa-home"></i><fmt:message key="take_me_home" bundle="${content}"/></a></p>
            </div>
        </div>
    </div>
</div>
<t:footer />
