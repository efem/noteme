<#import "init.ftl" as init />
<@init.pageInit title="NOTES" />
<@init.pageBody>
	<#if singleNote??>	
		NOTE:<br />
		${singleNote.content!""} <br />
	<#else>
		NOTE NOT FOUND
	</#if>
</@init.pageBody>
