<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Lineup</title>
</head>
<body>
<form action= "editLineupServlet" method="post">

<label style="margin-right: 40px;">User Name:</label><input type = "text" name = "userName" value= "${toEdit.user.userName}"></br>
	<label style="margin-right: 40px;">Lineup Name:</label><input type = "text" name = "teamName" value= "${toEdit.lineupName}"></br>
	<label style="margin-right: 21px;">Date of Lineup:</label><input type="text" name="month" placeholder="mm" size="4"> <input
			type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4">
	Available Teams:<br />
		<select name="allTeamsToAdd" multiple size="6">
			<c:forEach
				items="${requestScope.allTeams}" var="currentteam">
				<option value="${currentteam.id}">${currentteam.teamName}|
					${currentteam.division} | ${currentteam.rosterSize}</option>
			</c:forEach></select><br />
	
	<a href="index.html">Go add new teams instead.</a>
	<input type = "hidden" name ="id" value= "${toEdit.id}">
	<input type = "hidden" name ="userId" value= "${toEdit.user.id}">
	<input type ="submit" value="Save Edited Team">
</form>


</body>
</html>