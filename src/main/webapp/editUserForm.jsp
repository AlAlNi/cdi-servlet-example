<%@ page contentType="text/html;charset=UTF-8" %>

<h1>Edit the user</h1>
<form method="post" action="${pageContext.request.contextPath}/edituser" autocomplete="off">
    <input type="hidden" value="${user.id}" name="id">
    <div class="form-group">
        <label for="name">Name</label>
        <input name="name" type="text" class="form-control" id="name" value="${user.name}">
    </div>
    <div class="form-group">
        <label for="age">Age</label>
        <input name="age" type="text" class="form-control" id="age" value="${user.age}">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input name="email" type="text" class="form-control" id="email" value="${user.email}">
    </div>
    <div class="form-group">
        <label for="phone">Phone number</label>
        <input name="phone" type="text" class="form-control" id="phone" value="${user.phone}">
    </div>
    <button type="submit" class="btn btn-primary">Save changes</button>
</form>
