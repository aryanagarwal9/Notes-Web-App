<%--
  Created by IntelliJ IDEA.
  User: aryanagarwal
  Date: 13/03/22
  Time: 3:20 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Note</title>
</head>
<body>

<% String name = (String) request.getAttribute("name");%>
<h1><%=name%></h1>
<% String content = (String) request.getAttribute("content");%>
<%=content%>
<form method="GET" action = "http://localhost:8080">
    <input type="hidden" name="id" value=<%=name%>>
    <input type="submit" name="button" value="Delete">
</form>
</body>
</html>
