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
 <@spring.showErrors "<br>"/>
  First name:<br>
  <@spring.formInput "user.username" /><@spring.showErrors "<br />", "error" /><br>
  Last name:<br>
  <@spring.formInput "user.email" /><@spring.showErrors "<br>"/><br>
  <br>
  Password<br>
<@spring.formInput "user.password" /><@spring.showErrors "<br>"/><br>
  <br>
  Repeat password:<br>
  <input type="password" name="password_repeat" />
  <input type="submit" value="Register">
</form> 
	
	</body>
</html>