<%@ page import="java.util.ArrayList" %>

<html>

<%@include file="Head.html" %>

<body>

<div class="search">
    <%--Search Box--%>
    <form method="POST" action="Search">
        <% String searchString = (String) request.getAttribute("searchString");%>
        <div class="row g-2">
            <div class="col-sm-10">
                <input type="search" class="form-control col-lg-4" name="searchString"
                       placeholder="Enter search keyword here" value="<%=searchString%>" required/>
            </div>
            <div class="col-sm">
                <input type="submit" class="form-control btn-dark" value="Search"/>
            </div>
        </div>
    </form>

    <%--Display List of Notes--%>
        <div class="note-list">
            <ul>
                <%
                    ArrayList<String> notes = (ArrayList<String>) request.getAttribute("searchResult");
                    if (notes != null) {
                        for (String note : notes) {
                            String href = "http://localhost:8080/DisplayNote?id=" + note;
                %>
                <li class="note-list-bullet">
                    <p class="note-list-item">
                        <a href="<%=href%>"><%=note%>
                        </a>
                    </p>
                </li>
                <% }
                } %>
            </ul>
        </div>

        <%--Back Button--%>
        <a href="http://localhost:8080">
            <button type="button" class="btn btn-dark">Back</button>
        </a>

</div>

</body>
</html>


