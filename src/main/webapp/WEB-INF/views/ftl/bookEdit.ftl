<#import "import/macros.ftl" as mac/>
<@mac.spring.bind "command.bookDto"/>
<@mac.spring.showErrors '*', 'errors' />
<@mac.pageStart title="Book Edit" />
<@mac.pageBody>
		<h2><@mac.spring.message code="label.editbook" /></h2>
			<form name="bookForm" action="saveEdit.html" method="post">
				<table border="1">			
					<tr>
						<td><@mac.spring.message code="label.bookid" /></td>
						<td><input type="hidden" name="bookDto.id" value="${command.bookDto.id!""}" readonly>${command.bookDto.id!""}</td>
					</tr>
					<@mac.showErrorsInNewRow />	
					<tr>
						<td><@mac.spring.message code="label.isbn" /></td>
						<td><@mac.spring.formInput "command.bookDto.isbn" /></td>
					</tr>
					<@mac.showErrorsInNewRow />	
					<tr>
						<td><@mac.spring.message code="label.title" /></td>
						<td><@mac.spring.formInput "command.bookDto.title" /></td>
					</tr>
					<@mac.showErrorsInNewRow />	
					<tr>
						<td><@mac.spring.message code="label.genre" /></td>
						<td>
							<@mac.genresMacro "genre" command.genres/>
						</td>
					</tr>				
					<tr>
						<td><@mac.spring.message code="label.author" /></td>
						<td>
							<@mac.authorsMacro "authors" command.authors/>
						</td>
					</tr>
					<tr>
						<td><@mac.spring.message code="label.pageno" /></td>
						<td><@mac.spring.formInput "command.bookDto.noOfPages" /></td>
					</tr>
					<@mac.showErrorsInNewRow />	
					<tr>
						<td><@mac.spring.message code="label.publishdate" /></td>
						<td><@mac.spring.formInput "command.bookDto.publishingDate" /></td>
					</tr>
					<@mac.showErrorsInNewRow />		
				</table>
				<@mac.showButtonsBackSave />
			</form>
</@mac.pageBody>