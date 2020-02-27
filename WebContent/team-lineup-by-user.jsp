<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Lineups</title>
</head>
<body>
<form method="post" action="lineupNavagationServlet">
		<table>
			<c:forEach items="${requestScope.allLineups}" var="currentlineup">
				<tr>
					<td><input type="radio" name="id" value="${currentlineup.id}"></td>
					<td><h2>${currentlineup.lineupName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Lineup Date: ${currentlineup.dateOfLineup}</td>
				</tr>
				<tr>
					<td colspan="3">User: ${currentlineup.user.userName}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlineup.listOfTeams}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.teamName},${listVal.division},${listVal.rosterSize }</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToLineup"><input
			type="submit" value="delete" name="doThisToLineup">
	</form>
 	<a href="index.html">Create a new team</a>
		<a href="addTeamsToLineupServlet">Create a new Lineup</a>
</body>
</html>