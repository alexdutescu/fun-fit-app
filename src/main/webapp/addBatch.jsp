<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Batch</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<h2>Add Batch Details</h2>
	<form action="BatchController" method="post">
		<label>TypeOfBatch</label> <select name="typeofbatch">
			<option value="">--Select Batch--</option>
			<option value="Morning">Morning</option>
			<option value="Evening">Evening</option>
		</select> <br /> <label>Time</label> <select name="time">
			<option value="">--Time--</option>
			<%
			for (int i = 1; i <= 12; i++) {
			%>
			<option value="<%=i%>"><%=i%>:00</option>
			<%
			}
			%>
		</select> <br /> <input type="submit" value="Add Batch" /> <input type="reset"
			value="reset" />
	</form>
	<br />
	<a href="index.jsp">Back</a>
</body>
</html>