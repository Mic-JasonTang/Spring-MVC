<%--
  Created by User: JasonTang.
  Date: 11/01/2017
  Time: 10:58
  FileName: Spring-MVC
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
<h1>Success Page</h1>
<h1>time:${time}</h1>
<h1>users:${users}</h1>
<h2>request tom:${requestScope.tom}</h2>
<h2>session tom:${sessionScope.tom}</h2>
<h2>request hello:${requestScope.hello}</h2>
<h2>session hello:${sessionScope.hello}</h2>
<h2>request user:${requestScope.user}</h2>
<h2>session user:${sessionScope.user}</h2>
</body>
</html>
