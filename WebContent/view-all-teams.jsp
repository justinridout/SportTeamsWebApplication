<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Teams</title>
</head>
<body>

<form method ="post" action = "navigationServlet">
		<table>
		<td></td>
		<td>Team</td>
		<td style="padding-right: 10px">Division</td>
		<td>Roster Size</td>
			<c:forEach items="${requestScope.allTeams}" var="currentteam">
				<tr>
					<td><input type="radio" name="id" value="${currentteam.id}">
					</td>
					<td style="padding-right: 10px">${currentteam.teamName}</td>
					<td style="padding-right: 10px">${currentteam.division}</td>
					<td>${currentteam.rosterSize}</td>
				</tr>
			</c:forEach>
		</table>
		<input type ="submit" value ="edit" name="doThisToTeam">
		<input type ="submit" value ="delete" name="doThisToTeam">
		<input type ="submit" value ="add" name="doThisToTeam">
		
	</form>

</body>
</html>