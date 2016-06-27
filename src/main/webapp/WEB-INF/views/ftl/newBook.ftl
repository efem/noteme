<#import "import/macros.ftl" as mac/>
<@mac.spring.bind "command.bookDto"/>
<@mac.spring.showErrors '*', 'errors' />
<@mac.pageStart title="New Book" />
<@mac.pageBody>
	<center>
		<h2><@mac.spring.message code="label.addbook" /></h2>
			<form name="user" action="saveBook.html" method="post">
				<table width="500px" height="150px">
					<tr>
						<td><@mac.spring.message code="label.isbn" /></td>
						<td><@mac.spring.formInput "command.bookDto.isbn" /></td>
					</tr>
					<tr>
						<td></td>
						<td><@mac.spring.showErrors "<br />", "error" /></td>
					</tr>
					<tr>
						<td><@mac.spring.message code="label.title" /></td>
						<td><@mac.spring.formInput "command.bookDto.title" /></td>
					</tr>
					<tr>
						<td></td>
						<td><@mac.spring.showErrors "<br />", "error" /></td>
					</tr>
					<tr>
						<td><@mac.spring.message code="label.genre" /></td>
						<td>
							<select name="genre_id">
								<@mac.genresMacroNewBook "genres" command.genres/>
							</select>
						</td>
					</tr>
					<tr>
						<td><@mac.spring.message code="label.author" /></td>
						<td>
							<select name="author_id">
								<@mac.authorsMacroNewBook "authors" command.authors/>
							</select>
						</td>
					</tr>
					<tr>
						<td><@mac.spring.message code="label.pageno" /></td>
						<td><@mac.spring.formInput "command.bookDto.noOfPages" /></td>
					</tr>
					<tr>
						<td></td>
						<td><@mac.spring.showErrors "<br />", "error" /></td>
					</tr>
					<tr>
						<td><@mac.spring.message code="label.publishdate" /></td>
						<td><@mac.spring.formInput "command.bookDto.publishingDate" /></td>
					</tr>
					<tr>
						<td></td>
						<td><@mac.spring.showErrors "<br />", "error" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="<@mac.spring.message code="label.add" />" />
							<input type="button" value="<@mac.spring.message code="label.back" />" onClick="history.go(-1);">
						</td>
					</tr>
				</table>
			</form>
	</center>
</@mac.pageBody>