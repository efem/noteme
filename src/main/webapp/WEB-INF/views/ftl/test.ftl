<#import "init.ftl" as init />
<@init.pageInit title="ALL test" />
<@init.pageBody>
test

<@init.spring.message code="label.role" /><br>
		<@init.getRolemacro "roles" user.roles/> 
</@init.pageBody>