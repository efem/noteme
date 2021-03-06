<#import "init.ftl" as init />
<@init.spring.bind "user"/>
<@init.spring.showErrors '*', 'errors' />
<@init.pageInit title="LOG IN TO YOUR ACC" />
<@init.pageBody>
<form name="login" method="POST">
	
  	<@init.spring.message code="label.username" />
  		<@init.spring.formInput "user.username" /><br>
  	<@init.spring.message code="label.password" />
		<@init.spring.formPasswordInput "user.password" /><br>
  	<input type="submit" value="<@init.spring.message code="label.enter" />" />
</form> 
</@init.pageBody>