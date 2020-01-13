<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td scope="row">${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td><a href="${pageContext.request.contextPath}/showuser?id=${user.id}">Link</a></td>
            <td><a href="${pageContext.request.contextPath}/edituser?id=${user.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/deleteuser?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="/mobiles/">Main page</a>