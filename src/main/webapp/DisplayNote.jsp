<html>

<%@include file="Head.html"%>

<body>

<div class="display-note">

    <%--Display Content of Note--%>
    <% String noteName = (String) request.getAttribute("noteName");%>
    <% String content = (String) request.getAttribute("content");%>
    <h1 class="note-name"><%=noteName%></h1>
    <div class="display-content">
        <%=content%>
    </div>

    <form method="GET">
        <div class="btn-group">
            <%--Home Button--%>
            <a href="http://localhost:8080">
                <button type="button" class="btn btn-dark">Home</button>
            </a>

            <%--Edit & Rename Note Button--%>
            <input type="hidden" name="id" value="<%=noteName%>" formaction="Edit">
            <button type="submit" class="btn btn-outline-dark" formaction="Edit">Edit</button>

            <%--Delete Note Button--%>
            <input type="hidden" name="id" value="<%=noteName%>" formaction="Delete">
            <button type="submit" class="btn btn-outline-dark" formaction="Delete">Delete</button>
        </div>
    </form>
</div>

</body>
</html>
