<#import "init.ftl" as init />
<@init.pageInit title="NOTES" />
<@init.pageBody>
	<#if showNote??>${showNote.message!"dupa"}<#else>"brak notatki"</#if>
</@init.pageBody>
