<%--
  Created by IntelliJ IDEA.
  User: aryanagarwal
  Date: 13/03/22
  Time: 3:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note</title>
</head>
<body>

<% String content = (String) request.getAttribute("content");%>
<%=content%>


</body>
</html>
