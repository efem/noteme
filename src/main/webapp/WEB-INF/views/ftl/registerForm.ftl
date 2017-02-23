<#import "init.ftl" as init />
<@init.spring.bind "user"/>
<@init.spring.showErrors '*', 'errors' />
<@init.pageInit title="ADD NEW USER" />
<@init.pageBody>
<@init.renderNaviBar />
<form name="user" method="POST">
	<@spring.showErrors "<br>"/>
	<@init.spring.message code="label.username" /><br>
		<@init.spring.formInput "user.username" /><@init.spring.showErrors "<br />", "error" /><br>
  	<@init.spring.message code="label.email" /><br>
  		<@init.spring.formInput "user.email" /><@init.spring.showErrors "<br>"/><br>
  	<@init.spring.message code="label.password" /><br>
		<@init.spring.formPasswordInput "user.password" /><@init.spring.showErrors "<br>"/><br>
  	<@init.spring.message code="label.password.repeat" /><br>
  		<@init.spring.formPasswordInput "user.passwordVerify" /><@init.spring.showErrors "<br>"/><br>
 		<input type="hidden" name="userRoles" value="user" />
  	<input type="submit" value="<@init.spring.message code="label.register" />" />
</form> 
</@init.pageBody>