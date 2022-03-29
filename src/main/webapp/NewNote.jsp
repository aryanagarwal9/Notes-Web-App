<html>
<head>
    <title>Note</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="new-note">

    <%--Form to enter name and content of note--%>
    <form id="new-note-form" method="POST" action="AddNewNote">

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

    <%--    Back Button & Submit Button--%>
    <div class="btn-group">
        <a href="http://localhost:8080">
            <button type="button" class="btn btn-primary">Back</button>
        </a>
        <button class="btn btn-primary" form="new-note-form" type="submit">Submit</button>
    </div>

</div>

</body>
</html>
