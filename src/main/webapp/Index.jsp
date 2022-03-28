<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Note</title>
</head>
<body>

<%--Search Box--%>
<form method="POST" action="Search">
    <input type="search" name="searchString" placeholder="Enter search keyword here" required/>
    <input type="submit" value="Search"/>
</form>

<%--Sort Options--%>
<form method="GET" action="http://localhost:8080">
    <label>Sort By: </label>
    <input type="submit" name="sort" value="Name">
    <input type="submit" name="sort" value="Date Created">
</form>

<%--Display List of Notes--%>
<h2>Notes:</h2>

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
    } %>
</ul>

<%--Add New Note--%>
<form method="GET" action="NewNote.jsp">
    <input type="submit" name="button" value="New Note">
</form>

</body>
</html>
