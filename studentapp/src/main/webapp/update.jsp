<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Update Registration</h2>
	<form action="update" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%=request.getAttribute("name")%>"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" value="<%=request.getAttribute("city")%>"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="<%=request.getAttribute("email")%>" readOnly></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"></td>
			</tr>
			<tr>
				<td><input type="submit" type="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>