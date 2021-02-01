<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/styles/style.css">
<title>Document</title>
</head>

<body>


	<div class="wrapper fadeInDown">
			<c:choose>
				<c:when test="${not empty message }">
					<p class="alert ${messageClass}">${message }</p>
					<%
						session.setAttribute("message", null);
					session.setAttribute("messageClass", null);
					%>
				</c:when>
			</c:choose>
		
		<div id="formContent">

			<div class="fadeIn first">
				<img
					src="http://imcreator.com/blog/wp-content/uploads/2014/03/13.-Simple.jpg"
					id="icon" alt="User Icon" />
			</div>

			<!-- Login Form -->
			<form action="registration/createUser" method="post">
				<input type="text" id="login" class="fadeIn second" name="username"
					placeholder="username"> <input type="email" id="login"
					class="fadeIn second" name="email" placeholder="email"> <input
					type="text" id="password" class="fadeIn third" name="password"
					placeholder="password"> <input type="text" id="password"
					class="fadeIn third" name="confirmPassword"
					placeholder="confirm password"> <input type="submit"
					class="fadeIn fourth" value="Register">
			</form>

			<div id="formFooter">
				<span>Already have an account? <a class="underlineHover"
					href="login">Login</a></span>
			</div>

		</div>
	</div>


</body>

</html>