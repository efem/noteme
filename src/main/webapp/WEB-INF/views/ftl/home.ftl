<#import "init.ftl" as init />
<@init.pageInit title="HOME PAGE" />
<@init.pageBody>
	<a href="user/test">show test</a>
	<a href="user/register">new user</a>
	<@init.spring.message code="label.webapp" /><br />
    <@init.spring.message "label.webapp" />
<br />
<a href="?lang=en">EN</a> || <a href="?lang=pl">PL</a>
<a href="admin/showAdmin">note REST</a>
</@init.pageBody>