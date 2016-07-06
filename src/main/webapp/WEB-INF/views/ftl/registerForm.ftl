<#import "init.ftl" as init />
<@init.spring.bind "user"/>
<@init.spring.showErrors '*', 'errors' />
<@init.pageInit title="ADD NEW USER" />
<@init.pageBody>
<form name="user" method="POST">
	<@spring.showErrors "<br>"/>
	First name:<br>
		<@init.spring.formInput "user.username" /><@init.spring.showErrors "<br />", "error" /><br>
  	Last name:<br>
  		<@init.spring.formInput "user.email" /><@init.spring.showErrors "<br>"/><br>
  	Password<br>
		<@init.spring.formInput "user.password" /><@init.spring.showErrors "<br>"/><br>
  	Repeat password:<br>
  		<input type="password" name="password_repeat" />
  		<input type="submit" value="Register">
</form> 
</@init.pageBody>