<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
</head>
<body>

<form action= "editTeamServlet" method="post">
<div style="align-items: center; justify-content: center;">
	<label style="margin-right: 40px;">Team:</label><input type = "text" name = "teamName" value= "${toEdit.teamName}"></br>
	<label style="margin-right: 21px;">Division:</label><input type = "text" name = "division" value ="${toEdit.division}"></br>
	<label>Roster Size:</label> <input type = "text" name = "rosterSize" value ="${toEdit.rosterSize}"></br>
	<input type = "hidden" name ="id" value= "${toEdit.id}">
	<input type ="submit" value="Save Edited Team">
</div>
</form>

</body>
</html>