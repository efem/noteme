<#import "init.ftl" as init />
<@init.spring.bind "note"/>
<@init.spring.showErrors '*', 'errors' />
<@init.pageInit title="ADD NEW USER" />
<@init.pageBody>
<form name="user" method="POST">
	<@spring.showErrors "<br>"/>
	<@init.spring.message code="label.username" /><br>
		<@init.spring.formInput "user.username" /><@init.spring.showErrors "<br />", "error" /><br>
  	<@init.spring.message code="label.email" /><br>
  		<@init.spring.formInput "user.email" /><@init.spring.showErrors "<br>"/><br>
  	<@init.spring.message code="label.password" /><br>
		<@init.spring.formInput "user.password" /><@init.spring.showErrors "<br>"/><br>
  	<@init.spring.message code="label.password.repeat" /><br>
  		<@init.spring.formInput "user.passwordVerify" /><@init.spring.showErrors "<br>"/><br>
	<@init.spring.message code="label.role" /><br>
		<@init.getRolemacro "roles" user.roles/>
  	<input type="submit" value="<@init.spring.message code="label.register" />" />
</form> 
</@init.pageBody>