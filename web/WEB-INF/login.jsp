
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">
            <div>                
                <label>Username:</label>
                <input type="text" name="user" value="${user}">
            </div>
            <div>                
                <label>Password:</label>
                <input type="password" name="password" value="${password}">
            </div>
            <div>                
                <input type="submit" value="Log in">
            </div>
        </form>
        <div>
            <span>${message}</span>
        </div>
    </body>
</html>
