<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Participants</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<h2>Participants Details</h2>
	<table border="1" class="table">
		<tr>
			<th>Participant Id</th>
			<th>First Name</th>
			<th>Age</th>
			<th>Phone Number</th>
			<th>Batch Id</th>
		</tr>
		<core:forEach var="participant" items="${sessionScope.participants}">
			<tr>
				<td><core:out value="${participant.getParticipantId()}"></core:out>
				</td>
				<td><core:out value="${participant.getFirstName()}"></core:out>
				</td>
				<td><core:out value="${participant.getAge()}"></core:out></td>
				<td><core:out value="${participant.getPhoneNumber()}"></core:out>
				</td>
				<td><core:out value="${participant.getBatchId()}"></core:out></td>
				<td><a
					href="ParticipantsController?flag=2&participantid=${participant.getParticipantId()}">Delete</a></td>
			</tr>
		</core:forEach>
	</table>
	<br />
	<a href="index.jsp">Back</a>
</body>
</html>