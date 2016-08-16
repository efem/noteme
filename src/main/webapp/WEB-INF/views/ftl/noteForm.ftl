<#import "init.ftl" as init />
<@init.spring.bind "note"/>
<@init.spring.showErrors '*', 'errors' />
<@init.pageInit title="NEW NOTE" />
<@init.security.authorize access="isAuthenticated()">
    Hello, <@init.security.authentication property="principal.username" /> 
</@init.security.authorize>
<@init.security.authorize access="! isAuthenticated()">
    Posting anonymously, create an account <a href="/register">*here*</a>
</@init.security.authorize>
<@init.pageBody>
<form name="note" method="POST">
	
  	<@init.spring.message code="label.note" />
  		<@init.spring.formTextarea "note.content" /><br><@init.spring.showErrors "<br>"/><br>
  		
	<@init.security.authorize access="isAuthenticated()">
		 <input type="checkbox" name="mailtosend" value="true">Send e-mail<br >
	</@init.security.authorize>
  	<input type="hidden" id="trynick" name="trynick" value=""/>
  	<input type="submit" value="<@init.spring.message code="label.enter" />" />
</form> 
</@init.pageBody>