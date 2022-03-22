<%--
  Created by IntelliJ IDEA.
  User: aryanagarwal
  Date: 22/03/22
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Note</title>
</head>
<body>
<form method="POST" action="http://localhost:8080">
    <label for="name">Enter Name of Note: </label>
    <input type="text" id="name" name="name" placeholder="Name" required>
    <br><br>
    <textarea rows="5" cols="50" name="content" placeholder="Enter Text"></textarea>
    <br>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
