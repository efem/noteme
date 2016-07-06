<#import "init.ftl" as init />
<@init.pageInit title="HOME PAGE" />
<@init.pageBody>
	<a href="notes">show notes</a>
	<a href="user/register">new user</a>
	<@init.spring.message code="label.webapp" /><br />
    <@init.spring.message "label.webapp" />
</@init.pageBody>