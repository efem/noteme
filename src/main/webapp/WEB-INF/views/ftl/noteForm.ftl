<#import "init.ftl" as init />
<@init.spring.bind "note"/>
<@init.spring.showErrors '*', 'errors' />
<@init.pageInit title="NEW NOTE" />
<@init.pageBody>
<form name="note" method="POST">
	
  	<@init.spring.message code="label.note" />
  		<@init.spring.formTextarea "note.content" /><br><@init.spring.showErrors "<br>"/><br>
  	<input type="hidden" id="trynick" name="trynick" value=""/>
  	<input type="submit" value="<@init.spring.message code="label.enter" />" />
</form> 
</@init.pageBody>