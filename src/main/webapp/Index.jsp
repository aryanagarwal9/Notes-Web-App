<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: aryanagarwal
  Date: 21/03/22
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Note</title>
</head>
<body>
<h2>Notes:</h2>
<form method="POST" action="Search">
    <input type="text" name="searchString" placeholder="Enter search keyword here" required/>
    <input type="submit" value="Search"/>
</form>
<form method="POST" action="http://localhost:8080">
    <label>Sort By: </label>
    <input type="submit" name="sort" value="Name">
    <input type="submit" name="sort" value="Date Created">
</form>
<ul>
    <%
        ArrayList<String> notes = (ArrayList<String>) request.getAttribute("noteNames");
        if (notes != null) {
            for (String note : notes) {
                String href = "http://localhost:8080/DisplayNote?id=" + note;
    %>
    <li><a href="<%=href%>"><%=note%>
    </a></li>
    <% }
    }%>
</ul>
<form method="POST" action="NewNote.jsp">
    <input type="submit" name="button" value="New Note">
</form>
</body>
</html>
