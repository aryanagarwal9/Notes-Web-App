<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: aryanagarwal
  Date: 23/03/22
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Notes:</h2>
<form method="POST" action="Search">
    <% String searchString = (String) request.getAttribute("searchString");%>
    <input type="text" name="searchString" placeholder="Enter search keyword here" value="<%=searchString%>" required/>
    <input type="submit" value="Search"/>
</form>
<ul>
    <%
        ArrayList<String> notes = (ArrayList<String>) request.getAttribute("searchResult");
        if (notes != null) {
            for (String note : notes) {
                String href = "http://localhost:8080/DisplayNote?id=" + note;
    %>
    <li><a href="<%=href%>"><%=note%>
    </a></li>
    <% }
    }%>
</ul>
<form method="POST" action="http://localhost:8080">
    <input type="submit" name="button" value="Back">
</form>
</body>
</html>
