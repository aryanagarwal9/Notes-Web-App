<html>
<head>
    <title>Note</title>
</head>
<body>

<%--Form for Adding a New Note--%>
<form method="POST" action="AddNewNote">
    <label for="name">Enter Name of Note: </label>
    <input id="name" name="name" oninput="this.setCustomValidity('')"
           oninvalid="this.setCustomValidity('Name should be alphanumeric and may contain hyphens')"
           pattern="[a-zA-Z0-9-]+" placeholder="Name" required type="text">
    <br><br>
    <textarea rows="5" cols="50" name="content" placeholder="Enter Text"></textarea>
    <br>
    <input type="submit" value="submit"/>
</form>

<%--Back Button--%>
<a href="http://localhost:8080"><input type="button" name="button" value="Back"></a>

</body>
</html>
