<#import "init.ftl" as init />
<@init.pageInit title="ALL NOTES" />
<@init.pageBody>
	<#list noteList as notes>
		<br />
		${notes.message!""}
	</#list>
</@init.pageBody>