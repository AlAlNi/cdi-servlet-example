<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.server.CookieUtils" %>

<%
    String login = CookieUtils.getLogin(request);
    String bodyFile = (String) request.getAttribute("PageBody");
    String redirect = (String) request.getAttribute("Redirect");
    if (redirect == null) redirect = "/";
    if (bodyFile == null) {
        String mainPage = "main.jsp";
        request.setAttribute("PageBody", mainPage);
        bodyFile = mainPage;
    }

    if (login == null && !bodyFile.equals("auth.jsp")){
        CookieUtils.setRedirect(response, redirect);
        response.sendRedirect("/mobiles/auth");
    }
%>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <title><%= (String) request.getAttribute("PageTitle")%></title>
</head>
<body>
<div class="badge badge-primary text-right"><%=login!=null?"Hello, "+login+"!":""%></div>
<div class="container">
    <c:import url="${PageBody}"/>
</div>
</body>
</html>