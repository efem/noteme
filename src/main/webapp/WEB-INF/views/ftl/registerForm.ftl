<#import "spring.ftl" as spring>
<html>
	<head>
		<meta charset="UTF-8">
		<title>NOTES</title>
	</head>
	<body>
 <form name="user" method="POST">
  First name:<br>
  <input type="text" name="user.username"><br>
  Last name:<br>
  <input type="text" name="user.email">
  <br>
  Password<br>
  <input type="password" name="user.password">
  <br>
  Repeat password:<br>
  <input type="password" name="password_repeat">
  <input type="submit" value="Register">
</form> 
	
	</body>
</html>