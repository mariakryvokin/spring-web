<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<html>
<head>
<title>Sign In</title>
</head>
<body>
	<h1>Spring Security - Sign In</h1>

	<form method="post" action="/app/do-login">
		<label>Email:  </label>
		<input type="text" name="email"><br />
		<label>Password: </label>
		<input type="password" name="password" ><br />
		<input type="checkbox" name="remember-me"><br/>
		<button type="submit">Submit</button>
	</form>
</body>
</html>