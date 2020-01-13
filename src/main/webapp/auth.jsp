<%@ page contentType="text/html;charset=UTF-8" %>

<style>
    body{
        text-align: center;
    }
</style>

<h1>Welcome!</h1>
<form method="post" action="${pageContext.request.contextPath}/auth" autocomplete="off">
    <div class="form-group">
        Username: <input name="login" type="text" class="form-control" id="login" value="">
    </div>
    <div class="form-group">
        Password: <input name="password" type="password" class="form-control" id="password" value="">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>
