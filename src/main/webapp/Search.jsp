<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Note</title>
</head>
<body>

<h2>Notes:</h2>

<%--Search Box--%>
<form method="POST" action="Search">
    <% String searchString = (String) request.getAttribute("searchString");%>
    <input type="search" name="searchString" placeholder="Enter search keyword here" value="<%=searchString%>"
           required/>
    <input type="submit" value="Search"/>
</form>

<%--Search Results--%>
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

<%--Back Button--%>
<a href="http://localhost:8080"><input type="button" name="button" value="Back"></a>

</body>
</html>
