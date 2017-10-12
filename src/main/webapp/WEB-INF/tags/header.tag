<%@ tag body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="content" var="content"/>
<fmt:setBundle basename="analysis" var="analysis"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv = "content-type" content = "text/html; charset = UTF-8">
    <title><fmt:message key="appname" bundle="${content}"/></title>
    <base href="/">

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/custom.css">
    <link rel="stylesheet" type="text/css" href="../css/menu.css">
    <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">

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
            <nav class="navbar navbar-default">
                <div id="navbarCollapse" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <c:if test="${not empty user}" >
                            <c:if test="${user.usertype eq 'head' || user.usertype eq 'administrator'}" >
                                 <li><a href="/customer/form.html?option=customer"><fmt:message key="customers" bundle="${content}"/></a></li>
                                 <li><a href="/order/form.html?option=order"><fmt:message key="orders" bundle="${content}"/></a></li>
                                 <li><a href="/probe/form.html?option=probe"><fmt:message key="probes" bundle="${content}"/></a></li>
                            </c:if>
                            <c:if test="${user.usertype eq 'head' || user.usertype eq 'administrator' || user.usertype eq 'assistant'}" >
                                 <li><a href="/aes/form.html?option=aes"><fmt:message key="AES" bundle="${analysis}"/></a></li>
                                 <li><a href="/psa/form.html?option=psa"><fmt:message key="PSA" bundle="${analysis}"/></a></li>
                                 <li><a href="/sanpin/form.html?option=sanpin"><fmt:message key="SANPIN" bundle="${analysis}"/></a></li>
                            </c:if>
                            <c:if test="${user.usertype eq 'head' || user.usertype eq 'administrator'}" >
                                 <li><a href="/employee/form.html?option=employee"><fmt:message key="employees" bundle="${content}"/></a></li>
                                 <li><a href="/position/form.html?option=position"><fmt:message key="positions" bundle="${content}"/></a></li>
                            </c:if>
                            <c:if test="${user.usertype eq 'administrator'}" >
                                <li><a href="/user/form.html?option=user"><fmt:message key="users" bundle="${content}"/></a></li>
                            </c:if>
                                <li><a href="/profile/form.html?option=profile"><fmt:message key="profile" bundle="${content}"/></a></li>
                        </c:if>
                    </ul>
                    <form action ="/controller" method="POST" role="form" class="navbar-form navbar-right">
                        <button type="submit" class="btn btn-info" name="action" value ="logout"><fmt:message key="logout" bundle="${content}"/></button>
                        <input type="hidden" name="option" value ="profile">
                    </form>
                </div>
            </nav>
