<#import "import/macros.ftl" as mac/>
<@mac.pageStart title="Book List">
	<script  type="text/javascript" src="<@mac.spring.url '/resources/js/jquery-1.11.3.js'/>"></script>
	<script  type="text/javascript" src="<@mac.spring.url '/resources/js/jscript.js'/>"></script>
</@mac.pageStart>
<@mac.pageBody>
	<center>
		<h2><@mac.spring.message code="label.listbook" /></h2>
			<form name="bookForm" action="action/bookAction.html" method="post">
				<table border="1 width="600px">
					<tr id="first">
						<td><@mac.spring.message code="label.select" /></td>
						<td><@mac.spring.message code="label.bookid" /></td>
						<td><@mac.spring.message code="label.isbn" /></td>
						<td><@mac.spring.message code="label.title" /></td>
						<td><@mac.spring.message code="label.genre" /></td>
						<td><@mac.spring.message code="label.author" /></td>
						<td><@mac.spring.message code="label.pageno" /></td>
						<td><@mac.spring.message code="label.publishdate" /></td>
						<td><@mac.spring.message code="label.borrower" /></td>
					</tr>
					<@mac.showBooks "command" command.books/>
				</table>
				<input type="submit" name="bookAdd" value="<@mac.spring.message code="label.add" />" id="add" />
				<input type="submit" name="bookDetails" value="<@mac.spring.message code="label.show" />" id="show"/>
				<input type="submit" name="bookEdit" value="<@mac.spring.message code="label.edit" />" id="edit"/>
				<input type="submit" name="deleteBook" value="<@mac.spring.message code="label.delete" />" id="delete"/>
			</form>
		<br />
		<span><a href="?lang=en">en</a> | <a href="?lang=pl">pl</a></span>
	</center>
</@mac.pageBody>