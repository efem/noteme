<#import "init.ftl" as init />
<@init.spring.bind "note"/>
<@init.spring.showErrors '*', 'errors' />
<@init.pageInit title="NEW NOTE" />
<@init.pageBody>
<form name="new" method="POST">
	
  	<@init.spring.message code="label.note" />
  		<@init.spring.formTextarea "note.content" /><br><@init.spring.showErrors "<br>"/><br>
  	<input type="submit" value="<@init.spring.message code="label.enter" />" />
</form> 
</@init.pageBody>