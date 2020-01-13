<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<ul class="list-group">
    <li class="list-group-item">${user.id}</li>
    <li class="list-group-item">${user.name}</li>
    <li class="list-group-item">${user.age}</li>
    <li class="list-group-item">${user.email}</li>
    <li class="list-group-item">${user.phone}</li>
</ul>

<br>
<a href="/mobiles/">Main page</a>