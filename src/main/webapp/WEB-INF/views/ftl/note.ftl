<#import "init.ftl" as init />

<@init.pageInit title="NOTES" />
<@init.pageBody>
	<#if singleNote??>	
		NOTE:<br />
		${singleNote.content!""} <br />
		Posted by: 
		<#if singleNote.user??>
	    <b>${singleNote.user.username!""}</b> <br />
	    E-mail to: ${singleNote.user.email!""} was 
	    	<#if singleNote.wasmailsend == true>
	    		SEND
	    	<#else>
	    		NOT SEND
	    	</#if>
		<#else>
    		<#if singleNote.nickfound == true>
    		<b>${singleNote.trynick!""}</b>
    		<#else>
    		Anonymous
    		</#if>
		</#if>

	<#else>
		NOTE NOT FOUND
	</#if>
</@init.pageBody>
