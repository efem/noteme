<#import "init.ftl" as init />
<@init.pageInit title="ALL NOTES" />
<@init.pageBody>
	USER PROFILE: <br />
	Username: ${userProfile.username!""} <br />
	Email: ${userProfile.email!""} <br />
	Pass: ${userProfile.password!""}
</@init.pageBody>