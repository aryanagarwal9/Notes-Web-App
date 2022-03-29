<html>

<%@include file="Head.html"%>

<body>

<div class="new-note">

    <%--Form to enter name and content of note--%>
    <form id="new-note-form" method="POST" action="NewNote">

        <div class="input-group input-group-lg mb-3">
            <span class="input-group-text" id="basic-addon1">Note:</span>
            <input type="text" class="form-control" id="name" name="name" oninput="this.setCustomValidity('')"
                   oninvalid="this.setCustomValidity('Required, should be alphanumeric, may contain hyphens')"
                   pattern="[a-zA-Z0-9-]+" placeholder="Name" required>
        </div>

        <div class="input-group">
            <span class="input-group-text">Content</span>
            <textarea class="form-control" rows="20" cols="50" name="content" placeholder="Enter Text"></textarea>
        </div>

    </form>

    <%--    Home Button & Submit Button--%>
    <div class="btn-group">
        <a href="http://localhost:8080">
            <button type="button" class="btn btn-dark">Home</button>
        </a>
        <button class="btn btn-outline-dark" form="new-note-form" type="submit">Done</button>
    </div>

</div>

</body>
</html>
