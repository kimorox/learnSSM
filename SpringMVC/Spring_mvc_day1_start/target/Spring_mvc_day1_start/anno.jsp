<%--
  Created by IntelliJ IDEA.
  User: kimoro
  Date: 2021/1/29
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--常用注解--%>
<a href="/anno/testRequestParam?name=哈哈">RequestParam</a>
<br>
<form action="anno/testRequestBody" method="post">
    用户姓名：<input type="text" name="uname"/><br/>
    用户年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>
</form>

<a href="anno/testRequestHeader">RequestHeader</a>
<br>
<a href="anno/testCookieValue">testCookieValue</a>
</body>
</html>
