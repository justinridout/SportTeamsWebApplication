<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Lineup</title>
</head>
<body>
<form action="createNewLineupServlet" method="post">
		Lineup Name:<input type="text" name="lineupName"><br />Lineup date:
		<input type="text" name="month" placeholder="mm" size="4"> <input
			type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4">User
		Name:<input type="text" name="userName"><br />Available
		Teams:<br />
		<select name="allTeamsToAdd" multiple size="6">
			<c:forEach
				items="${requestScope.allTeams}" var="currentteam">
				<option value="${currentteam.id}">${currentteam.teamName}|
					${currentteam.division} | ${currentteam.rosterSize}</option>
			</c:forEach></select><br />
		<input type="submit" value="Create Lineup and Add Teams">
	</form>
	<a href="index.html">Go add new teams instead.</a>
</body>
</html>