<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="user" class="com.server.pojo.User" />
<c:set target="${user}" property="name" value="UserName" />
<jsp:setProperty name="user" property="age" value="18" />


<h1>Adding a new user</h1>
<form method="post" action="${pageContext.request.contextPath}/adduser" autocomplete="off">
    <div class="form-group">
        <label for="name">Name</label>
        <input name="name" type="text" class="form-control" id="name" value="<jsp:getProperty name="user" property="name" />">
    </div>
    <div class="form-group">
        <label for="age">Age</label>
        <input name="age" type="text" class="form-control" id="age" value="<jsp:getProperty name="user" property="age" />">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input name="email" type="text" class="form-control" id="email" value="<jsp:getProperty name="user" property="email" />">
    </div>
    <div class="form-group">
        <label for="phone">Phone number</label>
        <input name="phone" type="text" class="form-control" id="phone" value="<jsp:getProperty name="user" property="phone" />">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
