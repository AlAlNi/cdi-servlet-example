<%@ page contentType="text/html;charset=UTF-8" %>

<h1>Edit the mobile</h1>
<form method="post" action="${pageContext.request.contextPath}/editmobile" autocomplete="off">
    <input type="hidden" value="${mobile.id}" name="id">
    <div class="form-group">
        <label for="model">Model</label>
        <input name="model" type="text" class="form-control" id="model" value="${mobile.model}">
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <input name="price" type="text" class="form-control" id="price" value="${mobile.price}">
    </div>
    <div class="form-group">
        <label for="manufacturer">Email</label>
        <input name="manufacturer" type="text" class="form-control" id="manufacturer" value="${mobile.manufacturer}">
    </div>
    <button type="submit" class="btn btn-primary">Save changes</button>
</form>
