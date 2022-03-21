<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: aryanagarwal
  Date: 21/03/22
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Notes:</h2>
<ul>
    <%
        ArrayList<String> notes = (ArrayList<String>) request.getAttribute("noteNames");
        System.out.println(notes);
        for (String note : notes)
        {
            StringBuffer url = request.getRequestURL();
            String href = "http://localhost:8080" + "/DisplayNote?id=" + note;
    %>
    <li><a href="<%=href%>"><%=note%></a>
    </li>
    <% } %>
</ul>
</body>
</html>
