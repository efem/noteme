<#import "init.ftl" as init />
<@init.spring.bind "user"/>
<@init.spring.showErrors '*', 'errors' />
<@init.pageInit title="LOG IN TO YOUR ACC" />
<@init.pageBody>
<form name="login" method="POST">
	<@spring.showErrors "<br>"/>
  	<@init.spring.message code="label.email" /><br>
  		<@init.spring.formInput "user.email" /><@init.spring.showErrors "<br>"/><br>
  	<@init.spring.message code="label.password" /><br>
		<@init.spring.formInput "user.password" /><@init.spring.showErrors "<br>"/><br>
  	<input type="submit" value="<@init.spring.message code="label.enter" />" />
</form> 
</@init.pageBody>