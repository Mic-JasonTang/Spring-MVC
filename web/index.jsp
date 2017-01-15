<%--
  Created by User: JasonTang.
  Date: 11/01/2017
  Time: 10:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HelloWorld</title>
    <script type="application/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
      $(function() {
        $("#testJSON").click(function(){
          var url = this.href;
          $.post(url,function(data){
            for(var i =0; i < data.length; i ++) {
              var id = data[i].id;
              var username = data[i].userName;
              alert(id + ": " + username);
            }
          })
          return false;
        });
      })
    </script>
  </head>
  <body>

  <br> <br>
  <a href="testJSON" id="testJSON">Test JSON</a>

  <br> <br>
  <a href="testRedirect">Test Redirect</a>

  <br> <br>
  <a href="testView">Test View</a>

  <br> <br>
  <form action="testModelAttribute" method="post">
    <input type="text" name="username" value="tom"/>
    <input type="text" name="age" value="16"/>
    <input type="submit" value="submit"/>
  </form>

  <br> <br>
  <a href="testSessionAttributes">Test SessionAttributes</a>

  <br> <br>
  <a href="testMap">Test Map</a>

  <br> <br>
  <a href="testModelAndView">Test ModelAndView</a>

  <br> <br>
  <a href="springmvc/testServletAPI">Test ServletAPI</a>

  <br> <br>
  <%--<form action="springmvc/testPojo" method="post">--%>
    <%--username:<input type="text" name="username"/> <br>--%>
    <%--password:<input type="password" name="password"/> <br>--%>
    <%--age:<input type="text" name="age"/> <br>--%>
    <%--<!-- 级联属性，即为属性的属性，User属性中有一个Address属性，Address属性中还有一个province和city属性 -->--%>
    <%--province:<input type="text" name="Address.province"/> <br>--%>
    <%--city:<input type="text" name="Address.city"/> <br>--%>
    <%--<input type="submit" value="submit"/>--%>
  <%--</form>--%>

  <br> <br>
  <a href="springmvc/testCookieValue">Test CookieValue</a>

  <br> <br>
  <a href="springmvc/testRequestHeader">Test RequestHeader</a>

  <br> <br>
  <a href="springmvc/testRequestParam?username=spring&age=18">Test RequestParam</a>

  <br> <br>
  <form method="post" action="springmvc/testREST/1">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="Test REST PUT"/>
  </form>

  <br> <br>
  <form method="post" action="springmvc/testREST/1">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="Test REST DELETE"/>
  </form>

  <br> <br>
  <form method="post" action="springmvc/testREST">
    <input type="submit" value="Test REST POST "/>
  </form>

  <br> <br>
  <a href="springmvc/testREST/1">Test REST Get</a>
  <br> <br>

  <a href="springmvc/testPathVariable/2">Test PathVariable</a>

  <br> <br>
  <a href="springmvc/testAntPath/aaa/test">testAntPath</a>

  <br> <br>
  <a href="springmvc/testParamsAndHeaders?username=spring&age=11">testParamsAndHeaders</a>

  <br> <br>
  <form method="post" action="springmvc/testMethod">
    <input type="submit" value="testMethod"/>
  </form>

  <br> <br>
  <a href="helloworld">helloWorld</a>
  </body>
</html>
