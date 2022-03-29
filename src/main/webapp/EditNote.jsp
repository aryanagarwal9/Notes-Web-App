<html>
<head>
    <title>Note</title>
</head>
<body>

<% String noteName = (String) request.getAttribute("noteName");%>
<% String content = (String) request.getAttribute("content");%>

<%--Form for Editing the Note--%>
<form method="POST" action="EditNote">
    <label for="name">Enter Name of Note: </label>
    <input type="hidden" name="id" value=<%=noteName%>>
    <input type="text" id="name" name="name" placeholder="Name" value="<%=noteName%>" pattern="[a-zA-Z0-9-]+"
           oninput="this.setCustomValidity('')"
           oninvalid="this.setCustomValidity('Name should be alphanumeric and may contain hyphens')" required>
    <br><br>
    <textarea rows="5" cols="50" name="content" placeholder="Enter Text"><%=content%></textarea>
    <br>
    <input type="submit" value="submit"/>
</form>

<%--Back Button--%>
<a href="http://localhost:8080"><input type="button" name="button" value="Back"></a>

</body>
</html>
