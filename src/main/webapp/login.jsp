<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loginpage"><%=request.getAttribute("message") %></br></br>
Student Id:<input type="text" name="stdid" required></br></br>
Student Name:<input type="text" name="stdname" required></br>
<input type="submit" value="login"></br></br>
<a href ="register.jsp">Click Here</a> to register.
</form>

</body>
</html>