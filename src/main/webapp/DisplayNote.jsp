<html>
<head>
    <title>Note</title>
</head>
<body>

<%--Display Content of Note--%>
<% String noteName = (String) request.getAttribute("noteName");%>
<h1><%=noteName%>
</h1>
<% String content = (String) request.getAttribute("content");%>
<%=content%>

<%--Add New Note Button--%>
<form method="GET" action="NewNote.jsp">
    <input type="submit" name="button" value="New Note">
</form>

<%--Edit & Rename Note Button--%>
<form method="GET" action="EditNote">
    <input type="hidden" name="id" value=<%=noteName%>>
    <input type="submit" name="button" value="Edit Note">
</form>

<%--Delete Note Button--%>
<form method="GET" action="DeleteNote">
    <input type="hidden" name="id" value=<%=noteName%>>
    <input type="submit" name="button" value="Delete">
</form>

<%--Back Button--%>
<a href="http://localhost:8080"><input type="button" name="button" value="Back"></a>

</body>
</html>
