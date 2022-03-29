<html>

<%@include file="Head.html" %>

<body>

<div class="edit-note">

    <%--Form to enter name and content of note--%>
    <% String noteName = (String) request.getAttribute("noteName");%>
    <% String content = (String) request.getAttribute("content");%>
    <form id="edit-note-form" method="POST" action="Edit">

        <div class="input-group input-group-lg mb-3">
            <span class="input-group-text" id="basic-addon1">Note:</span>
            <input type="hidden" name="id" value=<%=noteName%>>
            <input type="text" class="form-control" id="name" name="name" value="<%=noteName%>"
                   oninput="this.setCustomValidity('')"
                   oninvalid="this.setCustomValidity('Required, should be alphanumeric, may contain hyphens')"
                   pattern="[a-zA-Z0-9-]+" placeholder="Name" required>
        </div>

        <div class="input-group">
            <span class="input-group-text">Content</span>
            <textarea class="form-control" rows="20" cols="50" name="content"
                      placeholder="Enter Text"><%=content%></textarea>
        </div>

    </form>

    <%--    Back Button & Done Button--%>
    <div class="btn-group">
        <% String noteURL = "http://localhost:8080/DisplayNote?id=" + noteName;%>
        <a href=<%=noteURL%>>
            <button type="button" class="btn btn-dark">Back</button>
        </a>
        <button class="btn btn-outline-dark" form="edit-note-form" type="submit">Done</button>
    </div>

</div>

</body>
</html>
