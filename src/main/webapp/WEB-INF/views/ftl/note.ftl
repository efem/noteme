<#import "init.ftl" as init />

<@init.pageInit title="NOTES" />
<@init.pageBody>
	<#if singleNote??>	
		NOTE:<br />
		${singleNote.content!""} <br />
	<#else>
		NOTE NOT FOUND
	</#if>

<@init.security.authorize access="isAuthenticated()">
    logged in as <@init.security.authentication property="principal.username" /> 
</@init.security.authorize>

<@init.security.authorize access="! isAuthenticated()">
    Not logged in
</@init.security.authorize>
</@init.pageBody>
