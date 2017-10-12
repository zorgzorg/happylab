<%@ tag body-content="empty"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="content" var="content"/>
<div class="container">
<footer class="container-fluid bg-10 text-center">
  <p>2017 <fmt:message key="copyright" bundle="${content}"/></p>
</footer>
</div>
</div>
</body>
</html>