<#import "init.ftl" as init />
<@init.pageInit title="USER PROFILE" />
<@init.pageBody>
	
	<#if userProfile??>
		USER PROFILE: <br />
		Username: ${userProfile.username!""} <br />
		Email: ${userProfile.email!""} <br />
		Pass: ${userProfile.password!""} <br />
		Roles: 
		
	<#else>
		USER NOT FOUND
	</#if>

</@init.pageBody>