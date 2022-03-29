<%@ page import="java.util.ArrayList" %>

<html>

<%@include file="Head.html" %>

<body>

<div class="home">

    <%--Search Box--%>
    <form method="POST" action="Search">
        <div class="row g-2">
            <div class="col-sm-10">
                <input type="search" class="form-control col-lg-4" name="searchString"
                       placeholder="Enter search keyword here" required/>
            </div>
            <div class="col-sm">
                <input type="submit" class="form-control btn-dark" value="Search"/>
            </div>
        </div>
    </form>

    <%--Sort Options--%>
    <form method="GET" action="http://localhost:8080">
        <div class="btn-group">
            <button type="submit" class="btn btn-outline-light" name="sort" value="Name">Name</button>
            <button type="submit" class="btn btn-outline-light" name="sort" value="Date Created">Date Created</button>
        </div>
    </form>

    <%--Display List of Notes--%>
    <div class="note-list">
        <ul>
            <%
                ArrayList<String> notes = (ArrayList<String>) request.getAttribute("noteNames");
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

    <%--Add New Note Button--%>
    <form method="GET" action="NewNote.jsp">
        <button type="submit" class="btn btn-dark">New Note</button>
    </form>

</div>

</body>
</html>
