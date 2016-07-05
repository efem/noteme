<#import "spring.ftl" as spring />
<@spring.bind "user"/>
<@spring.showErrors '*', 'errors' />
<html>
	<head>
		<meta charset="UTF-8">
		<title>NOTES</title>
	</head>
	<body>
 <form name="user" method="POST">
  First name:<br>
  <input type="text" name="username" /><br>
  Last name:<br>
  <input type="text" name="email" />
  <br>
  Password<br>
  <input type="password" name="password" />
  <br>
  Repeat password:<br>
  <input type="password" name="password_repeat" />
  <input type="submit" value="Register">
</form> 
	
	</body>
</html>